package com.test.game.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.GridLayout;

import com.test.game.ui.home.HomeViewModel;

import java.util.ArrayList;
import java.util.List;
/*
* This class is for creating
* the GridLayout in the form
* of 4 rows and 4 colums */

public class GameView extends GridLayout {

    public static Card[][] cards = new Card[4][4];
    private static List<Point> emptyPoints = new ArrayList<Point>();
    public int num[][] = new int[4][4];
    public int score;
    public boolean hasTouched = false;

    public GameView(Context context) {
        super(context);
        initView();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        super.onSizeChanged(w, h, oldw, oldh);
        int cardWidth = (Math.min(w, h)-10)/4;
        addCards(cardWidth, cardWidth);
        startGame();
    }

    /* init the 4*4 grid view */
    private void initView() {
        setRowCount(4);
        setColumnCount(4);
    }

    private void addCards(int cardWidth, int cardHeight) {
        this.removeAllViews();
        Card c;
        for(int y=0;y<4;++y) {
            for(int x = 0;x<4;++x) {
                c = new Card(getContext());
                c.setNum(0);
                addView(c, cardWidth, cardHeight);
                cards[x][y] = c;
            }
        }
    }

    public static void startGame() {
        for(int y=0;y<4;++y) {
            for(int x=0;x<4;++x) {
                cards[x][y].setNum(0);
            }
        }
        addRandomNum();
        addRandomNum();
    }

    private static void addRandomNum() {
        emptyPoints.clear();
        for (int y = 0; y < 4; ++y) {
            for (int x = 0; x < 4; ++x) {
                if (cards[x][y].getNum() == 0) {
                    emptyPoints.add(new Point(x, y));
                }
            }
        }

        Point p = emptyPoints.remove((int)(Math.random()*emptyPoints.size()));
        cards[p.x][p.y].setNum(Math.random()>0.1?2:4);
    }
}
