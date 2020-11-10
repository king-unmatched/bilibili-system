package com.jk.pojo;

public class StringUtil {

    public static Boolean isEmpty(String str){

        if (str == null || "".equals(str) || str.length() <= 0 || str.isEmpty()){
            return true;
        }
        return false;
    }


    public static Boolean isNotEmpty(String str){
        if (!isEmpty(str)){
            return true;
        }
        return false;
    }
}
