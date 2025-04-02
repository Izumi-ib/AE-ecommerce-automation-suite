package stepDefinitions.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;

public class ApiClient {

    private String baseUri;

    public ApiClient(String baseUri){
        if (baseUri == null || baseUri.isEmpty()) {
            throw new IllegalArgumentException("baseURI cannot be null or empty");
        }
        this.baseUri = baseUri;
    }

    public Response sendGetRequest(String endpoint) {
        return RestAssured.given()
                .baseUri(baseUri)
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .statusCode(200)
                .extract().response();
    }

    public Response sendPostRequest(String endpoint, String body) {
        return RestAssured.given()
                .baseUri(baseUri)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .statusCode(200)
                .extract().response();
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
