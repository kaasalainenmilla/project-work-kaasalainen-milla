import util.*;
import java.io.*; 
import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        /* Initializing file reader */
        Console c = System.console(); 
        System.out.println("Input 1, if you want to add a new contact");
        System.out.println("Input 2 to view contacts");
        System.out.println("Input 3 to remove contact");
        System.out.println("Input 4 to update contact");
        int input = Integer.parseInt(c.readLine());
        int id = lines() + 1;
        if(input == 1) {
            newContact(id);
        }
        if(input == 2) {
            String line = null;
            try (BufferedReader file = new BufferedReader(new FileReader("contacts.txt"))){
                while((line = file.readLine()) != null) {
                    System.out.println(line);
                }
                file.close();
            }
            catch(IOException e)
            {
                System.out.println("Error");
            }
        }
        if(input == 3) {
            System.out.println("Which contact id do you wish to delete?");
            String number = c.readLine();
            remove(number);
        }
        if(input == 4) {
            System.out.println("Which contact id do you wish to update?");
            String number = c.readLine();
            update(number);
        }
    }
    public static int lines() {
        /* Getting id from number of lines */
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("contacts.txt"))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    public static void newContact(int id) {
        /* Creates a new contact */
        Console c = System.console(); 
        System.out.println("Please input contact first name");
        String fName = c.readLine();
        System.out.println("Please input contact last name");
        String lName = c.readLine();
        System.out.println("Please input contact phone number");
        String phone = c.readLine();
        System.out.println("Please input contact address");
        String address = c.readLine();
        System.out.println("Please input contact email address");
        String email = c.readLine();
        Contact input = new Contact(id, fName, lName, phone, address, email);
        System.out.println("New contact " + fName + " succesfully created");  
    }
    public static void remove(String number) {
        try {
            File inputFile = new File("contacts.txt");
            File tempFile = new File("contacts2.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String lineToRemove = number;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.startsWith(lineToRemove)){
                 continue;
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close(); 
            reader.close(); 
            inputFile.delete();
            boolean flag = tempFile.renameTo(inputFile);
            if (flag == true) {
                System.out.println("Contact deleted");
            } else {
                System.out.println("Operation Failed");
            }
        } catch (IOException e) {
                e.printStackTrace(); 
        }
    }
    public static void update(String number) {
        try {
            File inputFile = new File("contacts.txt");
            File tempFile = new File("contacts2.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String lineToUpdate = number;
            String currentLine;
            while((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if(trimmedLine.startsWith(lineToUpdate)){
                 continue;
                } else {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close(); 
            reader.close(); 
            inputFile.delete();
            boolean flag = tempFile.renameTo(inputFile);
            if (flag == true) {
                System.out.println("Please input new contact info");
            } else {
                System.out.println("Operation Failed");
            }
        } catch (IOException e) {
                e.printStackTrace(); 
        }
        int id = Integer.parseInt(number);
        newContact(id);
    }
}


