package com.datasoft_bd.assignment.Storage;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by Faizul Haque Nayan on 7/19/2017.
 */

public class NewExpanseObject extends RealmObject {

    @Index
    private int id;
    @Required
    private String Purpose;

    private double amount;
    private String catagory;

    public int getId() {
        return id;
    }

    public String getPurpose() {
        return Purpose;
    }

    public double getAmount() {
        return amount;
    }


    public void setId(int id) {

        this.id = id;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}
