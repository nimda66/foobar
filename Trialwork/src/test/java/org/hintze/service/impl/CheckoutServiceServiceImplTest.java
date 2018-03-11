package org.hintze.service.impl;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.logging.Logger;

@RunWith(DataProviderRunner.class)
public class CheckoutServiceServiceImplTest {
    private static final Logger LOGGER = Logger.getLogger("CheckoutServiceServiceImplTest");

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

//    @Test
//    public void scan() {
//        CheckoutServiceServiceImpl checkout = new CheckoutServiceServiceImpl();
//
//        BigDecimal resultPrice = checkout.scan(UnitType.A.name());
//        Assert.assertEquals(UnitType.A.getPrice(), resultPrice);
//    }

    @Test
    @UseDataProvider("totalsData")
    public void total(int expectedTotal, String multiItems) {
        CheckoutServiceServiceImpl checkout = new CheckoutServiceServiceImpl();

        String[] splitItems = multiItems.split(StringUtils.EMPTY);
        Arrays.stream(splitItems).forEach(item -> {
            LOGGER.info("Test item: " + item);
            checkout.scan(item);
        });
        Assert.assertEquals(expectedTotal, checkout.total());
    }
}
