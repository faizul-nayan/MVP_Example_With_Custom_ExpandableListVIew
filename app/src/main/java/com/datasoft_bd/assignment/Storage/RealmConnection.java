package com.datasoft_bd.assignment.Storage;

import android.content.Context;
import io.realm.Realm;

/**
 * Created by mehedi on 7/24/17.
 */

public class RealmConnection {
    private Context context;
    private static Realm realm;


    public RealmConnection(Context context) {

        this.context = context;

        Realm.init(context);
        realm = Realm.getDefaultInstance();
    }

  public Realm getConnection(){
      return realm;
  }
  public void closeConnection(){realm.close();}
}
