package product.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CompositeDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//shopList.jsp���� �󼼺��� Ŭ��
	@RequestMapping(command)
	public String composite() {
		
	}
	
	
}
