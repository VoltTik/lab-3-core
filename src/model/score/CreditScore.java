package model.score;

import model.account.Account;
import model.money.Money;

public class CreditScore extends Score {

    public CreditScore(Money balance, Account owner, Integer number) {
        super(balance, owner, number);
    }

    @Override
    public String toString() {
        return "CreditScore{" +
                "balance=" + this.getBalance().getValue() +
                ", owner=" + this.getOwner().getLogin() +
                ", number=" + this.getNumber() +
                '}';
    }

    @Override
    protected boolean addMoneyRules(Money money) {
        return true;
    }

}
