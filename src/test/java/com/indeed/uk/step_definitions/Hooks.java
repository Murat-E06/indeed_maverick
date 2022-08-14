package com.indeed.uk.step_definitions;

import com.indeed.uk.utilities.DBUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
public class Hooks {

	@Before("@db")
	public void dbHook() {
		System.out.println("creating database connection");
		DBUtils.createConnection();
	}
	
	@After("@db")
	public void afterDbHook() {
		System.out.println("closing database connection");
		DBUtils.destroy();
	}
	
}
