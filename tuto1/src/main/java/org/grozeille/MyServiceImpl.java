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

	public Result plus(int a, int b) {
		Result result = new Result();
		result.setValue(a+b);
		result.setMessage(a+"+"+b);
		return result;
	}

}
