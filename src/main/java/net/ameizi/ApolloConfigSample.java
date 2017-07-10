package net.ameizi;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @EnableApolloConfig要和@Configuration一起使用，不然不会生效。
 */
@Configuration
@EnableApolloConfig
public class ApolloConfigSample {

    @Bean
    public JavaConfigSample javaConfigSample(){
        return new JavaConfigSample();
    }

    @Bean
    public ConfigurationPropertiesSample configurationPropertiesSample() {
        return new ConfigurationPropertiesSample();
    }

}
