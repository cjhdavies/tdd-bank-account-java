package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositAnAmountShouldIncreaseBalanceByAmount() {
        Account account = new Account();
        account.deposit(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void multipleDepositsShouldIncreaseTheBalanceByTotalAmount() {
        Account account = new Account();
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void withdrawingAnAmountShouldDecreaseBalanceByAmount() {
        Account account = new Account();
        account.withdraw(10);
        assertThat(account.balance()).isEqualTo(-10);
    }

    @Test
    public void multipleWithdrawalsReducesBalancesByTotal() {
        Account account = new Account();
        account.withdraw(10);
        account.withdraw(30);
        assertThat(account.balance()).isEqualTo(-40);
    }

    @Test
    public void depositingAndWithdrawingUpdatesBalance() {
        Account account = new Account();
        account.deposit(100);
        account.withdraw(50);
        assertThat(account.balance()).isEqualTo(50);
    }

    @Test
    public void multipleDepositsAndWithdrawalsUpdateBalance() {
        Account account = new Account();
        account.deposit(500);
        account.withdraw(400);
        account.withdraw(200);
        account.deposit(300);
        assertThat(account.balance()).isEqualTo(200);
    }
}
