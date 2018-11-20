package com.qht.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public static String post(String url ,String param) {
		PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL httpUrl = new URL(url);     
            System.out.println("httpUrl\n"+httpUrl);
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
		String url = "https://console.tim.qq.com/v4/group_open_http_svc/create_group?usersig=eJxNj0tvgzAQhP9K5WurFjCv5IZIIpAgbUmktifLsR1wHuCahRCq-vcSRKvu8Zud3ZkvtE02j5SxqimBwFUJNEcGehix5KIEuZdCD5DysyxlDZpCpacFqpTkhALBmv-z1fxIRmlgpm0YpmP7Dp5E0SmpBaF7GM9i1-izyXwA6fIjjF8Xh7SYNQxfsuiUbZnq1zFbbrDooHa6p-4NrChtw5f3xSrI4yJI2nBV5H0cHI67ZLf2Sma5l6i5Zp*uYtX9zDWF4wD3-dPz9Azk*VZ1iGa5tmd7vyFaoWtZlWh*h6whuGlh4zbo*wcE6Fr-&identifier=administrator&sdkappid=1400154853&random=92751892592376814743133956525716&contenttype=json";
		              
		String data = "{\"Owner_Account\": \"Web_trtc_01\",\"Type\":\"Public\", \"Name\": \"TestGroup99\"}";
		String result= post(url,data);
		System.out.println(result);
	
	}
}
