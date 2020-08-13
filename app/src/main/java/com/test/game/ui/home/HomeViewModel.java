package com.test.game.ui.home;
import com.test.game.ui.base.BaseViewModel;

public class HomeViewModel extends BaseViewModel<com.test.game.ui.home.HomeNavigator> {

    public HomeViewModel() {
        super();
    }

    public void startGame(){
        getNavigator().startNewGame();

    }


}
