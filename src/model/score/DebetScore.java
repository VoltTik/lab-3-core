package model.score;

import model.account.Account;
import model.constants.Constants;
import model.money.Money;

public class DebetScore extends Score {

    private CreditScore creditScore;

    public DebetScore(Money balance, Account owner, Integer number, CreditScore creditScore) {
        super(balance, owner, number);
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "DebetScore{" +
                "balance=" + this.getBalance().getValue() +
                ", owner=" + this.getOwner().getLogin() +
                ", number=" + this.getNumber() +
                ", CreditScore number=" + creditScore.getBalance().getValue() +
                '}';
    }

    @Override
    public Money getMoney(double balanceLess) {
        if (creditScore.getBalance().getValue() < Constants.MIN_CREDIT_BALANCE) {
            throw new IllegalArgumentException("Unable to get Money. The credit score is less, then -20000.");
        } else {
            if (balanceLess > Constants.MAX_GET_VALUE) {
                throw new IllegalArgumentException("Wrong balance less!");
            }
            this.getBalance().setValue(this.getBalance().getValue() - balanceLess);
            return this.getBalance();
        }
    }

    @Override
    protected boolean addMoneyRules(Money money) {
        if (this.creditScore.getBalance().getValue() < Constants.MIN_CREDIT_BALANCE) {
            throw new IllegalArgumentException("Unable to Add Money. The credit score is less, then -20000.");
        } else {
            return true;
        }
    }

}
