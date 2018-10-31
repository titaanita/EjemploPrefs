package com.example.android.ejemploprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText usernom= (EditText)findViewById(R.id.username);
        final EditText pass= (EditText)findViewById(R.id.password);
        Button boton=(Button)findViewById(R.id.login);
        Button leer=(Button)findViewById(R.id.leer);

        final SharedPreferences userDetails = getSharedPreferences("userdetails",MODE_PRIVATE);



        Log.i("username",usernom.getText().toString());
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Retrieve values
                String userName = userDetails.getString("username", "");
                String password = userDetails.getString("password", "");

                //Cargarlos
                usernom.setText(userName);
                pass.setText(password);
            }
        });
        leer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = userDetails.edit();
                edit.putString("username", usernom.getText().toString());
                edit.putString("password", pass.getText().toString());
                edit.commit();
            }
        });



    }
}
