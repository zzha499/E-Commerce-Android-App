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
                {"Acer", "3244", "acer_1 acer_2 acer_3", "The Acer Predator computer"},
                {"Asus", "1599", "asus_rog_1 asus_rog_2 asus_rog_3", "The Asus gaming computer"},
                {"Dell", "3699", "xps_1 xps_2 xps_3", "The Dell XPS 17"},
                {"MacBook Pro", "4999", "mbp_16_1 mbp_16_1 mbp_16_1", "The MacBook Pro 16"},
                {"MacBook Air", "1799", "mb_air_2 mb_air_1 mb_air_3", "The MacBook Air"},
                {"iPad Pro 2020", "1499", "ipad_pro_1 ipad_pro_2 ipad_pro_3", "The iPad Pro 2020"}
        };

        static String[][] mobile_phone = {
                {"iPhone SE", "799", "iphone_se_1 iphone_se_2 iphone_se_3", "New iPhone SE"},
                {"iPhone 11", "1349", "iphone11_1 iphone11_2 iphone11_3", "iPhone 11"},
                {"iPhone 11 Pro", "1949", "iphone11p_1 iphone11p_2 iphone11p_3", "iPhone 11 Pro"},
                {"Huawei Mate 30", "998.99", "mate30_1 mate30_2 mate30_3", "Huawei Mate 30 Pro"},
                {"Huawei Mate Xs", "3999", "matexs_1 matexs_2 matexs_3", "Huawei Mate XS 5G"},
                {"Xiaomi Mi 10", "998.99", "mi10_1 mi10_2 mi10_3", "Xiaomi Mi 10"},
                {"OnePlus 8 Pro", "1779", "oneplus_8_1 oneplus_8_2 oneplus_8_3", "OnePlus 8"},
                {"Huawei P40 Pro", "1499", "p40_1 p40_2 p40_3", "Huawei P40 Pro"},
                {"Samsung S20", "1399", "s20_1 s20_2 s20_3", "Samsung S20 128G"},
                {"Oppor Find X2", "1899", "findx2_2 findx2_1 findx2_3", "Oppor Find X2 Pro"}
        };

        static String[][] music = {
                {"Beats Wireless Solo", "499", "beats_solo_1 beats_solo_2 beats_solo_3", "The Beats Solo Pro"},
                {"Bose", "699", "bose_1 bose_2 bose_3", "The Bose Noise Cancelling Headphone"},
                {"AirPods Pro", "449", "airpodspro_1 airpodspro_2 airpodspro_3", "Apple AirPods Pro"},
                {"Sennheiser", "550", "sennheiser_1 sennheiser_2 sennheiser_3", "Sennheiser Headphone"},
                {"Sennheiser CX", "119.95", "sennheiser_cx_1 sennheiser_cx_2 sennheiser_cx_3", "Sennheiser CX 150"},
                {"Sonos Speaker", "1199", "sonos_subgen3_1 sonos_subgen3_2 sonos_subgen3_3", "Sonos Sub Generation 3"},
                {"Sony Headphone", "449", "sony_wh1000xm3_1 sony_wh1000xm3_2 sony_wh1000xm3_3", "Sony Bass Headphone-wh1000xm3"},
                {"Panasonic Headphone", "417", "panasonicsc_1 panasonicsc_2 panasonicsc_3", "Panasonic Headphone: SC-TMAX20GSK"},
                {"JBL Headphone", "239.99", "jbl_head_1 jbl_head_2 jbl_head_3", "The JBL headphone"},
                {"JBL Pulse-4", "369.00", "jbl_pulse4_1 jbl_pulse4_2 jbl_pulse4_3", "Amazing speaker"}
        };

        static String[][] camera = {
                {"Canon Camera", "699", "canon_eos_1500d canon_eos_1500d_2 canon_eos_1500d_3", "The Alien gaming computer"},
                {"Canon lens", "499", "canon_efs_250mm canon_efs_250mm_2 canon_efs_250mm_3", "Canon EFS lens, 250mm"},
                {"Canon PowerShot", "999", "canon_powershot_g7x_iii canon_powershot_g7x_iii_2 canon_powershot_g7x_iii_3", "The Hp computer"},
                {"Joby-GorillaPod", "143", "joby_gorillapod joby_gorillapod_2 joby_gorillapod_3", "The Lenovo computer"},
                {"DJI-Ronin-S", "1199", "dji_ronin_s dji_ronin_s_2 dji_ronin_s_3", "The Alien gaming computer"},
                {"Nikon", "399", "nikon_af_50mm nikon_af_50mm_2 nikon_af_50mm_3", "The Mac computer"},
                {"Nikon-D3500", "799", "nikon_d3500 nikon_d3500_2 nikon_d3500_3", "The Hp computer"},
                {"Olympus-OM-D", "1499", "olympus_om_d olympus_om_d_2 olympus_om_d_3", "The Lenovo computer"},
                {"Sony-WX800b", "960", "sony_wx800b sony_wx800b_2 sony_wx800b_3", "The Lenovo computer"},
                {"GoPro-Max360", "869", "gopro_max360 gopro_max360_2 gopro_max360_3", "The Alien gaming computer"}
        };

        static String[][] gaming = {
                {"Xbox One", "399", "xbox_1 xbox_2 xbox_3", "The Alien gaming computer"},
                {"Nintendo Switch", "529", "switch_1 switch_2 switch_3", "The Mac computer"},
                {"PS4", "469", "ps4_1 ps4_2 ps4_3", "The Hp computer"},
                {"PlayStation VR", "319", "ps_vr_1 ps_vr_2 ps_vr_3", "The Lenovo computer"},
                {"PlayStation Move", "129", "ps_move_1 ps_move_2 ps_move_3", "The Alien gaming computer"},
                {"PS4 Pro", "639", "ps4pro_1 ps4pro_2 ps4pro_3", "The Mac computer"},
                {"SpongeBob Game", "279", "spongebob_1 spongebob_2 spongebob_3", "The Hp computer"},
                {"Nintendo Switch lite", "369", "switch_lite_1 switch_lite_2 switch_lite_3", "The Lenovo computer"},
                {"StarWar Game", "99", "starwar_1 starwar_2 starwar_3", "The Lenovo computer"},
                {"Avengers Game", "94", "avengers_1 avengers_2 avengers_3", "The Alien gaming computer"}
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
