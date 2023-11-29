import java.util.*;

class ATM {
     
    float Balance;
    int PIN=5674;

    public void checkpin(){
        System.out.println("enter your pin: ");
        Scanner sc = new Scanner(System.in);
        int enteredpin=sc.nextInt();
        if(enteredpin==PIN){
            menu();
        }
        else{
            System.out.println("Enter a valid pin: ");
            menu();

        }
    }

    public void menu(){
        System.out.println("Enter yout choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. EXIT");

        Scanner sc=new Scanner(System.in);
        int opt=sc.nextInt();

        if(opt==1){
            checkBalance();
        }
        else if(opt==2){
            withdrawMoney();
        }
        else if(opt==3){
            depositMoney();
        }
        else if(opt==4){
            return;
        }
        else{
            System.out.println("Invalid Option");
        }

    }

    public void checkBalance(){
        System.out.println("Your balance is "+Balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("How much do you want to withdraw?: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        if(amount>Balance){
            System.out.println("Insufficient Balance!");
        }
        else{
            Balance-=amount;
            System.out.println("Withdrawl Successful");
        }
        menu();
        
    }
    public void depositMoney() {
        System.out.println("How much do you want to deposit?: ");
        Scanner sc = new Scanner(System.in);
        double amount = sc.nextDouble();
        Balance+=amount;
        System.out.println("Deposit Successful");
        menu();

    }

}
public class ATMMachine{
    public static void main(String[] args) {
        ATM obj=new ATM();
        obj.checkpin();
    }
    
}
