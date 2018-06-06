package com.tpcoinnew.others.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;


import com.tpcoinnew.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/*
 * Created by NhatHoang on 14/05/2018.
 */
public class LoadingDialog extends Dialog {
    @BindView(R.id.dialogLoading_pbLoading)
    ProgressBar pbLoading;

    public LoadingDialog(Context context) {
        super(context, android.R.style.Theme_Holo_Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getWindow() != null) {
            getWindow().setDimAmount(0.3f);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        setContentView(R.layout.dialog_loading);
        ButterKnife.bind(this);
        pbLoading.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(getContext(), R.color.colorPrimary), PorterDuff.Mode.SRC_IN);
    }
}
