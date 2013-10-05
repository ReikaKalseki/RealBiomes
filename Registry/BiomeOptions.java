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
import Reika.DragonAPI.Interfaces.ConfigList;
import Reika.RealBiomes.RealBiomes;
import Reika.RotaryCraft.RotaryCraft;

public enum BiomeOptions implements ConfigList {

	ENABLE("Enable Mod", false),
	DISABLEVANILLA("Disable Vanilla Biomes", false),
	DISABLEOCEANS("Disable Oceans", true),
	BASEID("Base Biome ID", 120),
	LOGLOADING("Console Loading Info", true),
	DEBUGMODE("Debug Mode", false);

	private String label;
	private boolean defaultState;
	private int defaultValue;
	private float defaultFloat;
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

	public boolean isDecimal() {
		return type == float.class;
	}

	public float setDecimal(Configuration config) {
		if (!this.isDecimal())
			throw new RegistrationException(RotaryCraft.instance, "Config Property \""+this.getLabel()+"\" is not decimal!");
		return (float)config.get("Control Setup", this.getLabel(), defaultFloat).getDouble(defaultFloat);
	}

	public float getFloat() {
		return (Float)RotaryCraft.config.getControl(this.ordinal());
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
		return (Boolean)RealBiomes.config.getControl(this.ordinal());
	}

	public int getValue() {
		return (Integer)RealBiomes.config.getControl(this.ordinal());
	}

	public boolean isDummiedOut() {
		return type == null;
	}

}
