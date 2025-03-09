package dev.kkoncki;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@QuarkusTest
public class GitHubResourceIntegrationTest {

    private static final String VALID_USER = "kacpi-k";

    @Test
    public void testGetUserRepositories_HappyPath() {
        given()
            .when()
                .get("/github/" + VALID_USER + "/repos")
            .then()
                .statusCode(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body("$", not(empty()))
                .body("[0].repository_name", notNullValue())
                .body("[0].owner_login", equalTo(VALID_USER))
                .body("[0].branches", not(empty()))
                .body("[0].branches[0].name", notNullValue())
                .body("[0].branches[0].last_commit_sha", matchesPattern("[a-f0-9]{40}"));
    }
}
