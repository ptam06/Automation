package com.utils;


import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class PropertyReader {
    protected static InputStream inputStream;
   static HashMap<String,String>result=new HashMap<String, String>();


    public static HashMap<String, String> getFileinfo(String fileinfo) throws IOException {
        try {

            Properties prop = new Properties();
           String propFile=fileinfo;

            inputStream = PropertyReader.class.getClass().getResourceAsStream(propFile);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
            }

            Set propNames = prop.stringPropertyNames();
            Iterator<String> iterator = propNames.iterator();
            while (iterator.hasNext()) {
                 String key = iterator.next();
                  result.put(key, prop.getProperty(key));


            }

            inputStream.close();
        } catch (Exception e)
        {
            System.out.print("Exception"+e);

        }
      return result;

    }



}
