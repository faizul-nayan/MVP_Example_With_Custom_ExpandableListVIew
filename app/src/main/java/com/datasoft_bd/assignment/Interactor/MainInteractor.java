package com.datasoft_bd.assignment.Interactor;

import android.content.Context;

import com.datasoft_bd.assignment.Storage.NewExpanseObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public interface MainInteractor {

    interface OnFinishedListener {
        void onFinished(ArrayList<String> totalList, HashMap<String,
                ArrayList<NewExpanseObject>> dataList, ArrayList<String> catagoryList);
    }

    void getData(OnFinishedListener listener, Context context);
}
