package com.zh.SpringBootDemo.tasks;

import java.util.Random;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/*为了让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync，如下所示：

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
*/
//注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效

@Component
public class AsyncTask {
	
	public static Random random =new Random();

	@Async
    public void doTaskOne() throws Exception {
        System.out.println("任务一开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一结束共耗时：" + (end - start) + "毫秒");
    }

	@Async
    public void doTaskTwo() throws Exception {
        System.out.println("任务二开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二结束共耗时：" + (end - start) + "毫秒");
    }

	@Async
    public void doTaskThree() throws Exception {
        System.out.println("任务三开始");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三结束共耗时：" + (end - start) + "毫秒");
    }

}
