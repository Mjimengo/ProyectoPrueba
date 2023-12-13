package org.acme;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class QueryParameterMissingExceptionMapper implements ExceptionMapper<QueryParameterMissingException> {

    public static class ErrorMessage {
        private final String message;

        public ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Override
    public Response toResponse(QueryParameterMissingException e) {
        var error = new ErrorMessage(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(error).build();
    }
}
