package user.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.CollectorMapper;
import user.pojo.Collector;
import user.pojo.CollectorExample;
import user.service.CollectorService;


@Service("collectorServiceImpl")
@Component
public class CollectorServiceImp implements CollectorService{
	
	@Autowired
	CollectorMapper collectorMapper = null;
	
	
	
	
	/**
	 * ����order������ѯ������Ϣ
	 * @param orderId
	 * @return
	 *//*
	@Override
	public OrderInfo getDetailedOrderByOrderid(int id) {
		// TODO Auto-generated method stub
		OrderInfo order = new OrderInfo();
		try{
			if(id != 0){
				order = orderMapper.selectByPrimaryKey(id);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}*/

	
	/**
	 * ����Ա���ܶ���
	 * ����״̬��Ϊ�ѽӵ�
	 * ͬʱ�޸Ķ���״̬
	 *//*
	@Override
	public String AcceptOrder(int id, String collectorAccount){
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(id != 0 && collectorAccount != ""){
				OrderInfo record = new OrderInfo();
				
				record.setId(id);
				record.setCollectoraccount(collectorAccount);
				record.setOrderstate(2);
				if(orderMapper.updateByPrimaryKeySelective(record) > 0){
					result = "success";
				}
			}
		}catch(Exception e){
			result ="fail";
			e.printStackTrace();
		}
		return result;
	}*/

	/**
	 * �ϴ��������ݣ�ȷ���ջ�
	 * ���ز������ݼ�¼��
	 * @param resRecordsList
	 * @return
	 *//*
	@Override
	public String completeGoodsDetails(List<ResourceRecords> resRecordsList , int id) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			//�б�ǿ�,ִ�в������
			int count = 0;
			if(!resRecordsList.isEmpty()){
				for(ResourceRecords record:resRecordsList){
					resRecordMapper.insert(record);
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
		return result;
	}*/

	/**
	 * �������붩��ȷ��״̬
	 * ���ض�����Ϣ
	 * @param orderId
	 * @return
	 *//*
	@Override
	public OrderInfo ConfirmOrder(int id) {
		// TODO Auto-generated method stub
		OrderInfo record = new OrderInfo();
		try{
			//�п�
			if(id != 0){
				record.setId(id);
				record.setOrderstate(3);
				if(orderMapper.updateByPrimaryKeySelective(record) > 0){
					record = orderMapper.selectByPrimaryKey(id);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return record;
	}*/

	/**
	 * ��ȡ�����Ѿ��ӵ��Ķ���
	 * @return
	 *//*
	@Override
	public List<OrderInfo> getPreRecoveredOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> orderlist = null;
		try{
			OrderInfoExample orderexample = new OrderInfoExample();
			orderexample.createCriteria().andOrderstateEqualTo(2);
			orderlist = orderMapper.selectByExample(orderexample);
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderlist;
	}*/

