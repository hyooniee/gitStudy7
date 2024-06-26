package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;
import product.model.ProductBean;

@Controller
public class CartAddController {
	
	private final String command="add.mall";
	private final String gotoPage="redirect:/list.mall";
	
	
	//produrctDetailView.jsp���� �ֹ��ϱ� Ŭ�������� num,pageNumber,orderqty������ �Ѿ��
	@RequestMapping(command)
	public String add(ProductBean pb,  //ProductBean�ȿ� num,orderqty�� ����ִ�.
			@RequestParam(value="pageNumber",required=false) int pageNumber,
			HttpSession session //�α���
			) {
		System.out.println(this.getClass()+"POST"); //���� Ŭ���� �̸�, ���
		System.out.println("pb.getNum():"+pb.getNum());
		System.out.println("pb.getOrderqty():"+pb.getOrderqty());
		
		System.out.println("pageNumber:"+pageNumber);
		//memberLoginController
		if(session.getAttribute("loginInfo")==null) {//���ǿ� �α��� ������ �ȵǾ������� =>�α��ξ���
			session.setAttribute("destination", "redirect:/detail.prd?num="+pb.getNum()+"&pageNumber="+pageNumber);//memberLoginController 
			return  "redirect:loginForm.mb"; //memberLoginController=>memberloginForm
			//�ϴ� �������� �ٷ� ���� loginForm���� ����. �α��������� �α��� �����ϸ� "destination"���� ������ ������ ����~
			//"redirect:/detail.prd"�� �����ؼ� ����� ����.  
			//���� ���� ���Ŵ� �׳� �����ϱ� ���� ������.. �����ϴ°� �����̴�.
		}else {//�α��μ���
			
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");//��ٱ��� (����)�̸�:mycart
			System.out.println("mycart"+mycart);
			
			if(mycart== null) {//��ٱ��ϰ� ���� ����
				mycart = new MyCartList(); //��ٱ��ϸ� ������
			}
			
			System.out.println("mycart2"+mycart);
			mycart.addOrder(pb.getNum(), pb.getOrderqty()); //����ٰ� ��� ��ǰ �������� ���Ǽ���
			session.setAttribute("mycart", mycart); //�ϳ��� ��ٱ��Ͽ� ��� ��ǰ�߰� �۾�
			
			
			return gotoPage;
		}
		//�ֹ��� �α����ѻ���� �Ѿ�� �ִ�.
	}
	
}
