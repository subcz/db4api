package org.dreambot.api.methods.container.impl.bank;

import lib.utilities.client.util.Dream;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.utilities.impl.Condition;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum BankLocation {
	AL_KHARID,
	ARCEUUS,
	ARDOUGNE_NORTH,
	ARDOUGNE_SOUTH,
	BARBARIAN_OUTPOST,
	BLAST_FURNACE,
	BURGH_DE_ROTT,
	CANIFIS,
	CASTLE_WARS,
	CATHERBY,
	COOKS_GUILD,
	CORSAIR_COVE,
	CRAFTING_GUILD,
	DARKMEYER,
	DRAYNOR,
	DUEL_ARENA,
	EDGEVILLE,
	ETCETERIA,
	FALADOR_EAST,
	FALADOR_WEST,
	FARMING_GUILD,
	FEROX_ENCLAVE,
	FISHING_GUILD,
	FOSSIL_ISLAND,
	GIANTS_FOUNDRY,
	GNOME_STRONGHOLD,
	GOTR,
	GRAND_EXCHANGE,
	GRAND_TREE,
	HALLOWED_SEPULCHER,
	HOSIDIUS,
	HOSIDIUS_KITCHEN,
	HOSIDIUS_SHORE,
	HOSIDIUS_VINERY,
	JATIZSO,
	KELDAGRIM,
	KOUREND_CASTLE,
	LANDS_END,
	LLETYA,
	LOVAKENGJ_SOUTH,
	LOVAKENGJ_WEST,
	LUMBRIDGE,
	LUMBRIDGE_BASEMENT,
	LUNAR_ISLAND,
	MAGE_BANK,
	MINING_GUILD,
	MOONCLAN_ISLE,
	MOS_LEHARMLESS,
	MOTHERLODE_MINE,
	MOUNT_KARUULM,
	MOUNT_QUIDAMORTEM,
	NARDAH,
	NEITIZNOT,
	NORTH_PRIFDDINAS,
	PEST_CONTROL,
	PISCATORIS,
	PORT_KHAZARD,
	PORT_PHASMATYS,
	PORT_PISCARILIUS,
	ROGUES_DEN,
	RUINS_OF_CAMDOZAAL,
	RUINS_OF_UNKAH,
	SEERS,
	SHANTAY_PASS,
	SHAYZIEN,
	SHILO_VILLAGE,
	SOUL_WARS,
	SOUTH_PRIFDDINAS,
	SULFUR_MINE,
	TZHAAR,
	TZHAAR_EAST,
	VARROCK_EAST,
	VARROCK_WEST,
	VER_SINHAZA,
	WARRIORS_GUILD,
	WINTERTODT,
	WOODCUTTING_GUILD,
	WOODCUTTING_GUILD_DUNGEON,
	YANILLE,
	ZANARIS;
	
	public net.eternalclient.api.containers.bank.BankLocation toEC() {
		try {
			return net.eternalclient.api.containers.bank.BankLocation.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("BANK LOCATION: Missing EC bank location for DreamBot location \"" + name() + "\".");
			return null;
		}
	}
	
	public Area getArea(int radius) {
		return new Area(Objects.requireNonNull(toEC()).getSurroundingArea(radius));
	}
	
	public BankType getBankType() {
		return BankType.valueOf(Objects.requireNonNull(toEC()).getType());
	}
	
	public Tile getCenter() {
		return new Tile(Objects.requireNonNull(toEC()).getTile());
	}
	
	public Condition getCondition() {
		return () -> Objects.requireNonNull(toEC()).hasRequirements();
	}
	
//	public static BankLocation getNearest() {
//		return Bank.
//	}
	
	public static List<BankLocation> getValidLocations() {
		return Arrays.stream(values()).filter(bank -> bank.getCondition().verify()).collect(Collectors.toList());
	}
	
	public boolean isMembersOnly() {
		return Objects.requireNonNull(toEC()).isMembers();
	}
	
	@Override
	public String toString() {
		return Objects.requireNonNull(toEC()).toString();
	}
	
	public static BankLocation valueOf(net.eternalclient.api.containers.bank.BankLocation bankLoc) {
		for(BankLocation loc : values()) {
			if(loc.name().equals(bankLoc.name())) return loc;
		}
		Logger.log("BANK LOCATION: Missing Dreambot bank location for EC location \"" + bankLoc + "\".");
		return null;
	}
}
