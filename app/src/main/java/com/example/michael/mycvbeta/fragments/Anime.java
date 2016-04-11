package com.example.michael.mycvbeta.fragments;


import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.mycvbeta.MainActivity;
import com.example.michael.mycvbeta.R;
import com.example.michael.mycvbeta.adapters.CustomerSwipeAdapter;
import com.example.michael.mycvbeta.adapters.MyFragmentPagerAdapter;
import com.example.michael.mycvbeta.adapters.ViewPagerCustomDuration;
import com.example.michael.mycvbeta.inner_fragments.Fragment1;
import com.example.michael.mycvbeta.inner_fragments.Fragment2;
import com.example.michael.mycvbeta.inner_fragments.Fragment3;
import com.example.michael.mycvbeta.inner_fragments.Fragment4;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Michael on 16-03-2016.
 */
public class Anime extends Fragment {
    ViewPager animeViewPager;

    CustomerSwipeAdapter customerSwipeAdapter;
    ImageView dot1;
    ImageView dot2;
    ImageView dot3;
    ImageView dot4;
    TextView tvdescript;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment3_layout, container, false);
        dot1 = (ImageView) v.findViewById(R.id.dot1);
        dot2 = (ImageView) v.findViewById(R.id.dot2);
        dot3 = (ImageView) v.findViewById(R.id.dot3);
        dot4 = (ImageView) v.findViewById(R.id.dot4);

        animeViewPager = (ViewPager) v.findViewById(R.id.animeViewpager);
        tvdescript = (TextView)v.findViewById(R.id.descriptionId);
        tvdescript.setText(R.string.clannad_description);
//        animeViewPager.setScrollDurationFactor(2); // make the animation twice as slow

        customerSwipeAdapter = new CustomerSwipeAdapter(getContext());
        animeViewPager.setAdapter(customerSwipeAdapter);


        animeViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            int positionCurrent;
            boolean dontLoadList;
            private int previousState, currentState;



            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


//                positionCurrent = position;
//                if (positionOffset == 0 && positionOffsetPixels == 0) // the offset is zero when the swiping ends
//                {
//                    dontLoadList = false;
//                } else
//                    dontLoadList = true; // To avoid loading content for list after swiping the pager.
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tvdescript.setText(R.string.clannad_description);
                        dot1.setImageResource(R.drawable.circle_selected);
                        dot2.setImageResource(R.drawable.circle);
                        dot3.setImageResource(R.drawable.circle);
                        dot4.setImageResource(R.drawable.circle);

                        break;

                    case 1:
                        tvdescript.setText(R.string.fairytail_description);
                        dot1.setImageResource(R.drawable.circle);
                        dot2.setImageResource(R.drawable.circle_selected);
                        dot3.setImageResource(R.drawable.circle);
                        dot4.setImageResource(R.drawable.circle);

                        break;

                    case 2:
                        tvdescript.setText(R.string.tora_description);
                        dot1.setImageResource(R.drawable.circle);
                        dot2.setImageResource(R.drawable.circle);
                        dot3.setImageResource(R.drawable.circle_selected);
                        dot4.setImageResource(R.drawable.circle);

                        break;

                    case 3:
                        tvdescript.setText(R.string.kyoukai_descrip);
                        dot1.setImageResource(R.drawable.circle);
                        dot2.setImageResource(R.drawable.circle);
                        dot3.setImageResource(R.drawable.circle);
                        dot4.setImageResource(R.drawable.circle_selected);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {




//                int currentPage = animeViewPager.getCurrentItem();
//                if (currentPage == 0) {
//                    animeViewPager.setCurrentItem(0);
//                }


//                if (state == 0) { // the viewpager is idle as swipping ended
//                    new Handler().postDelayed(new Runnable() {
//                        public void run() {
//                            if (!dontLoadList) {
//                                //async thread code to execute loading the list...
//                            }
//                        }
//                    }, 200);
//                }
            }
        });


        return v;
    }
}
