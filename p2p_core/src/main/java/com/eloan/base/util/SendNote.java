package com.eloan.base.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class SendNote {


    public static ResultJSON sendMess(String realName,String idCardStr){


        String host = "https://idcert.market.alicloudapi.com";
        String path = "/idcard";
        String method = "GET";
        String appcode = "ebf058f9925b4f1da3a181cc36e84765";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("idCard", idCardStr);
        querys.put("name", realName);
        //JDK 1.8示例代码请在这里下载：  http://code.fegine.com/java/cmapi022049.zip

        ResultJSON resultJSON = new ResultJSON();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 或者直接下载：
             * http://code.fegine.com/HttpUtils.zip
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             * 相关jar包（非pom）直接下载：
             * http://code.fegine.com/aliyun-jar.zip
             */
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //System.out.println(response.toString());如不输出json, 请打开这行代码，打印调试头部状态码。
            //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
            //获取response的body
            String s = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSON.parseObject(s);

            if ( jsonObject.getString("status").equals("01")){
                resultJSON.setSuccess(true);
                resultJSON.setMsg("认证成功");
            }else {
                resultJSON.setSuccess(false);
                resultJSON.setMsg("认证失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultJSON;

    }

}
