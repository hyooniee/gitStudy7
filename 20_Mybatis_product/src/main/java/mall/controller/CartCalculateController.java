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
	
	//mallList.jsp(��ٱ��� ��Ϻ���)���� �����ϱ� Ŭ��
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		//MyCartList cartlist = new MyCartList();//��ǰ�� ���� ���ο� ��ٱ��ϸ� ����.
		//cartlist.getAllOrderLists();
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");//CartAddController���� ���Ǽ�����
		Map<Integer,Integer> orderLists = mycart.getAllOrderLists();
		System.out.println("�ֹ�����:"+orderLists.size());
	
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
		
		//ȸ�� ����Ʈ ���� �߰�
		memberDao.updateMpoint(mb.getId(),100);
		session.removeAttribute("mycart");//�����ϰ� ���� ��ٱ��ϴ� �������� ��! 
		//���� ������ ��ٱ��ϴ� �����!
		return gotoPage;
	}
}	
	

