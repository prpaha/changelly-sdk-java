package ru.prpaha.changelly.repository;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;
import ru.prpaha.changelly.dto.FixedRate;
import ru.prpaha.changelly.dto.requests.GetFixedRatesRequest;
import ru.prpaha.changelly.dto.responses.FixedRatesResponse;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;
import ru.prpaha.changelly.service.ChangellyClient;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@AllArgsConstructor
@Repository
public class RatesRepositoryImpl implements RatesRepository {

    private final ChangellyClient changellyClient;

    @Override
    public Collection<FixedRate> getFixedRates(GetFixedRatesRequest request) throws ChangellyHandleException {
        val ratesResponse = changellyClient.invoke(request, FixedRatesResponse.class);
        return ratesResponse.getResult();
    }
}
