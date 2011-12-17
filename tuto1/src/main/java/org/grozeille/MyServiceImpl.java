package org.grozeille;

import org.springframework.beans.factory.annotation.Autowired;

public class MyServiceImpl implements MyService {

	private MyDao dao;
	
	public MyDao getDao() {
		return dao;
	}

	@Autowired
	public void setDao(MyDao dao) {
		this.dao = dao;
	}

	public int plus(int a, int b) {
		dao.save(a);
		return a+b;
	}

}
