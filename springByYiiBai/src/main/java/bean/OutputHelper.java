package bean;

import inter.IOutputGenerator;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 15:13
 * @Description:
 */
public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generatorOutput() {
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator generator) {
        this.outputGenerator = generator;
    }
}
