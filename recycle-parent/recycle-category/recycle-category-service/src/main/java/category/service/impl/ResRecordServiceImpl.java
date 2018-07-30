package category.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import category.dao.ResourceRecordsMapper;
import category.pojo.ResourceRecords;
import category.pojo.ResourceRecordsExample;
import category.service.ResRecordService;

@Service("resRecordServiceImpl")
public class ResRecordServiceImpl implements ResRecordService{

	@Autowired
	ResourceRecordsMapper recordMapper;
	
	/**
	 * ������Ӷ�����Դ��¼
	 */
	@Override
	public String addManyRecords(List<ResourceRecords> recordList) {
		// TODO Auto-generated method stub
		String result = "";
		int count = 0;
		try{
			for(ResourceRecords record:recordList){
				recordMapper.insert(record);
				count++;
			}
			result = count == recordList.size()?"success":"fail";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �ϴ��������ݣ�ȷ���ջ�
	 * ���ز������ݼ�¼��
	 * @param resRecordsList
	 * @return
	 */
	@Override
	public String completeGoodsDetails(List<ResourceRecords> resRecordsList , int id) {
		// TODO Auto-generated method stub
		return "";
		/*String result = "";
		try{
			//�б�ǿ�,ִ�в������
			int count = 0;
			if(!resRecordsList.isEmpty()){
				for(ResourceRecords record:resRecordsList){
					recordMapper.insert(record);
					count++;
				}	
				OrderInfo record = new OrderInfo();
				record.setId(id);
				record.setOrderstate(4);
				if(orderMapper.updateByPrimaryKeySelective(record) != 0){
					result = "success";
				}
			}
			result = count > 0?"success":"fail";
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
		}
		return result;*/
	}
	
	
	/**
	 * ͨ��������ɾ�����������Դ��¼
	 */
	@Override
	public String deleteManyRecordsById(List<Integer> idList) {
		// TODO Auto-generated method stub
		String result = "";
		int count = 0;
		try{
			for(int id:idList){
				recordMapper.deleteByPrimaryKey(id);
				count ++;
			}
			result = count>= idList.size()?"success":"fail";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �����޸Ķ�����Դ��¼
	 */
	@Override
	public String modifyManyRecordsById(List<ResourceRecords> recordList) {
		// TODO Auto-generated method stub
		String result = "";
		int count = 0;
		try{
			for(ResourceRecords record:recordList){
				recordMapper.updateByPrimaryKeySelective(record);
				count ++;
			}
			result = count >= recordList.size()?"success":"fail";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ���ݶ�����Ż�ȡ
	 * ��Դ��¼(ģ����ѯ)
	 */
	@Override
	public List<ResourceRecords> getRecordsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		List<ResourceRecords> recordList = null;
		try{
			if(orderId != null){
				ResourceRecordsExample example = new ResourceRecordsExample();
				example.createCriteria().andOrderidLike("%"+orderId+"%");
				recordList = recordMapper.selectByExample(example);
			}
		}catch(Exception e){
			recordList = null;
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * ������Դ���ֻ�ö�Ӧ����Դ��¼
	 * ʹ��ģ����ѯ
	 */
	@Override
	public List<ResourceRecords> getRecordsByResName(String resourceName) {
		// TODO Auto-generated method stub
		List<ResourceRecords> recordList = null;
		try{
			//�п�
			if(resourceName != null){
				ResourceRecordsExample example = new ResourceRecordsExample();
				example.createCriteria().andResourcenameLike("%"+resourceName+"%");	
				recordList = recordMapper.selectByExample(example);
			}
		}catch(Exception e){
			recordList = null;
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * ͨ����Դid�õ���Դ��¼
	 */
	@Override
	public List<ResourceRecords> getRecordsByResId(String resourceId) {
		// TODO Auto-generated method stub
		List<ResourceRecords> recordList = null;
		try{
			if(resourceId != null){
				ResourceRecordsExample example = new ResourceRecordsExample();
				example.createCriteria().andResourceidLike("%"+resourceId+"%");
				recordList = recordMapper.selectByExample(example);
			}
		}catch(Exception e){
			recordList = null;
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * �õ����еĶ�����Դ
	 */
	@Override
	public List<ResourceRecords> getAllRecords() {
		// TODO Auto-generated method stub
		List<ResourceRecords> recordList = null;
		try{
			ResourceRecordsExample example = new ResourceRecordsExample();
			example.setOrderByClause("'id' ASC");
			recordList = recordMapper.selectByExample(example);
		}catch(Exception e){
			recordList = null;
			e.printStackTrace();
		}
		return recordList;
	}

	/**
	 * ���ݶ����ź���Դ��ɾ����Դ��¼
	 */
	@Override
	public String deleteRecord(String orderid, String resourceid) {
		String result = "";
		try{
			ResourceRecordsExample example = new ResourceRecordsExample();
			example.createCriteria().andOrderidEqualTo(orderid);
			example.createCriteria().andResourceidEqualTo(resourceid);
			if(recordMapper.deleteByExample(example) != 0){
				result = "success";
			}else{
				result = "fail";
			}
		}catch(Exception e){
			result = "error";
			e.printStackTrace();
		}
		return result;
	}

	
}
