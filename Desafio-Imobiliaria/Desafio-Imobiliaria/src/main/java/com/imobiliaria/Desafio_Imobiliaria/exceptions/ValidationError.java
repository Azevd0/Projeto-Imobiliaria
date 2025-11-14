package com.imobiliaria.Desafio_Imobiliaria.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    private List<FieldMessage> error = new ArrayList<>();

    public ValidationError(LocalDateTime timestamp, Integer status, String mensage, String path) {
        super(timestamp, status, mensage, path);
    }

    public List<FieldMessage> getError() {
        return error;
    }

    public void addError(String defaultMessage, String field) {
        this.error.add(new FieldMessage(field, defaultMessage));
    }
}
