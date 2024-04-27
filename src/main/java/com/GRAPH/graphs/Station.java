package com.GRAPH.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station {
	private String name;
	private List<Station> neighbours;

	public Station(String name) {
		this.name = name;
		this.neighbours = new ArrayList<>(3);
	}

	String getName() {
		return name;
	}

	void addNeighbour(Station v) {
		this.neighbours.add(v);
	}

	List<Station> getNeighbours() {
		return this.neighbours;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Station && this.name.equals(((Station) obj).getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.name);
	}
}