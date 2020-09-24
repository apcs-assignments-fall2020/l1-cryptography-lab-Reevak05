import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        String converted = "";
        int j = 0;
        for (int i = 0; i<message.length();i++) {
            if ((message.charAt(i)>=65) && (message.charAt(i)<=90-(key.charAt(j%key.length())-65))||((message.charAt(i)>=97) && (message.charAt(i)<=122-(key.charAt(j%key.length())-65)))) converted += (char)(message.charAt(i)+(key.charAt(j%key.length())-65));
            else if (((message.charAt(i)>90-(key.charAt(j%key.length())-65)) && (message.charAt(i)<=90))||((message.charAt(i)>122-(key.charAt(j%key.length())-65)) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-(26-(key.charAt(j%key.length())-65)));
            else {
                converted += (char)(message.charAt(i));
                j-=1;
            }
            j++;
        }
        return converted;
    }

    public static String decryptVigenere(String message, String key) {
        String converted = "";
        int j = 0;
        for (int i = 0; i<message.length();i++) {
            if ((message.charAt(i)>=65+(key.charAt(j%key.length())-65)) && (message.charAt(i)<=90)||((message.charAt(i)>=97+(key.charAt(j%key.length())-65)) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-(key.charAt(j%key.length())-65));
            else if (((message.charAt(i)>=65) && (message.charAt(i)<=90))||((message.charAt(i)>=97) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)+(26-(key.charAt(j%key.length())-65)));
            else {
                converted += (char)(message.charAt(i));
                j-=1;
            }
            j++;
        }
        return converted;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
