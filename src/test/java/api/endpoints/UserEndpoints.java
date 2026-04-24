package api.endpoints;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

//UserEndpoints.java
//created for perform create, read, update and delete requests to the user api.
public class UserEndpoints {

    public static Response createUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_URL);

        return response;
    }

    public static Response readUser(String userName) {
        Response response = given()
                .pathParam("username", userName)
                .when()
                .get(Routes.get_URL);
        return response;
    }

    public static Response updateUser(String userName, User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)

                .when()
                .put(Routes.put_URL);
        return response;

    }

    public static Response deleteUser(String userName) {
        Response response = given()
                .pathParam("username", userName)

                .when()
                .delete(Routes.delete_URL);
        return response;
    }

}