package com.peleodiase.bbc;
 
import java.util.List;
 
import com.peleodiase.bbc.model.Program;
import junit.framework.TestCase;

public class ProgramServiceTest extends TestCase {

	public void test_type() throws Exception {
		assertNotNull(ProgramService.class);
	}

	public void test_instantiation() throws Exception {
		ProgramService target = new ProgramService();
		assertNotNull(target);
	}

	public void test_listPrograms_A$() throws Exception {
		ProgramService target = new ProgramService();
		List<Program> actual = target.listPrograms();
		assertNotNull(actual);
	}

}
