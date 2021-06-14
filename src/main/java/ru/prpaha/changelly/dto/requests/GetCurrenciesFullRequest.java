package ru.prpaha.changelly.dto.requests;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class GetCurrenciesFullRequest extends RPCRequest<Void> {

    private static final String METHOD_NAME = "getCurrenciesFull";

    public GetCurrenciesFullRequest() {
        super(UUID.randomUUID().toString(), METHOD_NAME, null);
    }

}
