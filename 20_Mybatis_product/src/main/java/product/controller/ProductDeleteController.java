package product.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {
	private final String command = "/delete.prd";
	private final String gotoPage = "redirect:/list.prd";

	@Autowired
	ProductDao productDao;

	@Autowired
	ServletContext servletContext;

	@RequestMapping(command)
	public String delete(
			@RequestParam(value="num") int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword,
			RedirectAttributes redirectAttributes) {

		ProductBean product = productDao.detailViewByNum(num);

		String image = product.getImage(); // �ȭ.jpg
		System.out.println("������ư Ŭ���ϸ� �Ѿ���� image : " + image);
		
		productDao.deleteProduct(num); 
		

		String deletePath = servletContext.getRealPath("/resources/uploadImage/");
		System.out.println("deletePath:" + deletePath);
		
		File file = new File(deletePath+File.separator+image);
		if(file.exists()) {
			file.delete();
		}
		try {
			String encodedWhatColumn = URLEncoder.encode(whatColumn, "UTF-8"); // ��ǰ��(name), ����
			String encodedKeyword = URLEncoder.encode(keyword, "UTF-8"); // ��

//			String redirectUrl = "redirect:/list.prd?pageNumber=" + pageNumber + "&whatColumn=" + whatColumn + "&keyword="+keyword; 
			String redirectUrl = "redirect:/list.prd?pageNumber=" + pageNumber + "&whatColumn=" + encodedWhatColumn + "&keyword="+encodedKeyword; 
			return redirectUrl;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("url���ڵ� ����");
			return "redirect:/prd";
		}
	}

}