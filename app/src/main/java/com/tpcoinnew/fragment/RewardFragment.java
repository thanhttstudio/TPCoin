package com.tpcoinnew.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tpcoinnew.R;
import com.tpcoinnew.bases.BaseFragment;

public class RewardFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reward, container, false);
        showActionbar(view, getString(R.string.reward), false);
        return view;
    }

}
