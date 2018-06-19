package message;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/12 10:11
 * @Description:
 */
public class Message {
    public static final int KEY_MSG = 1;
    public static final int MOUSE_MSG = 2;
    public static final int SYS_MSG = 3;

    private Object source;
    private int type;
    private String info;

    public Message(Object source, int type, String info) {
        this.source = source;
        this.type = type;
        this.info = info;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
