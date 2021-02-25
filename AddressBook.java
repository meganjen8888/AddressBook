package com.company;
import java.util.ArrayList;

class AddressBook {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }

    ArrayList<AddressEntry> addressEntryList = new ArrayList<AddressEntry>();

    public ArrayList iflistcontainsword(String word) {
        ArrayList<String> addressWithWord = new ArrayList<>();
        String line;
        for (int i = 0; i < addressEntryList.size(); i++) {
            if (addressEntryList.get(i).toString().contains(word)) {
                line = i + ". " + addressEntryList.get(i).toString();
                //System.out.println(line);
                addressWithWord.add(line);
                //System.out.println(line);
                //System.out.println();
            }
        }
        return addressWithWord;
    }

    public ArrayList<AddressEntry> list() {
        for (int i = 0; i < addressEntryList.size(); i++) {
            System.out.println(addressEntryList.get(i).toString());
            System.out.println();
        }
        return null;
    }
    public int length() {
        return addressEntryList.size();
        //return 0;
    }
    /**
     * @param addressEntry
     * **/
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }



}
