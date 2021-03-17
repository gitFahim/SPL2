package com.example.otplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

public class ManageDatabase extends AppCompatActivity {

    EditText  name, age;
    //UserDB userdb;
    RadioButton maleB, femaleB, othersB;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_database);

        //databaseReference = FirebaseDatabase.getInstance().getReference("User");
        databaseReference = FirebaseDatabase.getInstance().getReference();

        name = findViewById(R.id.userName);
        age = findViewById(R.id.userAge);

        maleB = findViewById(R.id.male);
        femaleB = findViewById(R.id.female);
        othersB = findViewById(R.id.others);

        findViewById(R.id.buttonDatabase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

            }
        });

    }

    public void saveData(){


        String nameS = name.getText().toString().trim();
        int ageN = Integer.parseInt(age.getText().toString().trim());
        String m1 = maleB.getText().toString();
        String m2 = femaleB.getText().toString();
        String m3 = othersB.getText().toString();
        String genderCheck;

        if(maleB.isChecked()) {

            genderCheck = maleB.getText().toString();
            //userdb.setGenderU(m1);
            //genderCheck = userdb.getGenderU();
        }
        else if(femaleB.isChecked()) {
            genderCheck = femaleB.getText().toString();
            //userdb.setGenderU(m2);
            //genderCheck = userdb.getGenderU();
        }
        else {
            genderCheck = othersB.getText().toString();
            //userdb.setGenderU(m3);
            //genderCheck = userdb.getGenderU();
        }
/*
        String key = databaseReference.push().getKey();

        //UserDB userDB = new UserDB(nameS,ageN);
        databaseReference.child(key).setValue("Name");
        Intent send2 = new Intent(ManageDatabase.this, Welcome.class);
        startActivity(send2);

 */
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            String uid = user.getUid();
            //UserDB userDB = new UserDB(nameS,ageN);
            //UserDB userDB = new UserDB(nameS,ageN,genderCheck);
            //UserDB userdb2 = new UserDB(nameS, ageN, userdb.getGenderU());
            UserDB userdb2 = new UserDB(nameS, ageN, genderCheck);

            databaseReference.child(uid).setValue(userdb2);

            Intent send2 = new Intent(ManageDatabase.this, Welcome.class);
            startActivity(send2);

        }
    }
}