package com.flor.unit;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorResult {

    public static Map getFieldErrors(BindingResult bindingResult){
        HashMap map = new HashMap();
        List<FieldError> errors = bindingResult.getFieldErrors();
        map.put("code",0);
        for (FieldError fieldError : errors) {
            //   System.out.println(fieldError.getField()+"====="+fieldError.getDefaultMessage());
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return map;
    }



}
