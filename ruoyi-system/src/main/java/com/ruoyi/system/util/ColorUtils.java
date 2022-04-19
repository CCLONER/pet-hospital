package com.ruoyi.system.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cc
 * @create 2022-04-18 18:19
 */
public class ColorUtils {

    public static Map<String,String> insertColor(Integer value){

        String color = "";

        if (value <= 3) {
            color = "#48a71c";
        }else if(value <=6){
            color = "#26774d";
        }else if(value <= 9){
            color = "#628ced";
        }else if (value <=12){
            color = "#61a0a8";
        }

        Map<String, String> map = new HashMap<>();
        map.put("color",color);

        return map;
    }


}
