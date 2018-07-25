import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: shuyizhi @Date: 2018-07-25 13:43 @Description: dom4j解析xml 参考:
 * https://blog.csdn.net/rickyit/article/details/53813246 https://dom4j.github.io/
 */
public class Dom4jSAX {
    private static ArrayList<Book> bookList = new ArrayList<>();
    /** 解析books.xml */
    public static void readXml() {
        // 创建SAXReader对象
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载books.xml,获取document对象
            Document document =
                    reader.read(Dom4jSAX.class.getClassLoader().getResourceAsStream("books.xml"));
            // 通过document对象获取根节点bookStore
            Element bookStore = document.getRootElement();
            // 获取迭代器
            Iterator iterator = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息
            System.out.println("=================开始遍历某一本书=========================");
            while (iterator.hasNext()) {
                Element book = (Element) iterator.next();
                List<Attribute> bookAttrs = book.attributes();
                for (Attribute attr : bookAttrs) {
                    System.out.println("属性名: " + attr.getName() + "-----属性值: " + attr.getValue());
                }
                Iterator itt = book.elementIterator();
                while (itt.hasNext()) {
                    Element bookChild = (Element) itt.next();
                    System.out.println(
                            "节点名: "
                                    + bookChild.getName()
                                    + "----节点值: "
                                    + bookChild.getStringValue());
                }
            }
            System.out.println("=================遍历某一本书结束=========================");

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * SAXReader读取xml
     *
     * @param xmlPath xml文件路径
     * @throws DocumentException
     */
    public static void readXmlByXmlReader(String xmlPath) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(xmlPath));
        Element root = document.getRootElement();
        // 获取迭代器
        Iterator iterator = root.elementIterator();
        // 遍历迭代器,获取信息
        System.out.println(
                "============================开始遍历======================================");
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            List<Attribute> attributes = element.attributes();
            for (Attribute attribute : attributes) {
                System.out.println(
                        "属性名: " + attribute.getName() + "---属性值: " + attribute.getValue());
            }
            Iterator itt = element.elementIterator();
            while (itt.hasNext()) {
                Element child = (Element) itt.next();
                System.out.println("节点名: " + child.getName() + "---节点值: " + child.getStringValue());
            }
        }
        System.out.println(
                "============================遍历结束======================================");
    }

    /**
     * 创建xml文件
     *
     * @throws IOException
     */
    public static void createXml() throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");
        Element author1 =
                root.addElement("author")
                        .addAttribute("name", "束义志")
                        .addAttribute("location", "中国合肥")
                        .addText("James Strachan");
        Element author2 =
                root.addElement("author")
                        .addAttribute("name", "束糖豆")
                        .addAttribute("locatoin", "中国合肥")
                        .addText("Bob McWhirter");
        System.out.println(Dom4jSAX.class.getResource("").getPath()); // 输出文件保存路径
        FileWriter out = new FileWriter(Dom4jSAX.class.getResource("").getPath() + "foo.xml");
        document.write(out);
        out.flush();
        out.close();
    }

    /**
     * 创建xml文档(document)
     *
     * @return Document
     */
    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        // 设置根节点
        Element root = document.addElement("root");
        document.setXMLEncoding("UTF-8");
        // 增加子节点，设置属性和属性值
        for (int i = 0; i < 10; i++) {
            root.addElement("author")
                    .addAttribute("name", "shuyizhi" + (i + 1))
                    .addAttribute("location", "中国合肥")
                    .addText("束义志" + (i + 1));
        }
        return document;
    }

    /**
     * 根据指定的Document创建xml文件
     *
     * @param document
     * @throws IOException
     */
    public static void createXmlFileByXmlWriter(Document document) throws IOException {
        System.out.println(Dom4jSAX.class.getResource("").getPath()); // 输出文件保存路径
        FileWriter fileWriter =
                new FileWriter(Dom4jSAX.class.getResource("").getPath() + "test.xml");
        XMLWriter writer = new XMLWriter(fileWriter);
        writer.write(document);
        writer.flush();
        writer.close();
    }
}
