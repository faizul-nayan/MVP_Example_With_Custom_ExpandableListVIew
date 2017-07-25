package com.datasoft_bd.assignment.Presenter.Impl;

import android.content.Context;

import com.datasoft_bd.assignment.Interactor.Impl.NewExpanseInteractorImpl;
import com.datasoft_bd.assignment.Interactor.NewExpanceInteractor;
import com.datasoft_bd.assignment.Presenter.NewExpansePresenter;
import com.datasoft_bd.assignment.View.NewExpanseView;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public class NewExpansePresenterImpl implements NewExpansePresenter, NewExpanceInteractor.OnInsertFinishListener {

    private NewExpanseView expanseView;
    private NewExpanceInteractor expanceInteractor;
    private Context context;

    public NewExpansePresenterImpl(NewExpanseView expanseView, NewExpanseInteractorImpl expanceInteractor, Context context) {
        this.expanseView = expanseView;
        this.expanceInteractor = expanceInteractor;
        this.context = context;
    }


    @Override
    public void onResume() {
        if(expanseView != null){}
    }

    @Override
    public void onDestroy() {
        expanseView = null;
    }

    @Override
    public void saveData(String purpose, String amount, String catagory) {

        expanceInteractor.insert(purpose, amount, catagory, this, context);
    }


    @Override
    public void onSuccess(boolean flag) {

            expanseView.resetFields(flag);

    }

    @Override
    public void onTransction(String message, int code) {
            expanseView.showMessage(message, code);
    }
}
