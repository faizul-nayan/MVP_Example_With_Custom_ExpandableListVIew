package com.datasoft_bd.assignment.Presenter.Impl;

import android.content.Context;

import com.datasoft_bd.assignment.Interactor.Impl.MainInteractorImpl;
import com.datasoft_bd.assignment.Interactor.MainInteractor;
import com.datasoft_bd.assignment.Storage.NewExpanseObject;
import com.datasoft_bd.assignment.Presenter.MainPresenter;
import com.datasoft_bd.assignment.View.MainView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public class MainPresenterImpl implements MainPresenter,  MainInteractor.OnFinishedListener{

    private MainView mainView;
    private MainInteractor mainInteractor;
    private Context context;

    public MainPresenterImpl(MainView mainView, MainInteractorImpl findItemsInteractor, Context context) {
        this.mainView = mainView;
        this.mainInteractor = findItemsInteractor;
        this.context = context;
    }

    @Override
    public void onResume() {
        if (mainView != null) {

        }

        mainInteractor.getData(this, context);
    }


    @Override
    public void onFinished(ArrayList<String> totalList, HashMap<String,
            ArrayList<NewExpanseObject>> dataList, ArrayList<String> catagoryList) {

        if (mainView != null) {
            mainView.setItems(totalList, dataList, catagoryList);

        }
    }

    @Override public void onDestroy() {
        mainView = null;
    }

    public MainView getMainView() {
        return mainView;
    }

}
