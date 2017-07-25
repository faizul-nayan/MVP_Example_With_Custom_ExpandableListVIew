package com.datasoft_bd.assignment.View.root;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.datasoft_bd.assignment.Interactor.Impl.NewExpanseInteractorImpl;
import com.datasoft_bd.assignment.Presenter.Impl.NewExpansePresenterImpl;
import com.datasoft_bd.assignment.Presenter.NewExpansePresenter;
import com.datasoft_bd.assignment.R;
import com.datasoft_bd.assignment.Storage.RealmOperations;
import com.datasoft_bd.assignment.View.NewExpanseView;

import io.realm.Realm;

public class NewExpanseActivity extends Activity implements NewExpanseView, View.OnClickListener{

    private TextView expancePurposeTv;
    private TextView amountTv;
    private Spinner catagorySpn;
    private Button cancleBtn;
    private Button addNewBtn;
    private NewExpansePresenter expansePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expance);

        expancePurposeTv = (TextView) findViewById(R.id.expancePurposeTv);
        amountTv = (TextView) findViewById(R.id.amountTv);
        catagorySpn = (Spinner) findViewById(R.id.catagorySpinner);
        catagorySpn.setSelection(-1);
        cancleBtn = (Button) findViewById(R.id.cancleBtn);
        addNewBtn = (Button) findViewById(R.id.addNewBtn);
        cancleBtn.setOnClickListener(this);
        addNewBtn.setOnClickListener(this);

        expansePresenter = new NewExpansePresenterImpl(this, new NewExpanseInteractorImpl(), this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id){
            case R.id.cancleBtn:
                finish();
                break;
            case R.id.addNewBtn:

                expansePresenter.saveData(expancePurposeTv.getText().toString(),amountTv.getText().toString(),catagorySpn.getSelectedItem().toString());

                break;
            default:
                break;
        }
    }

    @Override
    public void showMessage(String message, int code) {
        if(code == 0) Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        else if(code == 1){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            expancePurposeTv.requestFocus();
        }
        else if(code == 2){
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            amountTv.requestFocus();
        }
    }

    @Override
    public void resetFields(boolean flag) {
        if(flag){
            expancePurposeTv.setText("");
            amountTv.setText("");
            catagorySpn.setSelection(1);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        expansePresenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        expansePresenter.onDestroy();
    }
}
