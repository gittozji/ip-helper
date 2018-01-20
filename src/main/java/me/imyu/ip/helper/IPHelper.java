package me.imyu.ip.helper;

import me.imyu.ip.util.HttpUtils;

/**
 * IP 帮助类
 * Created by imyu on 2018/1/18.
 */
public class IPHelper {
    public final static String GET_IP_INFO_URL = "http://ip.taobao.com/service/getIpInfo2.php?ip=myip";
    public final static String GET_IP_CONTENT_URL = "http://2017.ip138.com/ic.asp";

    /**
     * 获取外网 ip
     * @return 返回 ip 或者为 ""
     */
    public static String getIP() throws Exception {
        try {
            String content = HttpUtils.get(GET_IP_CONTENT_URL, "gb2312");
            return content.substring(content.indexOf("[") + 1, content.indexOf("]"));
        } catch (Exception e) {
            throw new Exception("IPHelper内容异常失败", e);
        }
    }
}