	/**
	 * ͨ��������ȡ����Ա��Ϣ
	 * @param collectorOpenid
	 * @return
	 */
	@Override
	public Collector getCollectorInfoById(int id) {
		// TODO Auto-generated method stub
		Collector collector = null;
		try{
			//�ж�idΪ�ջ���null
			if(id != 0){
				collector = collectorMapper.selectByPrimaryKey(id);
			}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		return collector;
	}

	/**
	 * ����Ա�޸�����
	 * @param oldPwd
	 * @param newPwd
	 * @return
	 */
	@Override
	public String changePasswordById(String oldPwd, String newPwd, int id) {
		// TODO Auto-generated method stub
		String modifyResult = "";
		try{
			//���id�͵�ǰ��������
			CollectorExample cexample = new CollectorExample();
			cexample.createCriteria().andIdEqualTo(id);
			cexample.createCriteria().andCollectorpasswordEqualTo(oldPwd);
			//��֤�����Ƿ���ȷ
			if(collectorMapper.selectByExample(cexample) != null){
				//��������example����
				cexample.clear();
				Collector record = new Collector();
				record.setCollectorpassword(newPwd);
				record.setId(id);
				//��ɸ���
				if(collectorMapper.updateByPrimaryKeySelective(record) > 0){
					modifyResult = "success";
				}
			}else{
				modifyResult = "ƥ�����";
			}
		}catch(Exception e){
			modifyResult = "fail";
			e.printStackTrace();
		}
		return modifyResult;
	}

	/**
	 * ��ȡ����Ա�˻����
	 * @param openId
	 * @return
	 */
	@Override
	public double getMyBalanceById(int id) {
		// TODO Auto-generated method stub
		double balance = 0.00;
		try{
			if(id != 0){
				Collector collector = collectorMapper.selectByPrimaryKey(id);
				balance = collector.getCollectorbalance();	
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return balance;
	}

	/**
	 * ����Ա��ȡ
	 * ������Ҫ�ջ��Ķ���
	 *//*
	@Override
	public List<OrderInfo> getNotRecveredOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> orderList = null;
		try{
			OrderInfoExample orderexample = new OrderInfoExample();
			//������������״̬λ��1.2֮���
			orderexample.createCriteria().andOrderstateBetween(1, 2);
			orderList = orderMapper.selectByExample(orderexample);
		}catch(Exception e){
			e.printStackTrace();
		}
		return orderList;
	}*/

	/**
	 * �����˺�������֤��¼
	 * ���ҽ�openid�����
	 */
	@Override
	public Collector validLogin(String collectorAccount, String password, String openid) {
		// TODO Auto-generated method stub
		Collector collector = null;
		List<Collector> clist = null;
		try{
			if(collectorAccount != "" && password != ""){	
				CollectorExample collectorExample = new CollectorExample();
				collectorExample.createCriteria().andCollectoraccountEqualTo(collectorAccount);
				collectorExample.createCriteria().andCollectorpasswordEqualTo(password);
				clist = collectorMapper.selectByExample(collectorExample);
				//��֤�ɹ�
				if(clist.size() != 0){
					collector = clist.get(0);
					//�����µ�openid
					collector.setCollectoropenid(openid);
					int count = collectorMapper.updateByPrimaryKey(collector);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return collector;
	}


	//����openId��¼����
	@Override
	public Collector LoginIn(String openId) {
		// TODO Auto-generated method stub
		List<Collector> cList = null;
		Collector collector = null;
		try{
			if(openId != ""){	
				CollectorExample collectorExample = new CollectorExample();
				collectorExample.createCriteria().andCollectoropenidEqualTo(openId);
				cList = collectorMapper.selectByExample(collectorExample);
				if(cList.size() != 0){
					collector = cList.get(0);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return collector;
	}


	//ɾ������Ա
	@Override
	public String deleteCollecotrById(int id) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(id != 0){
				result = collectorMapper.deleteByPrimaryKey(id)>0?"success":"fail";
			}
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
		}
		return result;
	}


	//��ӻ���Ա
	@Override
	public String addCollector(Collector collector) {
		String result = "";
		try{
			//���û���ԱĬ�ϲ���
			collector.setCollectorlevel("δ����");
			collector.setCollectorregisterdate(new Date());
			collector.setCollectorbalance(0.00);
			String phone = collector.getCollectorphone();
			if(phone != ""){
				collector.setCollectoraccount("co"+phone);
			}
			//System.out.println(123);
			//System.out.println(collector.getId());
			if(validUnique(collector) == "unique"){
				result = collectorMapper.insertSelective(collector)>0?"success":"fail";
			}
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}


	//��֤collectΨһ��,�ɹ�����unique
	public String validUnique(Collector collector){
		String result = "unique";
		try{
			String account = collector.getCollectoraccount();
			//String name = collector.getCollectorname();
			String phone = collector.getCollectorphone();
			CollectorExample example = new CollectorExample();
			//��֤�˺�
			if(account != null){
				example.createCriteria().andCollectoraccountEqualTo(account);
				result = collectorMapper.selectByExample(example).size() !=0?"account":"unique";
			}
			//��֤�绰
			if(phone != null){
				example.clear();
				example.createCriteria().andCollectorphoneEqualTo(phone);
				result = collectorMapper.selectByExample(example).size() != 0?"phone":"unique";
			}
			System.out.println(result);
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}
	
	//�����û���
	@Override
	public String setColNameById(String oldName, String newName, int id) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(id != 0){
				Collector record = new Collector();
				record.setId(id);
				record.setCollectorname(newName);
				if(validUnique(record) == "unique"){
					result = collectorMapper.updateByPrimaryKeySelective(record)>0?"success":"fail";
				}
			}
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
		}
		return result;
	}


	//���õ绰
	@Override
	public String setPhoneById(String newPhone, int id) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(id != 0){
				Collector record = new Collector();
				record.setId(id);
				record.setCollectorphone(newPhone);
				if(validUnique(record) == "unique"){
					collectorMapper.updateByPrimaryKeySelective(record);
					result = "success";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * ͨ����������ɾ��id
	 * @param list
	 * @return
	 */
	@Override
	public String deleteBatchCollector(List<Integer> list) {
		String result = "";
		try{
			int count =0;
			if(list.size() != 0){
				for(int i = 0;i<list.size();i++){
					int id = list.get(i);
					collectorMapper.deleteByPrimaryKey(id);
					count++;
				}
				result=count==list.size()?"success":"fail";
			}
		}catch(Exception e){
			e.printStackTrace();
			result = "error";
		}
		return result;
	}	
	
	@Override
	public Collector getCollectorByAccount(String account){
		CollectorExample example = new CollectorExample();
		example.createCriteria().andCollectoraccountEqualTo(account);
		List<Collector> list = collectorMapper.selectByExample(example);
		return list.get(0);
	}
	
}
