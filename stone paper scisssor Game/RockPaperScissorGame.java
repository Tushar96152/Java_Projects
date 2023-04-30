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
        int u=0;
        int c=0;
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
            System.out.println("Choose one of the following options:");
            System.out.println("1 :- For Stone.");
            System.out.println("2 :- For Paper.");
            System.out.println("3 :- For Scissor.");
            System.out.println("         ");
            System.out.print("Enter your pick:- ");
            Scanner sc = new Scanner(System.in);
            int guess=sc.nextInt();
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
                System.out.println("      ");
                u++;
                c++;
            } else if (a.equalsIgnoreCase("Stone")&& guess2.equalsIgnoreCase("Paper")) {
                System.out.println("Result: You win!!!");
                System.out.println("       ");
                u++;
            }
            else if (a.equalsIgnoreCase("Stone")&& guess2.equalsIgnoreCase("Scissor")) {
                System.out.println("Result: You Lose!!!");
                System.out.println("        ");
                c++;

            } else if (a.equalsIgnoreCase("Paper")&& guess2.equalsIgnoreCase("Stone")) {
                System.out.println("Result: You Lose!!!");
                System.out.println("         ");
                c++;

            } else if (a.equalsIgnoreCase("Paper")&& guess2.equalsIgnoreCase("Scissor")) {
                System.out.println("Result: You win!!!");
                System.out.println("          ");
                u++;

            } else if (a.equalsIgnoreCase("Scissor")&& guess2.equalsIgnoreCase("Stone")) {
                System.out.println("Result: You win!!!");
                System.out.println("           ");
                u++;

            } else if (a.equalsIgnoreCase("Scissor")&& guess2.equalsIgnoreCase("Paper")) {
                System.out.println("Result: You Lose!!!");
                System.out.println("           ");
                c++;
            }
        }
        if(u>c){
            System.out.println("YOU WON THE GAME!!!!.");
        } else if (c == u) {
            System.out.println("GAME ENDED IN A DRAW.");

        }else if(c>u) {
            System.out.println("YOU LOST!! BETTER LUCK NEXT TIME.");
        }

    }

    public static void main(String[] args) {
        guessOption();
    }
}