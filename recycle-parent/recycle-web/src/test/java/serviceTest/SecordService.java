package serviceTest;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.json.JSONObject;
import order.dto.OrderDetail;
import order.service.OrderInfoService;
import user.dto.UserInfoDto;
import user.service.SellerService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-mvc.xml"})
public class SecordService {
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private OrderInfoService orderService;
	
	private Logger log;
	
	@Test
	public void seGetNormalSeller_AddressByAccountTest(){
		UserInfoDto sellerDto = sellerService.getNormalSeller_AddressByAccount("test1");
		
		log.info(JSONObject.fromObject(sellerDto));
		assertEquals(sellerDto.getStatus(),"success");
	}
	
	@Test
	public void orgGetOrderResByOrderId(){
		OrderDetail orderDetail = orderService.getOrderResByOrderId("111");
		log.info(JSONObject.fromObject(orderDetail));
		assertEquals(orderDetail.getStatus(), "success");
	}
}
