package org.acme;

public class QueryParameterMissingException extends RuntimeException {

    public QueryParameterMissingException(String message) {
        super(message);
    }
}