package com.datasoft_bd.assignment.View;

import com.datasoft_bd.assignment.Storage.NewExpanseObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public interface MainView {


    void setItems(ArrayList<String> totalList, HashMap<String, ArrayList<NewExpanseObject>> dataList, ArrayList<String> catagoryList);

    void showMessage(String message);
}
