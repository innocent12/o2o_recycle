package service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;
import pojo.AccessToken;
import pojo.TextMessage;
import util.MessageUtil;
import util.WeiXinUtil;

@Component
public class WeiXinService {

	
	
	//根据微信消息类型处理微信请求
	public static String processRequest(HttpServletRequest request, HttpSession session){
		String responsemessage = "";
		try{
			String getInfo_Url = "https://api.weixin.qq.com/cgi-bin/user/info?"
					+ "access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
		 	/*String appid = "wxaa4fd8b9758238a0";
			String appsecret = "9bb0d077a262afa7c49da4c6454d3acf";*/
			
			//将request中的参数一一对应到名值对中
			Map<String , String> requestMap = MessageUtil.parseXml(request);
			//
			
			//得到微信请求消息的相关参数
			String fromUserName = requestMap.get("FromUserName");
			String toUserName = requestMap.get("ToUserName");
			String msgType = requestMap.get("MsgType");
			String eventkey = requestMap.get("EventKey");
			String event = requestMap.get("event");
			
			WeiXinUtil wxutil = new WeiXinUtil();
			//获取微信access_token
			AccessToken accesstoken = wxutil.getAccessToken();
			String url= getInfo_Url.replace("ACCESS_TOKEN", accesstoken.getAccess_token()).replace("OPENID", fromUserName);
			//向微信服务器发送get请求，获得对应用户的信息
			String result = WeiXinUtil.sendGet(url);
			//将得到的字符串转化为json格式
			JSONObject jsonobject = JSONObject.fromObject(result);
			//设置消息参数
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(fromUserName);
			textMessage.setFromUserName(toUserName);
			textMessage.setCreateTime(new Date().getTime());
			//公众号请求为event
			if(msgType.equals("event")){
				//点击event
				//if(event.equals("click")){
					//点击的按钮对应的key值为11
					if(eventkey.equals("11")){
						//设置将要发送的消息
						 
						textMessage.setMsgType("text"); 
						textMessage.setContent(result);
						//封装对象成json格式
						responsemessage = MessageUtil.textMessageToXml(textMessage);
					}else if(event.equals("subscribe")){
						textMessage.setMsgType("text");
						textMessage.setContent("欢迎关注考试全队——O2O资源回收平台!回收任意文字获得使用教程。");
					}
				//}
			}else if(msgType.equals("view")){
				String openid = getopenId(result);
				//将openid存入session中
				session.setAttribute("openid", openid);
			}else if(msgType.equals("location")){//推送位置消息
				String x = requestMap.get("Location_X");
				String y = requestMap.get("Location_Y");
				String scale = requestMap.get("Scale");
				String Label = requestMap.get("Label"); 
				textMessage.setMsgType("text");
				//收到位置推送则将位置保存到数据库
//				String msg =  sellerService.savePosition(x, y, fromUserName);
				String msg = "wait";
				if(msg == "success"){
					textMessage.setContent("位置已成功录入!");
				}else if(msg == "empty"){
					textMessage.setContent("您还未注册账号,请注册账号后尝试!");
				}else{
					textMessage.setContent("未知错误，请稍后再试"+msg);
				}
				//将pojo类转换为xml格式
			}else if(msgType.equals("text")){//用户的是回复文字消息
				textMessage.setMsgType("text");
				textMessage.setContent("1.注册账号——在菜单中点击（我的账号），点击登录注册即可使用本平台功能.");
			}
			responsemessage = MessageUtil.textMessageToXml(textMessage);
		}catch(Exception e){
			e.printStackTrace();
		}
		return responsemessage;
	}
	
	//得到openid
	public static String getopenId(String url_info){
		String openid = "";
		try{
			JSONObject json = JSONObject.fromObject(url_info);
			openid = json.getString("openid");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return openid;
	}
	
}
