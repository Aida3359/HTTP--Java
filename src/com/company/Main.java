package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String query = "https://lomiren.kz/intern/category";

        HttpURLConnection connection = null;
        try{

            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if(HttpURLConnection.HTTP_OK==connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while((line= in.readLine()) != null){

                sb.append(line);
                sb.append("\n");

                }
            System.out.println(sb.toString());
            }else{
                System.out.println("fail:"+connection.getResponseCode()+"," + connection.getResponseMessage());
            }
        }catch (Throwable cause){
            cause.printStackTrace();
        }finally {
            if(connection != null){
                connection.disconnect();
            }
        }
    }
}
