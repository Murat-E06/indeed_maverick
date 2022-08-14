package com.indeed.uk.step_definitions;

import com.indeed.uk.pages.JobDetailPage;
import com.indeed.uk.utilities.BrowserUtils;
import com.indeed.uk.utilities.ConfigurationReader;
import com.indeed.uk.utilities.DBUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
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

    String dbUrl = ConfigurationReader.getProperty("dbUrl");
    String dbUsername = ConfigurationReader.getProperty("dbUsername");
    String dbPassword = ConfigurationReader.getProperty("dbPassword");

    List<Map<String, Object>> queryData;//from db
    List<Map<String, String>> jobList;//from ui


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

        jobList = new ArrayList<>();

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
        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from JOBS2");


        System.out.println("connection...");

        while (resultSet.next()) {//next:bir sonraki satır mevcut mu? evet ise geç ve yazdır.

            System.out.println(resultSet.getInt(1)
                    + " - " + resultSet.getString(2)
                    + " - " + resultSet.getString(3));
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

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();
         */
    }

    @Test
    public void test1() {
        DBUtils.createConnection();
        String query = "select * from INDEED_JOBS";
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> each : queryData) {
            System.out.println(each.toString());
        }

        DBUtils.destroy();
    }

    @Given("user reads the list of the job from data base")
    public void userReadsTheListOfTheJobFromDataBase() {
        //DBUtils.createConnection();

        String query = "select * from JOBS2";
        queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> each : queryData) {
            // System.out.println(each.toString());
            System.out.println(each.get("JOB_NAME"));
        }


        //DBUtils.destroy();
        /////////////////////////////////////////////////
/*
        String query2="select * from JOBS2";
        List<Map<String, Object>>query2Data=DBUtils.getQueryResultMap(query2);

        for (Map<String, Object> each : query2Data) {
            System.out.println(each.toString());

        }

 */

    }

    @Then("user verifies jobs from db is in the ui list")
    public void userVerifiesJobsFromDbIsInTheUiList() {
/*
        for (Map<String, Object> each : queryData) {
            String expectedResult = (String) each.get("JOB_NAME");//object to string casting
            Boolean foundMatch = false;
            for (Map<String, String> eachJob : jobList) {
                String actualResult = (String) eachJob.get("jobName");
                actualResult = actualResult.toUpperCase();

                if (actualResult.contains(expectedResult)) {
                    foundMatch = true;
                }
            }
            Assert.assertTrue(foundMatch);

        }
 */

    }




}



