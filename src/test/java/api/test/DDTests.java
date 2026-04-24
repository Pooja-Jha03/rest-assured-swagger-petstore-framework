package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1, dataProvider = "allData", dataProviderClass = DataProviders.class)

    public void testPostUsers(String UserID, String UserName, String FName, String LName, String Email, String Pass, String Ph) {

        User userPayload = new User();

        userPayload.setId(Integer.parseInt(UserID));
        userPayload.setUsername(UserName);
        userPayload.setFirstname(FName);
        userPayload.setLastname(LName);
        userPayload.setEmail(Email);
        userPayload.setPassword(Pass);
        userPayload.setPhone(Ph);

        Response response = UserEndpoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);

        response.then().log().all();

    }

@Test(priority = 2,dataProvider = "usernames",dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName){

    System.out.println("Deleting user: [" + userName + "]");

    Response response = UserEndpoints.deleteUser(userName);
    response.then().log().all();

    Assert.assertEquals(response.getStatusCode(),200);
}
}


