package de.handler.mobile.android.databindingexample.data;

import de.handler.mobile.android.databindingexample.data.model.FlagData;
import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import rx.Observable;

interface FlagService {
	String BASE_URL = "http://bit.ly/";

	@GET("1CgxlqK")
	Observable<Result<FlagData>> getFlagData();
}
