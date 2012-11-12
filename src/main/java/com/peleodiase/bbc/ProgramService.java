package com.peleodiase.bbc;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.peleodiase.bbc.model.Program;

/**
 * Program Service Class
 * 
 * @author Pele Odiase
 * 
 */
@Path("/programservice")
public class ProgramService {

	private static Map<String, Program> programs = new HashMap<String, Program>();

	// List of programs - ideally should be retrieved from the database

	static {
		Program questionTime = new Program();
		questionTime.setId("1");
		questionTime.setTitle("Question time");
		questionTime.setDescription("BBC question time by John Dimbleby");
		questionTime.setCategory("Politics");
		questionTime.setIsAvailable(true);
		getPrograms().put(questionTime.getId(), questionTime);

		Program matchOfTheDay = new Program();
		matchOfTheDay.setId("2");
		matchOfTheDay.setCategory("Sports");
		matchOfTheDay.setTitle("Match of the Day");
		matchOfTheDay
				.setDescription("Premier league sport highlights with Gary Lineker");
		matchOfTheDay.setIsAvailable(false);
		getPrograms().put(matchOfTheDay.getId(), matchOfTheDay);

		
		Program prog = new Program();
		prog.setId("12");
		prog.setCategory("Entertainment");
		prog.setTitle("The Apprentice");
		prog.setDescription("Series in which candidates compete to go into business with multi-millionaire tycoon Lord Sugar");
		prog.setIsAvailable(true);
		getPrograms().put(prog.getId(), prog);
		
	}

	/**
	 * List all programs
	 * 
	 * @return
	 */
	@GET
	@Path("/programs")
	@Produces(MediaType.APPLICATION_XML)
	public List<Program> listPrograms() {
		return new ArrayList<Program>(getPrograms().values());
	}

	/**
	 * Finds and returns a program by ID
	 * 
	 * @param programId
	 * @return
	 */
	@GET
	@Path("/programs/{programId : [0-9]+}")
	@Produces(MediaType.APPLICATION_XML)
	public Program getProgram(@PathParam("programId") String programId) {
		if (getPrograms().containsKey(programId)) {
			return getPrograms().get(programId);
		} else {
			throw new ResourceNotFoundException("No program found with Id :["
					+ programId + "]");
		}
	}

	/**
	 * Deletes an existing program
	 * 
	 * @param programId
	 * @return
	 */
	@DELETE
	@Path("/delete/{programId : [0-9]+}")
	@Produces(MediaType.APPLICATION_XML)
	public Response deleteProgram(@PathParam("programId") String programId) {
		if (getPrograms().containsKey(programId)) {
			getPrograms().remove(programId);
			String msg = "<pass>Program id " + programId
					+ " deleted successfully</pass>";
			Response response = Response.status(200)
					.type(MediaType.APPLICATION_XML).entity(msg).build();
			return response;
		} else {
			throw new ResourceNotFoundException("No program found with Id :["
					+ programId + "]");
		}
	}

	/**
	 * Adds a new program
	 * 
	 * @param programData
	 * @return
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_XML)
	public Response createProgram(Program program) {
		getPrograms().put(program.getId(), program);

		System.out.println("Created program " + program.getId());
		return Response.created(URI.create("/programs/" + program.getId()))
				.build();
	}

	/**
	 * Updates an existing program by ID. Program with the same id would be
	 * overwritten
	 * 
	 * @param programId
	 * @param programData
	 * @return
	 */
	@PUT
	@Path("/update/{programId : [0-9]+ }")
	@Produces(MediaType.APPLICATION_XML)
	public Response updateProgram(@PathParam("programId") String programId,
			Program programData) {

		if (getPrograms().containsKey(programId)) {
			getPrograms().put(programId, programData);
			String result = "<pass>Program " + programData.getId()
					+ " updated successfully</pass>";
			Response response = Response.status(200)
					.type(MediaType.APPLICATION_XML).entity(result).build();
			return response;
		} else {
			throw new ResourceNotFoundException("No program found with Id :["
					+ programId + "]");
		}

	}

	/**
	 * Returns a list of programs by availability status
	 * 
	 * @param status
	 * @return
	 */
	@GET
	@Path("/available/{status}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Program> programAvailability(@PathParam("status") String status) {
		Map<String, Program> resultSet = new HashMap<String, Program>();
		for (Entry<String, Program> entry : getPrograms().entrySet()) {
			if (entry.getValue().getIsAvailable() == Boolean.valueOf(status)) {
				resultSet.put(entry.getKey(), entry.getValue());
			}
		}

		return new ArrayList<Program>(resultSet.values());
	}

	/**
	 * Retrieves a list of programs by category
	 * 
	 * @param category
	 * @return
	 */
	@GET
	@Path("/category/{category}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Program> getProgramsByCategory(
			@PathParam("category") String category) {
		Map<String, Program> resultSet = new HashMap<String, Program>();

		for (Entry<String, Program> entry : getPrograms().entrySet()) {
			if (entry.getValue().getCategory().toLowerCase()
					.equals(category.toLowerCase())) {
				resultSet.put(entry.getKey(), entry.getValue());
			}
		}

		return new ArrayList<Program>(resultSet.values());
	}

	public static Map<String, Program> getPrograms() {
		return programs;
	}

	public static void setPrograms(Map<String, Program> programs) {
		ProgramService.programs = programs;
	}

}
