package org.grozeille;

public class MyDaoImpl implements MyDao {

	public void save(Object o) {
		System.out.println(o.toString());
	}
}
