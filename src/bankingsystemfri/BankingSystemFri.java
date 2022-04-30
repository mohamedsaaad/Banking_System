/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingsystemfri;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc1
 */
public class BankingSystemFri {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Client>allClients=new ArrayList<>();
    static ArrayList<BankAccount> allAccounts=new ArrayList<>();
    static Scanner input=new Scanner(System.in);
    
    public static void View(Viewer viewer){
        viewer.view();
    }
    static int search(int accountId){
        for(int i=0;i<allAccounts.size();i++){
            if(allAccounts.get(i).getAccountId() == accountId)
                return i;
        }        
        return -1;
    }
    static void showAllAccounts(){
        for(int i=0;i<allAccounts.size();i++){
            View(allAccounts.get(i));
            System.out.println("/************************************/");
        }
        
        
        
    }
    static void searchForAccount(){
        System.out.println("please enter account ID");
        int id=input.nextInt();
        int index = search(id);
        if(index==-1){
            System.out.println("error . account not found");
            return;
        }
        
        allAccounts.get(index).view();
    }
    
    static void deleteAccount(){
         System.out.println("please enter account ID");
        int id=input.nextInt();
        int index = search(id);
        if(index==-1){
            System.out.println("error . account not found");
            return;
        }
        
        allAccounts.get(index)
                .setOwner(null);
        allClients.get(index)
                .setAccount(null);
        
        allAccounts.remove(index);
        allClients.remove(index);
    }
    static void withdraw(){
        //Todo
    }
    static void deposit(){
        //Todo
    }
    static void addAccount(){
        input.nextLine();
        System.out.println("please enter client name");
        String name=input.nextLine();
        System.out.println("please enter client address");
        String address= input.nextLine();
        System.out.println("please enter client phone");
        String phone=input.nextLine();
        
        Client c=new Client(name, address, phone);
        
        System.out.println("please enter account type"
                + "\n 1- Basic account"
                + "\n 2- savings bank Account ");
        int accountType=-1;

        while(accountType!=1&&accountType!=2){
            accountType=input.nextInt();
            if(accountType!=1&&accountType!=2){
                System.out.println("error invalid account type");
            }
        }
        BankAccount newAccount =null;
        if(accountType==1){
            newAccount=new BankAccount();
        }else if(accountType==2){
            newAccount=new SavingsBankAccount();
        }
        
        newAccount.setOwner(c);
        c.setAccount(newAccount);
        
        allAccounts.add(newAccount);
        allClients.add(c);
        System.out.println("account created successfully");
        

    }

    public static void main(String[] args) {
        // TODO code application logic here
        addTestAccounts();
//        BankAccount ba=new BankAccount(50000);
//        Client owner =new Client("Mohamed", "123", "123");        
//        ba.setOwner(owner);
//        owner.setAccount(ba);
//        owner.view();

        while(true){
            System.out.println("1- add Account");
            System.out.println("2- search for account");
            System.out.println("3- show all accounts");
            System.out.println("4- remove account");
            System.out.println("5- deposit");
            System.out.println("6- withdraw");
            System.out.println("7- exit");
            
            int option=input.nextInt();
            if(option==1){
                addAccount();
            }
            else if(option==2)
                searchForAccount();
            else if(option==3){
                showAllAccounts();
            }else if(option==4){
                deleteAccount();
            }else if(option==5){
                deposit();
            }else if(option==6){
                withdraw();
            }
            else if(option==7){
                return;
            }
        }        
    }
    
    public static void addTestAccounts(){
        for(int i=1;i<21;i++){
            BankAccount ba=new BankAccount(i*5000);
            Client cl=new Client("client "+i, "address  "+i, "1235123");
            //
            cl.setAccount(ba);
            ba.setOwner(cl);
            
            allAccounts.add(ba);
            allClients.add(cl);
        }
    }
    
}
