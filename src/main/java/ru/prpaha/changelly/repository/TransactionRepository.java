package ru.prpaha.changelly.repository;

import ru.prpaha.changelly.dto.Transaction;
import ru.prpaha.changelly.dto.requests.CreateFixTransactionRequest;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public interface TransactionRepository {

    Transaction createFixTransaction(CreateFixTransactionRequest request) throws ChangellyHandleException;

}
