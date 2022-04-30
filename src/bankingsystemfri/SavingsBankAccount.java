/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfri;

/**
 *
 * @author pc1
 */
public class SavingsBankAccount extends BankAccount {
 
    double minimumBalance;

    public SavingsBankAccount(double minimumBalance, double balance) {
        super(balance);
        this.minimumBalance = minimumBalance;        
   }
   public SavingsBankAccount(){
       super(1000);
       minimumBalance=1000;
   }
    @Override
   public boolean withdraw(double amount){
       if(balance-amount<minimumBalance){
           System.out.println("error invalid input");
           return false;
       }
       return super.withdraw(amount);
   }

    @Override
    public boolean deposit(double amountOfMoney) {
        if(amountOfMoney<100){
            System.out.println("error amount should be > 100");
            return false;
        }
        return super.deposit(amountOfMoney);
    }

    @Override
    public void view() {
        System.out.println("Savings Bank Account");
        System.out.println("account ID : "+accountId);
        System.out.println("balance : "+balance);
        System.out.println("min Balance : "+minimumBalance);
    }

   
   
    
}
