package recycle.user.test;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.json.JSONObject;
import user.dto.UserInfoDto;
import user.service.SellerService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class SellerServiceTest {

	@Autowired
	private SellerService sellerService;
	private static final Log log = LogFactory.getLog(SellerServiceTest.class);
	
	@Test
	public void GetNormalSeller_AddressByAccountTest(){
		log.info("test begin");
		UserInfoDto sellerDto = sellerService.getNormalSeller_AddressByAccount("test1");
		
		log.info(JSONObject.fromObject(sellerDto.getNormalInfo()));
		System.out.println("seller.info"+JSONObject.fromObject(sellerDto.getNormalInfo())+"1"+sellerDto);
		assertNotNull(sellerDto.getStatus());
	}
	
}
