package ru.prpaha.changelly.utils;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@RunWith(JUnit4.class)
public class SignBuilderTests {

    private static String API_KEY = "api_key";
    private static String INPUT_DATA = "qwerty";
    private static String CORRECT_SIGN = "789ee6a99012712f7884b71f1d3411b8348a0f006df024bb601d6ed3a8160125a4ba2123888211fabdd9f9cfe02bf643346c7c14038089ac0e511ce6a3925851";

    @Test
    public void successBuildSign() throws InvalidKeyException, NoSuchAlgorithmException {
        String sign = SignBuilder.build(API_KEY, INPUT_DATA);
        Assertions.assertEquals(sign, CORRECT_SIGN);
    }

}
