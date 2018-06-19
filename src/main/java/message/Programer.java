package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 10:59
 * @Description:
 */
public class Programer {
    public void study(CallbackInterface callbackInterface) {
        int result = 0;
        do {
            result++;
            System.out.println("第" + result + "次研究的结果");
        } while (!callbackInterface.check(result));
        System.out.println("调研任务结束");
    }
}
