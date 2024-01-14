package APITesting.apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class ParametersRestAssured {

	//@Test
	public void Test_01() {
		Response resp = given().
				param("q", "Delhi").
				param("appid","9a9ab63655776d573d75842bd9b39d00").
				when().get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
		if(resp.getStatusCode()==200) {
			System.out.println("API is running");
		}
		else
		{
			System.out.println("API is not running");
		}
	}
	
	//@Test
	public void Test_02() {
		given().
		param("q", "Delhi").
		param("appid","9a9ab63655776d573d75842bd9b39d00").
		when().
		get("https://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);
	}
	
	//@Test
	public void Test_03() {
		Response resp = given().
				param("q", "Delhi").
				param("appid","9a9ab63655776d573d75842bd9b39d00").
				when().get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.asPrettyString());
	}
	
	@Test
	public void Test_04() {
		Response resp = given().
				param("zip", "208001,in").
				param("appid","9a9ab63655776d573d75842bd9b39d00").
				when().get("https://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.getStatusCode());
	}
}
