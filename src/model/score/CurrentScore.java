package model.score;

import model.account.Account;
import model.constants.Constants;
import model.money.Money;

public class CurrentScore extends Score {

    private DebetScore debetScore;

    public CurrentScore(Money balance, Account owner, Integer number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }

    @Override
    protected boolean addMoneyRules(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCourse();
        if (usdValueIn > Constants.OVERFLOW_CURRENT_VALUE) {
            this.debetScore.addMoney(new Money(Constants.BONUS_DEBIT_VALUE, "USD"));
        }
        return true;
    }

    @Override
    public String toString() {
        return "CurrentScore{" +
                "balance=" + this.getBalance().getValue() +
                ", owner=" + this.getOwner().getLogin() +
                ", number=" + this.getNumber() +
                ", DebetScore number=" + debetScore.getBalance().getValue() +
                '}';
    }
}
