package ru.prpaha.changelly.dto.responses;

import ru.prpaha.changelly.dto.CurrencyFull;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class CurrenciesFullResponse extends RPCResponse<Collection<CurrencyFull>> {

    public CurrenciesFullResponse() {
        super();
    }

    public CurrenciesFullResponse(final String jsonrpc, final String id,
                                  final Collection<CurrencyFull> currencies) {
        super(jsonrpc, id, currencies);
    }

}
