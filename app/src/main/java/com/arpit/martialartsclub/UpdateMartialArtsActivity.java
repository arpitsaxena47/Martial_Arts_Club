package com.arpit.martialartsclub;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class UpdateMartialArtsActivity extends AppCompatActivity implements View.OnClickListener {

    DatabaseHandler databaseHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_martial_arts);

        databaseHandler = new DatabaseHandler(this);

    }

    private void modifyUserInterface()
    {
        ArrayList<MartialArt> martialArtObject = databaseHandler.returnAllMartialArtObjects();

        if(martialArtObject.size() > 0)
        {
            ScrollView scrollView = new ScrollView(UpdateMartialArtsActivity.this);
            GridLayout gridLayout = new GridLayout(UpdateMartialArtsActivity.this);
            gridLayout.setRowCount(martialArtObject.size());
            gridLayout.setColumnCount(5);

            TextView[] idTextView = new TextView[martialArtObject.size()];
            EditText[][] edtNamesPricesAndColors = new EditText[martialArtObject.size()][3];

            Button[] modifyButton = new Button[martialArtObject.size()];

            Point screenSize = new Point();

            getWindowManager().getDefaultDisplay().getSize(screenSize);

            int screenWidth = screenSize.x;
            int index = 0;

            for(MartialArt martialArt : martialArtObject)
            {
                idTextView[index] = new TextView(UpdateMartialArtsActivity.this);
                idTextView[index].setGravity(Gravity.CENTER);
                idTextView[index].setText(martialArt.getMartialArtID());

                edtNamesPricesAndColors[index][0] = new EditText(UpdateMartialArtsActivity.this);
                edtNamesPricesAndColors[index][1] = new EditText(UpdateMartialArtsActivity.this);
                edtNamesPricesAndColors[index][2] = new EditText(UpdateMartialArtsActivity.this);

                edtNamesPricesAndColors[index][0].setText(martialArt.getMartialArtName());

                edtNamesPricesAndColors[index][1].setText(martialArt.getMartialArtPrice() + "");
                edtNamesPricesAndColors[index][1].setInputType(InputType.TYPE_CLASS_NUMBER);

                edtNamesPricesAndColors[index][2].setText(martialArt.getMartialArtColor());

                edtNamesPricesAndColors[index][0].setId(martialArt.getMartialArtID() + 10);
                edtNamesPricesAndColors[index][1].setId(martialArt.getMartialArtID() + 20);
                edtNamesPricesAndColors[index][2].setId(martialArt.getMartialArtID() + 30);

                modifyButton[index] = new Button(UpdateMartialArtsActivity.this);
                modifyButton[index].setText("Modify");
                modifyButton[index].setId(martialArt.getMartialArtID());
                modifyButton[index].setOnClickListener(UpdateMartialArtsActivity.this);

                index++;
            }


        }
    }

    @Override
    public void onClick(View v) {

    }
}