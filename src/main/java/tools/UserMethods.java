package tools;

import static io.restassured.RestAssured.given;

public class UserMethods {
    public String login(String email, String password) {
        String json = "{\"email\": \""+email+"\", \"password\": \""+password+"\"}";;
        return  given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login")
                .then().extract().path("accessToken");

    }

    public void delete(String accessToken) {
        given()
                .header("Content-type", "application/json")
                .header("authorization", accessToken)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
    }

    public void create(String name, String email, String password) {
        String json = "{\"email\": \""+email+"\", \"password\": \""+password+"\", \"name\": \""+name+"\"}";;
                 given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");
    }
}
