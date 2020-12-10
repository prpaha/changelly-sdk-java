package ru.prpaha.changelly.repository;

import ru.prpaha.changelly.dto.Currencies;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

import java.util.Collection;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface ClassifiersRepository {


    Collection<Currencies> getCurrencies() throws ChangellyHandleException;
}
