package tests.common;
import helpers.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class LoginLogout extends BaseTest {

    @Test(description = "F2.1 - Kiểm thử chức năng Đăng nhập/Đăng xuất 
    public void LoginLogout () {
        // ===================== BẮT ĐẦU TEST =====================
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        // Truy cập trang hệ thống TA 2025
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Ta2025");
        driver.manage().window().maximize();

        try {
            // --- Bước 1: Nhấn “Tin cậy” để tiếp tục truy cập ---
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Tin cậy')]"))).click();
		        // --- Bước 2: Chọn “Đăng nhập bằng Microsoft” ---
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng nhập')]"))).click();
// --- Bước 3: Nhập email  ---
WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
emailField.sendKeys(System.getProperty("username", "duong.2174802010611@vanlanguni.vn"));
            driver.findElement(By.xpath("//input[@type='submit']")).click();

            // --- Bước 4: Nhập mật khẩu ---
WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
            passwordField.sendKeys(System.getProperty("password", "YOUR_PASSWORD"));
            driver.findElement(By.xpath("//input[@type='submit']")).click();

            // --- Bước 5: Đợi xác thực Authenticator ---
            Thread.sleep(20000); // Chờ user xác nhận Authenticator

            // --- Bước 6: Ghi nhớ tài khoản (nếu xuất hiện) ---
            try {
                WebElement remember = driver.findElement(By.xpath("//input[@type='checkbox']"));
                if (!remember.isSelected()) remember.click();
                driver.findElement(By.xpath("//input[@type='submit']")).click();
            } catch (Exception e) {
                System.out.println("Không xuất hiện màn hình ghi nhớ. Tiếp tục...");
            }
		        // --- Bước 7: Xác nhận đăng nhập thành công ---
            boolean isLoginSuccess = driver.getPageSource().contains("Trang chủ") 
                                  || driver.getPageSource().contains("Dashboard") 
                                  || driver.getPageSource().contains("Giảng viên") 
                                  || driver.getCurrentUrl().contains("Home");

            Assert.assertTrue(isLoginSuccess, "❌ Đăng nhập thất bại hoặc không vào đúng trang chính.");

            System.out.println("✅ Đăng nhập thành công với role: " + System.getProperty("role", "Giảng viên"));
	        	// --- Bước 8: Thực hiện Đăng xuất ---
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("nav ul li a span img"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Đăng xuất')]"))).click();
            // --- Bước 9: Kiểm tra đăng xuất thành công ---
            boolean isLogoutSuccess = driver.getPageSource().contains("Đăng nhập") 
                                   || driver.getCurrentUrl().contains("login");

            Assert.assertTrue(isLogoutSuccess, "❌ Đăng xuất thất bại!");
            System.out.println("✅ Đăng xuất thành công.");

        } catch (Exception e) {
            System.out.println("⚠️ Lỗi khi thực thi test login/logout: " + e.getMessage());
            Assert.fail("Test thất bại do lỗi xử lý hoặc timeout.");
        }
        // ===================== KẾT THÚC TEST =====================
    }
}          

