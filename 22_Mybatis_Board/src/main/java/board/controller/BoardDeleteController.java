package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {
	private final String command = "boardDelete.bd";
	private final String getPage = "boardDeleteForm";
	private final String gotoPage = "redirect:/boardList.bd";
	private final String loginPage = "redirect:/loginForm.mb";
	
	@Autowired
	BoardDao boardDao;

	@Autowired
	ServletContext servletContext;
	
	
	
	
	
	
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String delete(	
			@RequestParam(value="num", required = true) int num,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			HttpSession session,Model model) {

		System.out.println(this.getClass()+" GET");
		System.out.println(num);
		System.out.println(pageNumber);
		System.out.println(whatColumn);
		System.out.println(keyword);
		ModelAndView mav = new ModelAndView();
	

		if(session.getAttribute("loginInfo") == null) {
			session.setAttribute("destination", "redirect:/boardDelete.bd?num=" + num);

			model.addAttribute("whatColumn" , whatColumn);
			model.addAttribute("keyword" , keyword);
			model.addAttribute("pageNumber" , pageNumber);
					
			return "redirect:/loginForm.mb";	
			
		}else {
			
			BoardBean board = boardDao.detailArticle(num);

			model.addAttribute("board" , board);
			return getPage;
			
		
		}

	}
		@RequestMapping(value = command, method = RequestMethod.POST)
		public ModelAndView deleteform( @RequestParam(value="num", required = true) int num,
									@RequestParam(value="whatColumn", required=false) String whatColumn,
									@RequestParam(value="keyword", required=false) String keyword,
									@RequestParam(value="pageNumber", required=false) String pageNumber) {
		
			
			ModelAndView mav = new ModelAndView();
			boardDao.deleteArticle(num);
		
			mav.setViewName(gotoPage);
			
			return mav;
		}
		
		
		
		
		
		
	
}
	
	
	

	
	
	
	
		
		
