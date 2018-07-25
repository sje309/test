import org.apache.commons.lang.StringUtils;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: shuyizhi @Date: 2018-07-24 16:09 @Description: DOM解析
 * 参考：https://blog.csdn.net/rickyit/article/details/53813246
 */
public class DomAnalysis {
    /** 解析books.xml */
    public static void domAnalyer() {
        // 创建一个DocumentBuilderFactory的对象
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            // 创建一个DocumentBuilder的对象
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            // 通过DocumentBuilder对象的parser方法加载books.xml文件到当前项目下
            org.w3c.dom.Document document =
                    documentBuilder.parse(DomAnalysis.class.getResourceAsStream("books.xml"));
            // 获取所有的book节点的集合
            NodeList bookList = document.getElementsByTagName("book");
            // 通过获取nodeList的getLength()方法获取bookList的长度
            System.out.println("一共有: " + bookList.getLength() + " 本书");
            // 遍历book节点
            int length = bookList.getLength();
            for (int i = 0; i < length; i++) {
                System.out.println(StringUtils.center("开始遍历第" + (i + 1) + "本书的内容", 40, "="));
                // 通过item(i)方法获取一个book节点,nodeList的索引值从0开始
                Node book = bookList.item(i);
                // 获取book节点的所有属性集合
                NamedNodeMap attrs = book.getAttributes();
                // 遍历book的属性
                int attrLength = attrs.getLength();
                for (int j = 0; j < attrLength; j++) {
                    // 通过item(index)方法获取book节点的某个属性
                    Node attr = attrs.item(j);
                    // 获取属性名
                    System.out.print("属性名: " + attr.getNodeName());
                    // 获取属性值
                    System.out.println("----> 属性值: " + attr.getNodeValue());
                }
                // 解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                // 遍历childNodes获取每个节点的节点名和节点值
                System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");
                // 遍历子节点
                for (int k = 0; k < childNodes.getLength(); k++) {
                    // 区分text类型的node以及element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        // 获取element类型节点的节点名
                        System.out.print(
                                "第" + (k + 1) + "个节点的节点名: " + childNodes.item(k).getNodeName());
                        // 获取element类型节点的节点值
                        System.out.println(
                                "----> 节点值: " + childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
                // System.out.println(StringUtils.center("开始遍历第" + (i + 1) + "本书的内容", 40, "="));
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
