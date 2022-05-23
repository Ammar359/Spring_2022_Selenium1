package Class1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UseTestNG {

    /**
     * Use of TestNG:
     *  1. to create Test Method
     *  2. to assert a test step
     *      assertEquals -> use when what to compare two values to be equal/identical
     *          eg: Assert.assertEquals(val1, val2, msg)
     *              Here, we are verifying if val1 is equals to val2
     *              if equals, the test-Step will pass
     *              else the testcase will fail, and msg will be printed out
     *
     *      assertTrue -> use when what to check if a boolean is true
     *          eg: Assert.assertTrue(val, msg)
     *              Here, we are verifying if val is true
     *              if val is true, the test-Step will pass
     *              else the testcase will fail, and msg will be printed out
     *
     *      assertFalse -> use when what to check if a boolean is false
     *          eg: Assert.assertFalse(val, msg)
     *              Here, we are verifying if val is false
     *              if val is false, the test-Step will pass
     *              else the testcase will fail, and msg will be printed out
     *
     *
     * Use of Selenium:
     *  to automate the web-testcases
     *
     */

    @Test   // Test - Annotation from testNG Library
    public void verify2Plus2Is4() {
        // Assert Library is part of TestNG Library
        Assert.assertEquals(2+2 , 14, "2+2 is not coming as expected");

    }


    @Test
    public void verify3Plus3Is6() {
        // Assert
        Assert.assertEquals(3+3 , 6, "3+3 is not coming as expected");
    }


}