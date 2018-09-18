import java.net.InetSocketAddress;

/** @Author: shuyizhi @Date: 2018-09-17 17:27 @Description: */
public class RpcTest {
    public static void main(String[] args) throws Exception {
        new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    RpcExporter.exporter("localhost", 8088);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        })
                .start();
        RpcImporter<EchoService> importer = new RpcImporter<>();
        EchoService echo =
                importer.importer(EchoServcieImpl.class, new InetSocketAddress("localhost", 8088));
        System.out.println(echo.echo("Are you ok?"));
    }
}
