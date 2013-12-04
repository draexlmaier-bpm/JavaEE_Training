/*
 */
package com.airhacks.xmas.business;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * Exceptions can be easily transformed to response code at a central place
 *
 * @author adam-bien.com
 */
@Provider
public class ConstaintValidationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST).header("x-violation-exception", exception.getConstraintViolations()).build();
    }

}
