package com.company;

import java.util.Comparator;

public class LastNameComparator implements Comparator<AddressEntry>{
    public int compare(AddressEntry a1, AddressEntry a2) {
        return a1.getLastName().compareTo(a2.getLastName());
    }
}
