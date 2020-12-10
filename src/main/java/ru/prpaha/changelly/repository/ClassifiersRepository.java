package ru.prpaha.changelly.repository;

import ru.prpaha.changelly.dto.Currency;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface ClassifiersRepository {


    Collection<Currency> getCurrencies() throws ChangellyHandleException;
}
