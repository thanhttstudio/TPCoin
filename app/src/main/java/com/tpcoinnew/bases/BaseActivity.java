package com.tpcoinnew.bases;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.tpcoinnew.R;
import com.tpcoinnew.activities.MainActivity;
import com.tpcoinnew.models.CustomTransaction;
import com.tpcoinnew.others.dialog.LoadingDialog;
import com.tpcoinnew.utils.NetworkUtils;

import butterknife.Unbinder;

/*
 * Created by NhatHoang on 14/05/2018.
 */
public abstract class BaseActivity extends AppCompatActivity {

    View.OnClickListener onBackClick = view -> onBackPressed();
    private LoadingDialog mDialogView;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }


    public void showLoading() {
        if (NetworkUtils.isNetworkConnected(this))
            if (mDialogView != null) {
                mDialogView.show();
            } else {
                mDialogView = new LoadingDialog(this);
                mDialogView.setCanceledOnTouchOutside(false);
                mDialogView.show();
            }
    }


    public void hideLoading() {
        if (mDialogView != null) {
            mDialogView.dismiss();
        }
    }


    public void showActionbar(View view, String title, boolean isShowBack) {
        TextView tvTitle = view.findViewById(R.id.actionbar_tvTitle);
        View vBack = view.findViewById(R.id.actionbar_imgBack);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
        if (vBack != null) {
            vBack.setVisibility(isShowBack ? View.VISIBLE : View.GONE);
            vBack.setOnClickListener(onBackClick);
        }
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    public void addFragment(BaseFragment fragment, boolean isAddToBackStack, boolean isAnimation) {
        addReplaceFragment(new CustomTransaction(isAnimation), fragment, false, isAddToBackStack);
    }


    public void replaceFragment(BaseFragment fragment, boolean isAddToBackStack, boolean isAnimation) {
        addReplaceFragment(new CustomTransaction(isAnimation), fragment, true, isAddToBackStack);
    }

    public void addReplaceFragment(CustomTransaction customTransaction, BaseFragment fragment, boolean isReplace, boolean isAddToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (customTransaction.isAnimation)
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            if (isReplace)
                fragmentTransaction.replace(customTransaction.containerViewId != 0 ? customTransaction.containerViewId : this instanceof MainActivity ? android.R.id.tabcontent : R.id.frmContainer, fragment);
            else {
                Fragment currentFragment = getSupportFragmentManager().findFragmentById(customTransaction.containerViewId != 0 ? customTransaction.containerViewId : this instanceof MainActivity ? android.R.id.tabcontent : R.id.frmContainer);
                if (currentFragment != null) {
                    fragmentTransaction.hide(currentFragment);
                }
                fragmentTransaction.add(customTransaction.containerViewId != 0 ? customTransaction.containerViewId : this instanceof MainActivity ? android.R.id.tabcontent : R.id.frmContainer, fragment, fragment.getClass().getSimpleName());
            }
            if (isAddToBackStack) {
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            }
            fragmentTransaction.commit();
        }
    }

    public void clearAllBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStack();
        }
    }

}
