package com.app.oliviama.classpractice_1130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends Activity implements View.OnClickListener {
    private EditText editText2;
    private Button buttonUpdate;
    private Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText2 = (EditText) findViewById(R.id.editText2);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        button2 = (Button) findViewById(R.id.button2);

        buttonUpdate.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    public void onClick(View v){
        //handles click events
        switch (v.getId())
        {
            //Login event
            case R.id.buttonUpdate:
            {

            }

            //Logout event
            case R.id.button2:
            {
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;


            }
        }
        Intent intent = new Intent(this,MainActivity.class);


    }
}
