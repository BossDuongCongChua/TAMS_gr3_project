package pages.giangvien;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GradePage {
    private WebDriver driver;

    private By studentRow = By.cssSelector("table#students tbody tr"); // TODO
    private By gradeInput = By.cssSelector("input.grade"); // TODO
    private By saveButton = By.id("saveGrades"); // TODO

    public GradePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setGradeForStudent(String studentName, String grade) {
        // simplistic: iterate rows, find student, input grade
        driver.findElements(studentRow).forEach(row -> {
            if(row.getText().contains(studentName)) {
                row.findElement(gradeInput).clear();
                row.findElement(gradeInput).sendKeys(grade);
            }
        });
    }

    public void saveGrades() {
        driver.findElement(saveButton).click();
    }
}
