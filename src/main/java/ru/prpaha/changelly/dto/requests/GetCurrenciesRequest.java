package ru.prpaha.changelly.dto.requests;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class GetCurrenciesRequest extends RPCRequest<Void> {

    private static final String METHOD_NAME = "getCurrencies";

    public GetCurrenciesRequest() {
        super(UUID.randomUUID().toString(), METHOD_NAME, null);
    }

}
