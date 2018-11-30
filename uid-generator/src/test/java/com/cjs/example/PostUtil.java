package com.cjs.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostUtil {
	
	/**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL httpUrl = new URL(url);           
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
        	conn.setRequestMethod("POST");
        	conn.setRequestProperty("Content-Type", "application/json");
        	conn.setRequestProperty("connection", "keep-alive");
        	conn.setUseCaches(false);//设置不要缓存
        	conn.setInstanceFollowRedirects(true);
        	conn.setDoOutput(true);
            conn.setDoInput(true);
        	conn.connect();            
            out = new PrintWriter(conn.getOutputStream());           
            out.print(param);            
            out.flush();           
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
        	close(out,in);
        }
        return result;
    } 
    
    private static void close(PrintWriter out,BufferedReader in) {
    	try{
            if(out!=null){
                out.close();
            }
            if(in!=null){
                in.close();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
	public static void main(String[] args) {
		String url = "http://139.159.198.250:8768/uid/idLeafKey";
		String param = "{\"data\":\"orderww\"}";
		String result = sendPost(url,param);
		System.out.println(result);
	}
}
