package dcits.daos;

/**
 * Created by kongxiangwen on 11/20/18 w:47.
 */

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

public class MybatisDao{

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	public MybatisDao() {
	}

	public SqlSessionTemplate getSession()
	{
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public void delete(String statementId, Object deleteObject) {
		try {
			this.sqlSessionTemplate.delete(statementId, deleteObject);
		} catch (Exception e) {
		}
	}

	public void insert(String statementId, Object insertObject) {
		try {
			this.sqlSessionTemplate.insert(statementId, insertObject);
		} catch (Exception e) {
		}
	}


	public void update(String statementId, Object updateObject) {
		try {
			this.sqlSessionTemplate.update(statementId, updateObject);
		} catch (Exception e) {
		}
	}


	public Object getObject(String statementId, Object selectParamObject) {
		return this.sqlSessionTemplate
				.selectOne(statementId, selectParamObject);
	}

	@SuppressWarnings("all")
	public List queryList(String statementId, Object queryParamObject) {
		return this.sqlSessionTemplate
				.selectList(statementId, queryParamObject);
	}
	@SuppressWarnings("all")
	public List queryList(String statementId, Object queryParamObject,
						  int pageNo, int pageSize) {
		RowBounds objRowBounds;
		int iOffset = (pageNo - 1) * pageSize;
		objRowBounds = new RowBounds(iOffset, pageSize);
		return this.sqlSessionTemplate.selectList(statementId,
				queryParamObject, objRowBounds);
	}
}

