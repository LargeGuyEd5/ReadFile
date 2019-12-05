import sun.security.krb5.internal.crypto.Des;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class main{

    public static void SearchByTerm() throws IOException{
        FileReader fr = new FileReader("C:\\Users\\Edi\\Desktop\\computingTerms.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner input = new Scanner(System.in);
        System.out.println("Term..? ");
        String TERM = input.nextLine();
        System.out.println(TERM);
        boolean found = false;
        String Desc = "";

        String line = br.readLine();
        do {
            if (line.equals(TERM)){
                found = true;
                Desc = br.readLine();
            }
        } while ((line = br.readLine()) != null);

        if(found == true){
            System.out.println("FOUND... ");
            System.out.println(Desc);
        } else
            System.out.println("TERM NOT FOUND");

        br.close();
    }

    public static void SearchByDescription() throws IOException{
        FileReader fr = new FileReader("C:\\Users\\Edi\\Desktop\\computingTerms.txt");
        BufferedReader br = new BufferedReader(fr);
        Scanner input = new Scanner(System.in);
        System.out.println("Term..? ");
        String TERM = input.nextLine();
        System.out.println(TERM);
        boolean found = false;
        String Desc = "";
        String keyWord = "";

        String content[] = new String[20];
        for (int i = 0; i < 20; i++){
            content[i] = br.readLine();
        }

        for (int j = 0; j < 20; j++){
            if (content[j].contains(TERM)) {
                Desc = content[j];
                keyWord = content[j -1];
                System.out.println("Found for " + keyWord);
                System.out.println(Desc);
                found = true;
            }
        }

        if (found == false){
            System.out.println("NO DESCRIPTIONS FOUND containing this key word");
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("1. Search for a term" + "\n" + "2. Search for a keyword in the descriptions" + "\n" + "3.End" + "\n" + "Key in choice");
        Scanner input = new Scanner(System.in);
        int keyInChoice = input.nextInt();
        if (keyInChoice == 1){
            SearchByTerm();
        } else if (keyInChoice == 2){
            SearchByDescription();
        } else
            exit(0);
        //commited
    }
}