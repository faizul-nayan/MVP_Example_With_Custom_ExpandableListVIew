package com.datasoft_bd.assignment.Storage;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.datasoft_bd.assignment.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Faizul Haque Nayan on 7/21/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<String> expandableListTitle;
    private HashMap<String, ArrayList<NewExpanseObject>> expandableListDetail;
    private ArrayList<String> catagoryList;

    public ExpandableListAdapter(Context context, ArrayList<String> expandableListTitle,
                                 HashMap<String, ArrayList<NewExpanseObject>> expandableListDetail, ArrayList<String> catagoryList) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
        this.catagoryList = catagoryList;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return listPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        ArrayList<NewExpanseObject> data = expandableListDetail.get(catagoryList.get(listPosition));
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.row_details, null);
        }
        TextView catPurposeTv = (TextView) convertView
                .findViewById(R.id.catPurposeTv);
        TextView singleAmoutTv = (TextView) convertView
                .findViewById(R.id.singleAmoutTv);
        catPurposeTv.setText(data.get(expandedListPosition).getPurpose());
        singleAmoutTv.setText(String.valueOf(data.get(expandedListPosition).getAmount()));
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(catagoryList.get(listPosition)).size();

    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView catagoryNameTv = (TextView) convertView
                .findViewById(R.id.catagoryNameTv);
        TextView totalAmoutTv = (TextView) convertView.findViewById(R.id.totalAmoutTv);
        catagoryNameTv.setTypeface(null, Typeface.BOLD);
        catagoryNameTv.setText(catagoryList.get(listPosition));
        totalAmoutTv.setText(listTitle);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}