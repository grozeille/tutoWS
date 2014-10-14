package org.grozeille;

import com.wordnik.swagger.annotations.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@WebService
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Path("/myservice")
@Api(value = "/myservice", description = "Calculator")
public interface MyService {
	
	@WebMethod
	@GET
	@Path("/plus")
    @ApiOperation(value = "Addition", notes = "More notes about this method", response = Result.class)
	public Result plus(
			@QueryParam("a")
			@WebParam(name ="a")
            @ApiParam(value = "first value", required = true)
			int a, 
			@QueryParam("b")
			@WebParam(name ="b")
            @ApiParam(value = "second value", required = true)
			int b);
}
