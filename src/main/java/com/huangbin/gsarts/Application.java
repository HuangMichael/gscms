
package com.huangbin.gsarts;

import com.huangbin.gsarts.liseners.AppilicationSessionExpire;
import com.huangbin.gsarts.liseners.AppilicationStartUp;
import com.huangbin.gsarts.liseners.AppilicationStopped;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 初始化入口
 */
@EnableTransactionManagement //启用事务管理
@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
@EnableScheduling //开启调度
@EnableCaching //开启缓存

public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(new AppilicationStartUp());
        app.addListeners(new AppilicationSessionExpire());
        app.addListeners(new AppilicationStopped());
        app.run(args);
    }
}
