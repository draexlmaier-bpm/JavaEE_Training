package com.airhacks.xmas.st;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class WishesResourcesTest {

    Client client;
    private WebResource target;

    @Before
    public void intitialize() {
        this.client = Client.create();
        this.target = this.client.resource("http://localhost:8080/xmas/v1/wishes/ev3-42");
    }

    @Test
    public void wishes() {
        Wish actual = this.target.accept(MediaType.APPLICATION_JSON).get(Wish.class);
        Assert.assertNotNull(actual);
    }
}
