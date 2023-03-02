//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package testcase;

import com.automation.base.DriverInstance;
import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenShot;
import com.automation.utils.PropertiesFileUtils;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_LoginPage extends DriverInstance {
    private WebElement checkLogin;
    private WebElement checkLogout;
    @DataProvider(
            name = "dataProvider"
    )
    public Object[][] readUserData() throws Exception {
        FileInputStream fis = new FileInputStream("data/assignment2_data_test.xlsx");
        Workbook wb = new XSSFWorkbook(fis);
        Sheet loginSheet = wb.getSheet("Login");
        int numberOfData = loginSheet.getPhysicalNumberOfRows();
        Object[][] testData = new Object[numberOfData][2];

        for(int i = 0; i < numberOfData; ++i) {
            Row rw = loginSheet.getRow(i);
            Cell email = rw.getCell(0);
            Cell password = rw.getCell(1);
            testData[i][0] = email.getStringCellValue();
            testData[i][1] = password.getStringCellValue();
        }

        return testData;
    }

    @Test(
            dataProvider = "dataProvider"
    )
    public void TC_Login(String userEmail, String userPassword) throws InterruptedException {
        this.checkLogin = this.driver.findElement(By.xpath(PropertiesFileUtils.getProperty("loginButton")));
        Assert.assertNotEquals(this.checkLogin.getText(), "Logout");
        LoginPage loginPage = new LoginPage(this.driver);
        PageFactory.initElements(this.driver, loginPage);
        loginPage.loginAndLogout();
        Thread.sleep(3000L);
        loginPage.enterEmail(userEmail);
        loginPage.enterPassword(userPassword);
        loginPage.clickEnter();
        Thread.sleep(3000L);
        this.checkLogout = this.driver.findElement(By.xpath("//a[@href=\"/logout\"]"));
        Assert.assertEquals(this.checkLogout.getText(), "Logout");
        this.checkLogout.click();
        Thread.sleep(3000L);
        System.out.println("Test case pass");
    }

    @AfterMethod
    public void takeScreenShot(ITestResult result) {
        if (2 == result.getStatus()) {
            String transfer = (String)result.getParameters()[0];
            int index = transfer.indexOf("@");
            String imgName = transfer.substring(0, index);
            CaptureScreenShot.takePictureFailTc(imgName);
            CaptureScreenShot.attachScreenShot();
            System.out.println("Fail");
        }

    }
}
