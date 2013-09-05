/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RealBiomes.Generators;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import Reika.DragonAPI.Libraries.World.ReikaWorldHelper;

public class WorldGenDeepOcean extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {/*
		int id = world.getBlockId(x, y-1, z);
		ReikaJavaLibrary.pConsole("Generating at "+x+", "+y+", "+z+"  (ID "+id+")");
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 16; k++) {
					int ymax = 6-(x*z)%3+random.nextInt(3);
					if (j < ymax && world.getBlockId(x+i, j, z+k) != Block.bedrock.blockID && world.getBlockId(x+i, j, z+k) != Block.dirt.blockID) {
						world.setBlock(x+i, j, z+k, Block.dirt.blockID);
						//ReikaJavaLibrary.pConsole("filling at "+(x+i)+", "+j+", "+(z+k)+"  (ID "+id+")");
					}
				}
			}
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 16; k++) {
					int ymax = 6-(x*z)%3-2+random.nextInt(3);
					//ReikaJavaLibrary.pConsole("replacing at "+(x+i)+", "+j+", "+(z+k)+"  (ID "+id+")");
					if (world.getBlockId(x+i, j, z+k) == Block.bedrock.blockID && j > 0) {
						if (k > ymax)
							world.setBlock(x+i, j, z+k, Block.dirt.blockID);
						else
							world.setBlock(x+i, j, z+k, Block.stone.blockID);
					}
				}
			}
		}*/
		for (int i = 0; i < 16; i++) {
			for (int j = 1; j < 5; j++) {
				for (int k = 0; k < 16; k++) {
					if (world.getBlockId(x+i, j, z+k) == Block.bedrock.blockID) {
						world.setBlock(x+i, j, z+k, Block.waterMoving.blockID);
					}
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			int gx = x+random.nextInt(16);
			int gz = z+random.nextInt(16);
			ReikaWorldHelper.recursiveFillWithinSphere(world, gx, 1, gz, world.getBlockId(gx, 1, gz), Block.dirt.blockID, -1, 0, gx, 1, gz, 2);
		}
		return true;
	}

}
