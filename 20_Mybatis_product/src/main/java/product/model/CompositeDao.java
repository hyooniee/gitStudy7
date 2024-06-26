package product.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class CompositeDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//shopList.jsp에서 상세보기 클릭
	@RequestMapping(command)
	public String composite() {
		
	}
	
	
}
