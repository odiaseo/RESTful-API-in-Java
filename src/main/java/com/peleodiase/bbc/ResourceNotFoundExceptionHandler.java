package com.peleodiase.bbc;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider; 

@Provider
public class ResourceNotFoundExceptionHandler implements
		ExceptionMapper<ResourceNotFoundException> {

	public Response toResponse(ResourceNotFoundException ex) {
		String msg = ex.getMessage();
		StringBuilder response = new StringBuilder("<response>");
		response.append("<status>failed</status>");
		response.append("<message>" + msg + "</message>");
		response.append("</response>");

		return Response.serverError().entity(response.toString()).build();
	}

}