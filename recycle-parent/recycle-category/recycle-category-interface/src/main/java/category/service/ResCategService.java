package category.service;

import java.util.List;

import category.pojo.ResourceCategory;

public interface ResCategService {
	
	ResourceCategory getResourceByNameAndType(String resourceName, String resourceType);
	
	//���������Դ
	String addMuchResource(List<ResourceCategory> resourceList);
	
	//�����Դ
	String addResource(ResourceCategory resource);

	//ɾ����Դ
	String deleteResource(ResourceCategory resource);
	
	//����idɾ����Դ
	String deleteResourceById(int id);
	
	//������������ɾ����Դ
	String deleteMuchResById(List<Integer> resList);
	
	//�޸���Դ
	String modifyResourceById(ResourceCategory resource);
	
	//�õ����е���Դ
	List<ResourceCategory> getAllResource();
	
	//�õ����е���Դ����
	List<String> getAllResourceType();
	//�õ�ָ����Դ�������������
	List<String> getResourceNameByType(String Type);
	//�������������Դ��Ϣ
	ResourceCategory getResourceCategoryById(int id);
	
	ResourceCategory getResourceCategoryByResourceId(String resourceid);
	
	//��֤��Դ�Ƿ��ظ�
	String validResUnique(ResourceCategory resource);
	
}
