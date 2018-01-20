package me.imyu.ip.helper;

import me.imyu.ip.util.EmailUtils;

import javax.mail.MessagingException;

/**
 * 邮件帮助类
 * Created by imyu on 2018/1/18.
 */
public class EmailHelper {
    public final static String FORM = "xxx@163.com";
    public final static String TO = "xxx@163.com";
    public final static String USERNAME = "xxx@163.com";
    public final static String PASSWORD = "xxx";

    public static void send(String title, String content) {
        try {
            EmailUtils.send(FORM, TO, title, content, USERNAME, PASSWORD);
        } catch (MessagingException e) {
            // 不处理
        }
    }
}
