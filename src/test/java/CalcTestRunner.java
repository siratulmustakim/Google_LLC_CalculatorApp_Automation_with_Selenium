import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTestRunner extends Setup{

    @Test
    public void doCalculation(){
        CalcScreen calcScreen = new CalcScreen(driver);

        String result = calcScreen.calcSeries(driver, "50+10-20*2+10/2");
        Assert.assertTrue(result.equals("25"));

//        String result = calcScreen.calcSeries(driver, "100/10*5-10+60");
//        Assert.assertTrue(result.equals("100"));
    }

}
