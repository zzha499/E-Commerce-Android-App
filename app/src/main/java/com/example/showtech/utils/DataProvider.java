package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.items.Electronic;

import java.util.ArrayList;

public class DataProvider {

    private Context context;

    public static class electronicData {
        static String[][] computers = {
                {"Alien", "100", "alien_computer", "The Alien gaming computer The Alien gaming computer The Alien gaming computer The Alien gaming computer The Alien gaming computer "},
                {"Mac", "2000", "mac_computer", "The Mac computer"},
                {"Hp", "2000", "hp_computer", "The Hp computer"},
                {"Lenovo", "300", "lenovo_computer", "The Lenovo computer"},
                {"Acer", "100", "acer_1 acer_2 acer_3", "The Alien gaming computer"},
                {"Asus", "2000", "asus_rog_1", "The Mac computer"},
                {"Dell", "2000", "xps_1", "The Hp computer"},
                {"MacBook Pro", "300", "mbp_16_1", "The Lenovo computer"},
                {"MacBook Air", "300", "mb_air_2", "The Lenovo computer"},
                {"iPad Pro 2020", "100", "ipad_pro_1", "The Alien gaming computer"}
        };

        static String[][] mobile_phone = {
                {"iPhone SE", "100", "iphone_se_1", "The Alien gaming computer"},
                {"iPhone 11", "2000", "iphone11_1", "The Mac computer"},
                {"iPhone 11 Pro", "2000", "iphone11p_1", "The Hp computer"},
                {"Huawei Mate 30", "300", "mate30_1", "The Lenovo computer"},
                {"Huawei Mate Xs", "100", "matexs_1", "The Alien gaming computer"},
                {"Xiaomi Mi 10", "2000", "mi10_1", "The Mac computer"},
                {"OnePlus 8 Pro", "2000", "oneplus_8_1", "The Hp computer"},
                {"Huawei P40 Pro", "300", "p40_1", "The Lenovo computer"},
                {"Samsung S20", "300", "s20_1", "The Lenovo computer"},
                {"Oppor Find X2", "100", "findx2_2", "The Alien gaming computer"}
        };

        static String[][] music = {
                {"Beats Wireless Solo", "100", "beats_solo_1", "The Alien gaming computer"},
                {"Bose Noise Cancelling", "2000", "bose_1", "The Mac computer"},
                {"AirPods Pro", "2000", "airpodspro_1", "The Hp computer"},
                {"Sennheiser", "300", "sennheiser_1", "The Lenovo computer"},
                {"Sennheiser CX", "100", "sennheiser_cx_1", "The Alien gaming computer"},
                {"Sonos Speaker", "2000", "sonos_subgen3_1", "The Mac computer"},
                {"Sony Headphone", "2000", "sony_wh1000xm3_1", "The Hp computer"},
                {"Panasonic Headphone", "300", "panasonicsc_1", "The Lenovo computer"},
                {"JBL Headphone", "300", "jbl_head_1", "The Lenovo computer"},
                {"JBL Pulse-4", "100", "jbl_pulse4_1", "The Alien gaming computer"}
        };

        static String[][] camera = {
                {"Canon Camera", "100", "canon_eos_1500d", "The Alien gaming computer"},
                {"Canon lens", "2000", "canon_efs_250mm", "The Mac computer"},
                {"Canon PowerShot", "2000", "canon_powershot_g7x_iii", "The Hp computer"},
                {"Joby-GorillaPod", "300", "joby_gorillapod", "The Lenovo computer"},
                {"DJI-Ronin-S", "100", "dji_ronin_s", "The Alien gaming computer"},
                {"Nikon", "2000", "nikon_af_50mm", "The Mac computer"},
                {"Nikon-D3500", "2000", "nikon_d3500", "The Hp computer"},
                {"Olympus-OM-D", "300", "olympus_om_d", "The Lenovo computer"},
                {"Sony-WX800b", "300", "sony_wx800b", "The Lenovo computer"},
                {"GoPro-Max360", "100", "gopro_max360", "The Alien gaming computer"}
        };

        static String[][] gaming = {
                {"Xbox One", "100", "xbox_1", "The Alien gaming computer"},
                {"Nintendo Switch", "2000", "switch_1", "The Mac computer"},
                {"PS4", "2000", "ps4_1", "The Hp computer"},
                {"PlayStation VR", "300", "ps_vr_1", "The Lenovo computer"},
                {"PlayStation Move", "100", "ps_move_1", "The Alien gaming computer"},
                {"PS4 Pro", "2000", "ps4pro_1", "The Mac computer"},
                {"SpongeBob Game", "2000", "spongebob_1", "The Hp computer"},
                {"Nintendo Switch", "300", "switch_lite_1", "The Lenovo computer"},
                {"StarWar Game", "300", "starwar_1", "The Lenovo computer"},
                {"Avengers Game", "100", "avengers_1", "The Alien gaming computer"}
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
            case "mobile phone":
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
                data = combine(electronicData.mobile_phone, electronicData.computers);
                break;
            case "all":
                data = combine(combine(combine(combine(electronicData.computers, electronicData.mobile_phone), electronicData.music), electronicData.camera), electronicData.gaming);
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

    private static String[][] combine(String[][] a, String[][] b){
        int length = a.length + b.length;
        String[][] result = new String[length][];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

}
