package com.example.showtech.utils;

import com.example.showtech.Electronic;

import java.util.Comparator;

public class ItemComparator implements Comparator<Electronic> {

    @Override
    public int compare(Electronic o1, Electronic o2) {
        if(o1.getViews() > o2.getViews()){
            return -1;
        }
        else if(o1.getViews() < o2.getViews()){
            return 1;
        }
        return 0;
    }
}
