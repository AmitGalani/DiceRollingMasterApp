package com.example.dicerollingmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_middle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
        Button nextbtn;
        EditText uname;
        nextbtn = findViewById(R.id.nextbtn);
        uname = findViewById(R.id.name);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext;
                //viewbox validattion using textutils
                if(TextUtils.isEmpty(uname.getText()))
                {
                    uname.setError("Please Enter Your Name");
                    uname.requestFocus();
                }
                else
                {
                    String name = uname.getText().toString();
                    inext = new Intent(activity_middle.this,MainActivity.class);
                    inext.putExtra("uname",name);
                    startActivity(inext);
                    finish();
                }
            }
        });

    }
}