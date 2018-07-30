package web.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * upload
 * @author JCX
 *
 */
@Controller
@RequestMapping("/upload")
public class UpLoadController {
	/*上传头像*/
	@RequestMapping(value="/pic",method=RequestMethod.POST)
	public String UpLoadPicture(MultipartFile picture) {
		
		String name = UUID.randomUUID().toString().replaceAll("-","");
		String Exname = FilenameUtils.getExtension(picture.getOriginalFilename());
		
		File pic = new File("D://upload//lanou//" + name + "." + Exname);
		try {
			picture.transferTo(pic);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "";
	}
}
