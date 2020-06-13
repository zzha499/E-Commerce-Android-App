package com.example.showtech.utils;

import android.content.Context;
import com.example.showtech.Electronic;

import java.util.ArrayList;

public class DataProvider {

    private Context context;

    public static class electronicData {
        static String[][] computers = {
                {"Alienware M15", "2974", "alien_1 alien_2 alien_3", "\nALIENWARE M15 R3 GAMING LAPTOP: Alienware’s most thin and powerful 15\" laptop ever. Now with the option for up to 10th gen Intel Core i9k processors with up to 12-phase Hyper Efficient Voltage regulation."},
                {"Microsoft Surface Book", "3799", "surface_1 surface_2 surface_3", "\nMicrosoft Surface Book 3 13.5\" i7 256GB:\n" +
                        "Most powerful Surface laptop yet, with quad-core powered, 10th Gen Intel Core processors\n" +
                        "Fastest graphics on Surface, powered by NVIDIA® GTX GeForce GPU\n" +
                        "Power when you need it. Up to 15.5 hours1 battery life\n"},
                {"HP Laptop", "999", "hp_1 hp_2 hp_3", "\n15.6\" HD SVA BrightView micro-edge WLED-backlit display\n" +
                        "AMD A9-9425 dual-core processor (1MB cache, 3.1GHz up to 3.7GHz)\n" +
                        "8GB RAM, 1TB Hard Drive\n"},
                {"Lenovo Laptop", "1999", "lenovo_1 lenovo_2 lenovo_3", "\nLenovo Yoga C640 13.3\" 2-in-1 Laptop 13.3\" Full HD touchscreen\n" +
                        "Intel Core i5-10210U quad core processor (6MB cache, 1.6GHz up to 4.2GHz)\n" +
                        "8GB RAM, 256GB SSD\n"},
                {"Acer Predator", "3244", "acer_1 acer_2 acer_3", "\nAcer Predator Helios 300 Gaming Laptop: \n" +
                        "15.6\" Full HD display\n" +
                        "Intel Core i7-9750H hexa-core processor (12MB Smart Cache, 2.60GHz up to 4.50GHz)\n" +
                        "16GB RAM, 256GB SSD + 1TB HDD\n" +
                        "NVIDIA® GeForce® GTX 1660Ti graphics with 6GB memory\n"},
                {"Asus Gaming Laptop", "1599", "asus_rog_1 asus_rog_2 asus_rog_3", "\nASUS ROG GX501VIK7700 Gaming Laptop:\n" +
                        "CPU: Quad Core 2.8GHz up to 3.8GHz CPU clock.\n" +
                        "RAM: 16GB, 2400 MHz.\n" +
                        "Internal Storage: 1TB, DDR4-2400MHz.\n" +
                        "Display: 15.6 inch (1080 x 1920) FHD LED Display.\n"},
                {"Dell XPS 17", "3699", "xps_1 xps_2 xps_3", "\n17-inch laptop in a 15-inch size loaded with power. Featuring 10th Gen Intel® Core™ processors, up to NVIDIA® GeForce RTX™ 2060 graphics and a studio-quality display."},
                {"MacBook Pro", "4999", "mbp_16_1 mbp_16_1 mbp_16_1", "Apple MacBook Pro 16-inch 1TB: \n" +
                        "Ninth-generation 8-core Intel Core i9 processor\n" +
                        "Stunning 16-inch Retina display with True Tone technology\n" +
                        "Touch Bar and Touch ID\n"},
                {"MacBook Air", "1799", "mb_air_2 mb_air_1 mb_air_3", "\nApple MacBook Air 13-inch i3 256GB: \n" +
                        "Stunning 13.3-inch Retina display with True Tone technology\n" +
                        "Backlit Magic Keyboard and Touch ID\n" +
                        "10th-generation Intel Core i3 processor\n"},
                {"iPad Pro 2020", "1499", "ipad_pro_1 ipad_pro_2 ipad_pro_3", "\nApple iPad Pro 11-inch 128GB Wi-Fi:\n" +
                        "11-inch edge-to-edge Liquid Retina display with ProMotion, True Tone and P3 wide colour\n" +
                        "A12Z Bionic chip with Neural Engine\n" +
                        "12-megapixel Wide camera, 10-megapixel Ultra Wide camera and LiDAR Scanner\n"}
        };

