package jsonPlaceHolder.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import jsonPlaceHolder.jsonPlaceHolderAPI;
import jsonPlaceHolder.response;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class photosStepDef {
    //Scenario 1
    @Given("get photos without parameter")
    public void getPhotosWithoutParameter() {
        SerenityRest.given().get(jsonPlaceHolderAPI.PHOTOS_LIST);
    }

    @When("Send Get photos request")
    public void sendGetPhotosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.PHOTOS_LIST);
    }

    @Then("Status Code Should be {int} OK")
    public void statusCodeShouldBeOK(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @And("Response body should return body albumId {int}")
    public void responseBodyShouldReturnBodyAlbumId(int arg0) {
        SerenityRest.then().body("albumId[0]", equalTo(arg0));
    }

    @And("Validate get list photos json schema")
    public void validateGetListPhotosJsonSchema() {
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA + "getPhotosListSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }


    //Scenario 2
    @Given("get photos resource with parameter {int}")
    public void getPhotosResourceWithParameter(int arg0) {
        SerenityRest.given().pathParam("id", arg0);
    }

    @When("Send Get photos resource request")
    public void sendGetPhotosResourceRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.PHOTOS_PER_USER_ID);
    }

    @And("Response body should contain albumId {int}")
    public void responseBodyShouldContainAlbumId(int arg0) {
        SerenityRest.then().body("albumId[0]", equalTo(arg0));
    }

    @And("Validate get photos resource json schema")
    public void validateGetPhotosResourceJsonSchema() {
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA + "getPhotosResourceSchema.json");
    }

    //Scenario 3
    @Given("Get photos with valid parameter {int}")
    public void getPhotosWithValidParameterId(int arg0) {
        SerenityRest.given().pathParam("id", arg0);
    }

    @When("Send Get single photos request")
    public void sendGetSinglePhotosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.PHOTOS_SINGLE);
    }

    @And("Response Body contain by {int}")
    public void responseBodyContainById(int arg0) {
        SerenityRest.then().body(response.ID, equalTo(arg0));
    }

    @And("Validate get single photos json schema")
    public void validateGetSinglePhotosJsonSchema() {
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA + "getPhotosSingleSchema.json");
    }

    //Scenario 4
    @Given("Get photos with invalid parameter {int}")
    public void getPhotosWithInvalidParameter(int arg0) {
        SerenityRest.given().pathParam("id", arg0);
    }

    @And("Response Body contain by id {int}")
    public void responseBodyById(int arg0) {
        SerenityRest.then().body(response.ID, equalTo(arg0));
    }

    @When("Send Get invalid photos request")
    public void sendGetInvalidPhotosRequest() {
        SerenityRest.when().get(jsonPlaceHolderAPI.PHOTOS_SINGLE);
    }

    //Scenario 4
    @Given("Post photos with valid json")
    public void postPhotosWithValidJson() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY + "postPhotosBody.json");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @When("Send photos post request")
    public void sendPhotosPostRequest() {
        SerenityRest.when().post(jsonPlaceHolderAPI.PHOTOS_LIST);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @And("Response body contain title {string} url {string} thumbnailUrl {string}")
    public void responseBodyContainTitlePhotoMantanUrlHttpsSIdNKThumbnailUrlHttpsSIdNK(String arg0, String arg1, String arg2) {
        SerenityRest.then()
                .body(response.TITLE, equalTo(arg0))
                .body("url", equalTo(arg1))
                .body("thumbnailUrl", equalTo(arg2));
    }

    @And("Validate json schema")
    public void validateJsonSchema(){
        File json = new File(jsonPlaceHolderAPI.JSON_SCHEMA+"postPhotosSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post photos with invalid json")
    public void postPhotosWithInvalidJson() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"invalidJsonBody.json");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @When("Send Post photos request")
    public void sendPostPhotosRequest() {
        SerenityRest.when().post(jsonPlaceHolderAPI.PHOTOS_LIST);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }

    @And("Response body contain error {string}")
    public void responseBodyContainError(String arg0) {
        SerenityRest.then().body("error",equalTo(arg0));
    }


    @Given("Post photos without body json url")
    public void postPhotosWithoutBodyJsonUrl() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutUrl.json");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Given("Post photos without body json title")
    public void postPhotosWithoutBodyJsonTitle() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutTitle.json");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Given("Post photos without body json thumbnailUrl")
    public void postPhotosWithoutBodyJsonThumbnailUrl() {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutThumbnail.json");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Given("Put photos with valid json with parameter {int}")
    public void putPhotosWithValidJson(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBody.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }


    @Given("Put photos with invalid json with parameter {int}")
    public void putPhotosWithInvalidJson(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"invalidJsonBody.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @When("Send Put photos request")
    public void sendPutPhotosRequest() {
        SerenityRest.when().put(jsonPlaceHolderAPI.PHOTOS_SINGLE);
    }

    @Given("Put photos without body json url with parameter {int}")
    public void putPhotosWithoutBodyJsonUrl(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutUrl.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Put photos without body json title with parameter {int}")
    public void putPhotosWithoutBodyJsonTitle(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutTitle.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Put photos without body json thumbnailUrl with parameter {int}")
    public void putPhotosWithoutBodyJsonThumbnailUrl(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutThumbnail.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Patch photos with valid json with parameter {int}")
    public void patchPhotosWithValidJsonWithParameter(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBody.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @When("Send Patch photos request")
    public void sendPatchPhotosRequest() {
        SerenityRest.when().patch(jsonPlaceHolderAPI.PHOTOS_SINGLE);
    }

    @Given("Patch photos with invalid json with parameter {int}")
    public void patchPhotosWithInvalidJsonWithParameter(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"invalidJsonBody.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Patch photos without body json url with parameter {int}")
    public void patchPhotosWithoutBodyJsonUrlWithParameter(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutUrl.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Patch photos without body json title with parameter {int}")
    public void patchPhotosWithoutBodyJsonTitleWithParameter(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutTitle.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Patch photos without body json thumbnailUrl with parameter {int}")
    public void patchPhotosWithoutBodyJsonThumbnailUrlWithParameter(int id) {
        File json = new File(jsonPlaceHolderAPI.JSON_REQUEST_BODY+"postPhotosBodyWithoutThumbnail.json");
        SerenityRest.given().pathParam("id",id).contentType(ContentType.JSON).body(json);
    }

    @Given("Delete photos with id {int}")
    public void deletePhotosWithIdId(int id) {
        SerenityRest.given()
                .pathParam("id",id);
    }

    @When("Send delete photos request")
    public void sendDeletePhotosRequest() {
        SerenityRest.when().delete(jsonPlaceHolderAPI.PHOTOS_SINGLE);
    }

    @Then("Status Code Should be {int} No Content")
    public void statusCodeShouldBeNoContent(int arg0) {
        SerenityRest.then().statusCode(arg0);
    }
}