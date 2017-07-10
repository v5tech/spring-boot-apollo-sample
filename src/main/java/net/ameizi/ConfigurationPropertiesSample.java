package net.ameizi;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 使用Spring Boot ConfigurationProperties方式
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "redis.cache")
public class ConfigurationPropertiesSample {

    private int expireSeconds;
    private int commandTimeout;

}
