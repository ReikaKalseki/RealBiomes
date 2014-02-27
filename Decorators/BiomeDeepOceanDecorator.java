/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RealBiomes.Decorators;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import Reika.RealBiomes.Generators.WorldGenDeepOcean;

public class BiomeDeepOceanDecorator extends BiomeDecorator {

	protected WorldGenerator spikeGen;

	public BiomeDeepOceanDecorator(BiomeGenBase par1BiomeGenBase) {
		super(par1BiomeGenBase);
		spikeGen = new WorldGenDeepOcean();
	}

	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4)
	{
		if (currentWorld != null)
		{
			//throw new RuntimeException("Already decorating!!");
		}
		else
		{
			currentWorld = par1World;
			randomGenerator = par2Random;
			chunk_X = par3;
			chunk_Z = par4;
			this.decorate();
			currentWorld = null;
			randomGenerator = null;
		}
	}


	@Override
	protected void decorate()
	{
		//ReikaJavaLibrary.pConsole("Generating for chunk "+chunk_X+", "+chunk_Z);
		//this.generateOres();

		if (true)
		{
			int i = chunk_X + randomGenerator.nextInt(16) + 8;
			int j = chunk_Z + randomGenerator.nextInt(16) + 8;
			int k = currentWorld.getTopSolidOrLiquidBlock(i, j);

			if (k > 0)
			{
				;
			}

			spikeGen.generate(currentWorld, randomGenerator, chunk_X, k, chunk_Z);
		}
	}

}
