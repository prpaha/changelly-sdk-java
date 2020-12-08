package ru.prpaha.changelly;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.prpaha.changelly.api.DefaultApi;
import ru.prpaha.changelly.invoker.ApiClient;

import java.text.SimpleDateFormat;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Configuration
@ComponentScan("ru.prpaha.changelly")
public class ChangellySDKConfiguration {

    @Value("${changelly.mainNet}")
    private Boolean mainNet;

    @Value("${changelly.apiKey}")
    private String changellyApiKey;

    @Bean
    public DefaultApi defaultApi() {
        return new DefaultApi(createApiClient());
    }

    private ApiClient createApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(mainNet ? ChangellyConstants.MAIN_NET_URL : ChangellyConstants.TEST_NET_URL);
        apiClient.setApiKeyPrefix(ChangellyConstants.API_KEY_PREFIX);
        apiClient.setApiKey(changellyApiKey);
        apiClient.setDateFormat(new SimpleDateFormat(ChangellyConstants.DATE_TIME_FORMAT));
        return apiClient;
    }

}