        static String[][] mobile = {
                {"iPhone SE", "799", "iphone_se_1 iphone_se_2 iphone_se_3", "\nNew Apple iPhone SE 64GB:\n" +
                        "4.7-inch Retina HD display\n" +
                        "A13 Bionic chip with third-generation Neural Engine\n" +
                        "12-megapixel Wide camera and 4K video\n"},
                {"iPhone 11", "1349", "iphone11_1 iphone11_2 iphone11_3", "\nApple iPhone 11 64GB:\n" +
                        "6.1-inch Liquid Retina HD LCD display\n" +
                        "Water and dust resistance (2 metres for up to 30 minutes, IP68)\n" +
                        "Dual-camera system with 12-megapixel Ultra-Wide and Wide cameras\n"},
                {"iPhone 11 Pro", "1949", "iphone11p_1 iphone11p_2 iphone11p_3", "\nApple iPhone 11 Pro 64GB:\n" +
                        "5.8-inch Super Retina XDR OLED display\n" +
                        "Water and dust resistance (4 metres for up to 30 minutes, IP68)\n" +
                        "Triple-camera system with 12-megapixel Ultra-Wide, Wide and Telephoto cameras\n"},
                {"Huawei Mate 30", "998.99", "mate30_1 mate30_2 mate30_3", "\nHuawei Mate 30 Pro 5G:\n" +
                        "The HUAWEI Mate 30 Pro 5G is equipped with 6.53 inch curved display, Kirin 990 5G chipset, Super Sensing Lecia Camera and EMUI10.\n" +
                        "With the 88-degree curved horizon display, HUAWEI Mate 30 Pro 5G offers seamless design and virtual buttons for volume and quad-game control. The in-screen fingerprint gives you fast and safe verification. Rated as IP68 dust and water resistant, it is reliable for daily use. Adopting the complementary antenna design which covers the top, middle and bottom, HUAWEI Mate 30 Pro 5G ensures stable signal connection no matter how your hands hold the phone.\n"},
                {"Huawei Mate Xs", "3999", "matexs_1 matexs_2 matexs_3", "\nHuawei Mate Xs 5G 512GB:\n" +
                        "8 inch Foldable FullView Display\n" +
                        "Kirin 990 5G Chipset\n" +
                        "SuperSensing 40MP Leica Quad Camera\n"},
                {"Xiaomi Mi 10", "998.99", "mi10_1 mi10_2 mi10_3", "\nChipset: Qualcomm SM8250 Snapdragon 865 (7 nm+)\n" +
                        "Type: Super AMOLED capacitive touchscreen, 16M colours\n" +
                        "Size:6.67 inches, 109.2 cm2 (~89.8% screen-to-body ratio)\n" +
                        "Resolution: 1080 x 2340 pixels, 19.5:9 ratio (~386 ppi density)\n" +
                        "Protection: Corning Gorilla Glass 5, HDR10+\n" +
                        "90Hz refresh rate\n"},
                {"OnePlus 8 Pro", "1779", "oneplus_8_1 oneplus_8_2 oneplus_8_3", "\nOnePlus 8 Pro:\n" +
                        "Operating System: OxygenOS based on Android™ 10.\n" +
                        "CPU: Qualcomm® Snapdragon™ 865.\n" +
                        "5G Chipset: X55.\n" +
                        "GPU: Adreno 650.\n" +
                        "RAM: 8GB/12GB LPDDR4X.\n" +
                        "Storage: 128GB/256GB UFS 3.0 2-LANE.\n" +
                        "Battery: 4300 mAh (non-removable)\n" +
                        "Warp Charge 30T Fast Charging (5V/6A)\n"},
                {"Huawei P40 Pro", "1499", "p40_1 p40_2 p40_3", "\nHuawei P40 Pro 5G 256GB:\n" +
                        "6.58\" OLED capacitive touchscreen\n" +
                        "8GB RAM\n" +
                        "256GB storage\n" +
                        "HiSilicon Kirin 990 5G (7 nm+) Chipset\n" +
                        "50MP(wide) x 12MP(telephoto) x 40MP(ultrawide) rear cameras\n" +
                        "32MP selfie camera\n" +
                        "Ultra-Vision Leica Quad Camera\n" +
                        "Ultra-Vision Main Camera\n" +
                        "Super Sensing Periscope Telephoto Lens\n"},
                {"Samsung S20", "1399", "s20_1 s20_2 s20_3", "\nSamsung Galaxy S20 128GB:\n" +
                        "Triple rear camera (12MP+64MP+12MP) with 30x Space Zoom & 8K video\n" +
                        "6.2\" Dynamic AMOLED Infinity-O display with 120Hz refresh rate\n" +
                        "Shoot night shots like a pro with twice the light of previous Samsung Galaxy devices\n"},
                {"Oppor Find X2", "1899", "findx2_2 findx2_1 findx2_3", "\nOPPO Find X2 Pro:\n" +
                        "120Hz Ultra Vision Screen with True Billion Colour Display\n" +
                        "Ultra-Vision Camera System\n" +
                        "65W SuperVOOC 2.0 Flash Charge + 4260mAh Battery\n"}
        };

