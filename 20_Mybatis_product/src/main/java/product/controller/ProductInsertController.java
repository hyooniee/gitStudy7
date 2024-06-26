package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductInsertController {
	private final String command = "insert.prd";
	private final String getPage = "productInsertForm"; 
	private final String gotoPage = "redirect:/list.prd";

	@Autowired 
	private ProductDao productDao;

	@Autowired
	ServletContext servletContext;
	
	// productList.jsp에서 추가하기 클릭
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String insert(HttpSession session) {
		//로그인 성공하면 loginInfo 세션 설정
		System.out.println("loginInfo:" + session.getAttribute("loginInfo")); // null
		if(session.getAttribute("loginInfo") == null) { // 
			session.setAttribute("destination", "redirect:/insert.prd");
			return "redirect:/loginForm.mb"; //MemberLoginController=>memberLoginForm.jsp
		}else {
			return getPage;//productInsertForm
		}
	}
	 
	//
	@RequestMapping(value=command, method = RequestMethod.POST)
	public ModelAndView insertForm(@ModelAttribute("product") @Valid ProductBean prod, BindingResult result) {
		
		System.out.println("PIC post");
		System.out.println("prod.getImage():"+prod.getImage()); // null, 시계.jpg
		System.out.println("prod.getUpload():"+prod.getUpload());
		MultipartFile multi = prod.getUpload();
		
		String uploadPath = servletContext.getRealPath("/resources/uploadImage/");
		System.out.println("uploadPath:" + uploadPath);
		//uploadPath:C:\Spring_test\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\20_MyBatis_Product\resources/uploadImage/

		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav; 
		}
		
		int cnt = -1;
		cnt = productDao.insertProduct(prod);
		if(cnt != -1) {
			mav.setViewName(gotoPage);
			
			File destination = new File(uploadPath+File.separator+multi.getOriginalFilename());
			// C:\Spring_test\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\20_MyBatis_Product\resources/uploadImage/시계.jpg
			try {
				multi.transferTo(destination);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			mav.setViewName(getPage);
		}
		
		return mav;
	}
}