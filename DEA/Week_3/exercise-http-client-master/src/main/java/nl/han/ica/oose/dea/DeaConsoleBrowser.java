package nl.han.ica.oose.dea;

import nl.han.ica.oose.dea.services.ConsolePrinterService;
import nl.han.ica.oose.dea.services.GitHubService;
import nl.han.ica.oose.dea.services.JsonPlaceholderService;

import java.io.IOException;
import java.util.Scanner;


public class DeaConsoleBrowser {

    private GitHubService gitHubService;
    private JsonPlaceholderService jsonPlaceholderService;
    private ConsolePrinterService consolePrinterService;

    public static void main(String[] args) throws IOException, InterruptedException {
        var consoleBrowser = new DeaConsoleBrowser();
        consoleBrowser.setGitHubService(new GitHubService());
        consoleBrowser.setJsonPlaceholderService(new JsonPlaceholderService());
        consoleBrowser.setConsolePrinterService(new ConsolePrinterService());

        consoleBrowser.start();
    }

    private void start() throws IOException, InterruptedException {
        var keyboard = new Scanner(System.in);
        var exit = false;

        consolePrinterService.printLogo();
        consolePrinterService.printSelectionScreen();

        while (!exit) {
            var input = keyboard.nextLine();
            if (input != null) {
                consolePrinterService.printOutputLine("You have selected : " + input);
                if ("q".equals(input)) {
                    consolePrinterService.printOutputLine("Exiting program");
                    exit = true;
                } else if ("1".equals(input)) {
                    consolePrinterService.printResponse(gitHubService.getIndexHtml());
                    consolePrinterService.printSelectionScreen();
                } else if ("2".equals(input)) {
                    consolePrinterService.printResponse(gitHubService.getReadme());
                    consolePrinterService.printSelectionScreen();
                } else if ("3".equals(input)) {
                    jsonPlaceholderService.getTodos();
                    consolePrinterService.printSelectionScreen();
                } else if ("4".equals(input)) {
                    jsonPlaceholderService.getTodosWithCallback(response -> {
                        consolePrinterService.printResponse(response);
                    });
                    consolePrinterService.printSelectionScreen();
                } else if ("5".equals(input)) {
                    jsonPlaceholderService.getTodosWithCallback(response -> {
                        consolePrinterService.printResponse(response);
                        consolePrinterService.printSelectionScreen();
                    });
                } else if ("6".equals(input)) {
                    jsonPlaceholderService.createNewTodoItemOnServer(response -> {
                        consolePrinterService.printResponse(response);
                        consolePrinterService.printSelectionScreen();
                    });
                }

            }
        }
        keyboard.close();
    }

    public void setJsonPlaceholderService(JsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }

    public void setGitHubService(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    public void setConsolePrinterService(ConsolePrinterService consolePrinterService) {
        this.consolePrinterService = consolePrinterService;
    }
}
