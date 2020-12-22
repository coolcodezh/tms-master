package vip.coolcode.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"vip.coolcode.account.mapper"})
public class AccountConfig {

    public AccountConfig() {
        System.out.println("配置类");
    }
}
