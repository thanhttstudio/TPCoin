package com.tpcoinnew.activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.tpcoinnew.R;
import com.tpcoinnew.bases.BaseActivity;
import com.tpcoinnew.fragment.BonusFragment;
import com.tpcoinnew.fragment.CoinFragment;
import com.tpcoinnew.fragment.HistoryFragment;
import com.tpcoinnew.fragment.MoreFragment;
import com.tpcoinnew.fragment.RewardFragment;
import com.tpcoinnew.others.enums.TabsEnum;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(android.R.id.tabs)
    public TabWidget tabWidget;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initiateTabHost();
    }

    private void initiateTabHost() {
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        tabHost.addTab(createTabSpec(TabsEnum.GET_COIN), CoinFragment.class, null);
        tabHost.addTab(createTabSpec(TabsEnum.BONUS), BonusFragment.class, null);
        tabHost.addTab(createTabSpec(TabsEnum.REWARD), RewardFragment.class, null);
        tabHost.addTab(createTabSpec(TabsEnum.HISTORY), HistoryFragment.class, null);
        tabHost.addTab(createTabSpec(TabsEnum.MORE), MoreFragment.class, null);
        setTabsColor();
        tabHost.setOnTabChangedListener(s -> {
            clearAllBackStack();
            setTabsColor();
        });
    }

    public TabHost.TabSpec createTabSpec(TabsEnum tab) {
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tab.toString());
        View view = LayoutInflater.from(this).inflate(R.layout.view_tab_main, null, false);
        ((ImageView) view.findViewById(R.id.viewTab_imgIcon)).setImageResource(tab.getIdIcon());
        ((TextView) view.findViewById(R.id.viewTab_tvTitle)).setText(tab.getTitle());
        tabSpec.setIndicator(view);
        return tabSpec;
    }

    private void setTabsColor() {
        for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
            setColorForView(i, false);
        }
        setColorForView(tabHost.getCurrentTab(), true);
    }

    private void setColorForView(int i, boolean select) {
        View view = tabHost.getTabWidget().getChildAt(i);
        ImageView imgIcon = view.findViewById(R.id.viewTab_imgIcon);
        TextView tvTitle = view.findViewById(R.id.viewTab_tvTitle);
        ConstraintLayout clMain = view.findViewById(R.id.viewTab_clMain);
        int widthAfter = getResources().getDimensionPixelSize(R.dimen._80dp);
        int widthDefault = getResources().getDimensionPixelSize(R.dimen._22dp);
        imgIcon.getLayoutParams().width = i == 2 ? widthAfter : widthDefault;
        imgIcon.setSelected(select);
        tvTitle.setTextColor(ContextCompat.getColor(this, select ? R.color.colorPrimary : R.color.silver));
        imgIcon.setColorFilter(getResources().getColor(select ? R.color.colorPrimary : R.color.silver), PorterDuff.Mode.SRC_IN);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager fragmentManager = getSupportFragmentManager();
        int stackCount = fragmentManager.getBackStackEntryCount();
        if (stackCount <= 0) {
            tabWidget.setVisibility(View.VISIBLE);
        }
    }

}

