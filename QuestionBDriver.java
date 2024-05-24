import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuestionBDriver {
    public static void main(String[] args){
        try {
            File base10database = new File("numbers.txt");
            Scanner fileReader = new Scanner(base10database);

            while (fileReader.hasNextLine()) {
                int base10num = fileReader.nextInt();


                System.out.print(base10num + " in binary is: ");
                printBinary(base10num);
                System.out.println();


            }
        }catch (FileNotFoundException e){
            System.out.println("file does not exist on your computer :-(");
        }
        catch (Exception e){
            System.out.println("Achievement unlocked: \"how did we get here?\"");
            System.out.println(e.getMessage());
        }

    }

    public static void printBinary(int base10Num){
        //base case
        if(base10Num <=0){
            return;
        }



        //recursive case



        printBinary(base10Num/2);
        System.out.print(base10Num%2); //last recursive call gets you the first digit of the binary sequence. This is why you need to put the sout after the recursive call.
    }
}
