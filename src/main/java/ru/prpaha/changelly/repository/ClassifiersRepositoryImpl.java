package ru.prpaha.changelly.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.prpaha.changelly.dto.Currency;
import ru.prpaha.changelly.dto.CurrencyFull;
import ru.prpaha.changelly.dto.requests.GetCurrenciesFullRequest;
import ru.prpaha.changelly.dto.requests.GetCurrenciesRequest;
import ru.prpaha.changelly.dto.responses.CurrenciesFullResponse;
import ru.prpaha.changelly.dto.responses.CurrenciesResponse;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;
import ru.prpaha.changelly.service.ChangellyClient;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Repository
@AllArgsConstructor
public class ClassifiersRepositoryImpl implements ClassifiersRepository {

    private final ChangellyClient changellyClient;

    @Override
    public Collection<Currency> getCurrencies() throws ChangellyHandleException {
        var response = changellyClient.invoke(new GetCurrenciesRequest(), CurrenciesResponse.class);
        return response.getResult();
    }

    @Override
    public Collection<CurrencyFull> getCurrenciesFull() throws ChangellyHandleException {
        var response = changellyClient.invoke(new GetCurrenciesFullRequest(), CurrenciesFullResponse.class);
        return response.getResult();
    }

}
