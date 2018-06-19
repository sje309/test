package jetty;

import org.eclipse.jetty.server.Server;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/30 10:35
 * @Description:
 */
public class JettyService {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8989);
        server.setHandler(new TestController());
        server.start();
        server.join();
    }
}
