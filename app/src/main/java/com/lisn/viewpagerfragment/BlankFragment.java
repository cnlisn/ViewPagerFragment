package com.lisn.viewpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {


    private String mTitle;
    private boolean isPrepared;
    private boolean isVisible;

    private BlankFragment() {
    }

    public static BlankFragment getInstance(String title) {
        BlankFragment sf = new BlankFragment();
        sf.mTitle = title;
        return sf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(mTitle);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.d("----------------"+mTitle+"====");
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //懒加载
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isVisible || !isPrepared) {
            return;
        }
        //getData();//数据请求
        Logger.e("----可见-----"+mTitle+"====");
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
        Logger.e("----不可见-----"+mTitle+"====");
    }
}
