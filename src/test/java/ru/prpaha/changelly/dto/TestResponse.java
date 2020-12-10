package ru.prpaha.changelly.dto;

import ru.prpaha.changelly.dto.responses.RPCResponse;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class TestResponse extends RPCResponse<TestResponseData> {

    public TestResponse(TestResponseData responseData) {
        super(UUID.randomUUID().toString(), UUID.randomUUID().toString(), responseData);
    }

}
