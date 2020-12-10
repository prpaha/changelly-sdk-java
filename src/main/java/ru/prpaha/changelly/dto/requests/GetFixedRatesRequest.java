package ru.prpaha.changelly.dto.requests;

import ru.prpaha.changelly.dto.FixedRate;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class GetFixedRatesRequest extends RPCRequest<Collection<FixedRate>> {

    public GetFixedRatesRequest(Collection<FixedRate> fixedRates) {
        super(UUID.randomUUID().toString(), "getFixRate", fixedRates);
    }

}
