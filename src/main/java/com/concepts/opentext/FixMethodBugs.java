package com.concepts.opentext;

import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FixMethodBugs {

    private static final String ACCOUNT_TYPE_SAVINGS = "SAVINGS";
    private static final String ACCOUNT_TYPE_CURRENT = "CURRENT";
    private Map<Integer, Account> accountMap = null;
    int idCount = 0;

    public FixMethodBugs() {
        this.accountMap = new HashMap<>();
    }

    public double calculateTotalInterest(List<Account> accounts) {
        double interestRate = 0;
        double totalBalance = 0;
        for (Account account : accounts) {
            if (ACCOUNT_TYPE_SAVINGS.equalsIgnoreCase(account.getType())) {
                interestRate = 0.5;
            } else if (ACCOUNT_TYPE_CURRENT.equalsIgnoreCase(account.getType())) {
                interestRate = 0.1;
            }
            totalBalance += account.getBalance() * interestRate;
        }
        return totalBalance;
    }

    public void transferAmountBetweenAccounts(Account src, Account dest, double amountToTransfer) {
        if (src == null || dest == null || amountToTransfer < 0) return;
        if (amountToTransfer <= src.getBalance()) {
            src.setBalance(src.getBalance() - amountToTransfer);
            dest.setBalance(dest.getBalance() + amountToTransfer);
        }
    }

    public Map<Integer, Account> addAccount(Account account) {
        idCount = idCount + 1;
        accountMap.put(idCount, account);
        return accountMap;
    }
}

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
class Account {
    private String userName;
    private String type;
    private double balance;
}