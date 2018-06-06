package com.tpcoinnew.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tpcoinnew.activities.AuthActivity;
import com.tpcoinnew.activities.MainActivity;


public class StartActivityUtils {
    public static void toMain(Context context, Bundle bundle) {
        Intent intent = new Intent().setClass(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (bundle != null)
            intent.putExtras(bundle);
        context.startActivity(intent);
    }

    public static void toAuth(Context context) {
        Intent intent = new Intent().setClass(context, AuthActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
