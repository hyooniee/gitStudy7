package board.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("BoardDao")
public class BoardDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	private String namespace="board.model.Board";


	public int getArticleCount(Map<String,String> map){

		int cnt = -1;
		cnt = sqlSessionTemplate.selectOne(namespace+".getArticleCount",map);
		System.out.println("totalCount : "+cnt);
		return cnt;

	}//getArticleCount

	public List<BoardBean> getArticles(Map<String,String>map,Paging pageInfo){

		List<BoardBean> lists = new ArrayList<BoardBean>();
		System.out.println("whatColumn: "+map.get("whatColumn"));
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		System.out.println("pageInfo.offset: "+pageInfo.getOffset());
		lists = sqlSessionTemplate.selectList(namespace+".getArticles", map, rowbounds);

		System.out.println("lists.size(): "+lists.size());
		return lists;

	}//getArticles

	public int insertArticle(BoardBean board) {
		int cnt =-1;
		cnt = sqlSessionTemplate.insert(namespace+".insertArticle",board);
		return cnt;
	}

	public int deleteArticle(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".deleteArticle",num);

		return cnt;
	}

	public BoardBean detailArticle(int num) {
		BoardBean board = null;
		board = sqlSessionTemplate.selectOne(namespace+".detailArticle",num);
		return board;
	}

	public int updateArticle(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateArticle",board);

		return cnt; 

	}
	public int replyArticle(BoardBean board) { 
		int cnt=-1;

		sqlSessionTemplate.update(namespace+".replyArticle",board);
		return cnt;	 
	}

	public void updateRestep(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateRestep",board);

	}

	public void updateCount(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".updateCount",num);

	}

	public void insertReply(BoardBean board) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace+".insertReply", board);
		System.out.println("reply: "+cnt);
		
	}		


}








