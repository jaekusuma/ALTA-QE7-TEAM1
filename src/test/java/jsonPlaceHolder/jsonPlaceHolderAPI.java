package jsonPlaceHolder;

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
}
