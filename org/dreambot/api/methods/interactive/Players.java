package org.dreambot.api.methods.interactive;


import net.eternalclient.api.accessors.LocalPlayer;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.Player;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Players {
	public static List<Player> all() {
		return toDBList(net.eternalclient.api.accessors.Players.all());
	}
	
	public static List<Player> all(Integer... ids) {
		return toDBList(net.eternalclient.api.accessors.Players.all(p -> p != null && Arrays.asList(ids).contains(p.getID())));
	}
	
	public static List<Player> all(String... names) {
		return toDBList(net.eternalclient.api.accessors.Players.all(p -> p != null && Arrays.asList(names).contains(p.getName())));
	}
	
	public static List<Player> all(Filter<Player> filter) {
		return toDBList(net.eternalclient.api.accessors.Players.all(filterToPredicate(filter)));
	}
	
	public static Player closest(Integer... ids) {
		return closest(p -> Arrays.asList(ids).contains(p.getID()));
	}
	
	public static Player closest(String... names) {
		return closest(p -> Arrays.asList(names).contains(p.getName()));
	}
	
	public static Player closest(Filter<Player> filter) {
		return new Player(net.eternalclient.api.accessors.Players.closest(filterToPredicate(filter)));
	}
	
	public static Player closest(Filter<Player> filter, Tile toTile) {
		return new Player(net.eternalclient.api.accessors.Players.closest(filterToPredicate(filter), toTile.toEC()));
	}
	
	public static Player getLocal() {
		return new Player(LocalPlayer.get());
	}
	
	private static Predicate<net.eternalclient.api.wrappers.interactives.Player> filterToPredicate(Filter<Player> filter) {
		return p -> filter.match(new Player(p));
	}
	
	private static List<Player> toDBList(List<net.eternalclient.api.wrappers.interactives.Player> players) {
		return players.stream()
				.map(Player::new)
				.collect(Collectors.toList());
	}
}
