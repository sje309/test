package es;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.junit.Test;

/**
 * @Author: shuyizhi
 * @Date: 2018/6/7 10:55
 * @Description:
 */
public class ElasticsearchUtilsTest {
    @Test
    public void Test() {
        ElasticsearchUtils elasticsearchUtils = new ElasticsearchUtils("elasticsearch", "127.0.0.1");
        String indexName = "school";
        String typeName = "student";


        // region创建索引
        //for (int i = 0; i < 50; i++) {
        //    String id = UUID.randomUUID().toString();
        //    String jsonData = "{\"account_number\":30,\"balance\":50000,\"firstname\":\"song\",\"lastname\":\"li\",\"age\":35,\"gender\":\"M\",\"address\":\"安徽省巢湖市巢湖学院\",\"employer\":\"songli\",\"email\":\"songli@microsoft.com\",\"city\":\"巢湖\",\"state\":\"安徽\"}";
        //    try {
        //        elasticsearchUtils.createIndex(indexName, typeName, id, jsonData);
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //    }
        //}

        //endregion

        //region 更新索引
        //String id = "c2238db1-7637-4504-94b2-3482c40bd49e";
        //String jsonData = "{\"account_number\":100,\"balance\":50000,\"firstname\":\"shu\",\"lastname\":\"yizhi\",\"age\":35,\"gender\":\"F\",\"address\":\"安徽省合肥市高新区创新大道与望江西路交叉口\",\"employer\":\"shuyizhi\",\"email\":\"shuyizhi@microsoft.com\",\"city\":\"合肥\",\"state\":\"安徽\"}";
        //
        //try {
        //    elasticsearchUtils.updateIndex(indexName, typeName, id, jsonData);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //endregion

        //region 执行查询
        //QueryBuilder builder = QueryBuilders.termQuery("firstname", "song");
        //try {
        //    SearchResponse response = elasticsearchUtils.searchResponse(indexName, typeName, builder);
        //    if (null != response) {
        //        SearchHits hits = response.getHits();
        //        if (null != hits) {
        //            System.out.println(StringUtils.center("start", 20, "="));
        //            System.out.println("获取的总数为: " + hits.totalHits);
        //            for (SearchHit hit : hits) {
        //                System.out.println(hit.getSourceAsString());
        //            }
        //        }
        //    }
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //endregion

        //region 删除指定的文档操作
        //删除id为c2238db1-7637-4504-94b2-3482c40bd49e的文档
        //try {
        //    elasticsearchUtils.deleteIndex(indexName, typeName, "c2238db1-7637-4504-94b2-3482c40bd49e");
        //    System.out.println("删除成功!");
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //endregion

        //region 根据查询结果删除
        //QueryBuilder builder = QueryBuilders.matchQuery("firstname", "song");       //查询firstname中包含song的数据
        //QueryBuilder builder = QueryBuilders.matchAllQuery();
        //elasticsearchUtils.deleteBySearch(indexName, builder);
        //endregion

        //region 根据指定的查询导出
        //String filePath = "D:\\studentExport.json";
        //QueryBuilder builder = QueryBuilders.matchAllQuery();
        //try {
        //    elasticsearchUtils.exportBulkBySearch(indexName, typeName, builder, filePath);      //执行导出
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}

        //region

        //region 导入
        //String filePath = "D:\\studentExport.json";
        //try {
        //    elasticsearchUtils.importBulkByFile(indexName, typeName, filePath);
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        //endregion

        //region 删除指定的索引
        try {
            elasticsearchUtils.deleteAllIndex("megacorp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //endregion

    }

    @Test
    public void searchResponseByFieldsTest() {
        ElasticsearchUtils elasticsearchUtils = new ElasticsearchUtils("elasticsearch", "192.168.155.221");
        String indexName = "bank";
        String typeName = "account";

        QueryBuilder builder = QueryBuilders.matchQuery("address", "Avenue");
        try {
            SearchResponse searchResponse = elasticsearchUtils.searchResponseByFields(indexName, typeName, builder, new String[]{"firstname", "lastname", "address", "city"});
            System.out.println("总共返回: " + searchResponse.getHits().totalHits + "条\n");
            if (null != searchResponse) {
                for (SearchHit hit : searchResponse.getHits()) {
                    System.out.println(hit.getSourceAsString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}