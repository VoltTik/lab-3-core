package model.score;

import model.account.Account;
import model.account.Principal;
import model.money.Money;

public class Main {

    public static void main(String[] args) {
        Principal principal1 = new Principal("Ivan", "Ivanovich", "Ivanov", (short) 25);
        Money money1 = new Money(-10000, "USD");
        Money money2 = new Money(20000, "USD");
        Money money3 = new Money(30000, "USD");
        Account account1 = new Account(principal1, "login1", "assasa");
        CreditScore creditScore = new CreditScore(money1, account1, 2546321);
        CreditScore creditScore2 = new CreditScore(new Money(-20001, "USD"), account1, 2546000);
        DebetScore debetScore = new DebetScore(money2, account1, 2546322, creditScore);
        DebetScore debetScore2 = new DebetScore(money2, account1, 2546322, creditScore2);
        CurrentScore currentScore = new CurrentScore(money3, account1, 2546323, debetScore);
        //Кредит
        System.out.println("BeginCredit: " + creditScore.toString());
        creditScore.addMoney(new Money(100000, "USD"));
        System.out.println("CreditAdd: " + creditScore.toString());
        creditScore.getMoney(30000);
        System.out.println("CreditGet: " + creditScore.toString());

        //Текущий
        System.out.println("BeginCurrent: " + currentScore.toString());
        currentScore.addMoney(new Money(1000000, "USD"));
        System.out.println("CurrentAdd: " + currentScore.toString());
        currentScore.getMoney(30000);
        System.out.println("CurrentGet: " + currentScore.toString());

        //Дебетовый
        System.out.println("BeginDebet: " + debetScore.toString());
        debetScore.addMoney(new Money(100000, "USD"));
        System.out.println("DebetScoreAdd: " + debetScore.toString());
        debetScore.getMoney(30000);
        System.out.println("DebetScoreGet: " + debetScore.toString());
        System.out.println("BeginDebet2: " + debetScore.toString());
        debetScore2.addMoney(new Money(100000, "USD"));
        System.out.println("Debet2ScoreAdd: " + debetScore.toString());
        debetScore2.getMoney(30000);
        System.out.println("Debet2ScoreGet: " + debetScore.toString());
    }
}
