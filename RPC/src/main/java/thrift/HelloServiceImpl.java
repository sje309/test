package thrift;

import org.apache.thrift.TException;

/** @Author: shuyizhi @Date: 2018-09-18 10:36 @Description: */
public class HelloServiceImpl implements Hello.Iface {
    @Override
    public String helloString(String para) throws TException {
        return "result: " + para;
    }
}
