package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Collections;
import java.util.*;
import java.io.PrintWriter;
import java.util.Comparator;
import java.lang.Math;

/**
 * @author Megan Jen
 * @since ${January 19, 2021}
 *
 */


class AddressBookApplication {

    //private static AddressBook ad;
    private static AddressEntry a3;
    private static AddressEntry a4;


    /**
     * @param args
     **/

    public static void main(String args[]) throws Exception {
        //ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();
        AddressBook addressBook = new AddressBook();
        //initAddressBookExercise(addressBook);
        Scanner input = new Scanner(System.in);
        System.out.println("Enter choice");
        String choice = input.nextLine();
        switch (choice) {
            case "a":
                System.out.println("Enter in FileName");
                String file = input.nextLine();
                loadFromFile(file);
                System.out.print(" addresses, successfully loaded");
            case "b":
                //I'm gonna have to need an empty array and then add all of the shit in the file
                System.out.println("Enter in FileName");
                String filewrite = input.nextLine();
                System.out.println("First Name: ");
                String firstNameadd = input.nextLine();
                System.out.println("Last Name: ");
                String lastNameadd = input.nextLine();
                System.out.println("Street: ");
                String streetadd = input.nextLine();
                System.out.println("City: ");
                String cityadd = input.nextLine();
                System.out.println("State: ");
                String stateadd = input.nextLine();
                System.out.println("Zip: ");
                int zipadd = Integer.parseInt(input.nextLine());
                System.out.println("Phone: ");
                String phoneadd = input.nextLine();
                System.out.println("Email: ");
                String emailadd = input.nextLine();
                AddressEntry added = new AddressEntry(firstNameadd, lastNameadd, streetadd, cityadd, stateadd, zipadd, phoneadd, emailadd);
                try {
                    FileWriter selectedFile = new FileWriter(filewrite);
                    selectedFile.write(added.toString());
                    selectedFile.close();
                } catch (IOException e) {
                    System.out.println("An error occured.");
                    e.printStackTrace();
                }
            case "c":
                System.out.println("Enter in file: ");
                String fileName = input.nextLine();
                System.out.println("Enter in Last Name of contact to remove: ");
                String search = input.nextLine();
                if (instances(fileName, search) >= 1) {
                    System.out.println("Instances of word: " + instances(fileName, search));
                    System.out.println(linesWithWord(fileName, search));
                    System.out.println("Select the number of the address you would like to remove: ");
                    int number = Integer.parseInt(input.nextLine());
                    System.out.println("Hit y to remove the following entry or n to return to main menu");
                    String removefile = input.nextLine();
                    if (removefile == "y") {
                        for (int i = 0; i < linesWithWord(fileName, search).size(); i++) {
                            if (linesWithWord(fileName, search).get(i).toString().contains(String.valueOf(number))) {
                                String result = fileToString(fileName);
                                result = result.replaceAll(linesWithWord(fileName, search).get(i).toString(), "");
                                PrintWriter ughhhh = new PrintWriter(new File(fileName));
                                ughhhh.append(result);
                                ughhhh.flush();
                            }
                        }

                    }
                }
                else {
                    System.out.println("No matches");
                }
            case "d":
                System.out.println("Enter in file: ");
                String fileNamee = input.nextLine();
                System.out.println("Enter in Last Name of contact to find: ");
                String searchh = input.nextLine();
                if (instances(fileNamee, searchh) >= 1) {
                    System.out.println("Instances of word: " + instances(fileNamee, searchh));
                    System.out.println(linesWithWord(fileNamee, searchh));
                }
                else {
                    System.out.println("No matches");
                }
            case "e":
                System.out.println("Enter in file: ");
                String idonthavetimeokgeez = input.nextLine();
                Collections.sort(idkwhattodoanymore(idonthavetimeokgeez), new LastNameComparator());
                for (AddressEntry a : idkwhattodoanymore(idonthavetimeokgeez)) {
                    System.out.println(a);
                }



        }
        //init("filename.txt");

    }


    public static String fileToString(String filePath) throws Exception{
        String input = null;
        Scanner sc = new Scanner(new File(filePath));
        StringBuffer sb = new StringBuffer();
        while (sc.hasNextLine()) {
            input = sc.nextLine();
            sb.append(input);
        }
        return sb.toString();
    }

