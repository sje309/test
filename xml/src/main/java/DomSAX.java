import org.apache.xml.resolver.readers.SAXParserHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @Author: shuyizhi @Date: 2018-07-24 17:01 @Description: SAX解析DOM Simple Apis for Xml
 * 参考：https://blog.csdn.net/rickyit/article/details/53813246
 */
public class DomSAX {
    /** 采用SAX的方式解析Xml */
    public static void domSAXXml() {
        // 创建一个SAXParserFactory对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            // 通过factory获取SAXParser实例
            SAXParser parser = factory.newSAXParser();
            // 创建SAXParserHandler的实例
            SAXParserHandler handler = new SAXParserHandler();
            parser.parse(DomSAX.class.getResourceAsStream("books.xml"), handler);
            // System.out.println(StringUtils.center("共有"+(handler.ge)));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
