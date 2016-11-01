package de.handler.mobile.android.databindingexample.ui.callback;

import android.support.annotation.NonNull;

import de.handler.mobile.android.databindingexample.data.model.FlagData;

public interface ActionCallback {
	void onClick(@NonNull FlagData.WorldPopulation worldPopulation);
}
