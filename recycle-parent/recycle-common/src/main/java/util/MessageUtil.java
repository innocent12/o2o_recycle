package util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import pojo.TextMessage;

public class MessageUtil {

	private static XStream xstream = new XStream();
	public static Map<String , String> parseXml(HttpServletRequest request) throws Exception{
		Map<String, String> map = new HashMap<String , String>();
		
		//将request的信息使用inputStream获取
		InputStream inputStream = request.getInputStream();
		//定义reader
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		
		//解析xml
		Element root = document.getRootElement();
		List<Element> elementList = root.elements();
		
		//遍历到map中
		for(Element e : elementList){
			map.put(e.getName(), e.getText());
		}
		//閲婃斁璧勬簮
		inputStream.close();
		inputStream = null;
		
		return map;
		
	}
	/*
	 * string转化为xml
	 * 
	 */
	public static String textMessageToXml(TextMessage textmessage){
		xstream.alias("xml", textmessage.getClass());
		return xstream.toXML(textmessage);
		
	}
}
