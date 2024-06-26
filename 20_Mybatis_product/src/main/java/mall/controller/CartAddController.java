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
	
	
	//produrctDetailView.jsp에서 주문하기 클릭했을때 num,pageNumber,orderqty가지고 넘어옴
	@RequestMapping(command)
	public String add(ProductBean pb,  //ProductBean안에 num,orderqty가 담겨있다.
			@RequestParam(value="pageNumber",required=false) int pageNumber,
			HttpSession session //로그인
			) {
		System.out.println(this.getClass()+"POST"); //현재 클래스 이름, 방식
		System.out.println("pb.getNum():"+pb.getNum());
		System.out.println("pb.getOrderqty():"+pb.getOrderqty());
		
		System.out.println("pageNumber:"+pageNumber);
		//memberLoginController
		if(session.getAttribute("loginInfo")==null) {//세션에 로그인 설정이 안되어있으면 =>로그인안함
			session.setAttribute("destination", "redirect:/detail.prd?num="+pb.getNum()+"&pageNumber="+pageNumber);//memberLoginController 
			return  "redirect:loginForm.mb"; //memberLoginController=>memberloginForm
			//일단 리턴으로 바로 가서 loginForm으로 간다. 로그인폼에서 로그인 성공하면 "destination"으로 설정한 곳으로 가라~
			//"redirect:/detail.prd"로 설정해서 여기로 간다.  
			//리턴 위에 쓴거는 그냥 설정하기 위해 쓴거지.. 실행하는건 리턴이다.
		}else {//로그인성공
			
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");//장바구니 (세션)이름:mycart
			System.out.println("mycart"+mycart);
			
			if(mycart== null) {//장바구니가 없는 상태
				mycart = new MyCartList(); //장바구니를 만들자
			}
			
			System.out.println("mycart2"+mycart);
			mycart.addOrder(pb.getNum(), pb.getOrderqty()); //여기다가 계속 상품 넣으려고 세션설정
			session.setAttribute("mycart", mycart); //하나의 장바구니에 계속 상품추가 작업
			
			
			return gotoPage;
		}
		//주문은 로그인한사람만 넘어갈수 있다.
	}
	
}
