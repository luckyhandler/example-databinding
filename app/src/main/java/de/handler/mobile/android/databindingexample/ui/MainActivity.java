package de.handler.mobile.android.databindingexample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import de.handler.mobile.android.databindingexample.R;
import de.handler.mobile.android.databindingexample.data.ActionCallback;
import de.handler.mobile.android.databindingexample.data.DataManager;
import de.handler.mobile.android.databindingexample.data.model.FlagData;

public class MainActivity extends AppCompatActivity implements ActionCallback {
	private final DataManager dataManager = new DataManager(new DataManager.OnDataReceivedListener() {
		@Override
		public void onDataReceived(List<FlagData.WorldPopulation> countries) {
			processData(countries);
		}
	});

	@Override
	public void onClick(FlagData.WorldPopulation worldPopulation) {
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.activity_main_fragment_container, FlagDetailFragment.newInstance(worldPopulation))
				.addToBackStack(FlagDetailFragment.class.getName())
				.commit();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.getData();
	}

	private void getData() {
		dataManager.getFlagData();
	}

	private void processData(List<FlagData.WorldPopulation> countries) {
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.activity_main_fragment_container, FlagListFragment.newInstance(countries))
				.commit();
	}
}
