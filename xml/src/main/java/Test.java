import org.dom4j.DocumentException;

/** @Author: shuyizhi @Date: 2018-07-24 16:34 @Description: */
public class Test {
    public static void main(String[] args) {
        // DomAnalysis.domAnalyer();

        // Dom4jSAX.readXml();

        /*try {
            Dom4jSAX.createXml();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*Document document = Dom4jSAX.createDocument();
        try {
            Dom4jSAX.createXmlFileByXmlWriter(document);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            Dom4jSAX.readXmlByXmlReader("E:\\shuyizhi\\test\\xml\\target\\classes\\test.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
