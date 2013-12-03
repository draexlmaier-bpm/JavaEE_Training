/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.draexlmaier.training.javaee.business.wishes.boundary;

import de.draexlmaier.training.javaee.business.wishes.entity.Wish;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author michael
 */
@Stateless
@Path("wishes")
public class WishesResource {

    @GET
    public List<Wish> all() {
        List<Wish> result = new ArrayList<>();
        result.add(new Wish("iPhone 5S", 2));

        return result;
    }
}
