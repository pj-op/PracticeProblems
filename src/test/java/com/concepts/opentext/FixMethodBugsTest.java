package com.concepts.opentext;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class FixMethodBugsTest {

    FixMethodBugs fixMethodBugs = null;
    Map<Integer, Account> accountMap = null;
    Map<String, Double> inerestRateMap = null;

    @Before
    public void setupData() {
        accountMap = new HashMap<>();
        fixMethodBugs = new FixMethodBugs();
        inerestRateMap = new HashMap<>();

        inerestRateMap.put("savings", 0.5);
        inerestRateMap.put("current", 0.1);

        Account account = new Account("Jhon", "current", 250);
        Account account2 = new Account("Jhon", "savings", 250);
        Account account3 = new Account("Tom", "savings", 500);
        Account account4 = new Account("Peter", "savings", 100);
        Account account5 = new Account("Peter", "current", 1000);

        fixMethodBugs.addAccount(account);
        fixMethodBugs.addAccount(account2);
        fixMethodBugs.addAccount(account3);
        fixMethodBugs.addAccount(account4);
        accountMap = fixMethodBugs.addAccount(account5);

    }

    @Test
    public void test_calculateTotalInterest() {
        double expectedTotalBalance = 0;
        double actualTotalBalance = 0;

        expectedTotalBalance = accountMap.values()
                .stream()
                .map(account -> account.getBalance() * inerestRateMap.get(account.getType()))
                .reduce(Double::sum).get();

        actualTotalBalance = fixMethodBugs.calculateTotalInterest(accountMap.values().stream().toList());

        if (expectedTotalBalance != actualTotalBalance) System.out.println("test_calculateTotalInterest failed");
        else System.out.println("test_calculateTotalInterest Passed !");

    }

    @Test
    public void test_transferAmountBetweenAccounts() {

        Account account2 = new Account("Jhon", "savings", 250);
        Account account3 = new Account("Tom", "savings", 500);

        fixMethodBugs.transferAmountBetweenAccounts(null, null, 150);
        fixMethodBugs.transferAmountBetweenAccounts(account2, account3, 150);
        fixMethodBugs.transferAmountBetweenAccounts(account2, account3, 1000);

        if (account2.getBalance() < 0 || account3.getBalance() < 0) System.out.println("test_transferAmountBetweenAccounts failed");
        else System.out.println("test_transferAmountBetweenAccounts Passed!");

    }
}