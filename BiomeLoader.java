/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RealBiomes;

import net.minecraft.world.biome.BiomeGenBase;
import Reika.RealBiomes.Registry.BiomeTypes;
import Reika.RealBiomes.Registry.BiomeOptions;
import cpw.mods.fml.common.registry.GameRegistry;

public class BiomeLoader {

	public static void loadBiomes() {
		for (int i = 0; i < BiomeTypes.biomeList.length; i++) {
			BiomeGenBase biome = BiomeTypes.biomeList[i].create();
			GameRegistry.addBiome(biome);
		}
		if (BiomeOptions.DISABLEOCEANS.getState())
			GameRegistry.removeBiome(BiomeGenBase.ocean);
		if (BiomeOptions.DISABLEVANILLA.getState()) {
			GameRegistry.removeBiome(BiomeGenBase.plains);
			GameRegistry.removeBiome(BiomeGenBase.taiga);
			GameRegistry.removeBiome(BiomeGenBase.taigaHills);
			GameRegistry.removeBiome(BiomeGenBase.jungle);
			GameRegistry.removeBiome(BiomeGenBase.jungleHills);
			GameRegistry.removeBiome(BiomeGenBase.forest);
			GameRegistry.removeBiome(BiomeGenBase.forestHills);
			GameRegistry.removeBiome(BiomeGenBase.desert);
			GameRegistry.removeBiome(BiomeGenBase.desertHills);
			GameRegistry.removeBiome(BiomeGenBase.extremeHills);
			GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
			GameRegistry.removeBiome(BiomeGenBase.swampland);
			GameRegistry.removeBiome(BiomeGenBase.iceMountains);
			GameRegistry.removeBiome(BiomeGenBase.icePlains);
			GameRegistry.removeBiome(BiomeGenBase.mushroomIsland);
			GameRegistry.removeBiome(BiomeGenBase.mushroomIslandShore);
		}
	}

}
