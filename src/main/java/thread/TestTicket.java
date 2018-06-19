package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/27 14:35
 * @Description:
 */
public class TestTicket {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        Ticket ticket = new Ticket();
        for (int i = 0; i < 20; i++) {
            threads.add(new Thread(new TicketRunnable(ticket)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
