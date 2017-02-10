package com.lisn.viewpagerfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private ViewPager vp;
    private List<Fragment> mFragments = new ArrayList<>();

    String ss = new String("hhhhh");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        long round = Math.round(11.5);
        long round2 = Math.round(-11.5);
        tv1.setText(round + "");
        tv2.setText(round2 + "");
        chenge();
        tv3.setText(ss);

//        mFragments.add(new WeiYanFragment());
        mFragments.add(BlankFragment.getInstance("Fragment1"));
        mFragments.add(BlankFragment.getInstance("Fragment2"));
        mFragments.add(BlankFragment.getInstance("Fragment3"));
        mFragments.add(BlankFragment.getInstance("Fragment4"));
        mFragments.add(BlankFragment.getInstance("Fragment5"));

        vp.setAdapter(new MyAdaper(getSupportFragmentManager()));

    }

    private void chenge() {
        ss = "yyyy";
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);

        vp = (ViewPager) findViewById(R.id.vp);
    }

    private class MyAdaper extends FragmentPagerAdapter {

        public MyAdaper(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
