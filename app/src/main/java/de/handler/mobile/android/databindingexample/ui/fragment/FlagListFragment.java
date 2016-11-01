package de.handler.mobile.android.databindingexample.ui.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.handler.mobile.android.databindingexample.R;
import de.handler.mobile.android.databindingexample.ui.adapter.DataBoundAdapter;
import de.handler.mobile.android.databindingexample.data.model.FlagData;
import de.handler.mobile.android.databindingexample.databinding.FlagItemBinding;
import de.handler.mobile.android.databindingexample.databinding.FragmentFlagListBinding;
import de.handler.mobile.android.databindingexample.ui.callback.ActionCallback;
import de.handler.mobile.android.databindingexample.ui.viewholder.DataBoundViewHolder;

public class FlagListFragment extends Fragment {
	private static final String ARG_COUNTRIES = "argument_countries";
	private ActionCallback mActionCallback;

	public static FlagListFragment newInstance(List<FlagData.WorldPopulation> countries) {
		FlagListFragment fragment = new FlagListFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelableArrayList(ARG_COUNTRIES, new ArrayList<>(countries));
		fragment.setArguments(bundle);
		return fragment;
	}


	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mActionCallback = (ActionCallback) context;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		FragmentFlagListBinding binding = DataBindingUtil.inflate(
				inflater,
				R.layout.fragment_flag_list,
				container,
				false);

		List<FlagData.WorldPopulation> countries = getArguments().getParcelableArrayList(ARG_COUNTRIES);
		WorldPopulationListAdapter worldPopulationListAdapter = new WorldPopulationListAdapter(mActionCallback, countries);
		binding.fragmentFlagListRecyclerView.setAdapter(worldPopulationListAdapter);

		return binding.getRoot();
	}


	private static class WorldPopulationListAdapter extends DataBoundAdapter<FlagItemBinding> {
		private List<FlagData.WorldPopulation> mFlagDataList = new ArrayList<>();
		private ActionCallback mActionCallback;

		WorldPopulationListAdapter(ActionCallback actionCallback, List<FlagData.WorldPopulation> worldPopulations) {
			super(R.layout.flag_item);
			mActionCallback = actionCallback;
			mFlagDataList = worldPopulations;
		}

		@Override
		protected void bindItem(DataBoundViewHolder<FlagItemBinding> holder, int position,
								List<Object> payloads) {
			holder.mBinding.setData(mFlagDataList.get(position));
			holder.mBinding.setCallback(mActionCallback);
		}

		@Override
		public int getItemCount() {
			return mFlagDataList.size();
		}
	}
}
