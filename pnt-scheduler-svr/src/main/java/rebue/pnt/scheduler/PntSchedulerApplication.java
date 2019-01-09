package rebue.pnt.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringCloudApplication
@EnableScheduling
@EnableFeignClients(basePackages = { "rebue.pnt.svr.feign" })
public class PntSchedulerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PntSchedulerApplication.class, args);
    }

}
