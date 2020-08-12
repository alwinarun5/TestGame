package com.test.game.ui;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

    private int mNum = 0;
    private TextView mLable;

    public Card(Context context) {
        super(context);
        mLable = new TextView(getContext());
        mLable.setTextSize(32);
        mLable.setGravity(Gravity.CENTER);
        LayoutParams lp = new LayoutParams(-1, -1);
        lp.setMargins(10, 10, 0, 0);
        addView(mLable, lp);
        setNum(0);
    }

    public int getNum() {
        return mNum;
    }

    public void setNum(int mNum) {

        this.mNum = mNum;
        if (mNum > 0) {
            mLable.setText(mNum + "");
        } else {
            mLable.setText("");
        }

        switch (mNum) {
            case 0: mLable.setBackgroundColor(0xffccc0b2); break;
            case 2: mLable.setBackgroundColor(0xffeee4da); break;
            case 4: mLable.setBackgroundColor(0xffede0c8); break;
            case 8: mLable.setBackgroundColor(0xfff2b179); break;
            case 16: mLable.setBackgroundColor(0xfff59563); break;
            case 32: mLable.setBackgroundColor(0xfff67c5f); break;
            case 64: mLable.setBackgroundColor(0xfff65e3b); break;
            case 128: mLable.setBackgroundColor(0xffedcf72); break;
            case 256: mLable.setBackgroundColor(0xffedc750); break;
            case 512: mLable.setBackgroundColor(0xffedc850); break;
            case 1024: mLable.setBackgroundColor(0xffecc640); break;
            default: mLable.setBackgroundColor(0xffedc22d); break;
        }

    }

    public boolean equals(Card card) {
        return getNum()==card.getNum();
    }
}
