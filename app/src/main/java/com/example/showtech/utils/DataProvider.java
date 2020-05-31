package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;

public class DataProvider {

    private Context context;

    public static class computer{
        static String[] names = {"Alien", "Mac", "Hp", "Lenovo"};
        static String[][] descriptions = {{"The Alien gaming computer", ""}, {"The Mac computer", ""}, {"The Hp computer", ""}, {"The Lenovo computer", ""}};
        static String[] prices = {"3000", "2000", "200", "300"};
        static String[] imageIDs = {"alien_computer", "mac_computer", "hp_computer", "lenovo_computer"};

    }

    public DataProvider(Context context){
        this.context = context;
    }


    public ArrayList<Electronic> provideData(String category){
        ArrayList<Electronic> items = new ArrayList<>();

        for (int i = 0; i < computer.names.length; i++) {
            Electronic item = new Electronic();
            item.setName(computer.names[i]);
            item.setPrice(Float.parseFloat(computer.prices[i]));
            item.setDescription("$" + computer.prices[i] + " \n" + computer.descriptions[i][0]);
            ArrayList<Integer> images = new ArrayList<>();
            int id = context.getResources().getIdentifier(computer.imageIDs[i], "drawable", context.getPackageName());
            images.add(id);
            item.setImages(images);
            items.add(item);
        }

        return items;


    }

}
