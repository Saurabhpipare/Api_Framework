package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

 

public class User_Test {
   
   public static String username="rohit";
   User PayLoad=new User();
  public static Response response;	
   
	@BeforeClass
	public void SetUpData() {
	PayLoad.setId(0);
	PayLoad.setUsername(username);
	PayLoad.setFirstName("mango");
	PayLoad.setLastName("roy");
	PayLoad.setEmail("rohitroy123@gmai.com");
	PayLoad.setPassword("roru@123");
	PayLoad.setPhone("1234567890");
	PayLoad.setUserStatus(0);
	}
	
	@Test(priority=1)
	public void TestUser() {
    response=UserEndPoints.Create_User(PayLoad);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=2)
	public void Message() {
	Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	@Test(priority=3)
	public void get_users() {
	Response response2=UserEndPoints.Get_User(username);
	response2.then().log().all();
	Assert.assertEquals(PayLoad.getUsername(),"rohit");
	Assert.assertEquals(PayLoad.getEmail(),"rohitroy123@gmai.com");
	}
	
	@Test(priority=4)
	public void Update() {
	PayLoad.setFirstName("hdgrtrb");
	PayLoad.setLastName("fhfgrtry");
	PayLoad.setEmail("hfryty123@gmai.com");	
	
	Response response3=UserEndPoints.Update_User(username, PayLoad);
	response3.then().log().all();
	String mail=PayLoad.getEmail();
	System.out.println(mail);
	}
}
