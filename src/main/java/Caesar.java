import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        String converted = "";
        for (int i = 0; i<message.length();i++) {
            if (((message.charAt(i)>=65) && (message.charAt(i)<=90-3))||((message.charAt(i)>=97) && (message.charAt(i)<=122-3))) converted += (char)(message.charAt(i)+3);
            else if (((message.charAt(i)>90-3) && (message.charAt(i)<=90))||((message.charAt(i)>122-3) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-(26-3));
            else converted += (char)(message.charAt(i));
        }
        return converted;
    }

    public static String decryptCaesar(String message) {
        String converted = "";
        for (int i = 0; i<message.length();i++) {
            if (((message.charAt(i)>=65+3) && (message.charAt(i)<=90))||((message.charAt(i)>=97+3) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-3);
            else if (((message.charAt(i)>=65) && (message.charAt(i)<=90))||((message.charAt(i)>=97) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)+(26-3));
            else converted += (char)(message.charAt(i));
        }
        return converted;
    }

    public static String encryptCaesarKey(String message, int key) {
        if (key>26) key = key%26;
        String converted = "";
        for (int i = 0; i<message.length();i++) {
            if (((message.charAt(i)>=65) && (message.charAt(i)<=90-key))||((message.charAt(i)>=97) && (message.charAt(i)<=122-key))) converted += (char)(message.charAt(i)+key);
            else if (((message.charAt(i)>90-key) && (message.charAt(i)<=90))||((message.charAt(i)>122-key) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-(26-key));
            else converted += (char)(message.charAt(i));
        }
        return converted;
    }

    public static String decryptCaesarKey(String message, int key) {
        if (key>26) key = key%26;
        String converted = "";
         for (int i = 0; i<message.length();i++) {
            if (((message.charAt(i)>=65+key) && (message.charAt(i)<=90))||((message.charAt(i)>=97+key) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)-key);
            else if (((message.charAt(i)>=65) && (message.charAt(i)<=90))||((message.charAt(i)>=97) && (message.charAt(i)<=122))) converted += (char)(message.charAt(i)+(26-key));
            else converted += (char)(message.charAt(i));
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
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
