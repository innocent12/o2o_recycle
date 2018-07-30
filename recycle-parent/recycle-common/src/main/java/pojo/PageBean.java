package pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author JCX
 *
 * @param <T>
 */
public class PageBean<T> implements Serializable{

	 private int currPage;//��ǰҳ��
	    private int pageSize;//ÿҳ��ʾ�ļ�¼��
	    private int totalCount;//�ܼ�¼��
	    private int totalPage;//��ҳ��
	    private List<T> lists;//ÿҳ����ʾ������

	    public PageBean() {
	        super();
	    }

	    public int getCurrPage() {
	        return currPage;
	    }

	    public void setCurrPage(int currPage) {
	        this.currPage = currPage;
	    }

	    public int getPageSize() {
	        return pageSize;
	    }

	    public void setPageSize(int pageSize) {
	        this.pageSize = pageSize;
	    }

	    public int getTotalCount() {
	        return totalCount;
	    }

	    public void setTotalCount(int totalCount) {
	        this.totalCount = totalCount;
	    }

	    public int getTotalPage() {
	        return totalPage;
	    }

	    public void setTotalPage(int totalPage) {
	        this.totalPage = totalPage;
	    }

	    public List<T> getLists() {
	        return lists;
	    }

	    public void setLists(List<T> lists) {
	        this.lists = lists;
	    }
}
