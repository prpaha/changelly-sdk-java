package ru.prpaha.changelly.dto;

import ru.prpaha.changelly.dto.requests.RPCRequest;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class TestRequest extends RPCRequest<TestRequestData> {

    public TestRequest(String param1, String param2) {
        super(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), new TestRequestData(param1, param2));
    }

}
