package com.my.springcloud.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Gzy
 * @version 1.0
 * @Description
 * @date create on 2023/3/7
 */
@Component
public class MyUrlCleaner implements UrlCleaner {


        @Override
        public String clean(String originUrl) {

            //总之就是要把Restful的URL统一的 返回一个
            String[] split = originUrl.split("/");
            return Arrays.stream(split).map(string-> {
                if(NumberUtils.isNumber(string)){
                    return "{number}";
                }
                return string;
            }).reduce((a,b)->a+"/"+b).orElse("");
        }


}
