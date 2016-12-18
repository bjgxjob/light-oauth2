package com.networknt.oauth.client.handler;

import com.networknt.client.Client;
import com.networknt.server.Server;
import com.networknt.exception.ClientException;
import com.networknt.exception.ApiException;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
* Generated by swagger-codegen
*/
public class Oauth2ClientGetHandlerTest {
    @ClassRule
    public static TestServer server = TestServer.getInstance();

    static final Logger logger = LoggerFactory.getLogger(Oauth2ClientGetHandlerTest.class);

    @Test
    public void testOauth2ClientGetHandler() throws ClientException, ApiException {
        CloseableHttpClient client = Client.getInstance().getSyncClient();
        HttpGet httpGet = new HttpGet("http://localhost:6884/oauth2/client");
        /*
        Client.getInstance().addAuthorization(httpPost);
        try {
            CloseableHttpResponse response = client.execute(httpGet);
            Assert.assertEquals(200, response.getStatusLine().getStatusCode());
            Assert.assertEquals("getAllClient", IOUtils.toString(response.getEntity().getContent(), "utf8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }
}