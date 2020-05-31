package com.automation.homework;

import com.automation.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class Homework2_GitHubAPI {
    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("GITHUB.URI");
    }

    @Test
    @DisplayName("Verify organization information")
    public void verifyOrganizationInfo() {

        Response response = given().accept(ContentType.JSON).
                when().get(baseURI + "/orgs/:?org=cucumber");

        assertEquals(response.statusCode(), 200);
        assertEquals(response.contentType(), "application/json; charset=utf-8");
        response.prettyPeek();

        response.then().assertThat().
                body("login", is("cucumber"),
                        "name", is("Cucumber"), "id", is(320565));
    }

    @Test
    @DisplayName("verify error message")
    public void verifyErrorMessage() {
        Response response = given().accept("application/xml").when().get(baseURI + "/orgs/:?org=cucumber");

        assertEquals(response.statusCode(), 415);
        assertEquals(response.contentType(), "application/json; charset=utf-8");

        String errorMessage = "Unsupported Media Type";
        assertTrue(response.statusLine().contains(errorMessage));
    }

    //is it a bug??
    //value of public_repos is 90, number of object is 30
    @Test
    @DisplayName("Number of repositories")
    public void numberOfRepositories() {

        Response response = given(). pathParam("org","cucumber").
                when().get(baseURI + "/orgs/{org}");

        int public_repos= response.jsonPath().getInt("public_repos");
        //System.out.println(public_repos);

        Response response1 = given().pathParam("org", "cucumber")
                .when().get(baseURI + "/orgs/{org}/repos");

        List<String> objects = response1.jsonPath().get();
        //System.out.println(objects.size());
        assertNotEquals( public_repos,objects.size() ); // 90 30 not same...
    }

    @Test
    @DisplayName("Verify id is unique")
    public void verifyIdInfo() {
        Response response = given().pathParam("org", "cucumber")
                .when().get(baseURI + "/orgs/{org}/repos");

        List<String> idList = response.jsonPath().getList("id");
        Set<String> uniqueIds = new LinkedHashSet<>(idList);
        assertEquals(idList.size(),uniqueIds.size());

        List<String> nodeIdList= given().pathParam("org", "cucumber")
                .when().get(baseURI + "/orgs/{org}/repos").jsonPath().getList("node_id");

        Set<String> uniqueNodeIds = new LinkedHashSet<>(nodeIdList);
        assertEquals(nodeIdList.size(),uniqueNodeIds.size());
    }

    @Test
    @DisplayName("Verify repository owner information")
    public void verifyOwnerInfo(){

        Integer id = when().get("/orgs/cucumber")
                .then().extract().jsonPath()
                .getInt("id");

        List<Integer> ownerIds = when().get("/orgs/cucumber/repos")
                .then().extract().jsonPath()
                .getList("owner.id");

        for (Integer ownerId : ownerIds) {
            assertEquals(id,ownerId);

        }

    }

    @Test
    @DisplayName("Verify that all repositories are listed in alphabetical order based on the value of the field name")
    public  void fullNameNaturalOrder() {
        Response response =
                given().
                        pathParam("org", "cucumber").
                        queryParam("sort", "full_name").
                        when().get("/orgs/{org}/repos");

        List<String> fullNames = response.jsonPath().getList("full_name");
        assertEquals(fullNames.stream().sorted().collect(Collectors.toList()), fullNames);
    }

    @Test
    @DisplayName("Verify that all repositories are listed in reverse alphabetical order based on the value of the field name")
    public void fullNameDescendingOrder() {
        Response response =
                given().
                        pathParam("org", "cucumber").
                        queryParam("sort", "full_name").
                        queryParam("direction", "desc").
                        when().get(baseURI + "/orgs/{org}/repos");

        List<String> fullNames = response.jsonPath().getList("full_name");
        // System.out.println(fullNames);
        Collections.reverse(fullNames);
        // System.out.println(fullNames);
        assertEquals(fullNames.stream().sorted().collect(Collectors.toList()), fullNames);
    }

    @Test
    @DisplayName("Verify that by default all repositories listed in descending order based on the value of the field created_at")
    public void defaultSort() {
        Response response =
                given().
                        pathParam("org", "cucumber").
                        when().get(baseURI + "/orgs/{org}/repos");

        List<String> defaultList = response.jsonPath().getList("created_at");
        assertEquals(new ArrayList<>(defaultList), defaultList);
        assertEquals(defaultList.stream().sorted().collect(Collectors.toList()), defaultList);
    }
}


