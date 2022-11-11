package jsonPlaceHolder.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import jsonPlaceHolder.jsonPlaceHolderAPI;
import jsonPlaceHolder.response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UsersStepDef {
    @Steps
    jsonPlaceHolderAPI goUsers;
    @Given("Get Users with valid parameter {int}")
    public void getUsersWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("Send Get Users request")
    public void sendGetUsersRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.USERS_SINGLE);
    }

    @And("Response Body contain by Id {int}")
    public void responseBodyContainByIdId(int id) {
        SerenityRest.then()
                .body(response.ID, equalTo(id));
    }
    @And("Validate Users json schema")
    public void validateUsersJsonSchema() {
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA+"usersJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get Users with invalid parameter {int}")
    public void getUsersWithInvalidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Given("get list Users without parameter {int}")
    public void getListUsersWithoutParameterId(int id) {
        SerenityRest.given().pathParam("id", id);

    }

    @When("send Get Resource Users request")
    public void sendGetResourceUsersRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.USERS_PER_USER_ID);
    }
//Post Users
    @Given("Post Users with valid body")
    public void postUsersWithValidBody() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/postTodosWithoutEmail.json");
        goUsers.postTodosValidBody(json);
    }
    @When("Send Post Users request")
    public void sendPostUsersRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.USERS_LIST);
    }


    @Given("Set Post Users without body")
    public void setPostUsersWithoutBody() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/PostUsersWithoutBody.json");
        goUsers.postTodosValidBody(json);
    }
//Put Users

    @Given("Set PUT Users with valid parameter")
    public void setPUTUsersWithValidParameterId() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/PostUsersWithoutBody.json");
        goUsers.postTodosValidBody(json);
    }
    @When("Send PUT Users request")
    public void sendPUTUsersRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.USERS_LIST);

    }

    @Given("PUT Users with valid parameter {int}")
    public void putUsersWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/PostUsersWithBody.json");
        goUsers.postTodosValidBody(json);
    }
//Delete Users
    @Given("Set Delete Users with valid parameter {int}")
    public void setDeleteUsersWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("Send Delete Users Request")
    public void sendDeleteUsersRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.USERS_SINGLE);
    }


}
