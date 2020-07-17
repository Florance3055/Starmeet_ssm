package com.flor.unit;

public class tool {

    public static boolean isNull(Object object){
        if (object != null) {
            return false;
        }
        return true;
    }

    public static boolean isNull(String object){
        if (!"".equals(object)) {
            return false;
        }
        return true;
    }
}
