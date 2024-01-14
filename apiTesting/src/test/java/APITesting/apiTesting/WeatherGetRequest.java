package APITesting.apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class WeatherGetRequest {

	@Test
	public void Test_01() {
		Response resp = when().
						get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=9a9ab63655776d573d75842bd9b39d00");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}
	
	@Test
	public void Test_02() {
		Response resp = when().
						get("https://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=9a9ab63655776d573d75842bd9b39d01");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 401);
	}
}
