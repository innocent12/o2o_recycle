package category.service;

import java.util.List;

import category.pojo.ResourceRecords;

public interface ResRecordService {
	
	//�����Ʒ����,��Ҫ�ϴ�����id����Դid��������
	String completeGoodsDetails(List<ResourceRecords> resRecordsList, int id);
	//新增一个service  解耦合
	
	//ɾ��ָ��������ָ������Դ��¼
	String deleteRecord(String orderid, String resourceid);
	
	//�������Ӷ����漰������Դ
	String addManyRecords(List<ResourceRecords> recordList);
	
	//����ɾ��������Դ��¼
	String deleteManyRecordsById(List<Integer> idList);

	//�����޸Ķ�����Դ��¼
	String modifyManyRecordsById(List<ResourceRecords> recordList);
	
	//����ָ�������ŵ���Դ��Ϣ��ģ����ѯ��
	List<ResourceRecords> getRecordsByOrderId(String orderId);
	
	//����ָ����Դ���ֵ���Դ��Ϣ(ģ����ѯ)
	List<ResourceRecords> getRecordsByResName(String resourceName);
	
	//����ָ����Դ�ŵ���Դ��Ϣ(ģ����ѯ)
	List<ResourceRecords> getRecordsByResId(String resourceId);
	
	//��ȡ���еĶ�����Դ,
	List<ResourceRecords> getAllRecords();
}
