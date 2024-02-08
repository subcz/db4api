package org.dreambot.api.methods.interactive;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.items.GroundItem;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroundItems {
	public static List<GroundItem> all() {
		return toDBList(net.eternalclient.api.accessors.GroundItems.all());
	}
	
	public static List<GroundItem> all(Integer... ids) {
		return toDBList(net.eternalclient.api.accessors.GroundItems.all(item -> item != null && Arrays.asList(ids).contains(item.getID())));
	}
	
	public static List<GroundItem> all(String... names) {
		return toDBList(net.eternalclient.api.accessors.GroundItems.all(item -> item != null && Arrays.asList(names).contains(item.getName())));
	}
	
	public static List<GroundItem> all(Filter<GroundItem> filter) {
		return toDBList(net.eternalclient.api.accessors.GroundItems.all(filterToPredicate(filter)));
	}
	
	public static GroundItem closest(Integer... ids) {
		return closest(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static GroundItem closest(String... names) {
		return closest(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static GroundItem closest(Filter<GroundItem> filter) {
		net.eternalclient.api.wrappers.interactives.GroundItem groundItem = net.eternalclient.api.accessors.GroundItems.closest(filterToPredicate(filter));
		return groundItem != null ? new GroundItem(groundItem) : null;
	}
	
//	public static GroundItem closest(Filter<GroundItem> filter, Tile toTile) {
//		net.eternalclient.api.wrappers.interactives.GroundItem groundItem = net.eternalclient.api.accessors.GroundItems.closest(filterToPredicate(filter), toTile.toEC());
//		return groundItem != null ? new GroundItem(groundItem) : null;
//	}
	
	private static Predicate<net.eternalclient.api.wrappers.interactives.GroundItem> filterToPredicate(Filter<GroundItem> filter) {
		return item -> filter.match(new GroundItem(item));
	}
	
	private static List<GroundItem> toDBList(List<net.eternalclient.api.wrappers.interactives.GroundItem> items) {
		return items.stream()
				.map(GroundItem::new)
				.collect(Collectors.toList());
	}
}
