package es;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/** @Author: shuyizhi @Date: 2018-07-23 13:46 @Description: */
@WebService
public class HelloWorldService {
    public String sayHello(String name) {
        System.out.println("Hello " + name + "!");
        return name;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/helloWorld", new HelloWorldService());
        System.out.println("发布成功!");
    }
}
