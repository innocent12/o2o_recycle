package util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import pojo.AccessToken;
import pojo.Menu;

@Component
public class WeiXinUtil {

	private static Logger log = LoggerFactory.getLogger(WeiXinUtil.class);
	public final static String  access_token_url = "https://api.weixin.qq.com/cgi-bin/token?"
			+ "grant_type=client_credential&appid=APPID&secret=APPSECRET";
	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/me nu/cr"
			+ "eate?access_token=ACCESS_TOKEN";
	
	public final static String authorization_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";
	
	public final static String appid = "wxaa4fd8b9758238a0";
	public final static String appsecret = "9bb0d077a262afa7c49da4c6454d3acf";
	
	
	/**
	 * 微信授权获取access_token
	 * 请求有次数限制
	 * @param appid
	 * @param appsecret
	 * @return
	 */
	public AccessToken getAccessToken(){
		AccessToken accesstoken = new AccessToken();
		String requestUrl = access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret);
		JSONObject jsonobject = httpRequest(requestUrl, "GET", null);
		//jsonobject
		if(null != jsonobject){
			try{
				//获取accesstoken
				accesstoken.setAccess_token(jsonobject.getString("access_token"));
				accesstoken.setValid_time(jsonobject.getInt("expires_in"));
			}catch(JSONException e){
				accesstoken = null;
				//获取accesstoken失败
				log.error("获取token失败 errcode:{} errmsg:{}", jsonobject.getInt("errcode"
						+ ""), jsonobject.getString( "errmsg"));
			}
		}
		return accesstoken;
	}
	
	/**
	 * 微信网页授权outhorization2
	 * 获取的openid
	 * 无法使用微信高级接口
	 * @param appid
	 * @param appsecret
	 * @param code
	 * @return
	 */
	public AccessToken getAccessToken(String code){
		AccessToken access_token = new AccessToken();
		try{
			System.out.print(code);
			String requestUrl = authorization_access_token_url.replace("APPID", appid).replace("APPSECRET", appsecret).replace("CODE", code);
			JSONObject jsonobject = httpRequest(requestUrl, "GET" , null);
			if(null != jsonobject){
				access_token.setAccess_token(jsonobject.optString("access_token"));
				access_token.setValid_time((jsonobject.optInt("expires_in")));
				access_token.setOpenid(jsonobject.optString("openid"));
				access_token.setRefresh_token(jsonobject.optString("refresh_token"));
			}
		}catch(JSONException e){
			e.printStackTrace();
			access_token = null;
		}catch(Exception e){
			e.printStackTrace();
			access_token = null;
		}
		return access_token;
	}
	
	
	/**
	 * 发送get请求到url
	 * @param url
	 * @return
	 */
	public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url ;
            URL realUrl = new URL(urlNameString);
            // 新建url连接
            URLConnection connection = realUrl.openConnection();
            //设置get请求参数
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            //连接
            connection.connect();
            //
            Map<String, List<String>> map = connection.getHeaderFields();
            //
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            //将获取到的信息保存在input流中
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("fail:" + e);
            e.printStackTrace();
        }
        //返回信息
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
	
/**
 * 
 * https请求代码参考自www.java1234.com
 * @param requestUrl
 * @param requestMethod
 * @param outputStr
 * @return
 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr){
		JSONObject jsonobject = null;
		StringBuffer buffer = new StringBuffer();
		try{
			//
			TrustManager[] tm = { new MyX509TrustManager()};
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");

			sslContext.init(null, tm, new java.security.SecureRandom());
			//
			SSLSocketFactory ssf = sslContext.getSocketFactory();
			
			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
			
			httpUrlConn.setSSLSocketFactory(ssf);
			
			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			
			//定义请求格式(get/post)
			httpUrlConn.setRequestMethod(requestMethod);
			if("GET".equalsIgnoreCase(requestMethod)){
				httpUrlConn.connect();
			}
			//设置out的格式
			if(null != outputStr){
				OutputStream outputStream = httpUrlConn.getOutputStream();
				//设置编码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}
			
			//连接信息读取到inputstream
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			String str = null;
			while((str = bufferedReader.readLine()) != null){
				buffer.append(str);
			}
			//释放资源
			bufferedReader.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonobject = JSONObject.fromObject(buffer.toString());
			
		}catch(ConnectException ce){
			log.error("weixin server connect time out.");
		}catch(Exception e){
			log.error("https request error:{}", e);
		}
		
		return jsonobject;
	}
	
	/**
	 * 公众号菜单通过微信测试接口调试
	 * 生成，以下代码仅供学习
	 * @param menu
	 * @param access_token
	 * @return
	 */
	public static int createMenu(Menu menu, String access_token){
		int result = 0;
		
		//创建菜单url
		String url = menu_create_url.replace("ACCESS_TOKEN", access_token);
		//将pojo转换为json对象 
		String jsonMenu = JSONObject.fromObject(menu).toString();
		//以post方式建立http连接
		JSONObject jsonobject = httpRequest(url, "POST", jsonMenu);
		
		if(null != jsonobject){
			if(0 != jsonobject.getInt("errcode")){
				result = jsonobject.getInt("errcode");
				log.error("错误信息： errcode:{} errmsg:{}",jsonobject.getInt("errcode"), jsonobject.getString( "errmsg")); 
				
			}
		}
		return result;
	}
}
