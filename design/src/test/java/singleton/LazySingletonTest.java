package singleton;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/** @Author: shuyizhi @Date: 2018-08-14 9:27 @Description: */
public class LazySingletonTest {
    @Test
    public void testLazySingle() {

        /*  LazySingleton lazySingleton1 = LazySingleton.getLazyInstance();
        LazySingleton lazySingleton2 = LazySingleton.getLazyInstance();
        LazySingleton lazySingleton3 = LazySingleton.getLazyInstance();*/

        /** 多线程环境下测试 */
        for (int i = 0; i < 100; i++) {
            new Thread(
                            () -> {
                                LazySingleton lazySingleton = LazySingleton.getLazyInstance();
                            })
                    .start();
        }
    }

    @Test
    public void testNoLazySingle() {
        // NoLazySingleton noLazySingleton1 = NoLazySingleton.getInstance();
        // NoLazySingleton noLazySingleton2 = NoLazySingleton.getInstance();
        // NoLazySingleton noLazySingleton3 = NoLazySingleton.getInstance();
        // NoLazySingleton noLazySingleton4 = NoLazySingleton.getInstance();

        for (int i = 0; i < 2000; i++) {
            new Thread(
                            () -> {
                                NoLazySingleton noLazySingleton = NoLazySingleton.getInstance();
                            })
                    .start();
        }

    }

    @Test
    public void testSafeLazySingle() {
        for (int i = 0; i < 100; i++) {
            new Thread(
                            () -> {
                                SafeLazySingleton safeLazySingleton =
                                        SafeLazySingleton.getInstance();
                            })
                    .start();
        }
    }

    public static int getDataByIndex(int index, int[] data) {
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return data[index];
    }

    public static int getDataByIndex1(int index, int[] data) {
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return data[index];
    }

    @Test
    public void testException() {
        String res = openFile();
        System.out.println("方法返回: " + res);
    }

    public static String openFile() {
        try {
            FileInputStream inputStream = new FileInputStream("D:\\ccc7.json");
            int ch = inputStream.read();
            System.out.println("aaa");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not found");
            return "step2";
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("io exception");
            return "step";
        } finally {
            System.out.println("finally block");
            return "finally";
        }
        // return "OK";
    }
}

class MultiTest implements Runnable {
    @Override
    public void run() {
        LazySingleton lazySingleton = LazySingleton.getLazyInstance();
    }
}