        static String[][] music = {
                {"Beats Wireless Solo", "499", "beats_solo_1 beats_solo_2 beats_solo_3", "\nBeats Solo Pro Wireless Noise Cancelling Over-Ear Headphones (Grey):\n" +
                        "Active Noise Cancelling (ANC) blocks external noise\n" +
                        "Transparency helps you stay aware of your surroundings while listening\n" +
                        "Up to 22 hours of listening time\n"},
                {"Bose", "699", "bose_1 bose_2 bose_3", "\nBose Noise Cancelling Over-Ear Headphones 700 (White):\n" +
                        "11 levels of noise cancelling\n" +
                        "Amazon Alexa built in\n" +
                        "20 hours of battery life\n"},
                {"AirPods Pro", "449", "airpodspro_1 airpodspro_2 airpodspro_3", "\nApple AirPods Pro:\n" +
                        "Active Noise Cancellation for immersive sound\n" +
                        "Transparency mode for hearing and connecting with the world around you\n" +
                        "Three sizes of soft, tapered silicone tips for a customisable fit\n"},
                {"Sennheiser", "550", "sennheiser_1 sennheiser_2 sennheiser_3", "\nSennheiser Momentum True Wireless 2 In-Ear Headpones:\n" +
                        "Up to 7 hours battery, + 21 hours with the charging case\n" +
                        "IPX4 - Splash resistant design for all weather conditions\n" +
                        "Active Noise Cancelling & Transparent Hearing\n"},
                {"Sennheiser CX", "119.95", "sennheiser_cx_1 sennheiser_cx_2 sennheiser_cx_3", "\nSennheiser CX 150 In-Ear Wireless Bluetooth Headphones (Black):\n" +
                        "10-hours of battery life\n" +
                        "Advanced wireless Bluetooth 5.0 technology\n" +
                        "Call and music management via three-button remote\n"},
                {"Sonos Speaker", "1199", "sonos_subgen3_1 sonos_subgen3_2 sonos_subgen3_3", "\nSonos Sub Gen 3 (White):\n" +
                        "Connect Sub to any Sonos system for a more immersive home theatre and music experience.\n" +
                        "Enduring design continues to fit perfectly into any space.\n\n" +
                        "The wireless subwoofer for deep bass\n"},
                {"Sony Headphone", "449", "sony_wh1000xm3_1 sony_wh1000xm3_2 sony_wh1000xm3_3", "\nSony WH-XB900N Extra Bass Wireless Noise Cancelling Over-Ear Headphones:\n" +
                        "Up to 30 hours battery life\n" +
                        "Voice control, including Amazon Alexa and Siri\n" +
                        "Digital Noise Cancelling\n"},
                {"Panasonic Headphone", "417", "panasonicsc_1 panasonicsc_2 panasonicsc_3", "\nPanasonic SC-TMAX20GSK Wireless Speaker System:\n" +
                        "20cm Woofer with Dual Drive / AIRQUAKE BASS\n" +
                        "Multicolour Illumination\n" +
                        "Be the life of the party with MAX Juke App\n"},
                {"JBL Headphone", "239.99", "jbl_head_1 jbl_head_2 jbl_head_3", "\nJBL Tune750BTNC Over-Ear Wireless Noise Cancelling Headphones (Black):\n" +
                        "15 hour battery life with Bluetooth and noise cancelling\n" +
                        "Hands-free calls & voice control\n" +
                        "JBL Pure Bass sound\n"},
                {"JBL Pulse-4", "369.00", "jbl_pulse4_1 jbl_pulse4_2 jbl_pulse4_3", "\nJBL Pulse 4 Portable Bluetooth Speaker:\n" +
                        "Light up the night - LED light in 360 degrees\n" +
                        "Make a splash with IPX7 waterproof design\n" +
                        "JBL signature sound in every direction with its ingenious 360 degree speaker\n" +
                        "Up to 12 hours of party time on a single charge\n"}
        };

