package com.armadio.magicalinstrument.entity;

import com.armadio.magicalinstrument.MagicalInstrument;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

import java.util.Random;

/**
 * Created by armaDio on 04/04/2015.
 */
public class ModEntities {

    public static void initEntities(){
        registerEntity(EntityDrummer.class,"drummer");
        registerEntity(EntityOrc.class,"ogre");
    }

    public static void registerEntity(Class entityClass, String name)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, MagicalInstrument.instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}
