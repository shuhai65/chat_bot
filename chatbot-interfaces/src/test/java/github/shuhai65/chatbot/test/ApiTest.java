package github.shuhai65.chatbot.test;

import org.apache.hc.core5.http.ContentType;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author shuhai65
 * @description 单元测试
 * @github https:github.com/shuhai65
 */
public class ApiTest {
    @Test
    public void query_unanwered_questions() throws IOException {
        // 1. 创建一个httpclient对象
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/48884852548448/topics?scope=all&count=20");
        httpGet.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"18727ffc7da81a-096b50fa9790308-26031851-1327104-18727ffc7dbdaa\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3MjdmZmM3ZGE4MWEtMDk2YjUwZmE5NzkwMzA4LTI2MDMxODUxLTEzMjcxMDQtMTg3MjdmZmM3ZGJkYWEifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"18727ffc7da81a-096b50fa9790308-26031851-1327104-18727ffc7dbdaa\"}; zsxq_access_token=3BD87B70-E2D0-8A44-58BD-FDA7BCE2E7D0_7BB05AD59B70C9F3; abtest_env=product; zsxqsessionid=a9a21d86e39058ab2f834f34fa54a884");
        httpGet.addHeader("content-type","application/json; charset=UTF-8");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            System.out.println("请求成功");
            String res = org.apache.http.util.EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println("请求失败");
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/412588128182418/comments");
        httpPost.addHeader("cookie","sensorsdata2015jssdkcross={\"distinct_id\":\"18727ffc7da81a-096b50fa9790308-26031851-1327104-18727ffc7dbdaa\",\"first_id\":\"\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg3MjdmZmM3ZGE4MWEtMDk2YjUwZmE5NzkwMzA4LTI2MDMxODUxLTEzMjcxMDQtMTg3MjdmZmM3ZGJkYWEifQ==\",\"history_login_id\":{\"name\":\"\",\"value\":\"\"},\"$device_id\":\"18727ffc7da81a-096b50fa9790308-26031851-1327104-18727ffc7dbdaa\"}; zsxq_access_token=3BD87B70-E2D0-8A44-58BD-FDA7BCE2E7D0_7BB05AD59B70C9F3; abtest_env=product; zsxqsessionid=a9a21d86e39058ab2f834f34fa54a884");
        httpPost.addHeader("content-type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"test\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8").getCharset());
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            System.out.println("请求成功");
            String res = org.apache.http.util.EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println("请求失败");
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


}
