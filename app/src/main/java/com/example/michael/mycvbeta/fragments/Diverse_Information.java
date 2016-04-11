package com.example.michael.mycvbeta.fragments;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.example.michael.mycvbeta.R;
import com.example.michael.mycvbeta.adapters.MyFragmentPagerAdapter;
import com.example.michael.mycvbeta.inner_fragments.Fragment1;
import com.example.michael.mycvbeta.inner_fragments.Fragment2;
import com.example.michael.mycvbeta.inner_fragments.Fragment3;
import com.example.michael.mycvbeta.inner_fragments.Fragment4;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Michael on 16-03-2016.
 */
public class Diverse_Information extends Fragment implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {
    ViewPager viewPager;
    private TabHost tabHost;
    TabWidget tabWidget;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    int fragmentID;

    View v;
    int iCV = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.viewpager_main, container, false);

        iCV++;

        //fragmentID = this.getArguments().getInt("fragmentId");
//        String getArgument = this.getArguments().getString("data");
//        Toast.makeText(getContext(), getArgument, Toast.LENGTH_LONG).show();
//            MainActivity activity = (MainActivity) getActivity();
//        String myDataFromActivity = activity.getMyData();
//        Toast.makeText(getContext(), myDataFromActivity, Toast.LENGTH_LONG).show();

        this.initViewPager();
        this.initTabHost(savedInstanceState, fragmentID);


        return v;
    }

    public class FakeContent implements TabHost.TabContentFactory {
        Context context;

        public FakeContent(Context mcontext) {
            context = mcontext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumHeight(0);
            return fakeView;
        }
    }
    private void initViewPager() {


        List<Fragment> listFragments = new ArrayList<Fragment>();
        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());
        listFragments.add(new Fragment4());

        this.myFragmentPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager(), listFragments);
        this.viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        this.viewPager.setAdapter(myFragmentPagerAdapter);
        this.viewPager.setOnPageChangeListener(this);
    }

    private void initTabHost(Bundle args, int fragId) {
        tabHost = (TabHost) v.findViewById(R.id.tabHost);
        tabHost.setup();


        String[] tabNames = {"fish", "dog", "cat",""};

        for (int i = 0; i < tabNames.length; i++) {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            Drawable a = ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_person_black_24dp);
            whiteIconPaint(a);
            Drawable b = ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_laptop_black_24dp);
            whiteIconPaint(b);
            Drawable c = ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_group_black_24dp);
            whiteIconPaint(c);
            Drawable d = ContextCompat.getDrawable(getContext().getApplicationContext(), R.drawable.ic_info_outline_black_24dp);
            whiteIconPaint(d);
            if (tabNames[i].equalsIgnoreCase("fish")) {
                tabSpec.setIndicator("", a);
            } else if (tabNames[i].equalsIgnoreCase("dog")) {
                tabSpec.setIndicator("", b);
            } else if (tabNames[i].equalsIgnoreCase("cat")) {
                tabSpec.setIndicator("", c);
            }else
                tabSpec.setIndicator("", d);

            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);

        }
        tabHost.setOnTabChangedListener(this);
   tabHost.setCurrentTab(3);
    }
    private void whiteIconPaint(Drawable a) {
        Resources res = getResources();
        int primaryColor = res.getColor(R.color.colorAccent3);
        a.setColorFilter(primaryColor, PorterDuff.Mode.SRC_IN);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int selectedItem) {
        tabHost.setCurrentTab(selectedItem);
    }

    //viewPager Listener
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //TabHostlistener
    @Override
    public void onTabChanged(String tabId) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);


        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) v.findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();


        int scrollPos = tabView.getLeft() - (horizontalScrollView.getWidth() - tabView.getWidth()) / 2;
        horizontalScrollView.smoothScrollBy(scrollPos, 0);
    }

    @Override
    public void onPause() {
        tabHost.setCurrentTab(3);
        super.onPause();

    }
}
