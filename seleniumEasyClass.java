import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class seleniumEasyClass {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 3);
    String SeleniumEasyUrl = "http://www.seleniumeasy.com/test/";

    @BeforeMethod
    public void openApplication() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(SeleniumEasyUrl);

    }

    /**
     * Input Forms
     */
    @Test
    public void Test01() {

        // Wait element
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".at-cv-lightbox.at-cv-goal-prompt.at-center-layout-2.at-cv-with-image>div>div>div>.at4-close")));
        driver.findElement(By.cssSelector(".at-cv-lightbox.at-cv-goal-prompt.at-center-layout-2.at-cv-with-image>div>div>div>.at4-close")).click();

        /*
         Simple form demo
         */

        // Simple form demo page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(1)")).click();

        // Single input field
        driver.findElement(By.cssSelector(".col-md-6.text-left>.panel.panel-default>.panel-body>#get-input>div>.form-control")).sendKeys("Selenium Easy");
        driver.findElement(By.cssSelector(".col-md-6.text-left>.panel.panel-default>.panel-body>#get-input>.btn.btn-default")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#display")).isDisplayed());

        // Two input fields
        driver.findElement(By.cssSelector("#sum1")).sendKeys("2");
        driver.findElement(By.cssSelector("#sum2")).sendKeys("3");
        driver.findElement(By.cssSelector("#gettotal>.btn.btn-default")).click();
        System.out.println(2 + 3);
        Assert.assertTrue(driver.findElement(By.cssSelector("#displayvalue")).isDisplayed());

        /*
        Checkbox demo
         */

        // Checkbox demo page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(2)")).click();

        // Single checkbox demo
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div>div>label>#isAgeSelected")).click();

        // Multiple checkbox demo
        driver.findElement(By.cssSelector("#check1")).click();
        driver.findElement(By.cssSelector("div>div.col-md-6.text-left>div:nth-child(5)>div.panel-body>div:nth-child(3)>label")).click();
        Assert.assertFalse(Boolean.parseBoolean(driver.findElement(By.cssSelector("#check1")).getCssValue("Check All")));

        /*
        Radio buttons demo
         */

        // Radio button page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(3)")).click();

        // Radio button demo
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>label:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>p:nth-child(6)>#buttoncheck")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>p:nth-child(7)")).isDisplayed());

        // Group radio buttons demo
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>div>div:nth-child(2)>label:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>div>div:nth-child(3)>label:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>.panel-body>.btn.btn-default")).click();
        //driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>.panel-body>.groupradiobutton")).getText();
        Assert.assertTrue(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>.panel-body>.groupradiobutton")).isDisplayed());
        //Assert.assertTrue(Boolean.parseBoolean(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>.panel-body>.groupradiobutton")).getText()));
        //driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>.panel-body>.groupradiobutton")).getText();

        /*
        Select dropdown demo
         */

        // Select dropdown page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(4)")).click();

        // Select list demo
        Select daySelect = new Select(driver.findElement(By.cssSelector(".form-control")));
        daySelect.selectByValue("Monday");

        // Multi select list demo
        Select countrySelect = new Select(driver.findElement(By.cssSelector("div>#multi-select")));
        countrySelect.selectByValue("Texas");

        driver.findElement(By.cssSelector("div>#printMe")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div>.getall-selected")).isDisplayed());


    /*
    Input form submit
     */

        // Input form page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(5)")).click();

        // Submit data
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(2)>div>div>.form-control")).sendKeys("Robert");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(3)>div>div>.form-control")).sendKeys("Robertson");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(4)>div>div>.form-control")).sendKeys("robi.robi@gmail.com");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(5)>div>div>.form-control")).sendKeys("12345678");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(6)>div>div>.form-control")).sendKeys("Topolska 18");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(7)>div>div>.form-control")).sendKeys("Belgrade");
        Select stateSelect = new Select(driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(8)>div>div>.form-control")));
        stateSelect.selectByVisibleText("Colorado");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(9)>div>div>.form-control")).sendKeys("12345");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(10)>div>div>.form-control")).sendKeys("www.robi.com");
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(11)>div>.radio:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".col-md-6.text-left>section>form>fieldset>div:nth-child(12)>div>div>.form-control")).sendKeys("Selenium Easy");
        driver.findElement(By.cssSelector(".btn.btn-default")).click();


    /*
    Ajax form submit
     */

        //Ajax form page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(6)")).click();

        // Ajax submit data
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>form>div:nth-child(1)>#title")).sendKeys("Robert Robertson");
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>form>div:nth-child(2)>#description")).sendKeys("Selenium Easy Project");
        driver.findElement(By.cssSelector(".col-md-6.text-left>div>div:nth-child(2)>form>div:nth-child(3)>#btn-submit")).click();

        /*
        JQuery Select drop down
         */

        //JQuery page
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(1)>ul>li:nth-child(7)")).click();


        // Drop down with search box
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>#country")).sendKeys("d");
        Select selectCountry = new Select(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(2)>div:nth-child(1)>div:nth-child(2)>#country")));
        selectCountry.selectByValue("Denmark");

        // Select Multiple Values
        Select multipleSelect = new Select(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(3)>div>div:nth-child(2)>.js-example-basic-multiple.select2-hidden-accessible")));
        multipleSelect.selectByValue("AK");
        multipleSelect.selectByValue("AZ");
        multipleSelect.selectByValue("AR");

        //Drop Down with Disabled values
        Select disabledValuesSelect = new Select(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(4)>div>div:nth-child(2)>.js-example-disabled-results.select2-hidden-accessible")));
        disabledValuesSelect.selectByValue("PR");

        Select relatedSelect = new Select(driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(5)>div>div:nth-child(2)>#files")));
        relatedSelect.selectByVisibleText("Java");


        /**
         * Date pickers
         */


        /*
        Bootstrap Date Pickers
         */

        // Bootstrap Date Pickers Example
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(2)>ul>li:nth-child(1)")).click();

        // Date Example
        driver.findElement(By.cssSelector(".glyphicon.glyphicon-th")).click();
        driver.findElement(By.cssSelector(".datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top>" +
                ".datepicker-days>table>tfoot>tr:nth-child(1)>.today")).click();
        driver.findElement(By.cssSelector(".glyphicon.glyphicon-th")).click();
        driver.findElement(By.cssSelector(".datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top>" +
                ".datepicker-days>table>tfoot>tr:nth-child(2)>.clear")).click();

        // Date Range Example
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(3)>div>.panel-body>div>div>input:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left." +
                "datepicker-orient-top>div:nth-child(1)>table>tbody>tr:nth-child(2)>td:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".col-md-6.text-left>div:nth-child(3)>div>.panel-body>div>div>input:nth-child(3)")).click();
        driver.findElement(By.cssSelector(".datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left." +
                "datepicker-orient-top>div:nth-child(1)>table>tbody>tr:nth-child(2)>td:nth-child(6)")).click();

        /*
        JQuery Date Picker
         */

        // JQuery Date Picker Demo

        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(2)>ul>li:nth-child(2)")).click();

        WebElement jquerystartDateBox = driver.findElement(By.cssSelector(".col-md-6.text-left>div>.panel-body>input:nth-child(2)"));
        jquerystartDateBox.sendKeys("8/12/2020");
        jquerystartDateBox.sendKeys(Keys.TAB);

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement jqueryendDateBox = driver.findElement(By.cssSelector(".col-md-6.text-left>div>.panel-body>input:nth-child(4)"));
        jqueryendDateBox.clear();
        jqueryendDateBox.sendKeys("11/12/2020");


        /**
         * Table
         */

        /*
        Table Pagination
         */

        // Table Pagination Example
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)>ul>li:nth-child(1)")).click();

        driver.findElement(By.cssSelector("#myPager>li:nth-child(3)>.page_link")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#myPager>li:nth-child(1)>.prev_link")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("#myPager>li:nth-child(5)>.next_link")).isDisplayed());

        driver.findElement(By.cssSelector("#myPager>li:nth-child(1)>.prev_link")).click();
        driver.findElement(By.cssSelector("#myPager>li:nth-child(3)>.page_link")).click();
        driver.findElement(By.cssSelector("#myPager>li:nth-child(5)>.next_link")).click();

        /*
        Table Data Search
         */

        // Type in your search to filter data by Tasks / Assignee / Status
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)>ul>li:nth-child(2)")).click();
        driver.findElement(By.cssSelector("#task-table-filter")).sendKeys("SEO tags");
        Assert.assertTrue(driver.findElement(By.cssSelector(".table.table-hover>tbody>tr:nth-child(3)")).isDisplayed());

        // Click the filter icon to activate column filters inputs
        driver.findElement(By.cssSelector(".btn.btn-default.btn-xs.btn-filter")).click();
        driver.findElement(By.cssSelector(".panel.panel-primary.filterable>table>thead>tr>th:nth-child(1)>.form-control")).sendKeys("3");
        Assert.assertTrue(driver.findElement(By.cssSelector(".panel.panel-primary.filterable>table>tbody>tr:nth-child(3)>td:nth-child(1)")).isDisplayed());


        /*
        Table Filter
         */


        // Click on Green / Orange / Red to filter records OR Click on All to view all records
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)>ul>li:nth-child(3)")).click();


//        driver.findElement(By.cssSelector(".btn.btn-danger.btn-filter")).click();
//        Assert.assertTrue(driver.findElement(By.cssSelector(".table-container>table>tbody>tr:nth-child(3)>td:nth-child(3)>div>a>.media-photo.fa.fa-smile-o.fa-3x")).isDisplayed());

        /*
        Table Sort And Search
         */

        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#treemenu>li>ul>li:nth-child(3)>ul>li:nth-child(4)")).click();

        //Table Sort And Search Demo
        driver.findElement(By.cssSelector("#example_filter>label>input")).sendKeys("Tokyo");

    }

}




