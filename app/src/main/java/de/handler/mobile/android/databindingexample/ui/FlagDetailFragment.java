package de.handler.mobile.android.databindingexample.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.handler.mobile.android.databindingexample.R;
import de.handler.mobile.android.databindingexample.data.model.FlagData;
import de.handler.mobile.android.databindingexample.databinding.FragmentFlagDetailBinding;

public class FlagDetailFragment extends Fragment {
	private static final String ARG_WORLD_POPULATION = "arg_world_polulation";

	public static FlagDetailFragment newInstance(FlagData.WorldPopulation worldPopulation) {
		FlagDetailFragment fragment = new FlagDetailFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(ARG_WORLD_POPULATION, worldPopulation);
		fragment.setArguments(bundle);
		return fragment;
	}


	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		FragmentFlagDetailBinding binding = DataBindingUtil.inflate(
				inflater,
				R.layout.fragment_flag_detail,
				container,
				false);

		FlagData.WorldPopulation worldPopulation = getArguments().getParcelable(ARG_WORLD_POPULATION);
		binding.setWorldPopulation(worldPopulation);

		return binding.getRoot();
	}
}
