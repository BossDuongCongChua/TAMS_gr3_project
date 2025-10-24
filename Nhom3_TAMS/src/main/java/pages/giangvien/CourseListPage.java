package pages.giangvien;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CourseListPage {
    private WebDriver driver;
    private By courseRows = By.cssSelector("table#courses tbody tr"); // TODO

    public CourseListPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getCourseCount() {
        List<WebElement> rows = driver.findElements(courseRows);
        return rows.size();
    }

    public void openCourseByName(String name) {
        // TODO: implement proper locator
        List<WebElement> rows = driver.findElements(courseRows);
        for(WebElement r : rows){
            if(r.getText().contains(name)){
                r.findElement(By.tagName("a")).click();
                return;
            }
        }
        throw new RuntimeException("Course not found: " + name);
    }
}
