package org.grozeille;

import junit.framework.Assert;

import org.junit.Test;

public class MyServiceTest {

	@Test
	public void test(){
		MyServiceImpl impl = new MyServiceImpl();
		impl.setDao(new MyDao() {
			
			public void save(Object o) {
				System.out.print(o.toString());
				
			}
		});
		int result = impl.plus(1, 2);
		
		Assert.assertEquals(3, result);
	}
}
