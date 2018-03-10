package org.hintze.application.service.impl;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.hintze.application.service.Checkout;
import org.hintze.application.service.UnitPrice;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(DataProviderRunner.class)
public class CheckoutImplTest {
    private static final Logger LOGGER = Logger.getLogger("CheckoutImplTest");

    @DataProvider
    public static Object[][] totalsData() {
        return new Object[][]{
                {0, ""},
                {50, "A"},
                {80, "AB"},
                {115, "CDBA"},
//
                {100, "AA"},
//TODO hin                {130, "AAA"},
//                {180, "AAAA"},
//                {230, "AAAAA"},
//                {260, "AAAAAA"},
////
//                {160, "AAAB"},
//                {175, "AAABB"},
//                {190, "AAABBD"},
//                {190, "DABABA"}
        };
    }

    @Test
    public void scan() {
        CheckoutImpl checkout = new CheckoutImpl();

        BigDecimal resultPrice = checkout.scan(UnitPrice.A.name());
        Assert.assertEquals(UnitPrice.A.getPrice(), resultPrice);
    }

    @Test
    @UseDataProvider("totalsData")
    public void total(int expectedTotal, String multiItems) {
        CheckoutImpl checkout = new CheckoutImpl();

        String[] splitItems = multiItems.split(StringUtils.EMPTY);
        Arrays.stream(splitItems).forEach(item -> {
            LOGGER.info("Test item: " + item);
            checkout.scan(item);
        });
        BigDecimal resultTotal = checkout.total();
        Assert.assertEquals(BigDecimal.valueOf(expectedTotal), resultTotal);
    }
}
