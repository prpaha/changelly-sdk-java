package ru.prpaha.changelly;

import ru.prpaha.changelly.dto.Error;
import ru.prpaha.changelly.dto.TestRequest;
import ru.prpaha.changelly.dto.TestResponse;
import ru.prpaha.changelly.dto.TestResponseData;
import ru.prpaha.changelly.dto.responses.RPCErrorResponse;

import java.util.Random;
import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class TestDataProvider {

    public static TestResponse getResponse() {
        TestResponseData responseData = new TestResponseData(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        return new TestResponse(responseData);
    }

    public static TestRequest getRequest() {
        return new TestRequest(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    public static RPCErrorResponse getErrorResponse() {
        return new RPCErrorResponse(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                new Error(new Random().nextInt(), UUID.randomUUID().toString()));
    }
}
