package com.datasoft_bd.assignment.Interactor.Impl;

import android.content.Context;

import com.datasoft_bd.assignment.Interactor.MainInteractor;
import com.datasoft_bd.assignment.Storage.NewExpanseObject;
import com.datasoft_bd.assignment.Storage.RealmOperations;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public class MainInteractorImpl implements MainInteractor {

    private RealmOperations realmOperations;
    private HashMap<String, ArrayList<NewExpanseObject>> dataList;
    private ArrayList<String> totalList;
    private ArrayList<String> catagoryList;

    @Override
    public void getData(final OnFinishedListener listener, Context context) {
        realmOperations = new RealmOperations(context);
        dataList = realmOperations.getData();
        totalList = realmOperations.getTotalAmount();
        catagoryList = realmOperations.getCatagoryList();

        listener.onFinished(totalList, dataList, catagoryList);

    }

}
