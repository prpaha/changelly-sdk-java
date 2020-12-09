package ru.prpaha.changelly.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import ru.prpaha.changelly.dto.RPCRequest;
import ru.prpaha.changelly.dto.RPCResponse;
import ru.prpaha.changelly.exceptions.ChangellyExchangeException;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;
import ru.prpaha.changelly.exceptions.SignNotCompiled;
import ru.prpaha.changelly.utils.SignBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@RequiredArgsConstructor
public class ChangellyClientImpl implements ChangellyClient {

    private static final String API_KEY = "api-key";
    private static final String SIGN = "sign";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private final String apiKey;
    private final String apiSecret;
    private final String serviceUrl;
    private final Gson gson;
    private final OkHttpClient httpClient;

    /**
     * @param request
     * @param <REQUEST>
     * @param <RESPONSE>
     * @return
     * @throws SignNotCompiled
     * @throws ChangellyExchangeException
     * @throws ChangellyHandleException
     */
    @Override
    public <REQUEST extends RPCRequest<?>, RESPONSE extends RPCResponse<?>> RESPONSE invoke(REQUEST request,
                                                                                            Class<RESPONSE> clazz)
            throws ChangellyHandleException {
        String requestBody = gson.toJson(request);
        try {
            Call call = httpClient.newCall(new Request.Builder()
                    .url(serviceUrl)
                    .addHeader(API_KEY, apiKey)
                    .addHeader(SIGN, SignBuilder.build(apiSecret, requestBody))
                    .post(RequestBody.create(requestBody, JSON))
                    .build());
            Response response = call.execute();
            Optional<ResponseBody> body = Optional.ofNullable(response.body());
            if (!response.isSuccessful()) {
                throw new ChangellyHandleException(response.code(), body.isPresent() ? response.body().string() : null);
            }
            if (body.isEmpty()) {
                throw new ChangellyExchangeException();
            }
            return gson.fromJson(body.get().string(), clazz);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new SignNotCompiled(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ChangellyExchangeException(e);
        }
    }

}
