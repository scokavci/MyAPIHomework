package com.automation.homework;
import com.automation.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class Homework3_HarryPotterAPI_FirstPart {
    @BeforeAll
    public static void setUp(){
        baseURI = ConfigurationReader.getProperty("HARRYPOTTER.URI");
    }

    @Test
    @DisplayName("Verify sorting hat")
    public void test1(){
        Response response = when().get("/sortingHat");
        response.then().statusCode(200).contentType("application/json; charset=utf-8");
        response.prettyPeek();  // different name every time

        List<String> houses=new ArrayList<>(Arrays.asList("\"Gryffindor\"","\"Ravenclaw\"","\"Slytherin\"","\"Hufflepuff\""));
        assertTrue(houses.contains(response.body().asString()));
    }

    @Test
    @DisplayName("Verify bad key")
    public void test2(){
        Response response = given().accept("application/json").
                and().queryParam("key","invalid").
                when().get("/characters");

        response.then().statusCode(401).contentType("application/json; charset=utf-8");

        String message = "Unauthorized";
        assertTrue( response.statusLine().contains(message) );
        response.then().assertThat().body("error",is("API Key Not Found"));
    }

    @Test
    @DisplayName("Verify no key")
    public void test3() {
        Response response = given().accept("application/json").
                when().get("/characters");

        response.then().statusCode(409).contentType("application/json; charset=utf-8");
        String message = "Conflict";
        assertTrue( response.statusLine().contains(message) );
        response.then().assertThat().body("error",is("Must pass API key for request"));
    }
    @Test
    @DisplayName("Verify number of characters")
    public void test4() {
        String API_KEY= "$2a$10$l0lXQEcmx65Aa4cZFQdEmu3MbF3FBwB/kLeCG9AEeeQa3e2aOjGG2";
        Response response = given().accept("application/json").
                and().queryParam("key", API_KEY).
                when().get("/characters");

        response.then().statusCode(200).contentType("application/json; charset=utf-8");
        // response.prettyPeek();
        System.out.println( response.jsonPath().getList("name").size() ); // 195 characters not 194
        //System.out.println( response.body().asString().length()); //54199
        assertEquals( response.jsonPath().getList("name").size(),195);
    }
}
