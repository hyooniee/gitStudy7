package order.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myOrderDao")
public class OrderDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "order.model.Order";

	public int insertData(String id) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".insertData",id);
		return cnt;
		
	}//insertData

	public int getMaxOrdersOid() {
		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace + ".getMaxOrdersOid");
		return cnt;
		
	
	}

	public List<OrderBean> getOrderById(String id) {
	
		return null;
	}
	
	
	
}