package com.datasoft_bd.assignment.View.root;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.datasoft_bd.assignment.Storage.ExpandableListAdapter;
import com.datasoft_bd.assignment.Interactor.Impl.MainInteractorImpl;
import com.datasoft_bd.assignment.Storage.NewExpanseObject;
import com.datasoft_bd.assignment.Presenter.Impl.MainPresenterImpl;
import com.datasoft_bd.assignment.Presenter.MainPresenter;
import com.datasoft_bd.assignment.R;
import com.datasoft_bd.assignment.View.MainView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements MainView {



    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private MainPresenter mainPresenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(getBaseContext(), NewExpanseActivity.class);
                startActivity(intent);
            }
        });

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);

        mainPresenter = new MainPresenterImpl(this, new MainInteractorImpl(), this);
    }

    @Override protected void onResume() {
        super.onResume();
        mainPresenter.onResume();
    }


    @Override protected void onDestroy() {
        mainPresenter.onDestroy();
        super.onDestroy();
    }


    @Override
    public void setItems(ArrayList<String> totalList, HashMap<String, ArrayList<NewExpanseObject>> dataList,
                         ArrayList<String> catagoryList) {
        expandableListAdapter = new ExpandableListAdapter(this, totalList, dataList, catagoryList);
        expandableListView.setAdapter(expandableListAdapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}
