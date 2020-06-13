package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.Electronic;

import java.util.ArrayList;

public class DataProvider {

    private Context context;

    public static class electronicData {
        static String[][] computers = {
                {"Alienware M15", "2974", "alien_1 alien_2 alien_3", "The Alien gaming computer The Alien gaming computer The Alien gaming computer The Alien gaming computer The Alien gaming computer "},
                {"Microsoft Surface Book", "3799", "surface_1 surface_2 surface_3", "The Mac computer"},
                {"Hp", "999", "hp_1 hp_2 hp_3", "The Hp computer"},
                {"Lenovo", "1999", "lenovo_1 lenovo_2 lenovo_3", "The Lenovo computer"},
                {"Acer", "3244", "acer_1 acer_2 acer_3", "The Acer Predator computer"},
                {"Asus", "1599", "asus_rog_1 asus_rog_2 asus_rog_3", "The Asus gaming computer"},
                {"Dell", "3699", "xps_1 xps_2 xps_3", "The Dell XPS 17"},
                {"MacBook Pro", "4999", "mbp_16_1 mbp_16_1 mbp_16_1", "The MacBook Pro 16"},
                {"MacBook Air", "1799", "mb_air_2 mb_air_1 mb_air_3", "The MacBook Air"},
                {"iPad Pro 2020", "1499", "ipad_pro_1 ipad_pro_2 ipad_pro_3", "The iPad Pro 2020"}
        };

