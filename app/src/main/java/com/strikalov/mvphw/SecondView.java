package com.strikalov.mvphw;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface SecondView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showResult(String result);

    @StateStrategyType(SkipStrategy.class)
    void getUserText();

    @StateStrategyType(SkipStrategy.class)
    void showError(int resourceId);

    @StateStrategyType(SkipStrategy.class)
    void resetEditText();

}
