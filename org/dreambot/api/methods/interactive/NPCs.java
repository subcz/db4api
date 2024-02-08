package org.dreambot.api.methods.interactive;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NPCs {
	public static List<NPC> all() {
		return toDBList(net.eternalclient.api.accessors.NPCs.all());
	}
	
	public static List<NPC> all(Integer... ids) {
		return toDBList(net.eternalclient.api.accessors.NPCs.all(npc -> npc != null && Arrays.asList(ids).contains(npc.getID())));
	}
	
	public static List<NPC> all(String... names) {
		return toDBList(net.eternalclient.api.accessors.NPCs.all(npc -> npc != null && Arrays.asList(names).contains(npc.getName())));
	}
	
	public static List<NPC> all(Filter<NPC> filter) {
		return toDBList(net.eternalclient.api.accessors.NPCs.all(filterToPredicate(filter)));
	}
	
	public static NPC closest(Integer... ids) {
		return closest(npc -> Arrays.asList(ids).contains(npc.getID()));
	}
	
	public static NPC closest(String... names) {
		return closest(npc -> Arrays.asList(names).contains(npc.getName()));
	}
	
	public static NPC closest(Filter<NPC> filter) {
		net.eternalclient.api.wrappers.interactives.NPC npc = net.eternalclient.api.accessors.NPCs.closest(filterToPredicate(filter));
		return npc != null ? new NPC(npc) : null;
	}
	
	public static NPC closest(Filter<NPC> filter, Tile toTile) {
		net.eternalclient.api.wrappers.interactives.NPC npc = net.eternalclient.api.accessors.NPCs.closest(filterToPredicate(filter), toTile.toEC());
		return npc != null ? new NPC(npc) : null;
	}
	
	private static Predicate<net.eternalclient.api.wrappers.interactives.NPC> filterToPredicate(Filter<NPC> filter) {
		return npc -> filter.match(new NPC(npc));
	}
	
	private static List<NPC> toDBList(List<net.eternalclient.api.wrappers.interactives.NPC> npcs) {
		return npcs.stream()
				.map(NPC::new)
				.collect(Collectors.toList());
	}
}
