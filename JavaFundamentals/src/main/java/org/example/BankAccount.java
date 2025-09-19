package org.example;

/// Access Specifier
// Public, Private, Default, Protected
public class BankAccount {

  private int accountBalance;

  public String accountNumer;

  public BankAccount() {
    accountNumer = "1234567890";
    accountBalance = 1000;
  }

  private void setAccountBalance(int accountBalance) {
    if (accountBalance < 0) {
      System.out.println("Account balance cannot be negative.");
      return;
    }
    this.accountBalance = accountBalance;
  }

  public void setAccountNumer(String accountNumer) {
    this.accountNumer = accountNumer;
  }

  public int getAccountBalance() {
    return accountBalance;
  }

  public String getAccountNumer() {
    return accountNumer;
  }
}