        static String[][] camera = {
                {"Canon Camera", "699", "canon_eos_1500d canon_eos_1500d_2 canon_eos_1500d_3", "\nCanon EOS 1500D DSLR Camera with 18-55mm Lens:\n" +
                        "24.1 MP APS-C sized sensor\n" +
                        "3\" LCD Screen\n" +
                        "Feature Guide\n"},
                {"Canon lens", "499", "canon_efs_250mm canon_efs_250mm_2 canon_efs_250mm_3", "\nCanon EF-S 55-250mm f/4-5.6 IS STM Lens:\n" +
                        "The impressive entry level telephoto lens just for you\n" +
                        "Achieve beautiful background blur\n" +
                        "Get up close to the smallest subjects\n"},
                {"Canon PowerShot", "999", "canon_powershot_g7x_iii canon_powershot_g7x_iii_2 canon_powershot_g7x_iii_3", "\nCanon PowerShot G7X III Compact Digital Camera:\n" +
                        "20.1MP stacked CMOS sensor\n" +
                        "Live streaming to YouTube\n" +
                        "4K (30p), Full HD (120p), HD video recording\n"},
                {"Joby-GorillaPod", "143", "joby_gorillapod joby_gorillapod_2 joby_gorillapod_3", "\nJoby GorillaPod 1K Tripod:\n" +
                        "Flexible tripod stand & ball head with 1kg capacity\n" +
                        "Ideal for content creators, vloggers and Youtubers\n"},
                {"DJI-Ronin-S", "1199", "dji_ronin_s dji_ronin_s_2 dji_ronin_s_3", "\nDJI Ronin-S Standard Kit:\n" +
                        "Empowers creators to shoot with the freedom of stabilised shots on the move\n" +
                        "Designed in a single-handed form factor for DSLR and mirrorless cameras\n"},
                {"Nikon", "399", "nikon_af_50mm nikon_af_50mm_2 nikon_af_50mm_3", "\nNikon AF-S Nikkor 50mm f1.8G Lens:\n" +
                        "Ideal for everyday use\n" +
                        "Perfect in low light\n" +
                        "Silent Wave Motor for fast and precise autofocusing\n"},
                {"Nikon-D3500", "799", "nikon_d3500 nikon_d3500_2 nikon_d3500_3", "\nNikon D3500 DSLR with AF-P DX 18-55mm VR Lens\n" +
                        "AF-P DX Nikkor 18-55mm f/3.5-5.6G VR lens kit\n" +
                        "24.2 megapixels\n" +
                        "Full HD 1080/60p videos\n"},
                {"Olympus-OM-D", "1499", "olympus_om_d olympus_om_d_2 olympus_om_d_3", "\nOlympus OM-D E-M5 Mark II Weatherproof Kit (12-50mm EZ Lens):\n" +
                        "Dustproof, splash proof, freezeproof\n" +
                        "5-axis image stabilisation\n" +
                        "Large high-resolution viewfinder (2.36m dots)\n"},
                {"Sony-WX800b", "960", "sony_wx800b sony_wx800b_2 sony_wx800b_3", "\nSony Cybershot WX800B Compact Camera with 24-720mm Zoom:\n" +
                        "18.2 effective megapixels 1/2.3 type ExmorR™ CMOS sensor\n" +
                        "24-720mm zoom range\n" +
                        "High quality 4K video recording\n"},
                {"GoPro-Max360", "869", "gopro_max360 gopro_max360_2 gopro_max360_3", "\nGoPro MAX 360 Action Cam:\n" +
                        "Max HyperSmooth\n" +
                        "Max TimeWarp\n" +
                        "1080p Live Streaming\n"}
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
