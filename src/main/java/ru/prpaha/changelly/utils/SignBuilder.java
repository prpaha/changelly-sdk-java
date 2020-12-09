package ru.prpaha.changelly.utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class SignBuilder {

    private static final String HMAC_SHA512 = "HmacSHA512";

    public static String build(final String apiKey, final String body)
            throws NoSuchAlgorithmException, InvalidKeyException {
        final byte[] byteKey = apiKey.getBytes(StandardCharsets.UTF_8);
        Mac sha512Hmac = Mac.getInstance(HMAC_SHA512);
        SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA512);
        sha512Hmac.init(keySpec);
        byte[] macData = sha512Hmac.doFinal(body.getBytes(StandardCharsets.UTF_8));

        return Hex.encodeHexString(macData);
    }

}
