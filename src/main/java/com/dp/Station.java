package com.dp;

import java.util.*;

class Station{
	String name;
	List<Station> neighbours;
	
	Station(String name){
		this.name =  name;
		neighbours = new ArrayList<Station>();
	}
	public void addNeighbour(Station s) {
		neighbours.add(s);
	}
	public String getName() {
		return name;
	}
	public List<Station> getNeighbours() {
		return neighbours;
	}
}

class TrainMap {
	
	private HashMap<String, Station> stations;
	
	public static void main(String args[]) {
		
		TrainMap tm = new TrainMap();
		tm.addStation("King's Cross St Pancras");
		tm.addStation("Angel");
		tm.addStation("Old Street");
		tm.addStation("Russell Square");
		tm.addStation("Farringdon");
		tm.addStation("Barbican");
		
		tm = tm.connectStations(tm.getStation("King's Cross St Pancras"), 
				tm.getStation("Angel"));
		tm = tm.connectStations(tm.getStation("Angel"), 
				tm.getStation("King's Cross St Pancras"));
		
		tm = tm.connectStations(tm.getStation("Angel"), 
				tm.getStation("Old Street"));
		tm = tm.connectStations(tm.getStation("Old Street"), 
				tm.getStation("Angel"));
		
		tm = tm.connectStations(tm.getStation("King's Cross St Pancras"), 
				tm.getStation("Russell Square"));
		tm = tm.connectStations(tm.getStation("Russell Square"), 
				tm.getStation("King's Cross St Pancras"));
		
		tm = tm.connectStations(tm.getStation("King's Cross St Pancras"), 
				tm.getStation("Farringdon"));
		tm = tm.connectStations(tm.getStation("Farringdon"), 
				tm.getStation("King's Cross St Pancras"));
		
		tm = tm.connectStations(tm.getStation("Angel"), 
				tm.getStation("Farringdon"));
		tm = tm.connectStations(tm.getStation("Farringdon"), 
				tm.getStation("Angel"));
		
		tm = tm.connectStations(tm.getStation("Barbican"), 
				tm.getStation("Farringdon"));
		tm = tm.connectStations(tm.getStation("Farringdon"), 
				tm.getStation("Barbican"));
		
		tm.shortestPath("King's Cross St Pancras", "Barbican");
		
	}

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
			throw new IllegalArgumentException("to station is null");
		}
		fromStation.addNeighbour(toStation);
		toStation.addNeighbour(fromStation);
		return this;
	}

	public List<Station> shortestPath(String from, String to) {
		/*
		 * TODO Implement
		 */
		
		Queue<String> bfs = new LinkedList<String>();
		HashMap<String, String> parent = new HashMap<String, String>();
		Set<String> visited = new HashSet<String>();
		
		bfs.add(from);
		visited.add(from);
		while(!bfs.isEmpty()) {
			String currentStation = bfs.peek();
			bfs.remove();
			for(int i =0 ; i < this.getStation(currentStation).getNeighbours().size() ; i++) {
				String neighbour = this.getStation(currentStation).getNeighbours().get(i).getName();
				if(!visited.contains(neighbour)) {
					bfs.add(neighbour);
					parent.put(neighbour, currentStation);
					visited.add(neighbour);
				}
				if(to.equals(neighbour)) {
					bfs.clear();
				}
			}
		}
		
		List<String> result = new ArrayList<String>();
		
		String toStation = to;
		
		result.add(toStation);
		while(parent.containsKey(from) && ! from.equals(result.get(result.size() - 1))) {
			toStation = parent.get(toStation);
			result.add(toStation);
		}
		
		result.forEach(e -> System.out.println(e));
		
		
		return Collections.emptyList();
	}

	public static String convertPathToStringRepresentation(List<Station> path) {
		if (path.isEmpty()) {
			return "";
		}
		return path.stream().map(Station::getName).reduce((s1, s2) -> s1 + "->" + s2).get();
	}
}
