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

public enum BiomeBlocks {

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
		return this.name().substring(0, 1)+this.name().substring(1).toLowerCase();
	}

}
