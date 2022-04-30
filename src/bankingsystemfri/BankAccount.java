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
public class BankAccount implements Viewer{
    private static int IDS_GENERATOR=1000;
    protected int accountId;
    protected double balance;
    protected Client owner;

    public BankAccount() {
        balance=0.0;
        accountId=IDS_GENERATOR++;
    }
    
    public BankAccount(double balance){
        this.balance=balance;
        accountId=IDS_GENERATOR++;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }
    
    
    public boolean withdraw(double amountOfMoney){
        if(amountOfMoney<0){
            System.out.println("error invalid input");
            return false;
        }
        else if(amountOfMoney>balance){
            System.out.println("error invalid amount");
            return false;
        }
        
        balance-=amountOfMoney;
        return true;
        
    }
    public boolean deposit(double amountOfMoney){
        if(amountOfMoney<0){
            System.out.println("error invalid input");
            return false;
        }
        balance+=amountOfMoney;
        return true;
        
    }

    @Override
     public void view(){
        System.out.println("Basic Bank Account");
        System.out.println("account Id : "+accountId);
        System.out.println("balance : "+balance);
        owner.view();
    }
   
    
    
}
