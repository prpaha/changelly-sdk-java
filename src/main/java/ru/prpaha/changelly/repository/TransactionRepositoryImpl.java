package ru.prpaha.changelly.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.prpaha.changelly.dto.Transaction;
import ru.prpaha.changelly.dto.requests.CreateFixTransactionRequest;
import ru.prpaha.changelly.dto.responses.TransactionFixResponse;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;
import ru.prpaha.changelly.service.ChangellyClient;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Repository
@AllArgsConstructor
public class TransactionRepositoryImpl implements TransactionRepository {

    private final ChangellyClient changellyClient;

    @Override
    public Transaction createFixTransaction(final CreateFixTransactionRequest request) throws ChangellyHandleException {
        TransactionFixResponse response = changellyClient.invoke(request, TransactionFixResponse.class);
        return response.getResult();
    }
}
