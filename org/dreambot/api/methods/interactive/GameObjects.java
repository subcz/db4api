package org.dreambot.api.methods.interactive;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.GameObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GameObjects {
	public static List<GameObject> all() {
		return toDBList(net.eternalclient.api.accessors.GameObjects.all());
	}
	
	public static List<GameObject> all(Integer... ids) {
		return toDBList(net.eternalclient.api.accessors.GameObjects.all(obj -> obj != null && Arrays.asList(ids).contains(obj.getID())));
	}
	
	public static List<GameObject> all(String... names) {
		return toDBList(net.eternalclient.api.accessors.GameObjects.all(obj -> obj != null && Arrays.asList(names).contains(obj.getName())));
	}
	
	public static List<GameObject> all(Filter<GameObject> filter) {
		return toDBList(net.eternalclient.api.accessors.GameObjects.all(filterToPredicate(filter)));
	}
	
	public static GameObject closest(Integer... ids) {
		return closest(obj -> Arrays.asList(ids).contains(obj.getID()));
	}
	
	public static GameObject closest(String... names) {
		return closest(obj -> Arrays.asList(names).contains(obj.getName()));
	}
	
	public static GameObject closest(Filter<GameObject> filter) {
		net.eternalclient.api.wrappers.interactives.GameObject obj = net.eternalclient.api.accessors.GameObjects.closest(filterToPredicate(filter));
		return obj != null ? new GameObject(obj) : null;
	}
	
	public static GameObject closest(Filter<GameObject> filter, Tile toTile) {
		net.eternalclient.api.wrappers.interactives.GameObject obj = net.eternalclient.api.accessors.GameObjects.closest(filterToPredicate(filter), toTile.toEC());
		return obj != null ? new GameObject(obj) : null;
	}
	
	private static Predicate<net.eternalclient.api.wrappers.interactives.GameObject> filterToPredicate(Filter<GameObject> filter) {
		return obj -> filter.match(new GameObject(obj));
	}
	
	private static List<GameObject> toDBList(List<net.eternalclient.api.wrappers.interactives.GameObject> objs) {
		return objs.stream()
				.map(GameObject::new)
				.collect(Collectors.toList());
	}
	
	public static GameObject[] getObjectsOnTile(Tile t) {
		return all(obj -> obj.getTile().equals(t)).toArray(new GameObject[0]);
	}
	
	public static GameObject getTopObjectOnTile(Tile t) {
		GameObject[] objs = getObjectsOnTile(t);
		return objs.length > 0 ? objs[0] : null;
	}
}
