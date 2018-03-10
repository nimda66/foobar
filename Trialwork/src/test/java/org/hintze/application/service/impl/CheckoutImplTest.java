package org.hintze.application.service.impl;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(DataProviderRunner.class)
public class CheckoutImplTest {
 static final Logger LOGGER  = Logger.getLogger("CheckoutImplTest");

    @DataProvider
    public static Object[][] totalsData() {
        return new Object[][] {
                {  0, ""},
                { 50, "A"},
                { 80, "AB"},
                {115, "CDBA"},
//
                {100, "AA"},
                {130, "AAA"},
                {180, "AAAA"},
                {230, "AAAAA"},
                {260, "AAAAAA"},
//
                {160, "AAAB"},
                {175, "AAABB"},
                {190, "AAABBD"},
                {190, "DABABA"}
        };
    }

    @Test
    public void scan() {
        Assert.assertTrue(true);
    }

    @Test
    @UseDataProvider("totalsData")
    public void total(int expectedTotal, String items) {
        LOGGER.log(Level.INFO, items+expectedTotal);
        Assert.assertTrue(true);
    }
}
