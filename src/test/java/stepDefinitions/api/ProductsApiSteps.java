package stepDefinitions.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import utils.ConfigReader;

public class ProductsApiSteps {

    private ApiClient apiClient;
    @When("I send a Get method to {string}")
    public void i_send_a_get_method_to(String basePath) {
        apiClient.sendGetRequest(ConfigReader.readProperty(basePath));
    }
    @Then("I should receive a list of products with status code {string}")
    public void i_should_receive_a_list_of_products_with_status_code(String expectedCode) {
        Response response = apiClient.sendGetRequest(ConfigReader.readProperty("basePath"));

        Assertions.assertEquals(Integer.parseInt(expectedCode), response.getStatusCode());

        Assertions.assertTrue(response.getBody().asString().contains("products"));

    }
}
