package tcpip;

import java.util.ResourceBundle;

/** @Author: shuyizhi @Date: 2018-08-09 11:33 @Description: 获取有关ipaddress.propertis配置信息 */
public class IpCommons {
    public static String ipaddress;
    public static int port;

    static {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("ipadress");
        ipaddress = resourceBundle.getString("ip");
        port = Integer.parseInt(resourceBundle.getString("port"));
    }
}
