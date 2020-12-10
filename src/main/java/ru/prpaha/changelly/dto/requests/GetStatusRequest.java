package ru.prpaha.changelly.dto.requests;

import ru.prpaha.changelly.dto.GetStatus;

import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
public class GetStatusRequest extends RPCRequest<GetStatus>{

    public GetStatusRequest(GetStatus getStatus) {
        super(UUID.randomUUID().toString(), "getStatus", getStatus);
    }

}
