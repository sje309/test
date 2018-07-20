package model;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 14:19
 * @Description:
 */
public class OutputHelper {
    IOutputGenerator outputGenerator;

    public void generateOutput() {
        outputGenerator.generateOutput();
    }

    public void setOutputGenerator(IOutputGenerator outputGenerator) {
        this.outputGenerator = outputGenerator;
    }
}
