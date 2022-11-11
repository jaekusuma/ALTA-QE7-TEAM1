package jsonPlaceHolder;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class jsonPlaceHolderAPI {
    public static final String URL = "https://jsonplaceholder.typicode.com";
    public static final String JSON_REQUEST_BODY = "src/test/resources/features/JsonFile/jsonRequestBody/";
    public static final String JSON_SCHEMA = "src/test/resources/features/JsonFile/jsonSchema/";

    public static String POST_LIST = URL + "/posts";
    public static String POST_SINGLE = URL + "/post/{id}";
    public static String POST_PER_USER_ID = URL + "/post?userId={id}";

    public static String COMMENTS_LIST = URL + "/comments";
    public static String COMMENTS_SINGLE = URL + "/comments/{id}";
    public static String COMMENTS_PER_USER_ID = URL + "/comments?postId?={id}";

    public static String ALBUMS_LIST = URL + "/albums";
    public static String ALBUMS_SINGLE = URL + "/albums/{id}";
    public static String ALBUMS_PER_USER_ID = URL + "/albums?userId={id}";

    public static String PHOTOS_LIST = URL + "/photos";
    public static String PHOTOS_SINGLE = URL + "/photos/{id}";
    public static String PHOTOS_PER_USER_ID = URL + "/photos?albumId={id}";

    public static String TODOS_LIST = URL + "/todos";
    public static String TODOS_SINGLE = URL + "/todos/{id}";
    public static String TODOS_PER_USER_ID = URL + "/todos?id={id}";


    public static String USERS_LIST = URL + "/users";
    public static String USERS_SINGLE = URL + "/users/{id}";
    public static String USERS_PER_USER_ID = URL + "/users?id={id}";

    @Step("Post Create User With Valid Email Password")
    public void postTodosValidEmailPassword(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Create User Without Email")
    public void postTodosWithoutEmail(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Create User With Valid Body")
    public void postTodosValidBody(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    
    @Step("Get Comments")
    public void getComments(int id){
        SerenityRest.given().pathParam("id",id);
    }
    @Step("Post New Comment")
    public void postNewComment(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update Comment")
    public void putUpdateComment(int id, File json){
        SerenityRest.given()
                .pathParam("id",id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Delete Comment")
    public void deleteComment(int id){
        SerenityRest.given()
                .pathParam("id",id);
    }

    }

