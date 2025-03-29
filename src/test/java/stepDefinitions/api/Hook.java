package stepDefinitions.api;

import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hook {

    private ApiClient apiClient;

    @Before("@api")
    public void setup(){
        apiClient = new ApiClient(ConfigReader.readProperty("baseUrl"));
    }




}
