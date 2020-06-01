package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;

public class DataProvider {

    private Context context;

    public static class computer{
        static String[] names = {"Alien", "Mac", "Hp", "Lenovo","Acer", "Asus", "Dell", "MackBook Pro","MacBook Air", "iPad Pro"};
        static String[][] descriptions = {{"The Alien gaming computer", ""}, {"The Mac computer", ""}, {"The Hp computer", ""}, {"The Lenovo computer", ""},
                                            {"The Acer computer", ""}, {"The Asus computer", ""}, {"The Dell computer", ""}, {"The MackBook Pro", ""}, {"The MacBook Air", ""}, {"The iPad Pro", ""}};

        static String[] prices = {"3000", "2000", "200", "300","100","100","100","100","100","100"};
        static String[] imageIDs = {"alien_computer", "mac_computer", "hp_computer", "lenovo_computer","acer_1_computer","asus_rog_1_computer","xps_1","mbp_16_1","mb_air_2","ipad_pro_1"};
    }



    public static class Mobile_phone{
        static String[] names = {"iPhone SE", "iPhone 11", "iPhone 11 Pro", "Huawei Mate 30","Huawei Mate XS", "Xiaomi Mi 10", "OnePlus 8 Pro", "Huawei P40 Pro","Samsung S20", "Oppo Find X2"};
        static String[][] descriptions = {{"This is", ""}, {"This is", ""}, {"This is", ""}, {"This is", ""},
                {"This is", ""}, {"This is", ""}, {"This is", ""}, {"This is", ""}, {"This is", ""}, {"This is", ""}};

        static String[] prices = {"3000", "2000", "200", "300","100","100","100","100","100","100"};
        static String[] imageIDs = {"iphone_se_1", "iphone_11_1", "iphone_11_p_1", "mate30_1","matexs_1","mi_10_1","oneplus_8_1","p40_1","s20_1","findx2_2"};
    }



    public static class Gaming{
        static String[] names = {"Alien", "Mac", "Hp", "Lenovo","Acer", "Asus", "Dell", "MackBook Pro","MacBook Air", "iPad Pro"};
        static String[][] descriptions = {{"The Alien gaming computer", ""}, {"The Mac computer", ""}, {"The Hp computer", ""}, {"The Lenovo computer", ""},
                {"The Acer computer", ""}, {"The Asus computer", ""}, {"The Dell computer", ""}, {"The MackBook Pro", ""}, {"The MacBook Air", ""}, {"The iPad Pro", ""}};

        static String[] prices = {"3000", "2000", "200", "300","100","100","100","100","100","100"};
        static String[] imageIDs = {"xbox_1", "switch_1", "ps4_1", "ps_vr_1","ps_move_1","ps4pro_1","spongebob_1","switch_lite_1","starwar_1","avengers_1"};
    }

    public static class Music{
        static String[] names = {"Alien", "Mac", "Hp", "Lenovo","Acer", "Asus", "Dell", "MackBook Pro","MacBook Air", "iPad Pro"};
        static String[][] descriptions = {{"The Alien gaming computer", ""}, {"The Mac computer", ""}, {"The Hp computer", ""}, {"The Lenovo computer", ""},
                {"The Acer computer", ""}, {"The Asus computer", ""}, {"The Dell computer", ""}, {"The MackBook Pro", ""}, {"The MacBook Air", ""}, {"The iPad Pro", ""}};

        static String[] prices = {"3000", "2000", "200", "300","100","100","100","100","100","100"};
        static String[] imageIDs = {"beats_solo_1", "bose_1", "airpods_pro_1", "sennheiser_1","sennheiser_cx_1","sonos_subgen3_1","sony_wh1000xm3_1","panasonic_sc_1","jbl_head_1","jbl_pulse4_1"};
    }

    public static class Camera{
        static String[] names = {"Alien", "Mac", "Hp", "Lenovo","Acer", "Asus", "Dell", "MackBook Pro","MacBook Air", "iPad Pro"};
        static String[][] descriptions = {{"The Alien gaming computer", ""}, {"The Mac computer", ""}, {"The Hp computer", ""}, {"The Lenovo computer", ""},
                {"The Acer computer", ""}, {"The Asus computer", ""}, {"The Dell computer", ""}, {"The MackBook Pro", ""}, {"The MacBook Air", ""}, {"The iPad Pro", ""}};

        static String[] prices = {"3000", "2000", "200", "300","100","100","100","100","100","100"};
        static String[] imageIDs = {"canon_eos_1500d", "canon_efs_250mm", "canon_powershot_g7x", "","joby_gorillapod","dji_ronin_s","nikon_af_50mm","nikon_d3500","olympus_om_d","mb_air_2","ipad_pro_1"};
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
