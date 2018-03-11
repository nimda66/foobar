package org.hintze.service.impl;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.lang3.StringUtils;
import org.hintze.model.UnitType;
import org.hintze.service.CheckoutService;
import org.hintze.strategy.impl.DefaultPricingStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.logging.Logger;

@RunWith(DataProviderRunner.class)
public class CheckoutServiceImplTest {
    private static final Logger LOGGER = Logger.getLogger("CheckoutServiceImplTest");

    @DataProvider
    public static Object[][] totalsData() {
        return new Object[][]{
                //without discount
                {0, ""},
                {50, "A"},
                {80, "AB"},
                {115, "CDBA"},
                {100, "AA"},
                //with discount
                {130, "AAA"},
                {180, "AAAA"},
                {230, "AAAAA"},
                {45, "BB"},
                {260, "AAAAAA"},
                {310, "AAAAAAA"},
                {75, "BBB"},
                {90, "BBBB"},
                {160, "AAAB"},
                {175, "AAABB"},
                {190, "AAABBD"},
                {190, "DABABA"}
        };
    }

    @Test
    public void scan() {
        CheckoutService checkoutService = new CheckoutServiceImpl();

        checkoutService.scan(UnitType.A.name());
        int resultTotal = checkoutService.total();
        Assert.assertEquals(UnitType.A.getPrice(), resultTotal);
    }

    @Test
    @UseDataProvider("totalsData")
    public void total(int expectedTotal, String multiItems) {
        //default rules
        CheckoutService checkoutService = new CheckoutServiceImpl();

        String[] splitItems = multiItems.split(StringUtils.EMPTY);
        Arrays.stream(splitItems).forEach(item -> {
            LOGGER.info("Test item: " + item);
            checkoutService.scan(item);
        });
        Assert.assertEquals(expectedTotal, checkoutService.total());
    }
}
