package com.datasoft_bd.assignment.Presenter;

/**
 * Created by Faizul Haque Nayan on 7/25/2017.
 */

public interface NewExpansePresenter {

    void onResume();
    void onDestroy();

    void saveData(String purpose, String amount, String catagory);
}
