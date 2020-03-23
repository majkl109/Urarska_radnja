package com.majkl.urarskaradnja;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lst;
    EditText satID;
    EditText nazivSata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.list);
        satID = findViewById(R.id.satID);
        nazivSata = findViewById(R.id.nazivSata);
    }
    public void loadSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHandler());
        satID.setText("");
        nazivSata.setText("");

    }
    public void addSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(satID.getText().toString());
        String name = nazivSata.getText().toString();
        Satovi satovi = new Satovi(id,name);
        dbHandler.addHandler(satovi);
        satID.setText("");
        nazivSata.setText("");
    }
    public void findSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Satovi satovi = dbHandler.findHandler(nazivSata.getText().toString());
        if(satovi != null) {
            lst.setText(String.valueOf(satovi.getSatID()) + " " +
                    satovi.getNazivSata());

        }else
            lst.setText("No match found");

    }
    public void removeSatovi(View view){
        MyDBHandler dbHandler = new MyDBHandler(this,
                null, null, 1);
        boolean result = dbHandler.deleteHandler(Integer.parseInt
                (satID.getText().toString));
        if(result) {
            satID.setText("");
            nazivSata.setText("");
            lst.setText("Record deleted");
        }else
            satID.setText("No match found");
        }
    public  void updateStudent(View view){
        MyDBHandler dbHandler = new MyDBHandler(this, null ,
                null,1);
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                satID.getText().toString()), nazivSata.getText().toString());
        if(result) {
            satID.setText("");
            nazivSata.setText("");
            lst.setText("Record updated");
        }else
            satID.setText("No match found");
        }

    }




