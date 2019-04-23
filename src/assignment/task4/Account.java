package assignment.task4;

import java.io.Serializable;

public class Account implements Serializable{
    String accName;
    double accBalance;
    int accNum;

    public Account(String accName, double accBalance, int accNum) {
        this.accName = accName;
        this.accBalance = accBalance;
        this.accNum = accNum;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public double getAccBalance() {
        return accBalance;
    }

    public int getAccNum() {
        return accNum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accName='" + accName + '\'' +
                ", accBalance=" + accBalance +
                ", accNum=" + accNum +
                '}';
    }
}