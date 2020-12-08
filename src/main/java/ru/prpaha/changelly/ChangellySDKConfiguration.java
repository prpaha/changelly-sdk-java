package ru.prpaha.changelly;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.prpaha.changelly.service.ChangellyClient;
import ru.prpaha.changelly.service.ChangellyClientImpl;

/**
 * @author Proskurin Pavel (prpaha@rambler.ru)
 */
@Configuration
@ComponentScan("ru.prpaha.changelly")
public class ChangellySDKConfiguration {

    @Value("${changelly.apiKey}")
    private String changellyApiKey;

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ChangellyClient client() {
        return new ChangellyClientImpl(ChangellyConstants.MAIN_NET_URL, changellyApiKey);
    }

}
