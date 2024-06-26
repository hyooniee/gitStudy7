package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderBean;
import order.model.OrderDao;
import orderdetail.model.OrderDetailBean;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {
	
	private final String command="calculate.mall";
	private final String gotoPage="redirect:/list.prd";
	
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	//mallList.jsp(장바구니 목록보기)에서 결제하기 클릭
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		//MyCartList cartlist = new MyCartList();//상품이 없는 새로운 장바구니를 만듦.
		//cartlist.getAllOrderLists();
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");//CartAddController에서 세션설정함
		Map<Integer,Integer> orderLists = mycart.getAllOrderLists();
		System.out.println("주문정보:"+orderLists.size());
	
		Set<Integer> keyset =  orderLists.keySet();
		System.out.println("keyset:" + keyset);
		
		
		orderDao.insertData(mb.getId());
		int maxoid = orderDao.getMaxOrdersOid();
		for(int pnum:keyset) {
		      
		 int qty = orderLists.get(pnum);
		 productDao.updateStock(pnum,qty);
		        
		 OrderDetailBean odb = new OrderDetailBean();
		 odb.setOid(maxoid);
		 odb.setPnum(pnum);
		 odb.setQty(qty);
		        
		 orderDetailDao.insertData(odb);       
		       
		
		
		}
		
		//회원 포인트 점수 추가
		memberDao.updateMpoint(mb.getId(),100);
		session.removeAttribute("mycart");//결제하고 나서 장바구니는 없어져도 됨! 
		//결제 했으면 장바구니는 비우자!
		return gotoPage;
	}
}	
	

