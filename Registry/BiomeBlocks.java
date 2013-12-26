/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2013
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RealBiomes.Registry;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import Reika.DragonAPI.Interfaces.RegistryEnum;
import Reika.DragonAPI.Libraries.Java.ReikaStringParser;

public enum BiomeBlocks implements RegistryEnum {

	//REGISTER ALL TO OREDICT

	TUNDRA(),
	PERMAFROST(),
	TUNDRAPLANT(),

	COLOREDLEAF(),
	WILLOWLEAF(),
	WILLOWWOOD(),
	CEDARLEAF(),
	CEDARWOOD(),

	MOSS(),
	ROCK(),
	SEQUOIALEAF(),
	SEQUOIAWOOD(),
	REDWOOD(),
	REDWOODLEAF(),

	CORAL(),

	SMOKERS(),
	TUBEWORMS(),

	DESERTSHRUB(),

	PEAT(),
	BULLRUSH(),

	CRACKEDROCK(),
	GLACIER(),

	ACACIAWOOD(),
	ACACIALEAVES(),
	BAOBOBWOOD(),
	BAOBOBLEAVES(),
	SAVANNAGRASS(),
	TERMITEMOUND(),

	BAMBOO(),

	REDROCK(),
	REDSAND(),
	AUSTROSHRUBS(),

	SALTFLAT();



	public String getOreDictName() {
		return ReikaStringParser.capFirstChar(this.name());
	}

	@Override
	public String getConfigName() {
		return this.getOreDictName();
	}

	@Override
	public int getDefaultID() {
		return 1000;
	}

	@Override
	public Class[] getConstructorParamTypes() {
		return new Class[]{int.class, Material.class};
	}

	@Override
	public Object[] getConstructorParams() {
		return new Object[]{this.getBlockID(), this.getBlockMaterial()};
	}

	@Override
	public String getUnlocalizedName() {
		return ReikaStringParser.stripSpaces(this.getBasicName());
	}

	@Override
	public Class getObjectClass() {
		return null;
	}

	@Override
	public String getBasicName() {
		return this.getOreDictName();
	}

	@Override
	public String getMultiValuedName(int meta) {
		return null;
	}

	@Override
	public boolean hasMultiValuedName() {
		return false;
	}

	@Override
	public int getNumberMetadatas() {
		return 0;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlock() {
		return null;
	}

	@Override
	public boolean hasItemBlock() {
		return false;
	}

	public int getBlockID() {
		return 0;
	}

	public Material getBlockMaterial() {
		return Material.rock;
	}

	@Override
	public boolean isBlock() {
		return true;
	}

	@Override
	public boolean isItem() {
		return false;
	}

	@Override
	public String getCategory() {
		return "Biome Blocks";
	}

	public boolean isDummiedOut() {
		return false;
	}

	public int getID() {
		return this.getBlockID();
	}

	@Override
	public boolean overwritingItem() {
		return false;
	}

}
