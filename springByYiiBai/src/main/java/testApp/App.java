package testApp;

import aspectJ.CustomerBo;
import bean.*;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @Author: shuyizhi @Date: 2018-07-13 14:59 @Description: */
public class App {
    /** 获取applicationContext.xml 相关配置 */
    private static final ApplicationContext APPLICATION_CONTEXT =
            new ClassPathXmlApplicationContext("applicationContext.xml");

    /** 获取AppConfig.java类中配置的注解 */
    private static final ApplicationContext CONTEXT_ANNOTATION =
            new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {
        // testHelloBean();
        // testOutputBean();
        // testHelloBeanByAnnotation();
        // testGetInnerBean();
        // testFileNameGenerator();
        // testSingletonBean();
        // testPrototypeBean();
        // testCollectionBeans();
        // testSpringListFactoryBean();
        // testSpringBeanRequired();
        // testCustomerService();
        // testSpringELByXml();
        // testSpringElByAnnotation();
        // testSpringELOperators();
        // testSpringELCollectionsByAnnotation();
        // testSpringElCollectionByXml();
        // testAutoWired();
        // testAopExample();

        testAspectJ();
    }

    public static void testAspectJ() {
        CustomerBo customerBo = (CustomerBo) APPLICATION_CONTEXT.getBean("customerBo");
        // customerBo.addCustomer();
        customerBo.addCustomerAround("ccc");
        // customerBo.addCustomerReturnValue();
        // try {
        //    customerBo.addCustomerThrowException();
        // } catch (Exception e) {
        //    e.printStackTrace();
        //    System.out.println(e.getMessage());
        // }
    }

    /** aop 模拟测试 */
    public static void testAopExample() {
        // aop.CustomerService customerService = (aop.CustomerService)
        // APPLICATION_CONTEXT.getBean("customerServcieAop");
        //
        // System.out.println("*******************************************************************");
        // customerService.printName();
        //
        // System.out.println("*******************************************************************");
        // customerService.printURL();
        //
        // System.out.println("*******************************************************************");
        // customerService.printThrowException();

        aop.CustomerService customerService =
                (aop.CustomerService) APPLICATION_CONTEXT.getBean("customerServiceProxy");
        System.out.println("*******************************************************************");
        customerService.printName();

        System.out.println("*******************************************************************");
        customerService.printURL();

        // System.out.println("*******************************************************************");
        // customerService.printThrowException();

    }

    public static void testAutoWired() {
        autowired.Customer customer =
                (autowired.Customer) APPLICATION_CONTEXT.getBean("customerAutoWired");
        System.out.println(customer.getPerson().getAddress());
    }

    /** 测试SpringEl 表达式集合(List\Map xml配置方式) */
    public static void testSpringElCollectionByXml() {
        spEL.ElMapsByXml mapsByXml = (spEL.ElMapsByXml) APPLICATION_CONTEXT.getBean("elMapByXml");
        System.out.println("====================maps start===========================");
        for (String key : mapsByXml.getMap().keySet()) {
            System.out.print("key: " + key + " ----> " + mapsByXml.getMap().get(key) + "\n");
        }

        System.out.println("\n====================lists start===========================");
        for (String s : mapsByXml.getList()) {
            System.out.println(s);
        }

        System.out.println(
                "\n====================collection.toString() start===========================");
        spEL.ELCollectionsByXml collectionsByXml =
                (spEL.ELCollectionsByXml) APPLICATION_CONTEXT.getBean("elCollectionByXml");
        System.out.println(collectionsByXml.toString());
    }

    /** 测试SpringEL表达式集合(List\Map注解方式) */
    public static void testSpringELCollectionsByAnnotation() {
        spEL.ElMaps maps = (spEL.ElMaps) APPLICATION_CONTEXT.getBean("testBean");
        for (String key : maps.getMap().keySet()) {
            System.out.print("key: " + key + "---->" + maps.getMap().get(key) + "\n");
        }

        spEL.ELCollections elCollections =
                (spEL.ELCollections) APPLICATION_CONTEXT.getBean("elCollections");
        System.out.println(elCollections.toString());
    }

    /** 测试SpringEL表达式运算符 */
    public static void testSpringELOperators() {
        spEL.ElOperator elOperator =
                (spEL.ElOperator) APPLICATION_CONTEXT.getBean("eloperatorBean");
        System.out.println(elOperator.toString());
    }

    /**
     * 注解方式实现SpringEl 需要开启包扫描 <context:component-scan base-package="spEL"></context:component-scan>
     */
    public static void testSpringElByAnnotation() {
        spEL.ItemAnnotation itemAnnotation =
                (spEL.ItemAnnotation) APPLICATION_CONTEXT.getBean("itemBeanAnnotation");
        spEL.CustomerAnnotation customerAnnotation =
                (spEL.CustomerAnnotation) APPLICATION_CONTEXT.getBean("customerAnnotation");
        System.out.println(itemAnnotation.toString());
        // 获取addressBean 注解方式
        spEL.Address address = (spEL.Address) APPLICATION_CONTEXT.getBean("addressBean");
        System.out.println(address.getFullAddress("-"));

        // springEL 方法调用
        spEL.Price price = (spEL.Price) APPLICATION_CONTEXT.getBean("priceBean");
        spEL.CustomerELCall customerELCall =
                (spEL.CustomerELCall) APPLICATION_CONTEXT.getBean("customerBeanElCall");
        System.out.println(customerELCall.toString());
    }

