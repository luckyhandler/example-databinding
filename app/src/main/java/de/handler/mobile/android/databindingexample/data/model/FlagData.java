package de.handler.mobile.android.databindingexample.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FlagData {
	@SerializedName("worldpopulation")
	public List<WorldPopulation> worldPopulation;

	public static class WorldPopulation {
		public int rank;
		public String country;
		public String population;
		public String flag;
	}
}
