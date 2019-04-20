package assignment.task4;

public class Account {
    String accName;
    Float accBalance;
    int accNum;

    public Account(String accName, Float accBalance, int accNum) {
        this.accName = accName;
        this.accBalance = accBalance;
        this.accNum = accNum;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public void setAccBalance(Float accBalance) {
        this.accBalance = accBalance;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public Float getAccBalance() {
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