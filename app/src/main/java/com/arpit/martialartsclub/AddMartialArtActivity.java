package com.arpit.martialartsclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMartialArtActivity extends AppCompatActivity implements View.OnClickListener {

EditText edtName , edtPrice , edtColor;
Button btnAddMartialArt , btnBack;
DatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);

        edtName = findViewById(R.id.edtName);
        edtPrice = findViewById(R.id.edtPrice);
        edtColor = findViewById(R.id.edtColor);

        btnAddMartialArt = findViewById(R.id.btnAddMartialArt);
        btnBack = findViewById(R.id.btnBack);

        databaseHandler = new DatabaseHandler(this);

        btnAddMartialArt.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    private void addMartialArtObjectToDatabase()
    {
        String nameValue = edtName.getText().toString();
        String priceValue = edtPrice.getText().toString();
        String colorValue = edtColor.getText().toString();

        try{
            double priceDoubleValue = Double.parseDouble(priceValue);
            MartialArt martialArtObject = new MartialArt(0,nameValue,priceDoubleValue,colorValue);
            databaseHandler.addMartialArt(martialArtObject);
            Toast.makeText(AddMartialArtActivity.this,martialArtObject + "  is Saved to database ",Toast.LENGTH_LONG).show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAddMartialArt:
                addMartialArtObjectToDatabase();
                break;

            case R.id.btnBack:
//                Intent homeIntent = new Intent(AddMartialArtActivity.this,MainActivity.class);
//                startActivity(homeIntent);
                this.finish();
                break;
        }
    }
}