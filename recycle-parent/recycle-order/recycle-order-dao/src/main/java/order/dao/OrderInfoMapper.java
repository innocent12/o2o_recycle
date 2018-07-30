package order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import order.pojo.OrderInfo;
import order.pojo.OrderInfoExample;
import order.vo.OrderResource;
import order.vo.VisualOrderInfo;

/**
 * 
 * @author JCX
 *
 */
public interface OrderInfoMapper {
    int countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
    
    //获取订单详细信息
    List<VisualOrderInfo> selectTheOrderByOrderidAndSeller(@Param("addressArea") String addressArea,@Param("sellerAccount") String sellerAccount,@Param("orderId") String orderId);
    
    List<OrderResource> selectResByOrderId(String orderId);
    
    //根据区域地址获取订单简要信息
    List<VisualOrderInfo> selectOrderListByArea(@Param("addressArea") String addressArea, @Param("ca_Account") String ca_Account);
}