package board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
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
public class BoardReplyController {
		
	private final String command="boardReply.bd";
	private final String getPage="boardReplyForm";
	private final String gotoPage="redirect:/boardList.bd";
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String reply(HttpSession session,
			@RequestParam("ref") int ref,
			@RequestParam("re_step") int re_step,
			@RequestParam("re_level") int re_level,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			Model model
			) {
		//로그인 성공하면 loginInfo 세션 설정
		System.out.println("loginInfo:" + session.getAttribute("loginInfo")); 
		if(session.getAttribute("loginInfo") == null) { // 
			session.setAttribute("destination", "redirect:/boardReply.bd?ref="+ref+"&re_step="+re_step+"&re_level="+re_level);
			model.addAttribute("pageNumber",pageNumber);
			
			return "redirect:/loginForm.mb";
		}else {
			return getPage;
		}
	}
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView replyForm(	
			@ModelAttribute("board") @Valid BoardBean board,
			BindingResult result,
			@RequestParam("ref") int ref,
			@RequestParam("re_step") int re_step,
			@RequestParam("re_level") int re_level,
			@RequestParam(value="pageNumber",required = false) String pageNumber,
			HttpServletRequest request
			) {
		
		ModelAndView mv = new ModelAndView();
		
		if(result.hasErrors()) {
			mv.setViewName(getPage);
			return mv;
		}
		
		board.setIp(request.getRemoteAddr());
		boardDao.updateRestep(board);
		
		board.setRef(ref);
		board.setRe_level(re_level+1);
		board.setRe_step(re_step+1);
		boardDao.insertReply(board);
		
		mv.setViewName(gotoPage+"?pageNumber="+pageNumber);
		return mv;

		
		
		
		
		
		
	
		
	}
}
