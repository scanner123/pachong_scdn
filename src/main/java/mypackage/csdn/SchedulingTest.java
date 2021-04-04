package mypackage.csdn;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static mypackage.csdn.Tool.doGet2;
import static mypackage.csdn.Tool.parse;

/**
 * 3.创建一个SchedulingTest类来完成这个任务
 */
@Component
public class SchedulingTest {
    private int i = 0;

    @Scheduled(fixedRate = 60 * 1000)//具体时间间隔，60*1000也就是1分钟执行一次
    void doSomethingWith() {
        String url = "https://blog.csdn.net/weixin_42063820";
        String body= Tool.doGet(url);
        Elements elements=parse(body);
            for (Element ele:elements)
        {
            String urlEle=ele.attr("href");
            System.out.println("获取到的地址urlEle:"+urlEle);
            doGet2(urlEle);
        }
        i++;
        System.out.println("第" + i + "次访问");
    }

    public static void main(String[] args) {
        SchedulingTest schedulingTest = new SchedulingTest();
        schedulingTest.doSomethingWith();
    }
}
