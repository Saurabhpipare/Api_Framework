package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response Create_User(User PayLoad) {
	
     Response response=given()	
	.header("accept","application/json")
	.header("Content-Type","application/json")
	.body(PayLoad)
	
	.when()
	.post(Routes.Post_Url);
	
	return response;
	}
	
	
	public static Response Get_User(String UserName) {
		
	Response response=given()	
	.header("accept","application/json")
	.pathParam("username",UserName)
	
	.when()
	.get(Routes.Get_Url);
	
	return response;
	}
	
	
	public static Response Update_User(String UserName,User PayLoad) {
		
	Response response=given()	
	.header("accept","application/json")
	.header("Content-Type","application/json")
	.pathParam("username",UserName)
	.body(PayLoad)
		
	.when()
	.put(Routes.Update_Url);
		
		return response;
		}
	
	public static Response Delete_User(String UserName) {
	
	 Response response=given()
	.header("accept","application/json")
	.pathParam("username",UserName)
	
	.when()
	.delete(Routes.Delete_Url);
	
	return response;
	}
}
