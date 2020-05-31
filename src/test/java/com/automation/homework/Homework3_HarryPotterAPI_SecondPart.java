package com.automation.homework;

import com.automation.pojos.hw3Pojo.House1;
import com.automation.utilities.ConfigurationReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class Homework3_HarryPotterAPI_SecondPart {
                     //interface
    private static ResponseSpecification responseSpec;
    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void createReqSpec() {
        requestSpec = new RequestSpecBuilder()
                      .setBaseUri(ConfigurationReader.getProperty("HARRYPOTTER.URI"))
                      .addQueryParam("key", ConfigurationReader.getProperty("HARRY.POTTER.API.KEY"))
                      .build();
    }
    @BeforeAll
    public static void createResSpec() {
        responseSpec = new ResponseSpecBuilder()
                       .expectStatusCode(200)
                       .expectContentType(ContentType.JSON).build();
    }

    @Test
    @DisplayName("Verify number of character id and house")
    public void test5() {
        Response response = given().spec(requestSpec).
                            when().get("/characters");

        response.then().spec(responseSpec).body("id", not(emptyOrNullString()));
        //assertFalse(response.jsonPath().getString("id").isEmpty());

        List<String> values = response.jsonPath().getList("dumbledoresArmy");
        for(Object value : values){
            if(value.toString().equals("true") || value.toString().equals("false")){
                assertTrue(true);
            }
        }

        List<String> houses = response.jsonPath().getList("house");
        for (String house : houses) {
            if (house != null) {
                assertTrue(house.contains("Gryffindor")
                        || house.contains("Slytherin")
                        || house.contains("Ravenclaw")
                        || house.contains("Hufflepuff"));
            }

        }
    }

    @Test
    @DisplayName("Verify all character information")
    public void test6() {
        Response response = given().spec(requestSpec).
                            when().get("/characters");
        response.then().spec(responseSpec);

        List<String> nameOfList = response.jsonPath().getList("name");
        Random random = new Random();
        //maximum number 0 -size()
        int randomID = random.nextInt(nameOfList.size());
        String randomName = nameOfList.get(randomID);
        //System.out.println(randomName);

        Response response1 = given().spec(requestSpec).
                             queryParam("name",randomName).
                             when().get("/characters");
        assertTrue(  response.body().asString().contains(randomName) ) ;
    }

    @Test
    @DisplayName("Verify name search")
    public void test7() {
        Response response = given().spec(requestSpec).
                            queryParam("name","Harry Potter").
                            when().get("/characters");
        response.then().spec(responseSpec);
        assertEquals(  response.jsonPath().getString("name"),"[Harry Potter]" );

        Response response1 = given().spec(requestSpec).
                             queryParam("name","Marry Potter").
                             when().get("/characters");
        response1.then().spec(responseSpec);
                                       //get() object .toString()
        assertTrue(  response1.jsonPath().get("name").toString().contentEquals("[]") );
    }

    @Test
    @DisplayName("Verify house members")
    public void test8() {
        Response response = given().spec(requestSpec).
                when().get("/houses");
        response.then().spec(responseSpec);

        List<House1> houses = response.jsonPath().getList("", House1.class);
        String id="";

        for (House1 each:houses) {
            if(each.getName().equals("Gryffindor"))
                id = each.getId();
        }

        Response response1 = given().spec(requestSpec).
                             when().get("/houses/"+id);
        response1.then().spec(responseSpec);

    }

    @Test
    @DisplayName("Verify house members again")
    public void test9() {
        Response response = given().spec(requestSpec).
                            when().get("/houses/"+"5a05e2b252f721a3cf2ea33f");
        List<Object> listOfMemberIds = response.jsonPath().getList("members._id");

        Response response1 = given().spec(requestSpec).
                             queryParam("house","Gryffindor").
                             when().get("/characters");
        response1.prettyPeek();
        List<Object> MemberIds = response1.jsonPath().getList("*._id");
        System.out.println("MemberIds = " + MemberIds);
        assertTrue(MemberIds.toString().contains(listOfMemberIds.toString()));
    }

}

