package com.shop.security.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.entity.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Component
public class TokenHandler {

    private Mac hmac;

    @Value("${token.secret}")
    private String secret;

    @PostConstruct
    public void initializeHmac() {
        String hmac_alg = "HmacSHA256";
        byte[] secretKey = DatatypeConverter.parseBase64Binary(secret);
        try {
            hmac = Mac.getInstance(hmac_alg);
            hmac.init(new SecretKeySpec(secretKey, hmac_alg));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
        }
    }

    private UserEntity fromJSON(final byte[] userBytes) {
        try {
            return new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), UserEntity.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] toJSON(UserEntity user) {
        try {
            return new ObjectMapper().writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private String toBase64(byte[] content) {
        return DatatypeConverter.printBase64Binary(content);
    }

    private byte[] fromBase64(String content) {
        return DatatypeConverter.parseBase64Binary(content);
    }

    // synchronized to guard internal hmac object
    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }

    public UserEntity parseUserFromToken(String token) {
        final String[] parts = token.split("\\.");
        if (parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0) {
            try {
                final byte[] userBytes = fromBase64(parts[0]);
                final byte[] hash = fromBase64(parts[1]);

                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
                if (validHash) {
                    return  fromJSON(userBytes);
                }
            } catch (IllegalArgumentException e) {
                //log tempering attempt here
            }
        }
        return null;
    }

    public String createTokenForUser(UserEntity user) {
        byte[] userBytes = toJSON(user);
        byte[] hash = createHmac(userBytes);
        return toBase64(userBytes) +
                "." +
                toBase64(hash);
    }

}
