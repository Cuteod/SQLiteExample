package com.example.sqliteexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button BnSave, BnView,BnUpdate, BnDelete;
    OnDbOpListener dbOpListener;



    public HomeFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListener{

        public void dBOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        BnSave = view.findViewById(R.id.btn_add_contact);
        BnSave.setOnClickListener(this);
        BnView = view.findViewById(R.id.btn_view_contacts);
        BnView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_add_contact:
                dbOpListener.dBOpPerformed(0);
                break;
            case R.id.btn_view_contacts:
                dbOpListener.dBOpPerformed(1);
                break;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        try {

            dbOpListener = (OnDbOpListener) activity;

        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"must implement the interface method..");
        }
    }
}
