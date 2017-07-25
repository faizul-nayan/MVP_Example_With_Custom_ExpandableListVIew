package com.datasoft_bd.assignment.Storage;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Faizul Haque Nayan on 7/20/2017.
 */

public class RealmOperations {

    private Context context;
    public String[] catagoryArray = {"Shirt","T-Shirt","Polo Shirt","Jeans Pants","Formal Pants","Slipper","Shoes"};
    private static ArrayList<String> totalAmountList = new ArrayList<String>();
    private static ArrayList<String> catagoryList = new ArrayList<String>();
    private static final String COLUMN = "catagory";
    private RealmConnection realmConnection;
    Realm realm;

    public RealmOperations(Context context) {
        this.context = context;
        realmConnection = new RealmConnection(this.context);
        realm = realmConnection.getConnection();

    }

    public HashMap<String, ArrayList<NewExpanseObject>> getData() {

        ArrayList<NewExpanseObject> dataArray = new ArrayList<NewExpanseObject>();
        HashMap<String, ArrayList<NewExpanseObject>> expandableListDetail = new HashMap<String, ArrayList<NewExpanseObject>>();
        NewExpanseObject newExpanseObject;
        for(int i = 0; i < catagoryArray.length; i++){
            RealmResults<NewExpanseObject> realmResults = realm.where(NewExpanseObject.class).equalTo(COLUMN,catagoryArray[i]).findAllAsync();
            realmResults.load();
            if(realmResults.size()!=0){
                int size = realmResults.size();
                for(int j = 0; j < size; j++){
                    newExpanseObject = realmResults.get(j);
                    dataArray.add(newExpanseObject);
                    Log.e("Purpose of Expance: ", realmResults.get(j).getPurpose());
                    Log.e("Amount: ", String.valueOf(realmResults.get(j).getAmount()));
                }
                catagoryList.add(catagoryArray[i]);
                double total = realmResults.sum("amount").doubleValue();
                expandableListDetail.put(catagoryArray[i],dataArray);
                Log.e("Total Amount: ", String.valueOf(total));

                Log.e("++++++++++++","-----------");
                totalAmountList.add(String.valueOf(total));
                dataArray = new ArrayList<NewExpanseObject>();
            }

        }
        return expandableListDetail;
    }

    public ArrayList<String> getTotalAmount(){
        return totalAmountList;
    }
    public ArrayList<String> getCatagoryList(){return catagoryList;}


    public boolean insertData(String expancePurpose, double amount, String catagory){

        final int[] nextId = new int[1];
        realm.executeTransaction(new Realm.Transaction() { // must be in transaction for this to work
                                     @Override
                                     public void execute(Realm realm) {
                                         // increment index
                                         Number currentIdNum = realm.where(NewExpanseObject.class).max("id");
                                         if(currentIdNum == null) {
                                             nextId[0] = 1;
                                         } else {
                                             nextId[0] = currentIdNum.intValue() + 1;
                                         }
                                     }
                                 }
        );

        try{
            realm.beginTransaction();
            NewExpanseObject newExpanseObject = realm.createObject(NewExpanseObject.class);
            newExpanseObject.setId(nextId[0]);
            newExpanseObject.setPurpose(expancePurpose);
            newExpanseObject.setAmount(amount);
            newExpanseObject.setCatagory(catagory);
            realm.commitTransaction();
            Toast.makeText(context, "Data Insert Success", Toast.LENGTH_LONG).show();
            Log.e("REALM++++++","Data Insert Success");
        }
        catch (Exception e){
            Toast.makeText(context, "Data Insert Fail "+e.getMessage(), Toast.LENGTH_LONG).show();
            Log.e("REALM--","Data Insert Fail "+e.getMessage());
        }

        return true;
    }
}