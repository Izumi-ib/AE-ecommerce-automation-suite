package stepDefinitions.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utils.ConfigReader;

import java.util.Map;

public class ProductsApiSteps {

    private ApiClient apiClient = Hook.apiClient;
    private Response response;


    @Then("I should receive a list of products with status code {string}")
    public void i_should_receive_a_list_of_products_with_status_code(String expectedCode) {
        response = apiClient.sendGetRequest("productsList");

        Assertions.assertEquals(Integer.parseInt(expectedCode), response.getStatusCode());

        Assertions.assertTrue(response.getBody().asString().contains("products"));
    }





}
