package com.es;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.es.po.User;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexAction;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Resource
public class APITest extends BaseTest {
       @Autowired
       RestHighLevelClient restHighLevelClient;

       @Test
       public void indexAdd() throws IOException {
              System.out.println(".....");
              //创建索引
              CreateIndexRequest request= new CreateIndexRequest("test");
              //执行请求
              CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
              System.out.print(JSONUtil.toJsonPrettyStr(createIndexResponse));

       }

       /**
        * 获取索引
        * @throws IOException
        */
       @Test
       public void getIndex() throws IOException{
              GetIndexRequest request = new GetIndexRequest("test");
              boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
              System.out.println(exists);
              if(exists){
                     GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
                     System.out.println(JSONUtil.toJsonPrettyStr(getIndexResponse));
              }


       }

       /**
        * 删除索引
        * @throws IOException
        */
       @Test
       public  void  delIndex() throws IOException {
              DeleteIndexRequest request = new DeleteIndexRequest("test");
              AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
              System.out.println(JSONUtil.toJsonPrettyStr(delete));

       }
      @Test
      public  void addDocument() throws IOException {
              User user=new User();
              user.setId("1");
              user.setAge(2);
              user.setName("zyy");
              //创建请求
             IndexRequest request = new IndexRequest("demo");
             request.id("1");
             request.timeout("1s");
             //将够我们的数据 放入请求中（json）
             request.source(JSONUtil.toJsonPrettyStr(user), XContentType.JSON);

             //使用客户端
             IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
             System.out.println(JSONUtil.toJsonPrettyStr(indexResponse));

      }

       /**
        * 获取文档
        * @throws IOException
        */
      @Test
      public  void getDocument() throws IOException{
             GetRequest request = new GetRequest("demo","1");

           //  request.fetchSourceContext(new FetchSourceContext(false));

             boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
             System.out.println(exists);
             //使用客户端
             GetResponse getResponse = restHighLevelClient.get(request, RequestOptions.DEFAULT);

             System.out.println(JSONUtil.toJsonPrettyStr(getResponse));
             System.out.println(getResponse.getSourceAsString());

      }

       /**
        * 更新文档
        * @throws IOException
        */
      @Test
      public void updateDoucument() throws IOException {
             UpdateRequest request= new UpdateRequest("demo","1");
             request.timeout("1s");
             User user=new User();
             user.setId("12312");
             user.setAge(22);
             user.setName("zyy");
             request. doc(JSONUtil.toJsonStr(user),XContentType.JSON);
             UpdateResponse update = restHighLevelClient.update(request, RequestOptions.DEFAULT);
             System.out.println(JSONUtil.toJsonPrettyStr(update));

      }

      @Test
      public  void delDocument() throws  IOException {
             DeleteRequest request =new DeleteRequest("demo", "1");
             request.timeout("1s");
             DeleteResponse deleteResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
             System.out.println(JSONUtil.toJsonPrettyStr(deleteResponse));
      }

      @Test
      public  void testBulkRequest() throws IOException {
             List<User> list =new ArrayList<>(100);
             for( int i =0; i<100;i++){
                    User user =new User();
                    user.setName("zyy"+i);
                    user.setAge(i+1);
                    user.setId(""+i);
                    list.add(user);

             }
             BulkRequest bulkRequest =new BulkRequest();
             bulkRequest.timeout("10s");

             for (int i=0 ;i < list.size() ;i++){
                  bulkRequest.add(
                          new IndexRequest("demo").id(""+i+1)
                          .source(JSONUtil.toJsonPrettyStr(list.get(i)), XContentType.JSON)
                  );

             }

             //执行批处理
             BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
             System.out.println(JSONUtil.toJsonPrettyStr(bulk));
      }


      @Test
      public  void testSearch() throws  IOException {
             SearchRequest request =new SearchRequest("demo");
             SearchSourceBuilder builder = new SearchSourceBuilder();
             builder.size(50);
             builder.from(0);
            // builder.timeout("10s");
             //精确匹配
             TermQueryBuilder queryBuilder = QueryBuilders.termQuery("name","zyy10");
             MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
           //  builder.query(queryBuilder);
             builder.query(matchAllQueryBuilder);

             request.source(builder);

             SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);
             System.out.println(JSONUtil.toJsonPrettyStr(searchResponse));
             System.out.println(JSONUtil.toJsonStr(searchResponse.getHits()));

      }


}