package de.handler.mobile.android.databindingexample.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * A class implementing the Observable interface will allow the binding to attach a single listener
 * to a bound object to listen for changes of all properties on that object.
 * The Observable interface has a mechanism to add and remove listeners, but notifying is up to the developer.
 * To make development easier, a base class, BaseObservable, was created to implement the listener registration mechanism.
 * The data class implementer is still responsible for notifying when the properties change.
 * This is done by assigning a Bindable annotation to the getter and notifying in the setter.
 */
public class FlagData extends BaseObservable implements Parcelable {
	@SerializedName("worldpopulation")
	@Bindable
	private List<WorldPopulation> worldPopulation;


	public void setWorldPopulation(List<WorldPopulation> worldPopulation) {
		this.worldPopulation = worldPopulation;
		notifyPropertyChanged(BR.worldPopulation);
	}

	public List<WorldPopulation> getWorldPopulation() {
		return worldPopulation;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.worldPopulation);
	}

	private FlagData(Parcel in) {
		this.worldPopulation = new ArrayList<>();
		in.readList(this.worldPopulation, WorldPopulation.class.getClassLoader());
	}

	public static final Parcelable.Creator<FlagData> CREATOR = new Parcelable.Creator<FlagData>() {
		@Override
		public FlagData createFromParcel(Parcel source) {
			return new FlagData(source);
		}

		@Override
		public FlagData[] newArray(int size) {
			return new FlagData[size];
		}
	};


	public static class WorldPopulation extends BaseObservable implements Parcelable {
		@Bindable
		private String rank;
		@Bindable
		private String country;
		@Bindable
		private String population;
		@Bindable
		private String flag;


		public void setFlag(String flag) {
			this.flag = flag;
			notifyPropertyChanged(BR.flag);
		}

		public void setRank(String rank) {
			this.rank = rank;
			notifyPropertyChanged(BR.rank);
		}

		public void setPopulation(String population) {
			this.population = population;
			notifyPropertyChanged(BR.population);
		}

		public void setCountry(String country) {
			this.country = country;
			notifyPropertyChanged(BR.country);
		}

		public String getFlag() {
			return flag;
		}

		public String getPopulation() {
			return population;
		}

		public String getCountry() {
			return country;
		}

		public String getRank() {
			return rank;
		}

		@Override
		public int describeContents() {
			return 0;
		}

		@Override
		public void writeToParcel(Parcel dest, int flags) {
			dest.writeString(this.rank);
			dest.writeString(this.country);
			dest.writeString(this.population);
			dest.writeString(this.flag);
		}

		WorldPopulation(Parcel in) {
			this.rank = in.readString();
			this.country = in.readString();
			this.population = in.readString();
			this.flag = in.readString();
		}

		public static final Creator<WorldPopulation> CREATOR = new Creator<WorldPopulation>() {
			@Override
			public WorldPopulation createFromParcel(Parcel source) {
				return new WorldPopulation(source);
			}

			@Override
			public WorldPopulation[] newArray(int size) {
				return new WorldPopulation[size];
			}
		};
	}
}
