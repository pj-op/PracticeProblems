package com.GRAPH.graphs;

import java.util.*;

public class TrainMap {
	private HashMap<String, Station> stations;

	public TrainMap() {
		this.stations = new HashMap<>();
	}

	public TrainMap addStation(String name) {
		Station s = new Station(name);
		this.stations.putIfAbsent(name, s);
		return this;
	}

	public Station getStation(String name) {
		return this.stations.get(name);
	}

	public TrainMap connectStations(Station fromStation, Station toStation) {
		if (fromStation == null) {
			throw new IllegalArgumentException("From station is null");
		}
		if (toStation == null) {
			throw new IllegalArgumentException("From station is null");
		}
		fromStation.addNeighbour(toStation);
		toStation.addNeighbour(fromStation);
		return this;
	}

	public List<Station> shortestPath(String from, String to) {

		if (stations.get(from) == null || stations.get(to) == null) {
			throw new IllegalArgumentException("No to or from station found");
		}

		Station fromStation = stations.get(from);
		// Use DFS to reach destination
		Deque<Station> queue = new ArrayDeque<>();
		queue.add(fromStation);

		// Keep tracker as well as avoid visiting the same node twice.
		Map<Station, Station> howWeReachDest = new HashMap<>();
		howWeReachDest.put(fromStation, null);

		while (!queue.isEmpty()) {
			Station current = queue.remove();

			if (current.getName().equals(to)) {
				break;
			}

			for (Station neighbour : current.getNeighbours()) {
				if (!howWeReachDest.containsKey(neighbour)) {
					queue.add(neighbour);
					howWeReachDest.put(neighbour, current);
				}
			}
		}

		// Back track all the way from destination to source,
		// Note source is mapped to null, Loop will break once source is encountered.
		List<Station> shortestPath = new ArrayList<>();

		Station destination = stations.get(to);

		while (destination != null) {
			shortestPath.add(destination);
			destination = howWeReachDest.get(destination);
		}

		Collections.reverse(shortestPath);

		return shortestPath;
	}

	public static String convertPathToStringRepresentation(List<Station> path) {
		if (path.isEmpty()) {
			return "";
		}
		return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
	}
}