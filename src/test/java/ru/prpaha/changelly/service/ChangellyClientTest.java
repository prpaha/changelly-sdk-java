package ru.prpaha.changelly.service;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.prpaha.changelly.TestDataProvider;
import ru.prpaha.changelly.dto.Currency;
import ru.prpaha.changelly.dto.TestRequest;
import ru.prpaha.changelly.dto.TestResponse;
import ru.prpaha.changelly.dto.TestResponseData;
import ru.prpaha.changelly.dto.requests.GetCurrenciesRequest;
import ru.prpaha.changelly.dto.responses.CurrenciesResponse;
import ru.prpaha.changelly.dto.responses.RPCErrorResponse;
import ru.prpaha.changelly.exceptions.ChangellyExchangeException;
import ru.prpaha.changelly.exceptions.ChangellyHandleException;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@RunWith(MockitoJUnitRunner.class)
public class ChangellyClientTest {

    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");

    @Mock
    private OkHttpClient httpClient;

    @Test
    public void invokeSuccess() throws ChangellyHandleException, IOException {
        Gson gson = new Gson();

        Call call = Mockito.mock(Call.class);
        Mockito.when(httpClient.newCall(Mockito.any())).thenReturn(call);

        TestResponseData responseData = new TestResponseData(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        TestResponse testResponse = new TestResponse(responseData);
        ResponseBody responseBody = ResponseBody.create(MEDIA_TYPE, gson.toJson(testResponse));

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.body()).thenReturn(responseBody);
        Mockito.when(response.isSuccessful()).thenReturn(true);

        Mockito.when(call.execute()).thenReturn(response);

        ChangellyClient client = getClient(gson);
        TestResponse result = client.invoke(new TestRequest(UUID.randomUUID().toString(),
                UUID.randomUUID().toString()), TestResponse.class);
        Assertions.assertNotNull(result);
    }

    private ChangellyClientImpl getClient(Gson gson) {
        return new ChangellyClientImpl(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "http://some.com", gson, httpClient);
    }

    @Test
    public void invokeHandleHttpStatusError() throws IOException {
        Gson gson = new Gson();

        Call call = Mockito.mock(Call.class);
        Mockito.when(httpClient.newCall(Mockito.any())).thenReturn(call);

        TestResponse testResponse = TestDataProvider.getResponse();
        ResponseBody responseBody = ResponseBody.create(MEDIA_TYPE, gson.toJson(testResponse));

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.body()).thenReturn(responseBody);
        Mockito.when(response.isSuccessful()).thenReturn(false);

        Mockito.when(call.execute()).thenReturn(response);

        ChangellyClient client = getClient(gson);
        try {
            client.invoke(TestDataProvider.getRequest(), TestResponse.class);
            Assertions.fail();
        } catch (ChangellyHandleException e) {

        }
    }

    @Test
    public void invokeHandleBodyError() throws IOException {
        Gson gson = new Gson();

        Call call = Mockito.mock(Call.class);
        Mockito.when(httpClient.newCall(Mockito.any())).thenReturn(call);

        RPCErrorResponse errorResponse = TestDataProvider.getErrorResponse();
        ResponseBody responseBody = ResponseBody.create(MEDIA_TYPE, gson.toJson(errorResponse));

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.body()).thenReturn(responseBody);
        Mockito.when(response.isSuccessful()).thenReturn(true);

        Mockito.when(call.execute()).thenReturn(response);

        ChangellyClient client = getClient(gson);
        try {
            client.invoke(TestDataProvider.getRequest(), TestResponse.class);
            Assertions.fail();
        } catch (ChangellyHandleException e) {
            Assertions.assertNotNull(e.getError());
            Assertions.assertEquals(e.getError().getCode(), errorResponse.getError().getCode());
            Assertions.assertEquals(e.getError().getMessage(), errorResponse.getError().getMessage());
        }
    }

    @Test
    public void invokeEmptyBodyError() throws IOException, ChangellyHandleException {
        Gson gson = new Gson();

        Call call = Mockito.mock(Call.class);
        Mockito.when(httpClient.newCall(Mockito.any())).thenReturn(call);

        TestResponse testResponse = TestDataProvider.getResponse();
        ResponseBody responseBody = ResponseBody.create(MEDIA_TYPE, gson.toJson(testResponse));

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.body()).thenReturn(null);
        Mockito.when(response.isSuccessful()).thenReturn(true);

        Mockito.when(call.execute()).thenReturn(response);

        ChangellyClient client = getClient(gson);
        try {
            client.invoke(TestDataProvider.getRequest(), TestResponse.class);
            Assertions.fail();
        } catch (ChangellyExchangeException e) {

        }
    }

    @Test
    public void getCurrenciesSuccess() throws IOException, ChangellyHandleException {
        Gson gson = new Gson();

        Call call = Mockito.mock(Call.class);
        Mockito.when(httpClient.newCall(Mockito.any())).thenReturn(call);

        CurrenciesResponse currenciesResponse = new CurrenciesResponse(UUID.randomUUID().toString(),
                UUID.randomUUID().toString(), Arrays.asList(
                        Currency.btc,
                        Currency.doge,
                        Currency.eth,
                        Currency.lsk,
                        Currency.xem,
                        Currency.zec
        ));
        ResponseBody responseBody = ResponseBody.create(MEDIA_TYPE, gson.toJson(currenciesResponse));

        Response response = Mockito.mock(Response.class);
        Mockito.when(response.body()).thenReturn(responseBody);
        Mockito.when(response.isSuccessful()).thenReturn(true);

        Mockito.when(call.execute()).thenReturn(response);

        ChangellyClient client = getClient(gson);
        CurrenciesResponse result = client.invoke(new GetCurrenciesRequest(), CurrenciesResponse.class);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), currenciesResponse.getId());
        Assertions.assertEquals(result.getJsonrpc(), currenciesResponse.getJsonrpc());
        Assertions.assertEquals(result.getResult().size(), currenciesResponse.getResult().size());
    }

}
