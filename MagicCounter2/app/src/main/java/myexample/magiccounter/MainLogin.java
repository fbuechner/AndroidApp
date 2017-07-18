package myexample.magiccounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.R.id.edit;

public class MainLogin extends AppCompatActivity {



    Button btnspielstart;
    EditText txtspieler1, txtspieler2;
    RadioButton btnstartinglife20, btnstartinglife40;
    String startinglife;
    String spieler1, spieler2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnspielstart = (Button) findViewById(R.id.btnspielstart);
        btnstartinglife20 = (RadioButton)  findViewById(R.id.btnstartinglife20) ;
        btnstartinglife40 = (RadioButton)  findViewById(R.id.btnstartinglife40) ;
        startinglife =   btnstartinglife20.getText().toString();
        txtspieler1 = (EditText) findViewById(R.id.txtspieler1) ;
        txtspieler2 = (EditText) findViewById(R.id.txtspieler2) ;
          String spieler1 = "Spieler 1";
         String spieler2 = "Spieler 2";


        btnspielstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String spieler1 = txtspieler1.getText().toString();
                String spieler2 = txtspieler2.getText().toString();

                if (btnstartinglife20.isChecked() == true) {
                    startinglife =   btnstartinglife20.getText().toString();


                }


                else if (  btnstartinglife40.isChecked() == true) {
                    startinglife = btnstartinglife40.getText().toString();

                }





                Intent toCounter = new Intent(MainLogin.this, MainCounter.class);
                toCounter.putExtra("toCounter", startinglife);
                toCounter.putExtra("player1", spieler1);
                toCounter.putExtra("player2", spieler2);
                startActivity(toCounter);


            }
        });



}}
