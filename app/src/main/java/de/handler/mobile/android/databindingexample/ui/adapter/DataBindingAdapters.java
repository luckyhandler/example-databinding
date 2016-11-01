package de.handler.mobile.android.databindingexample.ui.adapter;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Defines how to use the namespaces in xml and how they are bound to data for data binding.
 */
public class DataBindingAdapters {
	@BindingAdapter("android:src")
	public static void setImageUri(ImageView view, String imageUri) {
		if (imageUri == null) {
			view.setImageURI(null);
		} else {
			view.setImageURI(Uri.parse(imageUri));
		}
	}

	@BindingAdapter("android:src")
	public static void setImageUri(ImageView view, Uri imageUri) {
		view.setImageURI(imageUri);
	}

	@BindingAdapter("android:src")
	public static void setImageDrawable(ImageView view, Drawable drawable) {
		view.setImageDrawable(drawable);
	}

	@BindingAdapter("android:src")
	public static void setImageResource(ImageView imageView, int resource){
		imageView.setImageResource(resource);
	}

	@BindingAdapter("android:src")
	public static void setImageUrl(ImageView imageView, String imageUrl) {
		Picasso.with(imageView.getContext())
				.load(imageUrl)
				.into(imageView);
	}
}
