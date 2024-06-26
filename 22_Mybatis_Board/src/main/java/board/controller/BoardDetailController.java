package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;


@Controller
public class BoardDetailController {
	
	
	@Autowired
	BoardDao boardDao; 

	private final String command = "/detail.bd";
	private final String getPage = "boardDetailView";

	@RequestMapping(value = command)
	public String detailView(
			@RequestParam(value =  "num", required = true) int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam(value="whatColumn",required=false) String whatColumn,
			@RequestParam(value="keyword",required=false) String keyword,
			Model model) {

		
		boardDao.updateCount(num);
		
		
		System.out.println();   //jsp�� �Ѿ�� �Ӽ����� �ȳѰ��൵ param���� �ڵ����� �Ѿ!! model�Ӽ����� ���ʿ�x
		BoardBean board =  boardDao.detailArticle(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);

		return getPage;
	}
	
}
