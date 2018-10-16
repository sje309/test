import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-09 10:44
 * @Description:
 */
@SuppressWarnings("unchecked")
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("--------程序开始运行----------");
        long start = System.currentTimeMillis();

        int taskSize = 5;
        /**创建一个线程池*/
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        /**创建多个有返回值的任务*/
        List<java.util.concurrent.Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable callable = new MyCallable(i + " ");
            /**执行任务并获取Future对象*/
            java.util.concurrent.Future future = pool.submit(callable);
            list.add(future);
        }
        /**关闭线程池*/
        pool.shutdown();
        /**获取所有并发任务的运行结果*/
        for (Future f : list) {
            /**从Future对象上获取任务的返回值，并输出到控制台*/
            System.out.println(">>>" + f.get().toString());
        }
        System.out.println("---------程序运行结束--------,程序运行时间【" + (System.currentTimeMillis() - start) + "ms】");
    }


   /* public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("-----------程序开始运行---------------");
        Date date1 = new Date();
        int taskSize = 5;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        //创建多个有返回值的任务
        List<java.util.concurrent.Future> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new MyCallable(i + " ");
            //执行任务并获取Future对象
            java.util.concurrent.Future future = pool.submit(c);
            list.add(future);
        }
        //关闭线程池
        pool.shutdown();
        //获取所有并发任务的运行结果
        for (Future f : list) {
            //从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }
        Date date2 = new Date();
        System.out.println("------------程序运行结束---------,程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

    *//**
     * 获取当前线程的名称
     *//*
    public static void getCurrentThreadName(){
        System.out.println(Thread.currentThread().getName());
    }*/
}
