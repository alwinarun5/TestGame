package com.test.game.ui.home;

import android.os.Bundle;
import android.util.Log;

import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModelProviders;

import com.test.game.R;
import com.test.game.ViewModelProviderFactory;
import com.test.game.databinding.ActivityHomeBinding;
import com.test.game.ui.GameView;
import com.test.game.ui.base.BaseActivity;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator  {

    private HomeViewModel mHomeViewModel;
    private ActivityHomeBinding mActivityHomeBinding;
    public static int score = 0;
    public static HomeActivity homeActivity = null;

    @Inject
    ViewModelProviderFactory factory;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public HomeViewModel getViewModel() {
        mHomeViewModel = ViewModelProviders.of(this,factory).get(HomeViewModel.class);
        return mHomeViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityHomeBinding = getViewDataBinding();
        mHomeViewModel.setNavigator(this);
    }

    public HomeActivity() {
        homeActivity = this;
    }

    public static HomeActivity getHomeActivity() {
        return homeActivity;
    }

    @Override
    public void bestScore(int bestScore) {
        Log.i("SCORE:: BEST",String.valueOf(bestScore));
        mActivityHomeBinding.txtMaxScore.setText(String.valueOf(bestScore));
    }

    @Override
    public void currentScore(int currentScore) {
        Log.i("SCORE:: CURRENT",String.valueOf(currentScore));
        mActivityHomeBinding.txtScore.setText(String.valueOf(currentScore));
    }

    @Override
    public void startNewGame() {
        Log.i("SCORE:: NEW GAME","New game begin");
        GameView.startGame();
    }

    public void clearScore() {
        score = 0;
        showScore();
    }

    public void showScore() {
        mActivityHomeBinding.txtScore.setText(score + "");
    }

    public void addScore(int i) {

        score += i;
        showScore();
        mActivityHomeBinding.txtMaxScore.setText(String.valueOf(score));

    }
}
