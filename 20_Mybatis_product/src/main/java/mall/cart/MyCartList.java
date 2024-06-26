package mall.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCartList { //��ٱ���

	private Map<Integer, Integer> orderlists = null; //��� ��ǰ(key), �ֹ����� �(value)
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum,int oqty) {
		//���� �ֹ��� ��ǰ(7,2)
		if(!orderlists.containsKey(pnum)) {//��ٱ��Ͽ� ���� ��ǰ�� ������
			
			orderlists.put(pnum, oqty); //3����ǰ,2�� / 7����ǰ,1�� /5����ǰ,4��  =>7�� ��ǰ,3��
		}else {//������
			int qty = orderlists.get(pnum);
			orderlists.put(pnum, oqty+qty);
			
		}
		
		
		
		Set<Integer> key_set = orderlists.keySet();
		System.out.println("key_set:"+key_set); //��ǰ��ȣ�� ������(3,7,5)
		
		for(int key:key_set) {
			System.out.println(key+","+orderlists.get(key));
		}
		
		
		
	}

	public Map<Integer, Integer> getAllOrderLists() {
		
		
		
		return orderlists;
	}
	
}
//ó���� 7����ǰ 1�� ��ٱ��Ͽ� �ְ�, �ι�°�� 7����ǰ ��ٱ��Ͽ� 2�� �� ��� 7�� ��ǰ �� 3���� �����ϰ� ������
//key�� �̹� ������ key�� value�� ���ο� value������ ����Ⱑ �ż� 7����ǰ 2���� �ȴ�.