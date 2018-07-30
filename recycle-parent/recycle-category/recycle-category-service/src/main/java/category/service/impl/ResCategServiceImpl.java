package category.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import category.dao.ResourceCategoryMapper;
import category.pojo.ResourceCategory;
import category.pojo.ResourceCategoryExample;
import category.service.ResCategService;

@Service("resCategServiceImpl")
public class ResCategServiceImpl implements ResCategService{

	@Autowired
	ResourceCategoryMapper resMapper;
	
	/**
	 *����µ�Resource
	 *�ɹ�����success 
	 * @param resource
	 * @return
	 */
	@Override
	public String addResource(ResourceCategory resource) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			resource.setResourcestock(0);
			resource.setResourceid("re"+resource.getResourceid());
			if(validResUnique(resource) == "unique"){
				result = resMapper.insert(resource) >0?"success":"fail";
			}
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ������Դ��Ϣɾ����Դ
	 * @param resource
	 * @return
	 */
	@Override
	public String deleteResource(ResourceCategory resource) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(resource != null){
				int id = resource.getId();
				result = resMapper.deleteByPrimaryKey(id)>0?"success":"fail";
			}
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��������ɾ����Դ��
	 * @param id
	 * @return
	 */
	@Override
	public String deleteResourceById(int id) {
		String result = "fail";
		try{
			if(id != 0){
				result = resMapper.deleteByPrimaryKey(id)>0?"success":"fail";
			}
		}catch(Exception e){
			result="fail";
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}

	/**
	 * ����������Դ��Ϣ
	 * @param resource
	 * @return
	 */
	@Override
	public String modifyResourceById(ResourceCategory resource) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			if(resource != null){
				result = resMapper.updateByPrimaryKeySelective(resource)>0?"success":"fail";
			}
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * �õ����е���Դ��Ϣ�����Ұ���������
	 * @return
	 */
	@Override
	public List<ResourceCategory> getAllResource() {
		// TODO Auto-generated method stub
		List<ResourceCategory> resList = null;
		try{
			ResourceCategoryExample example = new ResourceCategoryExample();
			example.setOrderByClause("'resourceType' ASC");
			resList = resMapper.selectByExample(example);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resList;
	}

	/**
	 * �õ����е���Դ����
	 * �Ȳ�ѯ�����������Դ��Ϣ
	 * Ȼ�������������
	 * @return
	 */
	@Override
	public List<String> getAllResourceType() {
		// TODO Auto-generated method stub
		List<String> typeList = new ArrayList<>();
		try{
			List<ResourceCategory> resourceList = null;
			ResourceCategoryExample example = new ResourceCategoryExample();
			example.setOrderByClause("'resourceType' ASC");
			example.setDistinct(true);
			resourceList = resMapper.selectByExample(example);
			//����������List����
			for(ResourceCategory resource:resourceList){
				//���������temp����resouce��
				typeList.add(resource.getResourcetype());
			}
		}catch(Exception e){
			typeList = null;
			e.printStackTrace();
		}
		return typeList;
	}

	/**
	 * ��ѯָ����������е�
	 * ��Դ����
	 * @param Type
	 * @return
	 */
	@Override
	public List<String> getResourceNameByType(String Type) {
		// TODO Auto-generated method stub
		List<String> nameList = new ArrayList<>();
		try{
			ResourceCategoryExample example = new ResourceCategoryExample();
			example.createCriteria().andResourcetypeEqualTo(Type);
			List<ResourceCategory> resList = resMapper.selectByExample(example);
			for(ResourceCategory resource:resList){
				nameList.add(resource.getResourcename());
			}
		}catch(Exception e){
			nameList = null;
			e.printStackTrace();
		}
		return nameList;
	}

	/**
	 * ����������ѯ��Դ
	 * @param id
	 * @return
	 */
	@Override
	public ResourceCategory getResourceCategoryById(int id) {
		// TODO Auto-generated method stub
		ResourceCategory resource = null;
		try{
			resource = resMapper.selectByPrimaryKey(id);
		}catch(Exception e){
			resource = null;
			e.printStackTrace();
		}
		return resource;
	}

	/**
	 * ��֤��Դ�Ƿ�������
	 * ����������unique
	 */
	@Override
	public String validResUnique(ResourceCategory resource) {
		// TODO Auto-generated method stub
		String result = "fail";
		try{
			String name = resource.getResourcename();
			ResourceCategoryExample example = new ResourceCategoryExample();
			//������ͬ������
			if(name != null){
				example.createCriteria().andResourcenameEqualTo(name);
				result = resMapper.selectByExample(example).size()==0?"unique":"fail";
			}
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��������
	 * ����ɾ����Դ��Ϣ
	 * @param resList
	 * @return
	 */
	@Override
	public String deleteMuchResById(List<Integer> resList) {
		// TODO Auto-generated method stub
		String result = "";
		int num = 0;
		try{
			for(int count:resList){
				resMapper.deleteByPrimaryKey(count);
				num++;
			}
			result = num==resList.size()? "success":"fail";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��������µ���Դ
	 */
	@Override
	public String addMuchResource(List<ResourceCategory> resourceList) {
		// TODO Auto-generated method stub
		String result = "";
		try{
			int count = 0;
			for(ResourceCategory resource:resourceList){
				resMapper.insertSelective(resource);
				count ++;
			}
			result = count>0?"success":"fail";
		}catch(Exception e){
			result = "fail";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ResourceCategory getResourceByNameAndType(String resourceName, String resourceType) {
		ResourceCategory resource = new ResourceCategory();
		try{
			ResourceCategoryExample example = new ResourceCategoryExample();
			example.createCriteria().andResourcenameEqualTo(resourceName).andResourcetypeEqualTo(resourceType);
			List<ResourceCategory> reslist = resMapper.selectByExample(example);
			if(reslist.size()!=0){
				return reslist.get(0);
			}else{
				resource = null;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return resource;
	}
	
	@Override
	public ResourceCategory getResourceCategoryByResourceId(String resourceid) {
		// TODO Auto-generated method stub
		ResourceCategoryExample example = new ResourceCategoryExample();
		example.createCriteria().andResourceidEqualTo(resourceid);
		List<ResourceCategory> list = resMapper.selectByExample(example);
		return list.get(0);
	}
	
}
