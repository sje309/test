package es;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * @Author: shuyizhi
 * @Date: 2018/5/17 16:53
 * @Description: ES 简单测试
 * 参考：https://www.cnblogs.com/sunny1009/articles/7887568.html
 */
public class ElasticSearchTest1 {
    private static Logger logger = LoggerFactory.getLogger(ElasticSearchTest1.class);
    public final static String HOST = "127.0.0.1";
    public final static int PORT = 9300;    //http请求的端口是9200，客户端是9300
    public static TransportClient client = null;
    public static Settings settings = null;

    static {
        //创建客户端
        try {
            settings = Settings.builder().put("cluster.name", "elasticsearch").build();
            client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
            //System.out.println("client: " + client.nodeName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //createIndex();
        //getIndex();
        //updateIndex();
        //deleteIndex();

        //getCount();

        //delIndex();

        testUpdateIndex();

    }

    public static void close() {
        if (null != client) {
            logger.info("执行关闭连接操作...");
            client.close();
        }
    }

    public static void createIndex() {
        try {
            long start = System.currentTimeMillis();
            for (int i = 1; i <= 100; i++) {
                IndexResponse response = client.prepareIndex("msg", "tweet", Integer.toString(i))
                        .setSource(XContentFactory.jsonBuilder().startObject()
                                .field("userName", "张三" + Integer.toString(i))
                                .field("sendDate", new Date())
                                .field("msg", "你好李四" + Integer.toString(i))
                                .endObject()).get();
            }
            //System.out.println("索引名称: " + response.getIndex() + "\n类型: " + response.getType()
            //        + "\n文档ID: " + response.getId() + "\n当前实例状态: " + response.status());
            System.out.println("写入成功,总共100条数据,耗时： " + (System.currentTimeMillis() - start) + " ms.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public static void createIndex1() {
        try {
            IndexResponse response = client.prepareIndex("books", "book", "1")
                    .setSource(XContentFactory.jsonBuilder().startObject()
                            .field("book_name", "ElasticSearch入门")
                            .field("author", "张三")
                            .field("publish_time", "2017-09-09").endObject())
                    .get();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public static void getIndex() {
        try {
            GetResponse getResponse = client.prepareGet("msg", "tweet", "1").execute().actionGet();
            System.out.println(getResponse.getSourceAsString());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
    }

    public static void updateIndex() {
        UpdateRequest request = new UpdateRequest();
        request.index("msg");
        request.type("tweet");
        request.id("1");

        try {
            request.doc(XContentFactory.jsonBuilder().startObject().field("userName", "张三丰").endObject());
            client.update(request).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    /**
     * 更新索引为msg、type为tweet、id为2的文档数据
     */
    public static void testUpdateIndex() {
        UpdateRequest request = new UpdateRequest();
        request.index("msg");
        request.type("tweet");
        request.id("2");
        try {
            request.doc(XContentFactory.jsonBuilder().startObject()
                    .field("userName", "songli")
                    .field("sendDate", new Date())
                    .field("msg", "你好,宋丽").endObject());
            if (null == client) {
                client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
            }
            client.update(request).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void deleteIndex() {
        try {
            DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "1").get();
            if ("OK".equals(deleteResponse.status().name())) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
            System.out.println("deleteStatus: " + deleteResponse.status().name());
        } catch (Exception ex) {

        } finally {
            close();
        }
    }

    /**
     * 删除索引库，不可逆慎用
     * 删除index为msg的索引库
     */
    public static void delIndex() {
        try {
            DeleteIndexResponse response = client.admin().indices().prepareDelete("msg").get();
            if (response.isAcknowledged()) {
                System.out.println("删除索引库成功");
            } else {
                System.out.println("删除索引库失败");
            }
        } catch (Exception ex) {

        }

    }

    /**
     * 获取总数
     *
     * @return
     */
    public static long getCount() {
        long count = 0l;
        try {
            long start = System.currentTimeMillis();
            SearchResponse response = client.prepareSearch("msg").execute().actionGet();
            SearchHits searchHits = response.getHits();
            count = searchHits.totalHits;
            System.out.println("总条数为: " + count + ",耗时: " + (System.currentTimeMillis() - start) + " ms.");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close();
        }
        return count;
    }

}
