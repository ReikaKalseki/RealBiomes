/*******************************************************************************
 * @author Reika Kalseki
 * 
 * Copyright 2014
 * 
 * All rights reserved.
 * Distribution of the software in any form is only allowed with
 * explicit, prior permission from the owner.
 ******************************************************************************/
package Reika.RealBiomes.Biomes;

import Reika.RealBiomes.Base.RealBiomeBase;

public class BiomeDeepOcean extends RealBiomeBase {

	public BiomeDeepOcean(int par1) {
		super(par1);
		this.setMinMaxHeight(-2F, -2F);
		//this.theBiomeDecorator = new BiomeDeepOceanDecorator(this);
	}

}
