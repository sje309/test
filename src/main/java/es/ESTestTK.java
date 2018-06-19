package es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: shuyizhi
 * @Date: 2018/5/24 9:52
 * @Description:
 */
public class ESTestTK {
    private static Logger logger = LoggerFactory.getLogger(ElasticSearchTest1.class);
    public final static String HOST = "127.0.0.1";
    public final static int PORT = 9300;    //http请求的端口是9200，客户端是9300
    public static TransportClient client = null;
    public static Settings settings = null;

    static {
        //创建客户端
        try {
            settings = Settings.builder().put("cluster.name", "elasticsearch").put("client.transport.sniff", true).build();
            client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST), PORT));
            //System.out.println("client: " + client.nodeName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            getResponse();
            //addResponse();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error(ex.getMessage());
        } finally {
            close();
        }
    }

    public static void getResponse() {
       /* QueryBuilder queryBuilder = QueryBuilders.matchQuery("address", "lane");
        SearchResponse searchResponse = client.prepareSearch("bank")
                .setTypes("account")
                .setQuery(queryBuilder)
                .execute().actionGet();
        SearchHits hits = searchResponse.getHits();
        System.out.println("总共查到：" + hits.getTotalHits());
        SearchHit[] searchHits = hits.getHits();
        if (null != searchHits && searchHits.length > 0) {
            for (SearchHit hit : searchHits) {
                String firstname = (String) hit.getSource().get("firstname");
                String lastname = (String) hit.getSource().get("lastname");
                System.out.println(String.format("firstname: %s\t;lastname: %s", firstname, lastname));
            }
        }*/

        //QueryBuilder queryBuilder = QueryBuilders.matchQuery("address", "lane");
        //SearchResponse searchResponse = client.prepareSearch("bank")
        //        .setSize(20)
        //        .setFrom(0)
        //        .setTypes("account")
        //        .setQuery(queryBuilder)
        //        .addSort("account_number", SortOrder.DESC)
        //        .execute().actionGet();
        //SearchHits hits = searchResponse.getHits();
        //System.out.println("总共查到: " + hits.getTotalHits());
        //SearchHit[] searchHits = hits.getHits();
        //if (null != searchHits && searchHits.length > 0) {
        //    for (SearchHit hit : searchHits) {
        //        String firstName = (String) hit.getSource().get("firstname");
        //        String lastName = (String) hit.getSource().get("lastname");
        //        int account_number = (int) hit.getSource().get("account_number");
        //
        //        System.out.println(String.format("firstName:%s\t;lastName:%s\t;account_number:%d\t",
        //                firstName, lastName, account_number));
        //
        //    }
        //}


        //region 查询address中同时包含mill和lane的文档
        //      POST bank/account/_search
        //      {
        //          "query": {
        //          "bool": {
        //              "should": [
        //              {"match": {
        //                  "address": "mill"
        //              }},
        //              {
        //                  "match": {
        //                  "address": "lane"
        //              }
        //              }
        //    ],
        //              "filter": {
        //                  "range": {
        //                      "age": {
        //                          "gte": 24,
        //                                  "lte": 25
        //                      }
        //                  }
        //              }
        //          }
        //      },
        //          "sort": [
        //          {
        //              "account_number": {
        //              "order": "desc"
        //          }
        //          }
        //]
        //      }

        //QueryBuilder builder = QueryBuilders.boolQuery()
        //        .should(QueryBuilders.matchQuery("address", "mill"))
        //        .should(QueryBuilders.matchQuery("address", "lane"))
        //        .filter(QueryBuilders.rangeQuery("age").gte(24).lte(25));
        //
        //
        //SearchResponse searchResponse = client.prepareSearch("bank")
        //        .setTypes("account")
        //        .setQuery(builder)
        //        .addSort("account_number", SortOrder.DESC)
        //        .execute().actionGet();
        //SearchHits hits = searchResponse.getHits();
        //System.out.println("总共查询到: " + hits.getTotalHits());
        //if (null != hits) {
        //    for (SearchHit hit : hits.getHits()) {
        //        System.out.println(hit.getSourceAsString());
        //    }
        //}
        //endregion

        //region 查询年龄为25岁文档集合
        //QueryBuilder builder = QueryBuilders.termQuery("age", 25);

        //DSL :{"query":{"bool":{"must":[{"match":{"address":"lane"}},{"term":{"age":{"value":"34"}}}]}}}
        //QueryBuilder builder = QueryBuilders.boolQuery()
        //        .must(QueryBuilders.matchQuery("address", "lane"))
        //        .must(QueryBuilders.termQuery("age", 34));

        //DSL :{"query":{"bool":{"must":[{"match":{"address":"lane"}},{"range":{"age":{"gte":20,"lte":30}}}]}}}
        //QueryBuilder builder = QueryBuilders.boolQuery()
        //        .must(QueryBuilders.matchQuery("address", "lane"))
        //        .must(QueryBuilders.rangeQuery("age").gte(20).lte(30));

        //同时包含mill lane的文档
        //DSL:{"query":{"match_phrase":{"address":"mill lane"}}}
        //QueryBuilder builder = QueryBuilders.matchPhraseQuery("address", "mill lane");

        //address包含mill 或 lane的文档
        //DSL:{"query":{"bool":{"should":[{"match":{"address":"lane"}},{"match":{"address":"mill"}}]}},"sort":[{"account_number":{"order":"desc"}}]}
        //QueryBuilder builder = QueryBuilders.boolQuery()
        //        .should(QueryBuilders.matchQuery("address", "lane"))
        //        .should(QueryBuilders.matchQuery("address", "mill"));

        //查询balance在20000~30000之间的所有文档集合
        //DSL:{"query":{"bool":{"must":[{"match_all":{}}],"filter":{"range":{"balance":{"gte":20000,"lte":30000}}}}}}
        QueryBuilder builder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchAllQuery())
                .filter(QueryBuilders.rangeQuery("balance").gte(20000).lt(30000));

        SearchResponse searchResponse = client.prepareSearch("bank")
                .setTypes("account")
                .setQuery(builder)
                .addSort("account_number", SortOrder.DESC)
                .execute().actionGet();


        SearchHits hits = searchResponse.getHits();
        if (null != hits) {
            System.out.println("总共查询到: " + hits.totalHits);
            for (SearchHit hit : hits.getHits()) {
                System.out.println(hit.getSourceAsString());
            }
        }
        //endregion

    }

    /**
     * 创建一个新的文档(Document)
     *
     * @throws IOException
     */
    public static void addResponse() throws IOException {
        IndexResponse indexResponse = client.prepareIndex("bank", "account")
                .setSource(XContentFactory.jsonBuilder().startObject()
                        .field("account_number", 30)
                        .field("balance", 50000)
                        .field("firstname", "shu")
                        .field("lastname", "yizhi")
                        .field("age", 35)
                        .field("gender", "M")
                        .field("address", "安徽省合肥市望江西路与创新大道交叉口")
                        .field("employer", "shuyizhi")
                        .field("email", "shuyizhi@microsoft.com")
                        .field("city", "合肥")
                        .field("state", "安徽")
                        .endObject()
                ).get();

        if (null != indexResponse) {
            System.out.println("添加索引成功,版本号: " + indexResponse.getShardInfo());
        }
    }

    public static void close() {
        if (null != client) {
            client.close();
        }
    }
}
