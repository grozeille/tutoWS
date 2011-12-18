package org.grozeille;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@WebService
@Path("/myservice")
@Produces("application/json")
//@Produces({ "text/xml" })
//@Produces({ "text/plain" })
public interface MyService {
	
	@WebMethod
	@GET
	@Path("/plus")
//	@Produces("application/json")
	Result plus(
			@QueryParam("a")
			@WebParam(name ="a") 
			int a, 
			@QueryParam("b")
			@WebParam(name ="b")
			int b);
}
