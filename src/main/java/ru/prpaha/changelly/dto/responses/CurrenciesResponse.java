package ru.prpaha.changelly.dto.responses;

import ru.prpaha.changelly.dto.Currencies;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class CurrenciesResponse extends RPCResponse<Collection<Currencies>> {

    public CurrenciesResponse() {
        super();
    }

    public CurrenciesResponse(final String jsonrpc, final String id,
                              final Collection<Currencies> currencies) {
        super(jsonrpc, id, currencies);
    }

}
