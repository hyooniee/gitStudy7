package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {

	private final String command = "/loginForm.mb";
	private final String getPage = "memberLoginForm";

	@Autowired
	MemberDao memberDao;

	//상품추가하기 버튼을 눌렀는데 로그인 정보가 없을 때 
	// productList.jsp=>추가하기=>ProductInsertController=>redirect:/loginForm.mb
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String loginForm() {
		System.out.println(this.getClass()+" GET");
		return getPage;
	}

	//member\memberLoginForm.jsp에서 로그인 클릭(id:kim,password:1234)
	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView loginForm(MemberBean member, HttpSession session,HttpServletResponse response,Model model,
			@RequestParam(value = "pageNumber", required = false ) String pageNumber) {
		
		System.out.println(this.getClass());
		System.out.println("pageNumber"+pageNumber);
		
		
		
		ModelAndView mav = new ModelAndView();

		MemberBean mb = memberDao.getMember(member.getId());  
		System.out.println("mb:" + mb);

		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(mb == null){ // 해당 아이디가 존재하지 않는다.
				out.println("<script>");
				out.println("alert('해당 아이디는 존재하지 않습니다.');");
				out.println("</script>");
				out.flush();
				//mav.setViewName(getPage);
				return new ModelAndView( getPage ) ;
				
			}else{ // 해당 아이디가 존재한다.
				if(mb.getPassword().equals(member.getPassword())) { // 비번 일치
					
					session.setAttribute("loginInfo", mb); // loginInfo:로그인한 사람의 정보
					System.out.println("비번 일치");
					System.out.println("destination:"+(String)session.getAttribute("destination"));
					//destination:redirect:/insert.prd
					//destination:redirect:/update.prd?num=34
					//destination: "redirect:/detail.prd"=>ProductDetailController=>productDeatialView.jsp(p,w,k)
					
					//mav.setViewName( (String)session.getAttribute("destination") ) ;
					model.addAttribute("pageNumber", pageNumber);
					return new ModelAndView( (String)session.getAttribute("destination") ) ;
					
				}else { // 비번 불일치
					System.out.println("비번 불일치");
					out.println("<script>");
					out.println("alert('비번 불일치입니다.');");
					out.println("</script>");
					out.flush();
					//mav.setViewName(getPage);
					return new ModelAndView( getPage ) ;
				}
			}

		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return mav;
	}
}

