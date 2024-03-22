package com.TestNG;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();
        WebDriver driver = ((ForceFullyFailTestCase) currentClass).getDriver(); 
        
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the path where the screenshot will be saved
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String screenshotName = "screenshot_" + timestamp + ".png";
            String screenshotDirectory = "Screenshots";

            try {
                // Create the directory to save screenshots if it doesn't exist
                Files.createDirectories(Paths.get(screenshotDirectory));

                // Save the screenshot to the specified directory
                Files.move(screenshot.toPath(), Paths.get(screenshotDirectory, screenshotName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

