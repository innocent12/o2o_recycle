package user.service;

import java.util.List;

import user.pojo.Collector;



public interface CollectorService{
	
	
	//��֤����ԱΨһ��
	String validUnique(Collector collector);
	
	//����Ա�˺���֤��¼
	Collector validLogin(String collectorAccount, String password, String openid);
	
	//����openIdֱ�ӵ�¼
	Collector LoginIn(String openId);
	
	String deleteBatchCollector(List<Integer> list);
	
	//ɾ������Ա
	String deleteCollecotrById(int id);
	
	//��ӻ���Ա
	String addCollector(Collector collector);
	
	//�޸�����
	String changePasswordById(String oldPwd, String newPwd, int id);
	//�����û���
	String setColNameById(String oldName, String newName, int id);
	
	//��ӵ绰����
	String setPhoneById(String newPhone, int id);
	
	//����ҵ��˻����
	double getMyBalanceById(int id);
	
/*	//�õ������յĶ���(�����ڻ���Ա�Ĳ��Է���)
	List<OrderInfo> getNotRecveredOrder();
	
	//ͨ�������ŵõ���ϸ����(���ڶ�����)
	OrderInfo getDetailedOrderByOrderid(int id);*/
	
	/*//���ܶ���
	String AcceptOrder(int id, String collectorAccount);*/
	
	/*//�����Ʒ����,��Ҫ�ϴ�����id����Դid��������
	String completeGoodsDetails(List<ResourceRecords> resRecordsList, int id);*/
	
/*	//ȷ���ջ�,�������״̬
	OrderInfo ConfirmOrder(int id);
	
	//�õ�Ԥ����״̬�Ķ���
	List<OrderInfo> getPreRecoveredOrder();*/
	
	//�õ�����Ա��Ϣ
	Collector getCollectorInfoById(int id);
	
	Collector getCollectorByAccount(String account);
	
}
