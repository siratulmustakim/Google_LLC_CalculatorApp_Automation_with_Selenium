import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {

    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnSub;
    @FindBy(id = "com.google.android.calculator:id/op_div")
    WebElement btnDiv;
    @FindBy(id = "com.google.android.calculator:id/op_mul")
    WebElement btnSMul;
    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement txtClear;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement result;

    AndroidDriver driver;

    public CalcScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String calcSeries(AndroidDriver driver, String series){
        char[] arr = series.toCharArray();

        for (char c:arr) {
            if (Character.isDigit(c)){
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+ c)).click();
            }
            else if (c=='+') {
                btnPlus.click();
            }
            else if (c=='-') {
                btnSub.click();
            }
            else if (c=='*') {
                btnSMul.click();
            }
            else if (c=='/') {
                btnDiv.click();
            }
        }

        btnEqual.click();
        return result.getText();

        }

}
