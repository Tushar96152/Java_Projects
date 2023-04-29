import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.*;

public class FileHandlingSignIn_SingUp{

    static void create(){
        File obj = new File("registration.txt");
        try
        {
            if (obj.createNewFile()) {

                System.out.println("File created");
            }
            else System.out.println("Already exists");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    static void write_file(String name , String password , String gmail){
        try {
            FileWriter fw = new FileWriter("registration.txt", true);
            fw.write(name +" , "+password+" , "+gmail+"\n");

            fw.close();

            System.out.println("successfully update data");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    static boolean read(String check){
        boolean ans=false;
        try {
            File fr= new File("registration.txt");
            Scanner sc = new Scanner(fr);

            while(sc.hasNextLine())
            {  String file_data = sc.nextLine();
                 //System.out.println(file_data);
                ans= file_data.contains(check);
            }
            sc.close();
        }
        catch(Exception ignored){

        }
        return ans;
    }

    static void delete(){
        File fd = new File("registration.txt");
        if(fd.delete()) {
            System.out.println("Data base deleted successfully");
        }
        else
        {
            System.out.println("not deleted");
        }
    }




}

