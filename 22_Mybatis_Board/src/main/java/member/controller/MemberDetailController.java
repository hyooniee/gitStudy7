package member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;


@Controller
public class MemberDetailController {

	@Autowired
	MemberDao memberDao; 

	private final String command = "memberDetail.mb";
	private final String getPage = "memberDetailForm";

	@RequestMapping(value = command)
	public String detailView(
			@RequestParam(value =  "id", required = true) String id,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			Model model) {

		System.out.println(this.getClass());
		System.out.println(id);
		System.out.println(pageNumber);
		System.out.println(whatColumn);
		System.out.println(keyword);
		
		MemberBean member =  memberDao.getMember(id);
		model.addAttribute("member", member);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);

		return getPage; 
	}
}