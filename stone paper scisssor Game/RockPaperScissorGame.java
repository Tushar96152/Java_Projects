import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {
    static String []option={"Stone","Paper","Scissor"};
    static String gen_Option(){
        Random random=new Random();            // attempt a random option
        int index=random.nextInt(option.length);
        return option[index];
    }
    static void guessOption(){
        int user=0;
        int con=0;
        System.out.println("   ");
        System.out.println("   ");
        System.out.println("WELCOME TO THE GAME:-");
        System.out.println("You have 5 rounds.");
        System.out.println("Good Luck!!!");
        System.out.println(" ");
        System.out.println(" ");
        for(int i=1;i<6;i++){
            String a=gen_Option();
            System.out.println("Round "+i+"/5 :-");
            System.out.println("Choose one of the following options:\n");
            System.out.println("1. Stone.\n2.  Paper.\n3. Scissor.");       
            System.out.print("choose your option one of them\n");
            
            Scanner sc = new Scanner(System.in);
            int guess=sc.nextInt();          //input
            String guess2="";
            if(guess == 1){
                guess2="Stone";
            } else if (guess == 2) {
                guess2="Paper";
            } else if (guess == 3) {
                guess2="Scissor";
            } else if (guess>3) {
                System.out.println("Wrong Input");
                break;
            }
            
            System.out.println("Your Pick: "+guess2);
            System.out.println("Opponent's Pick: "+a);
            if(guess2.equalsIgnoreCase(a)){
                System.out.println("Result: It's a Draw!!!");
                
                user++;
                con++;
            } 
            else if (a.equalsIgnoreCase("Stone")&& guess2.equalsIgnoreCase("Paper")) {
                System.out.println("Result: You win!!!");
                
                user++;
            }
            else if (a.equalsIgnoreCase("Stone")&& guess2.equalsIgnoreCase("Scissor")) {
                System.out.println("Result: You Lose!!!");
               
                con++;

            }
            else if (a.equalsIgnoreCase("Paper")&& guess2.equalsIgnoreCase("Stone")) {
                System.out.println("Result: You Lose!!!");
               
                con++;

            }
            else if (a.equalsIgnoreCase("Paper")&& guess2.equalsIgnoreCase("Scissor")) {
                System.out.println("Result: You win!!!");
              
                user++;

            }
            else if (a.equalsIgnoreCase("Scissor")&& guess2.equalsIgnoreCase("Stone")) {
                System.out.println("Result: You win!!!");
                
                user++;

            } 
            else if (a.equalsIgnoreCase("Scissor")&& guess2.equalsIgnoreCase("Paper")) {
                System.out.println("Result: You Lose!!!");
                
                con++;
            }
        }
           // counting comparison
        if(user > con){
            System.out.println("YOU WON THE GAME!!!!.");
        }
        else if (con == user) {
            System.out.println("GAME ENDED IN A DRAW.");

        }
        else if(con > user) {
            System.out.println("YOU LOST  BETTER LUCK NEXT TIME.");
        }

    }

    public static void main(String[] args) {
        guessOption();
    }
}
