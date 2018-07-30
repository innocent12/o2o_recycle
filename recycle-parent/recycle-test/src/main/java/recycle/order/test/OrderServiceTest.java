package recycle.order.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.json.JSONObject;
import order.dto.OrderDetail;
import order.service.OrderInfoService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class OrderServiceTest {
	
	@Autowired
	private OrderInfoService orderService;
	
	private static final Log log = LogFactory.getLog(OrderServiceTest.class);
	
	@Test
	public void orgGetOrderResByOrderId(){
		log.info("开始");
		OrderDetail orderDetail = orderService.getOrderResByOrderId("111");
		log.info(JSONObject.fromObject(orderDetail));
		assertEquals(orderDetail.getStatus(), "success");
	}
}
