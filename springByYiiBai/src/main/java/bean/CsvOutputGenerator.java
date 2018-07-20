package bean;

import inter.IOutputGenerator;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 15:04
 * @Description:
 */
public class CsvOutputGenerator implements IOutputGenerator {
    @Override
    public void generateOutput() {
        System.out.println("CsvOutputGenerator");
    }
}
