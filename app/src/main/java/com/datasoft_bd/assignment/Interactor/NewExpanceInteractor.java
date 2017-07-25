package com.datasoft_bd.assignment.Interactor;

import android.content.Context;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public interface NewExpanceInteractor {

    static final String NULLPURPOSE = "Please Enter Expanse Purpose";
    static final String NULLAMOUNT = "Please Enter Expanse Amount";
    static final String SUCCESS = "Data Insert";
    static final int PURPOSECODE = 1;
    static final int AMOUNTCODE = 2;
    static final int SCCESSCODE = 0;
    interface OnInsertFinishListener{

        void onSuccess(boolean flag);
        void onTransction(String message, int code);
    }

    void insert(String purpose, String amount, String catagory, OnInsertFinishListener onInsertFinishListener, Context context);
}
