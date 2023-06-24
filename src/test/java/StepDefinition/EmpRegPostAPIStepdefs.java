package StepDefinition;

import Core.APICall;
import Core.FileHandleHelper;
import Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import repository.remoteRepo.requestRepo.EmployRegistrationPostRequestModel;
import repository.remoteRepo.responseRepo.EmployRegistrationPostResponseModel;

import static Core.CoreConstrainHelper.base_url;
import static Core.FilePathHelper.postApiPath;

public class EmpRegPostAPIStepdefs {
    private Gson gson = new Gson();

    private String requestModel;

    Response postAPIResponse;

    EmployRegistrationPostRequestModel employRegistrationPostRequestModel;

    String url;
    @Given("user has the api {string}")
    public void userHasTheApiPath( String Path) {
        url = base_url +Path;
    }

    @When("user hit {string} and {string}")
    public void userHitNameAndJob(String name, String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(postApiPath);
        employRegistrationPostRequestModel = new Gson().fromJson(requestBody.toJSONString(),EmployRegistrationPostRequestModel.class);
        employRegistrationPostRequestModel.setName(name);
        employRegistrationPostRequestModel.setJob(job);
        requestModel = gson.toJson(employRegistrationPostRequestModel);



        
    }

    @And("call the api with body")
    public void callTheApiWithBody() {
        postAPIResponse = APICall.postCall(HeaderFormatHelper.commonHeaders(),requestModel,url);
        System.out.println(postAPIResponse.body().asString());
    }

    @Then("it will return created date data")
    public void itWillReturnCreatedDateData() {
        EmployRegistrationPostResponseModel employRegistrationPostResponseModel = gson.fromJson(postAPIResponse.getBody().asString(), EmployRegistrationPostResponseModel.class);

        System.out.println(employRegistrationPostResponseModel.getName());
        System.out.println(employRegistrationPostResponseModel.getJob());
    }
}
