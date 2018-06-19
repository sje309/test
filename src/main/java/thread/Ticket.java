package thread;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 14:24
 * @Description:
 */
public class Ticket {
    private static final int DEFAULT_TICKET_COUNT = 1000;
    private int count = DEFAULT_TICKET_COUNT;
    private int buyedCount = 0;

    public boolean buyTicket(int count) throws InterruptedException {
        if (this.count - count < 0) {
            Thread.sleep(10);
            return false;
        } else {
            this.count = this.count - count;
            Thread.sleep(1);
            this.buyedCount = this.buyedCount + count;
            return true;
        }
    }

    public int getCount() {
        return count;
    }

    public int getBuyedCount() {
        return buyedCount;
    }

    public int getAllCount() {
        return count + buyedCount;
    }
}
