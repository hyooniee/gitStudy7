package mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailViewController {

	private final String command="detailView.mall";
	private final String getPage="shopResult";
	
	
	
	
	
	@RequestMapping(command)
	public String detailView() {
		
		
		
		return getPage;
	}
	
	
	
	
	
	
}
