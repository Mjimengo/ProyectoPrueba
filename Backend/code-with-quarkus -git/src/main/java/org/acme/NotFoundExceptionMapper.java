package org.acme;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.NotFoundException;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    public static class NotFoundMessage {
        private final String message;
        private final String detail;

        public NotFoundMessage(String message, String detail) {
            this.message = message;
            this.detail = detail;
        }

        public String getMessage() {
            return message;
        }

        public String getDetail() {
            return detail;
        }
    }

    @Override
    public Response toResponse(NotFoundException e) {
        var error = new NotFoundMessage("Recurso no encontrado", e.getMessage());
        return Response.status(404).entity(error).build();
    }
}
