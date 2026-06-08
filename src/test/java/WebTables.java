import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTables {

    /*
    Web Tables:
    1. Web tables are used to display data in a tabular format on web pages
    2. Web tables are created using HTML <table> tag and consist of rows and columns
    3. Table is referred as <webtable> in Selenium
    4. tr-table row, td-table data, th-table header
     */
    static void main(String[] args) {

        //Launch App
        WebDriver driver = new ChromeDriver(); //driver object created for Chrome browser
        driver.navigate().to("https://the-internet.herokuapp.com/tables"); //Launch App
        driver.manage().window().maximize(); //Maximize the browser

        //print all table rows count
        int row_count = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        System.out.println("Table row count is " + row_count);

        //print all table volumn count
        int colm_count = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();

        System.out.println("Table column count is " + colm_count);

        //******************** Static data capture*****************************
        //Get generic cell data eg; due amount of Jason
        String dueAmount = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[4]")).getText();
        System.out.println("Dew amount is "+ dueAmount);

        String emailID = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[4]/td[3]")).getText();
        System.out.println("Email ID is "+ emailID);

        //******************Dynamic data capture*******************************

        List<WebElement> colm_Names = driver.findElements(By.xpath("//table[@id='table1']/thead//span"));
        //colm_Names =[<Last Name>, <First Name>, <Email>....<Action>]
        //<Last Name> = driver.findElement("(//table[@id='table1']/thead//span)[1]")

        /*
        for(WebElement colm_Name : colm_Names){
            System.out.println(colm_Name.getText());
        }*/
        //get the position of FirstName and Due in webtable column
        int firstName_pos = 0;
        int due_pos = 0;

        for(int index_pos=0;index_pos<colm_Names.size();index_pos++){
            if(colm_Names.get(index_pos).getText().equalsIgnoreCase("last name")){
                    firstName_pos = index_pos+1;
            }
        }

        for(int index_pos=0;index_pos<colm_Names.size();index_pos++){
            if(colm_Names.get(index_pos).getText().equalsIgnoreCase("email")){
                due_pos = index_pos+1;
            }
        }
        System.out.println("The position of First Name is " + firstName_pos);
        System.out.println("The position of Due is " + due_pos);


        for(int row=1;row<=row_count;row++){
            String row_data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+row+"]/td["+firstName_pos+"]")).getText();
            if(row_data.equalsIgnoreCase("Conway")){
                String DueAmt = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+row+"]/td["+due_pos+"]")).getText();
                System.out.println(DueAmt);
            }
        }


        driver.quit();


    }

}
