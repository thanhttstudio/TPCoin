package com.tpcoinnew.bases;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.tpcoinnew.R;
import com.tpcoinnew.activities.MainActivity;
import com.tpcoinnew.interfaces.FragmentResultListener;

import butterknife.Unbinder;


/*
 * Created by NhatHoang on 20/04/2018.
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mUnBinder;

    public void showLoading() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showLoading();
        }
    }

    public void hideLoading() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).hideLoading();
        }
    }

    public boolean isNetworkConnected() {
        return getActivity() instanceof BaseActivity && ((BaseActivity) getActivity()).isNetworkConnected();
    }

    public void addFragment(BaseFragment fragment, boolean isAddToBackStack, boolean isAnimation) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).addFragment(fragment, isAddToBackStack, isAnimation);
        }
    }

    public void setVisibilityTab(int visibility) {
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).tabWidget.setVisibility(visibility);
        }
    }

    public void replaceFragment(BaseFragment fragment, boolean isAddToBackStack, boolean isAnimation) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).replaceFragment(fragment, isAddToBackStack, isAnimation);
        }
    }

    public void showActionbar(View view, String title, boolean isShowBack) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showActionbar(view, title, isShowBack);
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    public void clearAllBackStack() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).clearAllBackStack();
        }
    }

}
