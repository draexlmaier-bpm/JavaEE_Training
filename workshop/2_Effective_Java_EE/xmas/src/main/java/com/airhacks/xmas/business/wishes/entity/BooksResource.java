/*
 */
package com.airhacks.xmas.business.wishes.entity;

import javax.ws.rs.GET;

/**
 *
 * @author adam-bien.com
 */
//@Path("books")
public class BooksResource {

    @GET
    public String books() {
        return "snow crash";
    }

}
