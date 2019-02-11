package com.linglingyi.com.sample;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2019/1/29.
 */

public class BannerAdapter extends PagerAdapter {


    private final List<String> data;

    public BannerAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.main_page_image, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image_page);
        Glide.with(container.getContext())
                .load(data.get(position))
                .into(imageView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView((View) object);

    }
}
