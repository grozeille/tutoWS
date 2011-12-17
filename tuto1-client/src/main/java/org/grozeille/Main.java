package org.grozeille;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyServiceImplService service = new MyServiceImplService();
		MyService servicePort = service.getMyServiceImplPort();
		int result = servicePort.plus(1, 2);
		
		System.out.println(result);
	}

}
