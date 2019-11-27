package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    int iterate = 0;
    int Max_Count = 2;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (iterate < Max_Count)
            try {
                iterate++;
                return true;
            } catch (Exception e) {

            }
        return false;
    }

}
