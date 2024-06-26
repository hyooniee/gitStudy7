package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;

@Controller
public class OrderMallController {
	private final String command="order.mall";
	private final String getPage="shopList";
	private final String gotoPage="redirect:loginForm.mb";

	
	//main.jsp���� �ֹ������� Ȯ�������� order.mall��û
	@RequestMapping(command)
	public String order(HttpSession session,Model model) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		
		
		
		if(session.getAttribute("loginInfo")==null) {
			session.setAttribute("destination", "redirect:/order.mall");
			return gotoPage;
		}else {
			
			List<OrderBean> orderLists = OrderDao.getOrderById(mb.getId());
			
			
			for(OrderBean ob : orderLists) {
				
			}
			
			model.addAttribute("orderLists",orderLists);
			
			return getPage;
		}
		
		
	}
	
	
	
}



