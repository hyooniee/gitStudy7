package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {
	private final String command="boardInsert.bd";
	private final String getPage="boardWriteForm";
	private final String gotoPage="redirect:/boardList.bd";
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String insert(HttpSession session) {
		//로그인 성공하면 loginInfo 세션 설정
		System.out.println("loginInfo:" + session.getAttribute("loginInfo")); 
		if(session.getAttribute("loginInfo") == null) { // 
			session.setAttribute("destination", "redirect:/boardInsert.bd");
			return "redirect:/loginForm.mb";
		}else {
			return getPage;
		}
	}
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView insertForm(@ModelAttribute("board") @Valid BoardBean board,BindingResult result,
			HttpServletRequest request
			) {
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName(getPage);
			return mv;
		}
		int cnt=-1;
		
		board.setIp(request.getRemoteAddr());
		cnt= boardDao.insertArticle(board);
		
		if(cnt!=-1) {
			mv.setViewName(gotoPage);
		}else {
			mv.setViewName(getPage);
		}
		return mv;
		
	}
}
