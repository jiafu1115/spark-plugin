package org.jenkinsci.plugins.spark.client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jenkinsci.plugins.spark.SparkRoom;

import net.sf.json.JSONObject;

public final class SparkClient {
	
	private static HttpClient httpClient = new HttpClient();
 
    public static boolean sent(SparkRoom sparkRoom, String content) throws Exception {
         try {
            System.out.println(sparkRoom);
            System.out.println(content);
             
            PostMethod postMethod = new PostMethod("https://api.ciscospark.com/v1/messages");
            postMethod.addRequestHeader("Content-type", "application/json; charset=utf-8");
            postMethod.addRequestHeader("Authorization", "Bearer " + sparkRoom.getToken().trim());
            
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("roomId", sparkRoom.getRoomid());
            jsonObject.put("text", content);
            
            postMethod.setRequestEntity(new StringRequestEntity(jsonObject.toString(), "application/json", "UTF-8"));
            int statusCode = httpClient.executeMethod(postMethod);
            
            return isSuccess(statusCode);
            
         } catch (Exception e) {
            throw e;
        }

    }

	private static boolean isSuccess(int statusCode) {
		return statusCode>=200 && statusCode<300;
	}

}