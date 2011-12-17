package org.grozeille;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@WebService
@Path("/v1")
@Produces({ "text/xml", "text/plain" })
public interface MyService {
	
	@WebMethod
	@GET
	@Path("/test")
	int plus(@WebParam(name ="a") int a, @WebParam(name ="b")int b);
}
