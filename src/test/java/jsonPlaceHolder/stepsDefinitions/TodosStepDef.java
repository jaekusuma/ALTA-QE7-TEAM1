package jsonPlaceHolder.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import jsonPlaceHolder.jsonPlaceHolderAPI;
import jsonPlaceHolder.response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class TodosStepDef {
    @Steps
    jsonPlaceHolderAPI gotodos;

    //Scenario Get todos 1
    @Given("Get todos with valid parameter {int}")
    public void getTodosWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("Send Get todos request")
    public void sendGetTodosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.TODOS_SINGLE);
    }

//    @Then("Status Code Should be {int} OK")
//    public void statusCodeShouldBeOK(int OK) {
//        SerenityRest.then().statusCode(OK);
//    }

    @And("Response Body contain by postId {int}")
    public void responseBodyContainByPostId(int id) {
        SerenityRest.then()
                .body(response.USERID, equalTo(id));
    }

    //Scenario Get Todos 2
    @Given("Get todos with invalid parameter {int}")
    public void getTodosWithInvalidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Then("Status Code Should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    //
//    Scenario Get Todos 3
    @Given("get list todos without parameter {int}")
    public void getListTodosWithoutParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("send Get Resource todos request")
    public void sendGetTodosRequestinvalid()
        {
            SerenityRest.when().get(jsonPlaceHolderAPI.TODOS_PER_USER_ID);
        }
    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response Body contain by userId {int}")
    public void responseBodyContainByUserIdId(int id) {
        SerenityRest.then()
                .body("id[0]", equalTo(id));
    }

    // Post Todos 1

    @Given("Post todos with valid parameter")
    public void postTodosWithValidParameter() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "postTodosCreateNewUserWithEmailPassword.json");
        gotodos.postTodosValidEmailPassword(json);
    }
    @When("Send Post todos request")
    public void sendPostTodosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.TODOS_LIST);
    }
    @Then("Status Code Should be {int} Create")
    public void statusCodeShouldBeCreate(int Create) {
        SerenityRest.then().statusCode(Create);
    }


    // Post Todos 2
    @Given("Set Post todos without email")
    public void postTodosWithoutEmail() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/postTodosWithoutEmail.json");
        gotodos.postTodosWithoutEmail(json);
    }


    @Given("Post todos without password")
    public void postTodosWithoutPassword() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "/postTodosWithoutPassword.json");
        gotodos.postTodosValidEmailPassword(json);
    }

    @And("Validate todos json schema")
    public void validatetodosJsonSchema() {
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA+"todosJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
//Put Todos
    @Given("Set PUT todos with valid parameter {int}")
    public void setPUTTodosWithValidParameter(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("Send PUT todos request")
    public void sendPUTTodosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.TODOS_SINGLE);
    }

//  DELETE todos

    @Given("Set Delete with valid parameter {int}")
    public void setDeleteWithValidParameterId(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @When("Send Delete todos Request")
    public void sendDeleteTodosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.TODOS_SINGLE);
    }


}
