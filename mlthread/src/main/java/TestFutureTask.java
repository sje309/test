import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 13:22
 * @Description: FutureTask 子线程完成任务后，把得到的结果回传给主线程
 * 参考：http://www.importnew.com/26850.html
 */
public class TestFutureTask {
    public static void main(String[] args) {
        doTaskWithResultInworker();
    }

    private static void doTaskWithResultInworker() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1 * 1000);
                int result = 0;
                for (int i = 0; i <= 1000; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        System.out.println("Before futureTask.get()");
        try {
            System.out.println("Result: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("After futureTask.get()");
    }
}
