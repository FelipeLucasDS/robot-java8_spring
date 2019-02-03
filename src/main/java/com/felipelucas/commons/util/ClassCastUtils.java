package com.felipelucas.commons.util;

import org.apache.commons.lang3.EnumUtils;

public class ClassCastUtils {

    public static boolean canCast(Class clazz, String obj){
        try {
            if(clazz.isAssignableFrom(Integer.class)) {
                Integer.parseInt(obj);
                return true;
            }

            if(clazz.isEnum()){
                return EnumUtils.isValidEnum(clazz, obj);
            }

            clazz.cast(obj);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
