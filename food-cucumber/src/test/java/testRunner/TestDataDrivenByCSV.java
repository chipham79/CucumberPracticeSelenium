package testRunner;

import java.util.List;
import utils.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class TestDataDrivenByCSV 
{
	public static final String  pathCSVFile = "../food-cucumber/datas/usertest.csv"; 
	String firstname, lastname, email, password;
	
	//Constructor that passed params to the method 
	public TestDataDrivenByCSV(String firstname, String lastname, String email, String password)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
	
	// This annotated method is designed to pass parameters into the class via constructors
	@Parameters
	public static List<String[]> getData()
	{
		return CSV.get(pathCSVFile);
	}
	
	@Test
	public void test() {
		System.out.println(String.format("New Record: %s %s %s %s ", firstname, lastname, email, password ));
	}
}
