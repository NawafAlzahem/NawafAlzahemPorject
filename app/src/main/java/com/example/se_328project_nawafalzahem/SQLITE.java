package com.example.se_328project_nawafalzahem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLITE extends AppCompatActivity {

    EditText Firstname;
    EditText Lastname;
    EditText Phone;
    EditText Email;
    EditText Uni_ID;

    Button Insert,Update,Delete,SelectOption,InsertFromFireBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        DBHelper dbHelper=new DBHelper(this);

        Firstname=(EditText)findViewById(R.id.EDTfirstName);
        Lastname=(EditText)findViewById(R.id.EDTlastName);
        Phone=(EditText)findViewById(R.id.EDTphoneNumber);
        Email=(EditText)findViewById(R.id.EDTemailAddress);
        Uni_ID=(EditText)findViewById(R.id.EDT_UNIid);

        Insert=(Button)findViewById(R.id.InsertButton);
        Update=(Button)findViewById(R.id.UpdateButton);
        Delete=(Button)findViewById(R.id.DeleteButton);
        SelectOption=(Button)findViewById(R.id.SelectOptions);
        InsertFromFireBase=(Button)findViewById(R.id.InsertFromFireBase);

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText() + "";
                String lname = Lastname.getText() + "";
                String phone = Phone.getText() + "";
                String email = Email.getText() + "";
                String uid = Uni_ID.getText() + "";

                if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || phone.isEmpty() || uid.isEmpty()) {

                    Toast.makeText(SQLITE.this, "All field required.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}