package de.handler.mobile.android.databindingexample.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.handler.mobile.android.databindingexample.R;
import de.handler.mobile.android.databindingexample.data.ActionCallback;
import de.handler.mobile.android.databindingexample.data.DataBoundAdapter;
import de.handler.mobile.android.databindingexample.data.DataBoundViewHolder;
import de.handler.mobile.android.databindingexample.data.model.FlagData;
import de.handler.mobile.android.databindingexample.databinding.FlagItemBinding;
import de.handler.mobile.android.databindingexample.databinding.FragmentFlagListBinding;

public class FlagListFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		FragmentFlagListBinding binding = DataBindingUtil.inflate(
				inflater,
				R.layout.fragment_flag_list,
				container,
				false);

		ActionCallback actionCallback = new ActionCallback() {
			@Override
			public void onClick(FlagData.WorldPopulation worldPopulation) {
				//TODO: continue implementation https://github.com/google/android-ui-toolkit-demos/tree/master/DataBinding/DataBoundRecyclerView/app/src/main;
			}
		};

		return binding.getRoot();
	}


	/**
	 * This is an example of a data bound adapter use case where all items have the same type.
	 * <p>
	 * The parent class handles the item creation and this child class only implements the
	 * bindItem to set values in a type checked way.
	 */
	private static class WorldPopulationAdapter extends DataBoundAdapter<FlagItemBinding> {
		List<FlagData.WorldPopulation> mFlagDataList = new ArrayList<>();
		private ActionCallback mActionCallback;

		public WorldPopulationAdapter(ActionCallback actionCallback, FlagData.WorldPopulation... worldPopulations) {
			super(R.layout.flag_item);
			mActionCallback = actionCallback;
			Collections.addAll(mFlagDataList, worldPopulations);
		}

		@Override
		protected void bindItem(DataBoundViewHolder<FlagItemBinding> holder, int position,
								List<Object> payloads) {
			holder.binding.setData(mFlagDataList.get(position));
			holder.binding.setCallback(mActionCallback);
		}

		@Override
		public int getItemCount() {
			return mFlagDataList.size();
		}
	}
}
