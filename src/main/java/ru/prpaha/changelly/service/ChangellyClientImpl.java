package ru.prpaha.changelly.service;

import lombok.AllArgsConstructor;
import ru.prpaha.changelly.dto.RPCRequest;
import ru.prpaha.changelly.dto.RPCResponse;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@AllArgsConstructor
public class ChangellyClientImpl implements ChangellyClient {

    private String serviceUrl;
    private String apyKey;

    @Override
    public <REQUEST, RESPONSE> RPCRequest<REQUEST> invoke(final RPCResponse<RESPONSE> response) {

        return null;
    }

}
