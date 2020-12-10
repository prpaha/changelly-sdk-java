package ru.prpaha.changelly.dto.responses;

import ru.prpaha.changelly.dto.Currency;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class CurrenciesResponse extends RPCResponse<Collection<Currency>> {

    public CurrenciesResponse() {
        super();
    }

    public CurrenciesResponse(final String jsonrpc, final String id,
                              final Collection<Currency> currencies) {
        super(jsonrpc, id, currencies);
    }

}
