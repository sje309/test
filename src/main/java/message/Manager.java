package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 10:59
 * @Description:
 */
public class Manager implements CallbackInterface {
    private Programer programer = null;

    public Manager(Programer programer) {
        this.programer = programer;
    }

    public void entrust() {
        arrange();
    }

    private void arrange() {
        System.out.println("Manager 正在为Programmer安排工作");
        programer.study(this);
        System.out.println("为 Programmer 安排工作已经完成，Manager 做其他的事情去了。");
    }

    @Override
    public boolean check(int result) {
        return result == 5 ? Boolean.TRUE : Boolean.FALSE;
    }
}
