package bean;

import inter.IOutputGenerator;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 15:07
 * @Description:
 */
public class JsonOutpuGenerator implements IOutputGenerator {
    @Override
    public void generateOutput() {
        System.out.println("JsonOutputGenerator");
    }
}
