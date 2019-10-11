package com.example.sqliteexample;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {

    private Button bnSave;
    private EditText id,Name,Email;


    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        bnSave = view.findViewById(R.id.btn_save);
        id = view.findViewById(R.id.et_contact_id);
        Name = view.findViewById(R.id.et_name);
        Email = view.findViewById(R.id.et_email);

        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String Id = id.getText().toString();
            String name = Name.getText().toString();
            String email = Email.getText().toString();

            ContactdbHelper contactdbHelper = new ContactdbHelper(getActivity());
                SQLiteDatabase database = contactdbHelper.getWritableDatabase();
                contactdbHelper.addContact(Integer.parseInt(Id), name, email, database);
                contactdbHelper.close();

                id.setText("");
                Name.setText("");
                Email.setText("");
                Toast.makeText(getActivity(),"Contact Saved Successfully...", Toast.LENGTH_SHORT).show();



            }
        });

        return view;


    }



}
