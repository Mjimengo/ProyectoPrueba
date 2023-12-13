package org.acme;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.NoSuchElementException;

@Provider
public class NoSuchElementExceptionMapper implements ExceptionMapper<NoSuchElementException> {

    public static class NoSuchElementMessage {
        private final String message;
        private final String detail;

        public NoSuchElementMessage(String message, String detail) {
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
    public Response toResponse(NoSuchElementException e) {
        var error = new NoSuchElementMessage("Elemento no encontrado", e.getMessage());
        return Response.status(404).entity(error).build();
    }
}
