package me.imyu.ip;

import me.imyu.ip.helper.EmailHelper;
import me.imyu.ip.helper.IPHelper;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 主控
 * Created by imyu on 2018/1/18.
 */
public class Controller {
    private static String IP = "";
    public static void main(String[] args) {
        System.out.println("开始运行...");
        // 变更通知
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    String ip = IPHelper.getIP();
                    if (!IP.equals(ip)) {
                        System.out.println("home-web ip 地址变更通知 " + ip);
                        EmailHelper.send("home-web ip 地址变更通知", ip);
                        System.out.println("成功执行发送邮件代码");
                        IP = ip;
                    }
                } catch (Exception e) {
                    System.out.println("异常发生");
                    e.printStackTrace();
                }
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 1, 1, TimeUnit.MINUTES);
    }

}
