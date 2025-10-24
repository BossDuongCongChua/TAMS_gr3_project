package GiangVienTestcases;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import Common.BaseTest;

public class ViewFacultyTimetable extends BaseTest {

    @Test(priority = 1)
    public void ViewFacultyTimetable () throws InterruptedException {
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Ta2025/Ta2025/TimeTable");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 

        // Click menu "Thời khóa biểu"
        try {
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Thời khóa biểu')]"))).click();
        } catch (TimeoutException e) {} // Bỏ qua nếu đã ở trang này
        
        // Chọn Học kỳ: "251"
WebElement termInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Học kỳ')]/following-sibling::div//input")));
        termInput.clear();
        termInput.sendKeys("251");
        Thread.sleep(1000); 
        termInput.sendKeys(Keys.ENTER);
                // Chọn Ngành: "Kỹ thuật Phần mềm"
WebElement majorInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Ngành')]/following-sibling::div//input")));
        majorInput.clear();
        majorInput.sendKeys("Kỹ thuật Phần mềm");
        Thread.sleep(1000); 
        majorInput.sendKeys(Keys.ENTER);

        // Mở dropdown "Lọc môn học"
WebElement subjectFilterInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(), 'Lọc môn học')]/following-sibling::div//input")));
        subjectFilterInput.click();
        Thread.sleep(500); 

        // Chọn checkbox "Lập trình hướng đối tượng"
        // Tìm label chứa text môn học
WebElement subjectLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//span[contains(text(), 'Lập trình hướng đối tượng')]")));
        // Click vào label để chọn checkbox
        subjectLabel.click(); 

        // Kiểm tra bảng TKB hiển thị
WebElement scheduleTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
        Assert.assertTrue(scheduleTable.isDisplayed(), "Bảng TKB không hiển thị.");

        System.out.println("✅ TKB hiển thị thành công.");
    }
}

