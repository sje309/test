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
        /*try {
            String url = "http://www.baidu.com";
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href]");
            System.out.println(links.size());
            for (Element link : links) {
                System.out.println(link.attr("abs:href") + " " + link.text());
            }
            Elements imgs = document.select("img[src$=.png]");
            for (Element img : imgs) {
                System.out.println(img.attr("src"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /**社会新闻*/
        //getIfengSociety("http://news.ifeng.com/society/");
        /**大陆新闻*/
        //getIfengSociety("http://news.ifeng.com/mainland/");
        /**国际新闻*/
        //getIfengSociety("http://news.ifeng.com/world/");
        /**省城新闻*/
        getAnhuiNews("http://ah.anhuinews.com/jhdd/hf/index.shtml");
    }

    /**
     * 凤凰网新闻采集
     *
     * @param url
     */
    public static void getIfengSociety(String url) {
        try {
            //String url = "http://news.ifeng.com/society/";
            Document document = Jsoup.connect(url).get();
            Elements divs = document.select("div.juti_list");
            if (null != divs && divs.size() > 0) {
                for (Element div : divs) {
                    Elements as = div.select("h3 a[href]");
                    for (Element a : as) {
                        System.out.println("--------------------------------------------------------------------------------------");
                        String detailUrl = a.attr("abs:href");
                        String title = a.text();
                        System.out.println("新闻链接: " + detailUrl + "\n新闻标题: " + title);
                        getIfengSocietyDetails(detailUrl);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取社会新闻详细
     *
     * @param urlDetails
     */
    public static void getIfengSocietyDetails(String urlDetails) {
        try {
            Document documentDetails = Jsoup.connect(urlDetails).get();
            /**新闻标题*/
            Elements title = documentDetails.select("h1#artical_topic");
            /**新闻发布时间*/
            Elements time = documentDetails.select("span.ss01");
            /**新闻来源(名称)*/
            Elements from = documentDetails.select("span.ss03");
            /**新闻来源(url)*/
            Elements fromUrl = documentDetails.select("span.ss03").select("a");
            /**新闻内容*/
            Elements content = documentDetails.select("div#main_content");

            System.out.println("新闻标题: " + title.text());
            System.out.println("新闻发布时间: " + time.text());
            if (null != fromUrl && fromUrl.size() > 0) {
                System.out.println("新闻来源: " + fromUrl.get(0).text() + "\turl: " + fromUrl.get(0)
                        .attr("abs:href"));
            } else {
                System.out.println("新闻来源: " + from.text());
            }
            System.out.println("新闻内容: " + content.select("p").get(1).text());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAnhuiNews(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements tabs = document.select("table");
            if (null != tabs && tabs.size() > 0) {
                for (Element tab : tabs) {
                    /**获取新闻详细页URL*/
                    String detailUrl = tab.select("tr")
                            .get(0)
                            .select("td")
                            .get(0)
                            .select("a").get(0).attr("abs:href");

                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("新闻链接: " + detailUrl);
                    getAnhuiNewsDeatils(detailUrl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getAnhuiNewsDeatils(String detailUrl) {
        try {
            Document document = Jsoup.connect(detailUrl).get();
            /**标题*/
            String title = document.select("h1").text();
            /**新闻时间*/
            Element timeElement = document.selectFirst("div.f1");
            /**新闻内容*/
            String content = document.select("div.info").text();
            System.out.println("标题: " + title);
            System.out.println("新闻内容: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
