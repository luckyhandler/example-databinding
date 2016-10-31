package de.handler.mobile.android.databindingexample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import de.handler.mobile.android.databindingexample.R;
import de.handler.mobile.android.databindingexample.data.DataManager;
import de.handler.mobile.android.databindingexample.data.model.FlagData;

public class MainActivity extends AppCompatActivity {
	private final DataManager dataManager = new DataManager(new DataManager.OnDataReceivedListener() {
		@Override
		public void onDataReceived(List<FlagData.WorldPopulation> countries) {
			processData();
		}
	});

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.getData();
	}

	private void getData() {
		dataManager.getFlagData();
	}

	private void processData() {
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.activity_main_fragment_container, new FlagListFragment())
				.commit();
	}
}
