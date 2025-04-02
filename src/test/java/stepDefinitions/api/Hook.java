package stepDefinitions.api;

import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hook {

    public static ApiClient apiClient;

    @Before("@api")
    public void setup(){
        apiClient = new ApiClient("https://automationexercise.com/api");
    }




}
