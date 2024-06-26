package board.controller;

import java.io.File;
import java.io.IOException;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;


@Controller
public class BoardUpdateController {
	private final String command = "boardUpdate.bd";
	private final String getPage = "boardUpdateForm";
	private final String gotoPage = "redirect:/boardList.bd";
	private final String loginPage = "redirect:/loginForm.mb";

	@Autowired
	private BoardDao boardDao;

	@Autowired
	ServletContext servletContext;

	
	@RequestMapping(value = command, method = RequestMethod.GET)
	public String updateForm(	
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
			session.setAttribute("destination", "redirect:/boardUpdate.bd?num=" + num+"&whatColumn="+whatColumn+"&keyword="+keyword+"&pageNumber="+pageNumber);

			//model.addAttribute("whatColumn" , whatColumn);
			//model.addAttribute("keyword" , keyword);
			//model.addAttribute("pageNumber" , pageNumber);
					
			return "redirect:/loginForm.mb";	
			
		}else {
			
			BoardBean board = boardDao.detailArticle(num);

			model.addAttribute("board" , board);
			model.addAttribute("pageNumber" , pageNumber);
			return getPage;
		}
	}

	
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update( @ModelAttribute(value = "board") @Valid BoardBean board, BindingResult result,
								@RequestParam(value="whatColumn", required=true) String whatColumn,
								@RequestParam(value="keyword", required=true) String keyword,
								@RequestParam(value="pageNumber", required=true) String pageNumber) {
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		
		
		
		
		
		boardDao.updateArticle(board);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		mav.addObject("pageNumber", pageNumber);

		mav.setViewName(gotoPage);
		
		return mav;
	}
	
}
