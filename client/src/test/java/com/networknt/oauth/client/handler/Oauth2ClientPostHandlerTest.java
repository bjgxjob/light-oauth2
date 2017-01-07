package com.networknt.oauth.client.handler;

import com.networknt.client.Client;
import com.networknt.config.Config;
import com.networknt.exception.ApiException;
import com.networknt.exception.ClientException;
import com.networknt.status.Status;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
* Generated by swagger-codegen
*/
public class Oauth2ClientPostHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(Oauth2ClientPostHandlerTest.class);

    @Test
    public void testOauth2ClientPostHandler() throws ClientException, ApiException, UnsupportedEncodingException {
        String c = "{\"clientType\":\"public\",\"clientProfile\":\"mobile\",\"clientName\":\"AccountViewer\",\"clientDesc\":\"Retail Online Banking Account Viewer\",\"scope\":\"act.r act.w\",\"redirectUrl\": \"http://localhost:8080/authorization\",\"ownerId\":\"admin\"}";
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPost httpPost = new HttpPost("http://localhost:6884/oauth2/client");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(c));

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String body = IOUtils.toString(response.getEntity().getContent(), "utf8");
            Assert.assertEquals(200, statusCode);
            if(statusCode == 200) {
                Assert.assertNotNull(body);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOwnerNotFound() throws ClientException, ApiException, UnsupportedEncodingException {
        String c = "{\"clientType\":\"public\",\"clientProfile\":\"mobile\",\"clientName\":\"AccountViewer\",\"clientDesc\":\"Retail Online Banking Account Viewer\",\"scope\":\"act.r act.w\",\"redirectUrl\": \"http://localhost:8080/authorization\",\"ownerId\":\"fake\"}";
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPost httpPost = new HttpPost("http://localhost:6884/oauth2/client");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(c));

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String body = IOUtils.toString(response.getEntity().getContent(), "utf8");
            Assert.assertEquals(404, statusCode);
            if(statusCode == 404) {
                Status status = Config.getInstance().getMapper().readValue(body, Status.class);
                Assert.assertNotNull(status);
                Assert.assertEquals("ERR12013", status.getCode());
                Assert.assertEquals("USER_NOT_FOUND", status.getMessage()); // response_type missing
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidClientType() throws ClientException, ApiException, UnsupportedEncodingException {
        String c = "{\"clientType\":\"fake\",\"clientProfile\":\"mobile\",\"clientName\":\"AccountViewer\",\"clientDesc\":\"Retail Online Banking Account Viewer\",\"scope\":\"act.r act.w\",\"redirectUrl\": \"http://localhost:8080/authorization\",\"ownerId\":\"fake\"}";
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPost httpPost = new HttpPost("http://localhost:6884/oauth2/client");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(c));

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String body = IOUtils.toString(response.getEntity().getContent(), "utf8");
            Assert.assertEquals(400, statusCode);
            if(statusCode == 400) {
                Status status = Config.getInstance().getMapper().readValue(body, Status.class);
                Assert.assertNotNull(status);
                Assert.assertEquals("ERR11004", status.getCode());
                Assert.assertEquals("VALIDATOR_SCHEMA", status.getMessage()); // response_type missing
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInvalidClientProfile() throws ClientException, ApiException, UnsupportedEncodingException {
        String c = "{\"clientType\":\"public\",\"clientProfile\":\"fake\",\"clientName\":\"AccountViewer\",\"clientDesc\":\"Retail Online Banking Account Viewer\",\"scope\":\"act.r act.w\",\"redirectUrl\": \"http://localhost:8080/authorization\",\"ownerId\":\"fake\"}";
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpPost httpPost = new HttpPost("http://localhost:6884/oauth2/client");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setEntity(new StringEntity(c));

        try {
            CloseableHttpResponse response = client.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            String body = IOUtils.toString(response.getEntity().getContent(), "utf8");
            Assert.assertEquals(400, statusCode);
            if(statusCode == 400) {
                Status status = Config.getInstance().getMapper().readValue(body, Status.class);
                Assert.assertNotNull(status);
                Assert.assertEquals("ERR11004", status.getCode());
                Assert.assertEquals("VALIDATOR_SCHEMA", status.getMessage()); // response_type missing
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
