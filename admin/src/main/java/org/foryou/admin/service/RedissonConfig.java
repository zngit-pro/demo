package org.foryou.admin.service;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.CacheConfig;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author 1016823429@qq.com
 * date 2018/5/11
 **/
@ConfigurationProperties("spring.redisson")
@Configuration
public class RedissonConfig {
    private String master;
    private String[] slave;
    private String password;

    @Bean(destroyMethod = "shutdown")
    RedissonClient redisson() throws IOException {
        Config config = new Config();
        config.useMasterSlaveServers()
                .setMasterAddress(this.getMaster())
                .addSlaveAddress(this.getSlave())
                .setPassword(this.getPassword());
        return Redisson.create(config);
    }

    @Bean
    CacheManager cacheManager(RedissonClient redissonClient) {
        Map<String, CacheConfig> config = new HashMap<String, CacheConfig>();
        config.put("exp10s", new CacheConfig(10 * 1000, 12 * 60 * 1000));
        config.put("expnever", new CacheConfig(0, 12 * 60 * 1000));
        return new RedissonSpringCacheManager(redissonClient, config);
    }


    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String[] getSlave() {
        return slave;
    }

    public void setSlave(String[] slave) {
        this.slave = slave;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
