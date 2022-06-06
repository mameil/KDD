package me.kdshim.kdd_j.swagger.api;

import me.kdshim.kdd_j.swagger.model.ErrorResponseDto;
import me.kdshim.kdd_j.swagger.model.GetLinkDto;
import me.kdshim.kdd_j.swagger.model.PostLinkDto;

import java.util.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test class to verify that GET endpoints on generated project are reached.
 */
public class LinksApiControllerIT {

    @Test
    public void getAllLinksTest() throws Exception {
        final String requestURL = "http://localhost:8002//links";
        final HttpClient client = HttpClientBuilder.create().build();
        final HttpResponse response = client.execute(new HttpGet(requestURL));
        assertEquals(response.getStatusLine().getStatusCode(), 501);
    }
}
