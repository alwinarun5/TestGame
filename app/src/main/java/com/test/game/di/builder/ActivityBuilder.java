package com.test.game.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract com.test.game.ui.home.HomeActivity bindHomeActivity();

}
