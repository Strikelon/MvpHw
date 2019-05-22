package com.strikalov.mvphw;

import android.text.TextUtils;

public class FirstPresenter {

    private FirstView firstView;
    private Model model;

    public FirstPresenter(){
        model = new Model();
    }

    public void attachView(FirstView firstView){
        this.firstView = firstView;
    }

    public void onViewCreate(){
        if(firstView != null){
            firstView.showResult(model.getResult());
        }
    }

    public void onAddButtonClicked(){
        if(firstView != null){
            firstView.getUserText();
        }
    }

    public void onGetUserText(String userText){

        if(firstView != null) {

            if (!TextUtils.isEmpty(userText)) {

                String result = model.add(userText);
                firstView.showResult(result);
                firstView.resetEditText();

            } else {

                firstView.showError(R.string.error_no_text);

            }

        }
    }

}
