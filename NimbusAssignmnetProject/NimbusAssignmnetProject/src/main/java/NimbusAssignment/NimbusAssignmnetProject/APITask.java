package NimbusAssignment.NimbusAssignmnetProject;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class APITask {
	
	@Test
	public  void GetAPITest() {
		
		//String body = String.format("UserID=%s&Password=%s&Username=%s", 40810, "@Manish", "Manish@Time2Work.com");
		
		 RestAssured.baseURI ="http://autotest.time2work.com";
		
		/*
		 * String res= given().log().all().header("Content-Type","application/x-www-form-urlencoded"
		 * ).header("Accept","application/json")
		 * .header("Accept-Encoding","gzip").header("Host","autotest.time2work.com").
		 * header("Connection","Keep-Alive") .body(body)
		 * .when().post("/restapi/Authenticate")
		 * .then().log().all().extract().response().asString();
		 */
		
		
		String res1= given().contentType("application/x-www-form-urlencoded;charset=utf-8")
				.header("Accept-Encoding","gzip").header("Host","autotest.time2work.com").header("Connection","Keep-Alive").
				formParam("UserID", 40810).formParam("Password", "@Manish").formParam("Username", "Manish@Time2Work.com")
				.when().accept("application/json").post("/restapi/Authenticate")
				.then().log().all().extract().response().asString();
		
		
		JsonPath json= new JsonPath(res1);
		
		String auth =json.getString("AuthenticationToken");
		System.out.println(auth);
		
		String res2= given().contentType("application/json;charset=utf-8")
				.header("Accept-Encoding","gzip").header("Host","autotest.time2work.com").header("UserID",40810).header("AuthenticationToken", auth)
				.when().accept("application/json").get("/restapi/Report?report=UserReportModel&activeOnly=False&rosterableOnly=False&__ReportFunction=GetStaffList")
				.then().log().all().extract().response().asString();
		
        JsonPath json1= new JsonPath(res2);
		
		String forename =json1.get("Items[0].Value[0].Forename");
		System.out.println(forename);
		
		Assert.assertEquals("Manish", forename);
		
		
	}
	
	

}
