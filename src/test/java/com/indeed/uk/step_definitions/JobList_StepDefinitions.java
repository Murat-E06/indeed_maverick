package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.JobDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobList_StepDefinitions {

    JobDetailPage jobDetailPage = new JobDetailPage();

    String dbURL= ConfigurationReader.getProperty("dbURL");
    String dbUsername= ConfigurationReader.getProperty("dbUsername");
    String dbPassword= ConfigurationReader.getProperty("dbPassword");


    @Then("user gets the list of jobs")
    public void user_gets_the_list_of_jobs() {
        jobDetailPage.closeEmailWindow();

        BrowserUtils.waitFor(10);
        String result = jobDetailPage.getTextOfElements(jobDetailPage.jobList);
        System.out.println("result = \n" + result);

    }

    @Then("user clicks pages number buttons and get all list of jobs")
    public void userClicksPagesNumberButtonsAndGetAllListOfJobs() {
        jobDetailPage.closeEmailWindow();

        String result = jobDetailPage.getTextOfAllPagesElements(jobDetailPage.pageNumberList);
        //String result= jobDetailPage.getTextOfAllPagesWithWhileLoop(jobDetailPage.pageNumberList);
        System.out.println("result all pages = " + result);


    }


    @Then("user gets the list of the jobs in Map format")
    public void userGetsTheListOfTheJobsInMapFormat() {

        List<Map<String, String>> jobList = new ArrayList<>();

        for (WebElement each : jobDetailPage.jobList) {
            Map<String, String> job = new HashMap<>();
            job.put("jobName", each.getText());
            jobList.add(job);
        }
       // System.out.println(jobList);
        ///////////////////////////////////////////////////

        String textOfElementsSalary = jobDetailPage.getTextOfElements(jobDetailPage.salaryList);
        System.out.println("textOfElementsSalary = \n" + textOfElementsSalary);

       // List<Map<String, String>> salaryList = new ArrayList<>();

        for (WebElement each : jobDetailPage.salaryList) {
            Map<String, String> salary = new HashMap<>();
            salary.put("salary", each.getText());
        //    salaryList.add(salary);
            jobList.add(salary);

        }
     //   System.out.println(salaryList);
        System.out.println(jobList);

    }

    @Then("user gets the list of the job from data base")
    public void userGetsTheListOfTheJobFromDataBase() throws SQLException {

        // CREATE CONNECTION
        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from \"jobs_UK\"");

        System.out.println("connection...");

        while (resultSet.next()) {//next:bir sonraki satır mevcut mu? evet ise geç ve yazdır.

            System.out.println(resultSet.getInt(1)
                    + " - "+resultSet.getString(2)
                    + " - "+resultSet.getString(3));
        }

        /*
        //in order to get column names we need resultsetmetadata
        ResultSetMetaData rsmd = resultSet.getMetaData();

        //move to first row
        resultSet.next();

        //creating list for keeping all the rows maps
        List<Map<String,Object>> queryData = new ArrayList<>();

        Map<String,Object> row1 = new HashMap<>();

        row1.put(rsmd.getColumnName(1),resultSet.getObject(1));
        row1.put(rsmd.getColumnName(2),resultSet.getObject(2));
        row1.put(rsmd.getColumnName(3),resultSet.getObject(3));

        System.out.println(row1.toString());

        //adding rows one by one to my list
        queryData.add(row1);

        System.out.println(queryData);

         */

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();


    }
}