    /** Xml方式配置SpringEl表达式 */
    public static void testSpringELByXml() {
        spEL.Item item = (spEL.Item) APPLICATION_CONTEXT.getBean("itemBeanEl");
        System.out.println(item.toString());

        spEL.Customer customer = (spEL.Customer) APPLICATION_CONTEXT.getBean("customerBeanEl");
        System.out.println(customer.toString());

        spEL.AddressByXml addressByXml =
                (spEL.AddressByXml) APPLICATION_CONTEXT.getBean("addressBeanXml");
        System.out.println(addressByXml.toString());

        spEL.CustomerByXml customerByXml =
                (spEL.CustomerByXml) APPLICATION_CONTEXT.getBean("customerBeanXml");
        System.out.println("customerByXml.getAddress(): " + customerByXml.getAddress());
        System.out.println("customerByXml.getFullAddress(): " + customerByXml.getFullAddress());
        System.out.println("customerByXml.getCountry(): " + customerByXml.getCountry());
    }

    public static void testHelloBean() {
        HelloWorld helloWorld = (HelloWorld) APPLICATION_CONTEXT.getBean("helloBean");
        helloWorld.printHello();
    }

    public static void testOutputBean() {
        OutputHelper helper = (OutputHelper) APPLICATION_CONTEXT.getBean("outputHelper");
        helper.generatorOutput();
    }

    public static void testHelloBeanByAnnotation() {
        HelloWorld helloWorld = (HelloWorld) CONTEXT_ANNOTATION.getBean("helloBeanByAnnotation");
        helloWorld.setName("中国科学技术大学先进技术院");
        helloWorld.printHello();
    }

    /** 测试内部Bean */
    public static void testGetInnerBean() {
        CustomerBean customerBean = (CustomerBean) APPLICATION_CONTEXT.getBean("customerInnerBean");
        System.out.println(customerBean.toString());
    }

    public static void testFileNameGenerator() {
        FileNameGenerator fileNameGenerator =
                (FileNameGenerator) APPLICATION_CONTEXT.getBean("fileNameGenerator");
        System.out.println(fileNameGenerator.toString());
    }

    /** Bean单例作用域::每个Spring IOC容器返回一个bean实例 */
    public static void testSingletonBean() {
        CustomerService customerServiceA =
                (CustomerService) APPLICATION_CONTEXT.getBean("customerServiceSingleton");
        customerServiceA.setMessage("A Customer Service");
        System.out.println("customerServiceA.getMessage(): " + customerServiceA.getMessage());

        CustomerService customerServiceB =
                (CustomerService) APPLICATION_CONTEXT.getBean("customerService");

        System.out.println("customerServiceB.getMessage(): " + customerServiceB.getMessage());
        /**
         * 输出： customerServiceA.getMessage(): A Customer Service customerServiceB.getMessage(): A
         * Customer Service
         */
    }

    public static void testPrototypeBean() {
        CustomerService customerServiceA =
                (CustomerService) APPLICATION_CONTEXT.getBean("customerServicePrototype");
        customerServiceA.setMessage("A Customer Service");
        System.out.println("customerServiceA.getMessage(): " + customerServiceA.getMessage());

        CustomerService customerServiceB =
                (CustomerService) APPLICATION_CONTEXT.getBean("customerServicePrototype");
        customerServiceB.setMessage("B Customer Service");
        System.out.println("CustomerServiceB.getMessage(): " + customerServiceB.getMessage());
        /**
         * 输出： customerServiceA.getMessage(): A Customer Service CustomerServiceB.getMessage(): B
         * Customer Service
         */
        /**
         * 输出: customerServiceA.getMessage(): A Customer Service customerServiceB.getMessage(): B
         * Customer Service
         */
    }

    /** Spring 注入集合 */
    public static void testCollectionBeans() {
        CustomerListBeans beans =
                (CustomerListBeans) APPLICATION_CONTEXT.getBean("customerListBeans");
        System.out.println("===========================List Start============================");
        for (Object obj : beans.getLists()) {
            System.out.println(obj.toString());
        }
        System.out.println("===========================List End============================");

        System.out.println("\n===========================Set Start============================");
        System.out.println(beans.getSets());
        System.out.println("===========================Set End==============================");

        System.out.println("\n===========================Map Start==============================");
        for (Object key : beans.getMaps().entrySet()) {
            System.out.print(key + " ----> ");
            System.out.print(beans.getMaps().get(key) + "\n");
        }
        System.out.println("===========================Map End==============================");

        System.out.println(
                "\n===========================Properties Start==============================");
        for (Object key : beans.getProperties().keySet()) {
            System.out.print(key + " ----> ");
            System.out.print(beans.getProperties().get(key) + "\n");
        }
        System.out.println(
                "===========================Properties End==============================");
    }

    /** Spring Bean配置文件中创建一个具体的集合类(ArrayList和LinkedList) */
    public static void testSpringListFactoryBean() {
        // 普通ArrayList方式
        // CustomerListFactoryBean bean = (CustomerListFactoryBean)
        // context.getBean("customerListFactory");
        // util模式
        CustomerListFactoryBean bean =
                (CustomerListFactoryBean)
                        APPLICATION_CONTEXT.getBean("customerListFactoryBeanByUtil");
        int len = bean.getLists().size();
        for (int i = 0; i < len; i++) {
            System.out.println(bean.getLists().get(i));
        }
        System.out.println("\n");
        for (Object obj : bean.getLists()) {
            System.out.println(obj);
        }
    }

    public static void testSpringBeanRequired() {
        springCheck.Person person =
                (springCheck.Person) APPLICATION_CONTEXT.getBean("personBeanCheckBySimple");
        System.out.println(person.toString());
    }

    public static void testCustomerService() {
        // service.CustomerService customerService = (service.CustomerService)
        // APPLICATION_CONTEXT.getBean("customerService");
        // System.out.println(customerService.getMessage());
        //// context.close()

        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        service.CustomerService customerService =
                (service.CustomerService) context.getBean("customerService");
        System.out.println(customerService.getMessage());
        context.close();
    }
}
