package com.datasoft_bd.assignment.Interactor.Impl;

import android.content.Context;

import com.datasoft_bd.assignment.Interactor.NewExpanceInteractor;
import com.datasoft_bd.assignment.Storage.RealmOperations;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public class NewExpanseInteractorImpl implements NewExpanceInteractor {

    private RealmOperations realmOperations;
    @Override
    public void insert(String purpose, String amount, String catagory, OnInsertFinishListener onInsertFinishListener, Context context) {

        if(purpose.equalsIgnoreCase("")){
            onInsertFinishListener.onTransction(NULLPURPOSE,PURPOSECODE);
        }
        else if(amount.equalsIgnoreCase("")){
            onInsertFinishListener.onTransction(NULLAMOUNT,AMOUNTCODE);
        }
        else {
            realmOperations = new RealmOperations(context);
            boolean temp = realmOperations.insertData(purpose,
                    Double.parseDouble(amount),catagory);
            if(temp){
                onInsertFinishListener.onSuccess(temp);
                onInsertFinishListener.onTransction(SUCCESS, SCCESSCODE);
            }
        }
    }
}
