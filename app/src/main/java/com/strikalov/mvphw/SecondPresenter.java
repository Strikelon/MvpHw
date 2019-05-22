package com.strikalov.mvphw;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SecondPresenter extends MvpPresenter<SecondView> {

    private Model model;

    public SecondPresenter(){
        model = new Model();
    }

    public void onViewCreate() {
        getViewState().showResult(model.getResult());
    }

    public void onAddButtonClicked() {
        getViewState().getUserText();
    }

    public void onGetUserText(String userText) {


        if (!TextUtils.isEmpty(userText)) {

            String result = model.add(userText);
            getViewState().showResult(result);
            getViewState().resetEditText();

        } else {

            getViewState().showError(R.string.error_no_text);

        }

    }

}
