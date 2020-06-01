package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class DataProvider {

    private Context context;

    
    public static class electronicData{
        static String[][] computers = {
                {"Alien","3000", "alien_computer", "The Alien gaming computer"},
                {"Mac", "2000", "mac_computer", "The Mac computer"},
                {"Hp", "2000", "hp_computer", "The Hp computer"},
                {"Lenovo", "300", "lenovo_computer", "The Lenovo computer"}
        };

        static String[][] mobile_phone = {

        };

        static String[][] music = {

        };

        static String[][] camera = {

        };

        static String[][] gaming = {

        };

    }




    public DataProvider(Context context){
        this.context = context;
    }


    public ArrayList<Electronic> provideData(String category){
        ArrayList<Electronic> items = new ArrayList<>();
        String[][] data = {};
        switch (category.toLowerCase()) {
            case "computer":
                data = electronicData.computers;
                break;
            case "mobile_phone":
                data = electronicData.mobile_phone;
                break;
            case "music":
                data = electronicData.music;
                break;
            case "camera":
                data = electronicData.camera;
                break;
            case "gaming":
                data = electronicData.gaming;
                break;
            case "top selling":
                data = electronicData.computers;
                break;
        }

        for (String[] d : data) {
            Electronic item = new Electronic();
            item.setName(d[0]);
            item.setPrice(Float.parseFloat(d[1]));
            ArrayList<Integer> images = new ArrayList<>();
            String[] imagesIDs = d[2].split(" ");
            for (String s : imagesIDs) {
                int id = context.getResources().getIdentifier(s, "drawable", context.getPackageName());
                images.add(id);
            }
            item.setImages(images);
            item.setDescription(d[3]);

            items.add(item);
        }

        return items;
    }

}
