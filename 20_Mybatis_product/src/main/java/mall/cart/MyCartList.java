package mall.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCartList { //장바구니

	private Map<Integer, Integer> orderlists = null; //몇번 상품(key), 주문수량 몇개(value)
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum,int oqty) {
		//지금 주문한 상품(7,2)
		if(!orderlists.containsKey(pnum)) {//장바구니에 동일 상품이 없으면
			
			orderlists.put(pnum, oqty); //3번상품,2개 / 7번상품,1개 /5번상품,4개  =>7번 상품,3개
		}else {//있으면
			int qty = orderlists.get(pnum);
			orderlists.put(pnum, oqty+qty);
			
		}
		
		
		
		Set<Integer> key_set = orderlists.keySet();
		System.out.println("key_set:"+key_set); //상품번호만 가져옴(3,7,5)
		
		for(int key:key_set) {
			System.out.println(key+","+orderlists.get(key));
		}
		
		
		
	}

	public Map<Integer, Integer> getAllOrderLists() {
		
		
		
		return orderlists;
	}
	
}
//처음에 7번상품 1개 장바구니에 넣고, 두번째에 7번상품 장바구니에 2개 더 담아 7번 상품 총 3개를 구입하고 싶은데
//key가 이미 있으면 key의 value에 새로운 value값으로 덮어쓰기가 돼서 7번상품 2개가 된다.