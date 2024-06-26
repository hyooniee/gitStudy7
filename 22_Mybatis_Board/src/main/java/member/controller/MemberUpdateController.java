package member.controller;

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

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {
	
	private final String command = "memberUpdate.mb";
	private final String getPage = "memberUpdateForm";
	private final String gotoPage = "redirect:/memberList.mb";
	
	@Autowired
	MemberDao memberDao;
	
	//GET: memberList.jsp에서 수정 버튼 클릭시 => updateForm으로 이동
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String update(@RequestParam("id") String id,
						 @RequestParam("whatColumn") String whatColumn,
						 @RequestParam("keyword") String keyword,
						 @RequestParam("pageNumber") String pageNumber,
						 Model model) {
		
		MemberBean mb = memberDao.getMember(id);
		model.addAttribute("member", mb);
		
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update( @ModelAttribute(value = "member") @Valid MemberBean mb, BindingResult result,
								@RequestParam(value="whatColumn", required=false) String whatColumn,
								@RequestParam(value="keyword", required=false) String keyword,
								@RequestParam(value="pageNumber", required=false) String pageNumber) {
	
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		memberDao.updateMember(mb);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		mav.addObject("pageNumber", pageNumber);

		mav.setViewName(gotoPage);
		
		return mav;
	}
}