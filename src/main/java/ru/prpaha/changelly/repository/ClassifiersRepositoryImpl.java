package ru.prpaha.changelly.repository;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;
import ru.prpaha.changelly.dto.Currency;
import ru.prpaha.changelly.dto.requests.GetCurrenciesRequest;
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
        val response = changellyClient.invoke(new GetCurrenciesRequest(), CurrenciesResponse.class);
        return response.getResult();
    }

}
