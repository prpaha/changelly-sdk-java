package ru.prpaha.changelly;

import ru.prpaha.changelly.dto.TestRequest;
import ru.prpaha.changelly.dto.TestResponse;
import ru.prpaha.changelly.dto.TestResponseData;

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

}
