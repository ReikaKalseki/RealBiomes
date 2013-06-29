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

import java.net.URL;

import Reika.DragonAPI.Base.DragonAPIMod;
import Reika.DragonAPI.Instantiable.ControlledConfig;
import Reika.RealBiomes.Registry.BiomeOptions;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod( modid = "RealBiomes", name="RealBiomes", version="beta", certificateFingerprint = "@GET_FINGERPRINT@")
@NetworkMod(clientSideRequired = true, serverSideRequired = true/*,
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "RealBiomesData" }, packetHandler = ClientPackets.class),
serverPacketHandlerSpec = @SidedPacketHandler(channels = { "RealBiomesData" }, packetHandler = ServerPackets.class)*/)

public class RealBiomes extends DragonAPIMod {

	@Instance("RealBiomes")
	public static RealBiomes instance = new RealBiomes();

	public static final ControlledConfig config = new ControlledConfig(instance, BiomeOptions.optionList, null, null, null, 0);

	@Override
	@PreInit
	public void preload(FMLPreInitializationEvent evt) {
		config.initProps(evt);
	}

	@Override
	@Init
	public void load(FMLInitializationEvent event) {
		if (BiomeOptions.ENABLE.getState())
			BiomeLoader.loadBiomes();
	}

	@Override
	@PostInit // Like the modsLoaded thing from ModLoader
	public void postload(FMLPostInitializationEvent evt) {

	}

	@Override
	public String getDisplayName() {
		return "RealBiomes";
	}

	@Override
	public String getModAuthorName() {
		return "Reika";
	}

	@Override
	public URL getDocumentationSite() {
		return null;
	}

	@Override
	public boolean hasWiki() {
		return false;
	}

	@Override
	public URL getWiki() {
		return null;
	}
}
