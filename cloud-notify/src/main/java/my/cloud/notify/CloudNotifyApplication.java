package my.cloud.notify;

import my.cloud.notify.utils.properties.MailProperties;
import my.cloud.notify.utils.properties.TeamPlusProperties;
import my.cloud.notify.utils.properties.XSMSProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by Kevin Chang on 2022/7/7.
 **/
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties({TeamPlusProperties.class, XSMSProperties.class, MailProperties.class})
public class CloudNotifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudNotifyApplication.class,args);
    }
}
