package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;

    User userPayload;

    public Logger logger; //for logs

    @BeforeTest
    public void setup(){
faker = new Faker();
userPayload = new User();

userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstname(faker.name().firstName());
        userPayload.setLastname(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //logs
logger= LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)

    public void testPostUser(){
logger.info("*********Creating user ******");
       Response response = UserEndpoints.createUser(userPayload);

       response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*********User is created******");

    }

    @Test(priority = 2)

    public void testGetUserByName(){

        logger.info("*********Reading user info******");

        Response response = UserEndpoints.readUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(response.getContentType(),"application/json");

        logger.info("*********User info is displayed******");


    }

    @Test(priority = 3)

    public void testUpdateUserByName(){

        logger.info("*********Updating user ******");

        //update data using payload

        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());


        Response response = UserEndpoints.updateUser(this.userPayload.getUsername(),userPayload);

            response.then().log().all();

          Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*********User is updated******");


        //CHECKING DATA AFTER UPDATE
        Response responseAfterUpdate = UserEndpoints.readUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().all();

        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
    }

    @Test(priority = 4)

    public void testDeleteUSerByName(){

        logger.info("*********Deleting user ******");

        Response response =  UserEndpoints.deleteUser(this.userPayload.getUsername());

        Assert.assertEquals(response.getStatusCode(),200);

        logger.info("*********User deleted******");

    }

}
