package com.tpcoinnew.others.enums;
/*
 * Created by NhatHoang on 14/09/2017.
 */

import com.tpcoinnew.R;

public enum TabsEnum {

    GET_COIN(1, R.string.get_coin, R.drawable.selector_coin),
    BONUS(2, R.string.bonus, R.drawable.selector_bonus),
    REWARD(3, R.string.reward, R.drawable.selector_reward),
    HISTORY(4, R.string.history, R.drawable.selector_history),
    MORE(5, R.string.more, R.drawable.selector_more);

    private int title;
    private int idIcon;
    private int order;

    TabsEnum(int order, int title, int idIcon) {
        this.title = title;
        this.idIcon = idIcon;
        this.order = order;
    }

    public int getTitle() {
        return title;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public int getOrder() {
        return order;
    }
}
