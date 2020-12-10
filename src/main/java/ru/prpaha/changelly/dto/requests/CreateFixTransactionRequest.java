package ru.prpaha.changelly.dto.requests;

import ru.prpaha.changelly.dto.CreateFixTransaction;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class CreateFixTransactionRequest extends RPCRequest<CreateFixTransaction>{

    public CreateFixTransactionRequest(CreateFixTransaction createFixTransaction) {
        super(UUID.randomUUID().toString(), "createFixTransaction", createFixTransaction);
    }

}
