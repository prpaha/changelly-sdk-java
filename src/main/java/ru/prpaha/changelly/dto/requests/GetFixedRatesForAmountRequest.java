package ru.prpaha.changelly.dto.requests;

import ru.prpaha.changelly.dto.FixedRateAmount;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class GetFixedRatesForAmountRequest extends RPCRequest<Collection<FixedRateAmount>> {

    public GetFixedRatesForAmountRequest(Collection<FixedRateAmount> fixedRatesAmount) {
        super(UUID.randomUUID().toString(), "getFixRateForAmount", fixedRatesAmount);
    }

}
