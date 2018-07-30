package util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 
 *�½�֤��������࣬����������̳���X50TrustManager
 *���׳��κ��쳣�������������е�֤��
 * @author xutianyu
 *
 */
public class MyX509TrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException{}
	//�÷������ڼ��ͻ�������֤��
	
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException{}
	//�÷������ڼ�������������֤�飬
	
	public X509Certificate[] getAcceptedIssuers(){
		return null;
	}
	//�÷����������еĺϸ�֤�������
}
