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

import net.minecraftforge.common.Configuration;
import Reika.DragonAPI.Exception.RegistrationException;
import Reika.RealBiomes.BiomeConfig;
import Reika.RealBiomes.RealBiomes;

public enum BiomeOptions {

	ENABLE("Enable Mod", true),
	DISABLEVANILLA("Disable Vanilla Biomes", true),
	DISABLEOCEANS("Disable Oceans", true),
	BASEID("Base Biome ID", 120);

	private String label;
	private boolean defaultState;
	private int defaultValue;
	private Class type;

	public static final BiomeOptions[] optionList = BiomeOptions.values();

	private BiomeOptions(String l, boolean d) {
		label = l;
		defaultState = d;
		type = boolean.class;
	}

	private BiomeOptions(String l, int d) {
		label = l;
		defaultValue = d;
		type = int.class;
	}

	public boolean isBoolean() {
		return type == boolean.class;
	}

	public boolean isNumeric() {
		return type == int.class;
	}

	public Class getPropertyType() {
		return type;
	}

	public int setValue(Configuration config) {
		if (!this.isNumeric())
			throw new RegistrationException(RealBiomes.instance, "Config Property \""+this.getLabel()+"\" is not numerical!");
		return config.get("Control Setup", this.getLabel(), defaultValue).getInt();
	}

	public String getLabel() {
		return label;
	}

	public boolean setState(Configuration config) {
		if (!this.isBoolean())
			throw new RegistrationException(RealBiomes.instance, "Config Property \""+this.getLabel()+"\" is not boolean!");
		return config.get("Control Setup", this.getLabel(), defaultState).getBoolean(defaultState);
	}

	public boolean getState() {
		return (Boolean)BiomeConfig.controls[this.ordinal()];
	}

	public int getValue() {
		return (Integer)BiomeConfig.controls[this.ordinal()];
	}

}
