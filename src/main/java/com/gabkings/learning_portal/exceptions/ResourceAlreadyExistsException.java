package com.gabkings.learning_portal.exceptions;

import java.util.Arrays;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String name, String... fields) {
        super(String.format("%s already exists by %s",
                name, String.join(",", fields)));
    }
}
