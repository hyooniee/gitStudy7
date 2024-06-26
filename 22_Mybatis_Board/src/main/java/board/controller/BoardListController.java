package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {
	private final String command="/boardList.bd";
	private final String getPage="boardList";
	
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(command)
	public String list(@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			HttpServletRequest request,
			Model model			
			) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int articleCount = boardDao.getArticleCount(map);
		String url = request.getContextPath()+this.command;
		
		Paging pageInfo = new Paging(pageNumber, null, articleCount, url, whatColumn, keyword);

		List<BoardBean> boardLists = boardDao.getArticles(map, pageInfo);
		model.addAttribute("boardLists", boardLists);
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("pageInfo", pageInfo);
		
		return getPage;
	}
	


}
