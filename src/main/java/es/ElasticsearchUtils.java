package es;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.types.TypesExistsResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: shuyizhi
 * @Date: 2018/6/7 9:49
 * @Description: ES工具类，包括初始化、创建索引、更新索引、删除索引、查询索引
 * 参考：https://blog.csdn.net/lom9357bye/article/details/52841711
 * https://blog.csdn.net/u011781521/article/details/77848489
 */
public class ElasticsearchUtils {
    private Client client;
    private final Logger logger = LoggerFactory.getLogger(ElasticsearchUtils.class);

    public ElasticsearchUtils(String clusterName, String ipAddress) {
        //Settings settings = Settings.builder()
        //        //设置集群名称
        //        .put("cluster.name", clusterName)
        //        .put("client.transport.ignore_cluster_name", false)
        //        .put("node.client", true)
        //        .put("client.transport.sniff", true)
        //        .build();
        Settings settings = Settings.builder()
                .put("cluster.name", clusterName)
                .put("client.transport.sniff", true).build();
        try {
            client = new PreBuiltTransportClient(settings).
                    addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ipAddress), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
            logger.error("client初始化错误: " + e.getMessage());
        }

    }

    /**
     * 创建索引
     *
     * @param indexName 索引名称，相当于数据库名称
     * @param typeName  索引类型，相当于数据库中的表名
     * @param id        id名称，相当于表中某一行记录的标识
     * @param jsonData  json数据
     * @throws Exception
     */
    public void createIndex(String indexName, String typeName,
                            String id, String jsonData) throws Exception {
        IndexRequestBuilder requestBuilder = client.prepareIndex(indexName, typeName, id);
        if (null != requestBuilder) {
            requestBuilder.setSource(jsonData).execute().actionGet();       //创建索引
            if (requestBuilder.execute().get().getVersion() != 0) {
                logger.info("创建索引成功,版本号为: " + requestBuilder.execute().get().getVersion());
            } else {
                logger.info("创建索引失败!");
            }
        }
    }

    /**
     * 判断指定的索引是否存在
     *
     * @param indexName 索引名称
     * @return
     * @throws Exception
     */
    public boolean isIndexExists(String indexName) throws Exception {
        //return client.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
        //或者
        IndicesExistsResponse response = client.admin().indices().exists(
                new IndicesExistsRequest().indices(new String[]{indexName})).actionGet();
        return response.isExists();
    }

    /**
     * 判断指定索引的类型(type)是否存在
     *
     * @param indexName 索引名称
     * @param typeName  类型名称
     * @return
     * @throws Exception
     */
    public boolean isTypeExists(String indexName, String typeName) throws Exception {
        TypesExistsResponse response = client.admin().indices().typesExists(new TypesExistsRequest(new String[]{indexName}, typeName)).actionGet();
        return response.isExists();
    }

    /**
     * 执行查询
     *
     * @param indexName    索引名称
     * @param typeName     索引类型
     * @param queryBuilder 查询条件
     * @return
     * @throws Exception
     */
    //public SearchResponse searchResponse(String indexName, String typeName,
    //                                     QueryBuilder queryBuilder) throws Exception {
    //    SearchResponse searchResponse = client.prepareSearch(indexName)
    //            .setTypes(typeName)
    //            .setQuery(queryBuilder)
    //            .execute().actionGet();     //执行查询
    //    return searchResponse;
    //}

    /**
     * 执行查询
     *
     * @param indexName    索引名称
     * @param typeName     索引类型
     * @param queryBuilder 查询条件
     * @return
     * @throws Exception
     */
    public SearchResponse searchResponse(String indexName, String typeName, QueryBuilder queryBuilder) throws Exception {
        SearchResponse searchResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                .setQuery(queryBuilder)
                .execute().actionGet();
        return searchResponse;
    }

    public SearchResponse searchResponseByFields(String indexName, String typeName, QueryBuilder queryBuilder,
                                                 String[] fields) throws Exception {
        SearchResponse searchResponse = client.prepareSearch(indexName)
                .setTypes(typeName)
                .setQuery(queryBuilder)
                .setFetchSource(fields, null)
                .execute().actionGet();
        client.close();
        return searchResponse;
    }

    /**
     * 更新数据
     *
     * @param indexName 索引名称
     * @param typeName  索引类型名称
     * @param id        id
     * @param jsonData  更新document
     * @throws Exception
     */
    public void updateIndex(String indexName, String typeName, String id, String jsonData) throws Exception {
        //根据id判断一下是否存在该文档
        SearchResponse response = searchResponse(indexName, typeName, QueryBuilders.termQuery("id", id));
        if (null != response) {
            if (response.getHits().totalHits != 0) {
                UpdateRequest updateRequest = new UpdateRequest();
                updateRequest.index(indexName);     //设置索引名
                updateRequest.id(id);               //设置id
                updateRequest.type(typeName);       //设置索引类型
                updateRequest.doc(jsonData);
                client.update(updateRequest).actionGet();   //执行更新
                logger.info("更新type为student数据成功");
            } else {
                String errInfo = "id:" + id + "不存在!";
                logger.error(errInfo);
                throw new Exception("该id不存在!!");
            }

        } else {
            String errInfo = "id:" + id + "不存在!";
            logger.error(errInfo);
            throw new Exception("该id不存在!!");
        }
    }

    public void updateBySearch(String indexName, String typeName, QueryBuilder queryBuilder) throws Exception {

    }

    /**
     * 删除单条数据
     *
     * @param indexName
     * @param typeName
     * @param id
     * @throws Exception
     */
    public void deleteIndex(String indexName, String typeName, String id) throws Exception {
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.id(id);
        deleteRequest.type(typeName);
        deleteRequest.index(indexName);
        client.delete(deleteRequest).actionGet();       //执行删除
    }

    /**
     * 根据指定的查询结果删除数据
     *
     * @param indexName 索引名称
     * @param builder   查询条件
     */
    public void deleteBySearch(String indexName, QueryBuilder builder) {
        BulkByScrollResponse response = DeleteByQueryAction.INSTANCE.newRequestBuilder(client)
                .filter(builder)
                .source(indexName)
                .get();

        long deleted = response.getDeleted();
        if (0 != deleted) {
            logger.info("总共删除: " + deleted + " 条数据！");
        } else {
            logger.info("删除失败!");
        }
    }

    /**
     * 根据指定的索引、类型名称批量导入指定的JSON文件
     *
     * @param indexName 索引名称
     * @param typeName  类型名称
     * @param filePath  文件路径
     * @throws Exception
     */
    public void importBulkByFile(String indexName, String typeName, String filePath)
            throws Exception {

        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        int count = 0;
        while ((line = (bufferedReader.readLine())) != null) {
            bulkRequestBuilder.add(client.prepareIndex(indexName, typeName).setSource(line));
            if (count % 10 == 0) {
                bulkRequestBuilder.execute().actionGet();
                //此处新建一个bulkRequest，类似于重置效果,防止重复提交
                bulkRequestBuilder = client.prepareBulk();
                System.out.println("提交了: " + count);
            }
            count++;
        }
        //bulkRequestBuilder.execute().actionGet();
        logger.info("导入成功，总共导入" + count + "条数据!");
    }

    /**
     * 根据指定的查询导出对应的数据
     *
     * @param indexName 索引名称
     * @param typeName  索引类型名称
     * @param builder   查询
     * @param filePath  导出的文件路径
     * @throws Exception
     */
    public void exportBulkBySearch(String indexName, String typeName,
                                   QueryBuilder builder, String filePath) throws Exception {
        SearchResponse response = searchResponse(indexName, typeName, builder);

        SearchResponse response1 = client.prepareSearch(indexName)
                .setTypes(typeName)
                .setSize(10000)         //导出数据上限10000条
                .setQuery(QueryBuilders.matchAllQuery())
                .execute().actionGet();

        if (null != response1) {
            if (response1.getHits().totalHits > 0) {
                SearchHits hits = response1.getHits();
                FileWriter fw = null;
                BufferedWriter bfw = null;

                File file = new File(filePath);
                fw = new FileWriter(file);
                bfw = new BufferedWriter(fw);
                //默认是10条数
                //for (SearchHit hit : hits) {
                //    bfw.write(hit.getSourceAsString());
                //    bfw.write("\n");
                //}

                for (int i = 0; i < hits.totalHits; i++) {
                    bfw.write(hits.getHits()[i].getSourceAsString());
                    bfw.write("\n");
                }
                logger.info("总共导出: " + response1.getHits().totalHits + " 条数据");
                bfw.close();
                fw.close();
            }
        } else {
            logger.info("查询结果返回0条数据");
        }
    }

    /**
     * 删除索引，慎用!!!
     *
     * @param indexName 索引名称
     * @throws Exception
     */
    public void deleteAllIndex(String indexName) throws Exception {
        IndicesExistsRequest indicesExistsRequest = new IndicesExistsRequest(indexName);
        IndicesExistsResponse indicesExistsResponse = client.admin().indices().exists(indicesExistsRequest).actionGet();
        if (indicesExistsResponse.isExists()) {
            //存在，则删除
            DeleteIndexResponse deleteIndexResponse = client.admin().indices().prepareDelete(indexName)
                    .execute().actionGet();
            if (deleteIndexResponse.isAcknowledged()) {
                System.out.println("删除索引:" + indexName + "成功");
            } else {
                System.out.println("删除索引:" + indexName + "失败");
            }
        } else {
            //不存在
            logger.error("索引:" + indexName + "不存在");
            throw new Exception("索引:" + indexName + "不存在");
        }
    }
}

