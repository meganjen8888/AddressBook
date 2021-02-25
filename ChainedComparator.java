package com.company;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ChainedComparator implements ChainedComparatorr {
    private List<Comparator<AddressEntry>>listComparators;

    @SafeVarargs
    public ChainedComparator(Comparator<AddressEntry>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(AddressEntry a1, AddressEntry a2) {
        for (Comparator<AddressEntry> comparator : listComparators) {
            int result = comparator.compare(a1, a2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
