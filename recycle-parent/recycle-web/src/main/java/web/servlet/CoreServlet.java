package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.WeiXinService;
import util.SignUtil;

public class CoreServlet extends HttpServlet{

	private static final long serialVersionUID = 4440739483644821986L; 
	/** 
	 * .
	 * ȷ����������΢�ŷ�����  get����
	 * ��Ҫ������֤ǩ��
	* */ 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// ΢�ż���ǩ�� 
		String signature = request.getParameter("signature");  
		// ʱ��� 
		String timestamp = request.getParameter("timestamp");
		// ����� 
		String nonce = request.getParameter("nonce"); 
		// ����ַ��� 
		String echostr = request.getParameter("echostr"); 
		PrintWriter out = response.getWriter(); 
		// ͨ������ signature ���������У�飬��У��ɹ���ԭ������ echostr����ʾ���� �ɹ����������ʧ�� 
		if (SignUtil.checkSignature(signature, timestamp, nonce)) { 
			out.print(echostr); 
			//�޸ĵ�һ
			out.flush();
		} 
		out.close(); 
		out = null; 
		} 
	
	/** 
	 * 
	 *  ����΢�ŷ�����������post���� 
	 *  ���ڴ����û���Ϣ
	 * */  
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		// TODO ��Ϣ�Ľ��ա�������Ӧ 
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*JSONObject jsonobject = new JSONObject();*/
		HttpSession session = request.getSession();
		String responsemessage = WeiXinService.processRequest(request,session);
		PrintWriter out = response.getWriter();
		out.print(responsemessage);
		out.flush();
		out.close();
		} 
}
