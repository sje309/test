package thrift.helloWorld;

import org.apache.thrift.TException;

/** @Author: shuyizhi @Date: 2018-09-18 13:50 @Description: */
public class HelloWorldImpl implements HelloWorldService.Iface {
    @Override
    public String sayHello(User user) throws TException {
        return "Hi,My Name is " + user.getUsername() + " and My Age is " + user.getAge();
    }
}