        static String[][] mobile = {
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
                {"Xbox One", "399", "xbox_1 xbox_2 xbox_3", "\nXbox One X 1TB Console:\n" +
                        "Games play better on Xbox One X. Experience 40% more power than any other console.\n" +
                        "6 teraflops of graphical processing power and a 4K Blu-ray player provide more immersive gaming and entertainment1\n" +
                        "Play with the greatest community of gamers on the most advanced multiplayer network4\n" +
                        "Works with all your Xbox One games and accessories\n" +
                        "Great for 1080p screens—games run smoothly, look great, and load quickly\n"},
                {"Nintendo Switch", "529", "switch_1 switch_2 switch_3", "\nNintendo Switch Console Neon:\n" +
                        "Size: Approximately 4 inches high, 9.4 inches long, and 0.55 inches deep (with Joy-Con attached)\n" +
                        "Weight: Approximately .66 lbs\n" +
                        "(Approximately .88 lbs when Joy-Con controllers are attached)\n" +
                        "Screen: Multi-touch capacitive touch screen / 6.2-inch LCD Screen / 1280 x 720\n" +
                        "CPU/GPU: NVIDIA Custom Tegra processor\n" +
                        "Storage: 32 GB of internal storage, a portion of which is reserved for use by the system. Users can easily expand storage space using microSDHC or microSDXC cards up to 2TB (sold separately).Released on 09/08/2019\n"},
                {"PS4", "469", "ps4_1 ps4_2 ps4_3", "\nPS4 PlayStation 4 500GB Console Glacier White:\n" +
                        "Store your games, apps, screenshots and videos with 500GB and 1TB models – slimmer and lighter than the original PS4 model and available in Jet Black, Glacier White and now stunning Gold and Silver.\n" +
                        "Experience incredibly vivid, vibrant colours with breathtaking HDR visuals.\n" +
                        "Organise your games and apps and share with friends from a new, intuitive interface.\n" +
                        "Store your games, apps, screenshots and videos with 500GB and 1TB options.\n" +
                        "All the greatest TV, movies and more from your favourite entertainment apps.\n"},
                {"PlayStation VR", "319", "ps_vr_1 ps_vr_2 ps_vr_3", "\nPlayStation VR with Camera and Game Bundle (V4):\n" +
                        "5.7” OLED screen\n" +
                        "See hyper-real 3D environments come to life with a custom OLED screen.\n" +
                        "360-degree vision\n" +
                        "Whichever way you turn the 360-degree immersion of PS VR makes you part of a living, breathing world with a seamless field of view.\n" +
                        "120 frames per second\n" +
                        "Smooth visuals and super low latency combine to create an incredibly immersive gaming world.\n" +
                        "3D audio\n" +
                        "Discover a new dimension in sound with cutting-edge 3D audio that lets you accurately perceive the direction and distance of sounds that are coming from above, below and all around you.\n" +
                        "Built in mic\n" +
                        "Chat to your online friends, discuss in-game tactics and strengthen your immersion in the virtual world with the headset’s integrated microphone.\n"},
                {"PlayStation Move", "129", "ps_move_1 ps_move_2 ps_move_3", "\nPS4 PlayStation Move Twin Pack:\n" +
                        "Ergonomic, intuitive design - Thanks to a lightweight design, built-in vibration function and sphere that’s tracked by the PlayStation Camera as you move, the controller acts and feels like an extension of your own hand, allowing you to intuitively interact with a game’s virtual environment.\n" +
                        "Take total control - On top of its motion-sensing capabilities, the controller features easy-to-use button controls – including a large, dedicated trigger and the familiar DUALSHOCK 4 PS and action buttons.\n" +
                        "Wide variety of compatible PlayStation VR games - Combine PlayStation VR with the motion controller for truly unique experiences – once you slip on the headset, motion controllers in your hands become anything, from guns and pool cues to your own virtual hands.\n"},
                {"PS4 Pro", "639", "ps4pro_1 ps4pro_2 ps4pro_3", "\nPS4 PlayStation 4 Pro 1TB Limited Edition The Last of Us Part II Bundle:\n" +
                        "On PS4™Pro, 4K TV owners can explore the post-pandemic United States in stunning visual quality. HD TV owners will benefit from the game’s built-in supersampling with increased image clarity and detail. Meanwhile, players whose TVs support high dynamic range (HDR), will notice improved lighting and contrast – helping immerse themselves further in this dangerous world.\n"},
                {"SpongeBob Game", "279", "spongebob_1 spongebob_2 spongebob_3", "\nSpongeBob Squarepants: Battle for Bikini Bottom Rehydrated (Shiny Edition):\n" +
                        "Play as SpongeBob, Patrick and Sandy and use their unique sets of skills\n" +
                        "Thwart Plankton's evil plan to rule Bikini Bottom with his army of wacky robots\n" +
                        "Meet countless characters from the beloved series\n" +
                        "Faithful remake of one of the best SpongeBob games ever created\n" +
                        "High-end visuals, modern resolutions and carefully polished gameplay\n" +
                        "Brand new horde mode multiplayer for up to two players, online and splitscreen\n" +
                        "Restored content that was cut from the original game like the Robo Squidward boss fight and more\n"},
                {"Nintendo Switch lite", "369", "switch_lite_1 switch_lite_2 switch_lite_3", "\nNintendo Switch Lite Console:\n" +
                        "Nintendo Switch Lite is designed specifically for handheld play—so you can jump into your favourite games wherever you happen to be. Released on 20/09/2019\n"},
                {"StarWar Game", "99", "starwar_1 starwar_2 starwar_3", "\nLego Star Wars The Skywalker Saga\n" +
                        "Format ‐ PlayStation 4\n" +
                        "Genre ‐ Action & Adventure\n" +
                        "Rating ‐ CTC\n" +
                        "Consumer Advice ‐ CTC Check the classification\n" +
                        "Release Date ‐ 31/12/20\n"},
                {"Avengers Game", "94", "avengers_1 avengers_2 avengers_3", "\nMarvel's Avengers:\n" +
                        "Format ‐ PlayStation 4\n" +
                        "Genre ‐ Action & Adventure\n" +
                        "Rating ‐ CTC\n" +
                        "Consumer Advice ‐ CTC Check the classfication\n" +
                        "Release Date ‐ 04/09/20\n"}
        };
    }

    public DataProvider(Context context){
        this.context = context;
    }


    public ArrayList<Electronic> provideData(String category){
        ArrayList<Electronic> items = new ArrayList<>();
        String[][] data = {};
        ElectronicType type = ElectronicType.UNKNOWN;
        switch (category.toLowerCase()) {
            case "computer":
                data = electronicData.computers;
                type = ElectronicType.COMPUTER;
                break;
            case "mobile":
                data = electronicData.mobile;
                type = ElectronicType.MOBILE;
                break;
            case "music":
                data = electronicData.music;
                type = ElectronicType.MUSIC;
                break;
            case "camera":
                data = electronicData.camera;
                type = ElectronicType.CAMERA;
                break;
            case "gaming":
                data = electronicData.gaming;
                type = ElectronicType.GAMING;
                break;
            case "all":
                ArrayList<Electronic> allItems = new ArrayList<>();
                allItems.addAll(provideData("computer"));
                allItems.addAll(provideData("mobile"));
                allItems.addAll(provideData("camera"));
                allItems.addAll(provideData("music"));
                allItems.addAll(provideData("gaming"));
                return allItems;
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
            item.setElectronicType(type);

            items.add(item);
        }

        return items;
    }


}
