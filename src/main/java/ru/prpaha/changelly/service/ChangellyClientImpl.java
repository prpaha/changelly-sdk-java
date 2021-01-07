package ru.prpaha.changelly.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.util.StringUtils;
import ru.prpaha.changelly.dto.Error;
import ru.prpaha.changelly.dto.requests.RPCRequest;
import ru.prpaha.changelly.dto.responses.RPCResponse;
import ru.prpaha.changelly.exceptions.ChangellyExchangeException;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;
import ru.prpaha.changelly.exceptions.SignNotCompiled;
import ru.prpaha.changelly.utils.SignBuilder;

import java.io.IOException;
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
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final String ERROR = "error";
    private static final String CODE = "code";
    private static final String MESSAGE = "message";

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
                    .post(RequestBody.create(JSON, requestBody))
                    .build());
            Response response = call.execute();
            Optional<ResponseBody> body = Optional.ofNullable(response.body());
            if (!response.isSuccessful()) {
                throw new ChangellyHandleException(new Error(response.code(),
                        body.isPresent() ? response.body().string() : null));
            }
            if (!body.isPresent()) {
                throw new ChangellyExchangeException();
            }
            String responseBodyString = body.get().string();
            checkError(responseBodyString);
            return gson.fromJson(responseBodyString, clazz);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new SignNotCompiled(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ChangellyExchangeException(e);
        }
    }

    private void checkError(final String body) throws IOException, ChangellyHandleException {
        if (StringUtils.isEmpty(body)) {
            throw new ChangellyExchangeException();
        }

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(body).getAsJsonObject();
        if (jsonObject.has(ERROR)) {
            JsonObject error = jsonObject.getAsJsonObject(ERROR);
            int code = error.get(CODE).getAsInt();
            String message = error.get(MESSAGE).getAsString();
            throw new ChangellyHandleException(new Error(code, message));
        }
    }

}
