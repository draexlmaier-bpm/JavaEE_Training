/*
 */
package com.airhacks.xmas;

import java.net.URI;
import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author adam-bien.com
 */
@Path("wishes")
@Stateless
public class WishListResource {

    @Inject
    @Any
    Instance<WishList> services;

    @Inject
    String msg;

    @Inject
    String serverName;

    @Inject
    WishListService ws;

    @GET
    public Wish get() {
        return new Wish("hotwheel", 42);
    }

    @GET
    @Path("{id}")
    public Wish find(@PathParam("id") int id) {
        return this.ws.find(id);
    }

    @POST
    public Response save(Wish wish, @Context UriInfo info) {
        System.out.println("Got it: " + wish);
        //return Response.status(500).header("x-error", "provide license...").build();
        wish = this.ws.save(wish);
        URI uri = java.net.URI.create(info.getAbsolutePath() + "/" + wish.getId());
        return Response.created(uri).build();
    }

}
