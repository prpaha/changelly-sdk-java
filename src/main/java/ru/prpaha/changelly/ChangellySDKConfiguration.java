package ru.prpaha.changelly;

import com.google.gson.Gson;
import okhttp3.Cache;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.prpaha.changelly.service.ChangellyClient;
import ru.prpaha.changelly.service.ChangellyClientImpl;

import java.io.File;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Configuration
@ComponentScan("ru.prpaha.changelly")
public class ChangellySDKConfiguration {

    private static final String CHANGELLY_GSON = "CHANGELLY_GSON";
    private static final String CACHE_DIR = "./http_cache";

    @Value("${changelly.logging}")
    private Boolean logging;

    @Value("${changelly.cache}")
    private Boolean cache;

    @Value("${changelly.cacheSize}")
    private long cacheSize;

    @Value("${changelly.apiKey}")
    private String apiKey;

    @Value("${changelly.apiSecret}")
    private String apiSecret;

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ChangellyClient client(@Qualifier(CHANGELLY_GSON) final Gson gson, final OkHttpClient httpClient) {
        return new ChangellyClientImpl(apiKey, apiSecret, ChangellyConstants.MAIN_NET_URL, gson, httpClient);
    }

    @Bean(name = CHANGELLY_GSON)
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Gson gson() {
        return new Gson();
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public OkHttpClient httpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (logging) {
            builder.addInterceptor(new HttpLoggingInterceptor());
        }
        if (cache) {
            File cacheDir = new File(CACHE_DIR);
            builder.cache(new Cache(cacheDir, cacheSize));
        }
        return builder.build();
    }

}
