package de.handler.mobile.android.databindingexample.data.network;

import java.util.List;

import de.handler.mobile.android.databindingexample.data.model.FlagData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.Result;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Manages all network traffic of the app
 */
public class DataManager {
	public interface OnDataReceivedListener {
		void onDataReceived(List<FlagData.WorldPopulation> countries);
	}

	private final FlagService service;
	private OnDataReceivedListener onDataReceivedListener;

	public DataManager(OnDataReceivedListener onDataReceivedListener) {
		this.onDataReceivedListener = onDataReceivedListener;
		Retrofit retrofit = new Retrofit.Builder()
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.baseUrl(FlagService.BASE_URL)
				.build();

		service = retrofit.create(FlagService.class);
	}

	public void getFlagData() {
		Observable<Result<FlagData>> result = service.getFlagData()
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread());

		result.subscribe(new Subscriber<Result<FlagData>>() {
			@Override
			public void onCompleted() {
				// ignore for now
			}

			@Override
			public void onError(Throwable e) {
				// ignore for now
				// TODO implement error handling
			}

			@Override
			public void onNext(Result<FlagData> flagDataResult) {
				onDataReceivedListener.onDataReceived(flagDataResult.response().body().getWorldPopulation());
			}
		});
	}
}
