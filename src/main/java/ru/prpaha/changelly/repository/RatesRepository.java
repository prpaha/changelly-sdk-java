package ru.prpaha.changelly.repository;

import ru.prpaha.changelly.dto.FixedRate;
import ru.prpaha.changelly.dto.requests.GetFixedRatesRequest;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface RatesRepository {

    Collection<FixedRate> getFixedRates(GetFixedRatesRequest request) throws ChangellyHandleException;

}
