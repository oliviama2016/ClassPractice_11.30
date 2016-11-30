package com.app.oliviama.classpractice_1130;

import static android.content.ContentValues.TAG;
import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends Activity implements View.OnClickListener{

    //Declare all the widgets
    private EditText editText1;
    private EditText editText2;
    private Button buttonLogin;
    private Button buttonLogout;
    private Button buttonRegister;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link java objects to widgets
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(this);

        mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if (user!=null) {
                    //User is signed in
                    Log.d(Tag, "onAuthStateChanged:signed_in:" + user.getUid());
                }else {
                    //User is signed out
                    Log.d(Tag, "onAuthStateChanged:signed_out");

                }
            }

        }

        public void onStart() {
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);

        }
        public void onStop (){
            super.onStop();
            if (mAuthListener!=null) {
                mAuth.removeAuthStateListener(mAuthListener);

            }
        }
    }
    public void onClick(View v){

    }



}
