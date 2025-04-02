package stepDefinitions.api;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import utils.ConfigReader;

public class CommonApiSteps {

    private ApiClient apiClient = Hook.apiClient;
    private Response response;

    @When("I send a Get method to {string}")
    public void i_send_a_get_method_to(String basePath) {
        apiClient.sendGetRequest(ConfigReader.readProperty(basePath));
    }

    @When("I send a Post method to {string}")
    public void i_send_a_post_method_to(String basePath) {
        response = apiClient.sendPostRequest(ConfigReader.readProperty(basePath), "{}");
    }

//    @Then("the response should have Content-Type {string}")
//    public void the_response_should_have_content_type(String expectedContentType) {
//        response = apiClient.sendGetRequest("/brandsList");
//
//        System.out.println(response.asString());
//        System.out.println(response.contentType());
//
//    }

    @Then("I should receive a response code {string}")
    public void i_should_receive_a_response_code(String expectedStatusCode) {
        int actualStatusCode = response.jsonPath().getInt("responseCode");
        Assertions.assertEquals(Integer.parseInt(expectedStatusCode), actualStatusCode,
                "Expected status code " + expectedStatusCode + " but got " + actualStatusCode);
    }

    @Then("the response body should contain {string} with message {string}")
    public void the_response_body_should_contain_with_message(String key, String expectedMessage) {
        String actualMessage = response.jsonPath().getString(key);
        Assertions.assertEquals(expectedMessage, actualMessage,
                "Expected error message '" + expectedMessage + "' but got '" + actualMessage + "'");
    }

}
