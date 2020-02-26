package nl.han.ica.oose.dea.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GithubServiceTest {

    private static final String INDEX_START_STRING = "<!DOCTYPE html>";
    private static final String README_START_STRING = "<!--- 37 --->";
    private GitHubService githubService;

    @BeforeEach
    void setup() {
        this.githubService = new GitHubService();
    }

    @Test
    void getIndexHtmlReturnsTheIndexHtml() throws IOException, InterruptedException {
        // Arrange

        // Act
        String indexHtml = githubService.getIndexHtml().trim();

        // Assert
        Assertions.assertTrue(indexHtml.startsWith(INDEX_START_STRING));
    }

    @Test
    void getReadmeReturnsTheCorrectReadme() {
        // Arrange

        // Act
        String readme = githubService.getReadme();

        // Assert
        Assertions.assertTrue(readme.startsWith(README_START_STRING));
    }
}
