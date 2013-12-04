/*
 */
package com.airhacks.xmas.business.wishes.boundary;

import com.airhacks.xmas.business.wishes.entity.BooksResource;
import com.airhacks.xmas.business.wishes.entity.Wish;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author adam-bien.com
 */
@Stateless
@Path("wishes")
public class WishesResource {

    @Inject
    Validator validator;

    @Inject
    Logger logger;

    @Inject
    SantaClause sc;

    @GET
    public List<Wish> all() {
        List<Wish> all = new ArrayList<>();
        all.add(new Wish("ev3", 15));
        return all;
    }

    @GET
    @Path("{name}-{age}")
    @Produces({"airhacks/binary", "application/xml", "application/json"})
    public Wish find(@PathParam("name") String name, @PathParam("age") int age) {
        return new Wish(name, age);
    }

    @Path("{name}-{age}/books/")
    public BooksResource books(@PathParam("name") String name, @PathParam("age") int age) {
        return new BooksResource();
    }

    @POST
    public Response save(Wish wish) {
        Set<ConstraintViolation<Wish>> violations = validator.validate(wish);
        if (!violations.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        sc.save(wish);
        System.out.println("--- " + wish);
        return Response.noContent().build();
    }

}
