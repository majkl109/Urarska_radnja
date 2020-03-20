package com.majkl.urarskaradnja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.majkl.urarskaradnja.MyDBHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void loadSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHandler());
        SatID.setText("");
        NazivSata.setText("");

    }
    public void addSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(satID.getText().toString());
        String name = NazivSata.getText().toString();
        Satovi satovi = new Satovi(id,name);
        dbHandler.addHandler(satovi);
        SatID.setText("");
        NazivSata.setText("");
    }
}
