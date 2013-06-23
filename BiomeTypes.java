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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;
import Reika.DragonAPI.Exception.IDConflictException;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.RealBiomes.Biomes.BiomeArctic;
import Reika.RealBiomes.Biomes.BiomeBC;
import Reika.RealBiomes.Biomes.BiomeSahara;
import Reika.RealBiomes.Biomes.BiomeToronto;

public enum BiomeTypes {

	SAHARA(BiomeSahara.class, Block.sand, Block.sand, Block.sandStone, "Sahara Desert", 16421912, false, false),
	BC(BiomeBC.class, Block.grass, Block.dirt, Block.stone, "Temperate Rainforest", 5470985, false, true),
	TORONTO(BiomeToronto.class, Block.grass, Block.dirt, Block.stone, "Deciduous Forest", 353825, false, true),
	ARCTIC(BiomeArctic.class, Block.blockSnow, Block.ice, Block.stone, "Arctic", 16777215, true, false);

	private Block topBlock;
	private Block fillerBlock;
	private Block mainBlock;
	private Class biomeClass;
	private String name;
	private boolean isSnow;
	private int biomeColor;
	private boolean canRain;

	public static final BiomeTypes[] biomeList = BiomeTypes.values();

	private BiomeTypes(Class<? extends RealBiomeBase> biome, Block top, Block filler, Block solid, String n, int color, boolean snow, boolean rain) {

		topBlock = top;
		fillerBlock = filler;
		mainBlock = solid;

		biomeClass = biome;
		name = n;
		biomeColor = color;
		isSnow = snow;
		canRain = rain;
	}

	public BiomeGenBase create() {
		try {
			Constructor c = biomeClass.getConstructor(int.class);
			BiomeGenBase biome = ((BiomeGenBase)c.newInstance(this.ordinal()+BiomeConfig.biomeIDBase)).setBiomeName(name);
			biome.setColor(biomeColor);
			if (isSnow)
				biome.setEnableSnow();
			if (!canRain)
				biome.setDisableRain();
			biome.topBlock = (byte)topBlock.blockID;
			biome.fillerBlock = (byte)fillerBlock.blockID;
			return biome;
		}
		catch (InstantiationException e) {
			throw new RegistrationException(RealBiomes.instance, biomeClass+" could not be instantiated!");
		}
		catch (IllegalAccessException e) {
			throw new RegistrationException(RealBiomes.instance, biomeClass+" has a nonpublic constructor!");
		}
		catch (NoSuchMethodException e) {
			throw new RegistrationException(RealBiomes.instance, biomeClass+" was given an invalid constructor!");
		}
		catch (SecurityException e) {
			throw new RegistrationException(RealBiomes.instance, biomeClass+" threw security exception!");
		}
		catch (IllegalArgumentException e) {
			throw new RegistrationException(RealBiomes.instance, biomeClass+"'s constructor is not of the given type!");
		}
		catch (InvocationTargetException e) {
			if (e.getCause() instanceof IllegalArgumentException)
				throw new IDConflictException(RealBiomes.instance, e.getCause());
			else
				throw new RegistrationException(RealBiomes.instance, biomeClass+"'s threw invocation target exception!");
		}
	}

}