    public static ArrayList<AddressEntry> idkwhattodoanymore(String fileName) {
        //ArrayList<String> lineWithWord = new ArrayList<>();
        AddressBook ad = null;
        try {
            File f = new File(fileName);
            Scanner myReader = new Scanner(f);
            ad = new AddressBook();
            ArrayList<String> a5 = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                a5.add(data);
            }
            myReader.close();
            for (int j = 0; j < a5.size()/8; j++) {//iterating through a5
                a3 = new AddressEntry(a5.get(0+(8*j)), a5.get(1+(8*j)), a5.get(2+(8*j)), a5.get(3+(8*j)), a5.get(4+(8*j)), Integer.parseInt(a5.get(5+(8*j))), a5.get(6+(8*j)), a5.get(7+(8*j)));
                ad.add(a3);
            }
            a3 = null;


        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return ad.list();
    }

    public static int instances(String filename, String word) {
        int count = 0;
        try {
            File fil = new File(filename);
            Scanner reader = new Scanner(fil);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if(data.indexOf(word)!=-1) {
                    count = count + 1;
                }
            }
            //return (count);
            reader.close();
            //return count;
        }
    catch(
    FileNotFoundException e)
    {
        System.out.println("An error occured.");
        e.printStackTrace();
    }

        return count;
    }

    public static ArrayList<AddressEntry> linesWithWord(String fileName, String word) {
        //ArrayList<String> lineWithWord = new ArrayList<>();
        AddressBook ad = null;
        try {
            File f = new File(fileName);
            Scanner myReader = new Scanner(f);
            ad = new AddressBook();
            ArrayList<String> a5 = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                a5.add(data);
            }
            myReader.close();
            for (int j = 0; j < a5.size()/8; j++) {//iterating through a5
                a3 = new AddressEntry(a5.get(0+(8*j)), a5.get(1+(8*j)), a5.get(2+(8*j)), a5.get(3+(8*j)), a5.get(4+(8*j)), Integer.parseInt(a5.get(5+(8*j))), a5.get(6+(8*j)), a5.get(7+(8*j)));
                ad.add(a3);
            }
            a3 = null;


        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return ad.iflistcontainsword(word);
    }



    public static int loadFromFile(String filename) {
        AddressBook ad = null;
        try {
            File f = new File(filename);
            Scanner myReader = new Scanner(f);
            ad = new AddressBook();
            ArrayList<String> a5 = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                a5.add(data);
            }
            myReader.close();
            for (int j = 0; j < a5.size()/8; j++) {//iterating through a5
                a3 = new AddressEntry(a5.get(0+(8*j)), a5.get(1+(8*j)), a5.get(2+(8*j)), a5.get(3+(8*j)), a5.get(4+(8*j)), Integer.parseInt(a5.get(5+(8*j))), a5.get(6+(8*j)), a5.get(7+(8*j)));
                ad.add(a3);
            }
            a3 = null;

        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        return ad.length();
    }
    /**
     * @param ab
     * **/

    public static void initAddressBookExercise(AddressBook ab) {
        AddressEntry a1 = new AddressEntry("john", "doe", "street1", "city1", "state1", 69, "email1", "phone1");
        ab.add(a1);
        AddressEntry a2 = new AddressEntry("jane", "doe", "street2", "city2", "state2", 420, "email2", "phone2");
        ab.add(a2);
        ab.list();
    }
    public static void init(String filename) {
        AddressBook ad;
        try {
        File f = new File(filename);
        Scanner myReader = new Scanner(f);
            ad = new AddressBook();
        ArrayList<String> a5 = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            a5.add(data);
        }
        myReader.close();
        for (int j = 0; j < a5.size()/8; j++) {//iterating through a5
            a3 = new AddressEntry(a5.get(0+(8*j)), a5.get(1+(8*j)), a5.get(2+(8*j)), a5.get(3+(8*j)), a5.get(4+(8*j)), Integer.parseInt(a5.get(5+(8*j))), a5.get(6+(8*j)), a5.get(7+(8*j)));
            ad.add(a3);
        }
        a3 = null;
        ad.list();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }




}