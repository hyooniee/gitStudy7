package orderdetail.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDetailDao")
public class OrderDetailDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "orderdetail.model.OrderDetail";

	public OrderDetailDao() {
		System.out.println("OrderDetail»ý¼ºÀÚ");
	}


	public int insertData(OrderDetailBean odb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertData",odb);
		return cnt;
		
	}//insertData
}