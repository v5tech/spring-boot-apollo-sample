package net.ameizi;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.factory.annotation.Value;

/**
 * 使用Java Config方式
 * 使用@ApolloConfig自动注入Config对象
 * 使用@ApolloConfigChangeListener自动注入ConfigChangeListener对象
 * 当监听到属性值发生变化后使用Config API修改属性值
 */
public class JavaConfigSample {

    /**
     * @ApolloConfig用来自动注入Config对象
     */
    @ApolloConfig
    private Config config;

    @Value("${timeout:100}")
    private int timeout;
    private int batch;

    @Value("${batch:200}")
    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * @ApolloConfigChangeListener用来自动注册ConfigChangeListener
     */
    @ApolloConfigChangeListener
    private void someOnChange(ConfigChangeEvent changeEvent) {
        changeEvent.changedKeys().forEach(key ->{
            ConfigChange change = changeEvent.getChange(key);
            System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
        });
        if (changeEvent.isChanged("batch")) {
            batch = config.getIntProperty("batch", 200);
        }
    }

    public int getTimeout() {
        return config.getIntProperty("timeout",100);
    }

    public int getBatch() {
        return this.batch;
    }
}
