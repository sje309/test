import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @Author: shuyizhi
 * @Date: 2018-10-16 22:27
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("http://news.ifeng.com/society/").get();
            String title = document.title();
            //System.out.println("title: " + title);
            //Element element = document.getElementById("")
            //System.out.println(document.outerHtml());
            /**获取所有的div元素*/
            Elements divElements = document.getElementsByAttributeValue("className", "juti_list");
            for (Element element : divElements) {
                Elements jutDivs = element.getElementsByClass("juti_list");
                for (Element jutDiv : jutDivs) {
                    System.out.println(jutDiv.text());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
