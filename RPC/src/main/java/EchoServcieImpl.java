/** @Author: shuyizhi @Date: 2018-09-17 15:47 @Description: */
public class EchoServcieImpl implements EchoService {
    @Override
    public String echo(String ping) {
        System.out.println("ping: " + ping);
        return ping != null ? ping + "--> I am ok." : "I am ok.";
    }
}
