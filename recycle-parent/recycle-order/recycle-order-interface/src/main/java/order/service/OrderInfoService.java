package order.service;

import java.util.List;

import net.sf.json.JSONArray;
import order.dto.OrderDetail;
import order.pojo.OrderInfo;
import order.vo.VisualOrderInfo;

/**
 * 
 * @author yangshu
 *
 */
public interface OrderInfoService {
	//�õ������յĶ���(�����ڻ���Ա�Ĳ��Է���)
	List<OrderInfo> getNotRecveredOrder();
	
	//ͨ�������ŵõ���ϸ����(���ڶ�����)
	OrderInfo getDetailedOrderByOrderid(int id);
	
	String AcceptOrder(int id, String collectorAccount);
	
	//ȷ���ջ�,�������״̬
	OrderInfo ConfirmOrder(int id);
	
	//�õ�Ԥ����״̬�Ķ���
	List<OrderInfo> getPreRecoveredOrder();
	
	//解耦合新增的五个order service
	////////////////////
	
	//�õ�����Ա�����ջ��Ķ���
	List<OrderInfo> getAviableOrderByCollector(String account);
	
	//���ݶ������޸Ķ���״̬
	String modifyOrderStateByOrderId(String orderid, int state);
	
	//���������˺Ż�ȡ��������ϸ
	JSONArray getOrderIncomeBySeller(String account);
	
	List<OrderInfo> selectAllOrderinfo();
	OrderInfo addOrderinfo(OrderInfo orderinfo);
	OrderInfo selectOrderinfoById(int id);
	OrderInfo getUnfinishedOrderBySellerAccount(String selleraccount);
	OrderInfo selectOrderinfoByOrderid(String orderid);
	List<OrderInfo> selectOrderinfoBySelleraccount(String selleraccount);
	List<OrderInfo> selectOrderinfoByCollectoraccount(String collectoraccount);
	String modifyOrderinfo(OrderInfo orderinfo);
	String modifyOrderstate(int id);
	String cancelOrder(int id);
	String finishOrder(int id);
	String addSellermessage(String sellermessage,String level, int id);
	String deleteOrderinfoById(int id);
	String deleteOrderinfo(List<Integer> ids);
	
	/**
	 * 获取订单信息
	 * @param addressArea
	 * @param se_account
	 * @param orderId
	 * @return
	 */
	OrderDetail getOrderDetailedByVisualOrderInfo(String addressArea, String se_account, String orderId);
	
	/**
	 * 获取订单货物资源
	 * @param orderid
	 * @return
	 */
	OrderDetail getOrderResByOrderId(String orderid);
	
	/**
	 * @param addrArea
	 * @param collector
	 * @return
	 */
	List<VisualOrderInfo> getOrdersByCollectorAndArea(String addrArea, String collector);
}
