package tsuteto.tofufactory.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import tsuteto.tofufactory.integration.TFIntegrationManager;

public class TFConfig {

    public static String TofuCraftsmanExtraItems;
    public static String ZundaCraftsmanExtraItems;

    public static boolean updateCheck = true;

   
    public static boolean disableOreMithrilTofu = false;

    public static void ConfigRead(FMLPreInitializationEvent event) {
        Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());

        try {
            cfg.load();

            
            TFIntegrationManager.loadConfig(cfg);

            
            ConfigForTofuFactory(cfg);
            ConfigForTofuBC(cfg);
            ConfigForForestry(cfg);
            ConfigForIC2(cfg);
            ConfigForTC(cfg);
        } catch (Exception e) {
            FMLLog.log(Level.FATAL, e, "Error loading configuration");
        } finally {
            cfg.save();
        }
    }

    public static void ConfigForTofuFactory(Configuration cfg) {
        updateCheck = cfg.get("general", "updateCheck", updateCheck, "Enable update check")
            .getBoolean(true);

        
        disableOreMithrilTofu = cfg
            .get(
                "worldgen",
                "disableOreMithrilTofu",
                disableOreMithrilTofu,
                "Set to true to disable Mithril Tofu Ore generation")
            .getBoolean(false);
    }

    public static void ConfigForTofuBC(Configuration cfg) {
        
    }

    public static void ConfigForForestry(Configuration cfg) {
        Property pT = cfg.get("General_Forestry", "Backpack_Tofu_AdditionalItems", "");
        TofuCraftsmanExtraItems = pT.getString();

        Property pZ = cfg.get("General_Forestry", "Backpack_Zunda_AdditionalItems", "");
        ZundaCraftsmanExtraItems = pZ.getString();
    }

    public static void ConfigForIC2(Configuration cfg) {
        
    }

    public static void ConfigForTC(Configuration cfg) {
        
    }
}
