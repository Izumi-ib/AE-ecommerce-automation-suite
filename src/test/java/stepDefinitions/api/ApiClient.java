package stepDefinitions.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ConfigReader;

public class ApiClient {

    public ApiClient(String baseUrl){
        RestAssured.baseURI = baseUrl;
    }

    public Response sendGetRequest(String endpoint) {
        return RestAssured.given()
                .when()
                .get(endpoint);
    }

    public Response sendPostRequest(String endpoint, String body) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    public Response sendPutRequest(String endpoint, String body) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    public Response sendDeleteRequest(String endpoint) {
        return RestAssured.given()
                .when()
                .delete(endpoint);
    }

}
