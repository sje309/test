package thread;

import java.util.Random;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 14:28
 * @Description: 模拟售票
 */
public class TicketRunnable implements Runnable {
    private Ticket ticket;
    private Random random;

    public TicketRunnable(Ticket ticket) {
        this.ticket = ticket;
        random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (ticket) {
                try {
                    int count = random.nextInt(10) + 1;
                    boolean success = ticket.buyTicket(count);
                    System.out.println(String.format("%s打算买%d张票,买票%s了,还剩下%d张票，总共卖掉%d张票,总票数%d",
                            Thread.currentThread().getName(), count, success == true ? "成功" : "失败",
                            ticket.getCount(), ticket.getBuyedCount(), ticket.getAllCount()));
                    if (!success) {
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
