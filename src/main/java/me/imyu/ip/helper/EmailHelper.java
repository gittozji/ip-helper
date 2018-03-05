package me.imyu.ip.helper;

import me.imyu.ip.util.EmailUtils;

import javax.mail.MessagingException;

/**
 * 邮件帮助类
 * Created by imyu on 2018/1/18.
 */
public class EmailHelper {
    public final static String FORM = "xxxx@163.com";
    public final static String TO = "xxxx@163.com";
    public final static String USERNAME = "xxxx@163.com";
    public final static String PASSWORD = "xxxx";

    public static void send(String title, String content) {
        try {
            StringBuilder text = new StringBuilder();
            text.append("<!DOCTYPE html>");
            text.append("<html lang=\"en\">");
            text.append("<head>");
            text.append("<meta charset=\"UTF-8\">");
            text.append("<title>home</title>");
            text.append("</head>");
            text.append("<body>");
            text.append("<p>" + content + "</p>");
            text.append("<a href=\"http://"+content+":9191/home/base/\">首页</a>");
            text.append("<br/>");
            text.append("<br/>");
            text.append("<a href=\"http://"+content+":9191/home/base/pages/login.html\">登录</a>");
            text.append("</body>");
            text.append("</html>");
            EmailUtils.send(FORM, TO, title, text.toString(), USERNAME, PASSWORD);
        } catch (MessagingException e) {
            // 不处理
        }
    }
}
