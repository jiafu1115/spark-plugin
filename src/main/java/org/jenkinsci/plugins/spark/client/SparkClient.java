package org.jenkinsci.plugins.spark.client;

import org.jenkinsci.plugins.spark.SparkRoom;

public class SparkClient {
 
    public static void sent(SparkRoom sparkRoom, String content) throws Exception {
         try {
            System.out.println(sparkRoom);
            System.out.println(content);
        } catch (Exception e) {
            throw e;
        }

    }

}