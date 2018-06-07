package com.tpcoinnew.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;

import com.tpcoinnew.interfaces.DialogListener;
import com.tpcoinnew.others.dialog.AlertCustomDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/*
 * Created by NhatHoang on 20/04/2018.
 */
public class AppUtils {

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (cm != null) {
            netInfo = cm.getActiveNetworkInfo();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static void showAlert(final Context context, String title, String content, @Nullable final DialogListener listener) {
        AlertCustomDialog alertDialog = new AlertCustomDialog(context, title, content, listener);
        alertDialog.show();
    }

    public static void getHashKey(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    "com.tpcoinnew",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
