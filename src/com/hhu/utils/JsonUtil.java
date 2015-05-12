package com.hhu.utils;

import net.sf.json.JSONObject;

/**
 * json工具类
 * @author mpj
 *
 */
public class JsonUtil {
	
	  public static String createJsonString(String key, Object value)
	    {
	        String jsonString = null;

	        JSONObject jsonObject = new JSONObject();
	        jsonObject.put(key, value);
	        jsonString = jsonObject.toString();
	        
	        return jsonString;

	    }
}