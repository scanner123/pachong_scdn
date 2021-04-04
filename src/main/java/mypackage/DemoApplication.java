package mypackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 2.创建定时任务Scheduled，每隔1分钟来请求一次去访问博客
 * 可以用Spirng的@Scheduled来完成这个定时任务，我的项目是Spring boot，
 * 在启动类DemoApplication上方加上@EnableScheduling 来开启定时任务。
 */
@SpringBootApplication
@EnableScheduling//开启定时任务
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

