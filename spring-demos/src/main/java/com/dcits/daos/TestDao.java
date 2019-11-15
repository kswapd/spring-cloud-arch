
package com.dcits.daos;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.dcits.beans.DaoDemo;

@Repository
public class TestDao extends MybatisDao {

	public int getCount(DaoDemo test) {
		return (Integer) this.getObject("Test.queryDataCount", test);
	}

	public DaoDemo findById(int id) {
		DaoDemo daoDemo = getSession().selectOne("Test.findById", id);
		return daoDemo;
	}

	public List<DaoDemo> getLimit(int num) {
		List<DaoDemo> daoDemoList = getSession().selectList("Test.getLimit", num);
		return daoDemoList;
	}
}

