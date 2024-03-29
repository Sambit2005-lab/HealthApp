package com.example.healthapp;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.slider.Slider;

import java.util.Arrays;
import java.util.List;


public class homeFragment extends Fragment {
    View layout;
    Activity activity;

    private ViewPager2 viewpager;

    private SliderAdapter sliderAdapter;
    private Handler sliderHandler = new Handler();
    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewpager.setCurrentItem(viewpager.getCurrentItem() + 1);
        }
    };


    public homeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_home, container, false);

        viewpager = layout.findViewById(R.id.viewpager);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        List<Integer> images = Arrays.asList(R.drawable.doctor2, R.drawable.doctor1, R.drawable.doctor3);
        sliderAdapter = new SliderAdapter(images);

        viewpager.setAdapter(sliderAdapter);


        startSliderAutoScroll();


        return layout;
    }

    private void startSliderAutoScroll() {
        sliderHandler.postDelayed(sliderRunnable, 3000); // Delay in milliseconds (adjust as needed)
    }

    private void stopSliderAutoScroll() {
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        stopSliderAutoScroll();
    }
}
