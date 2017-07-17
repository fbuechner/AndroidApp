package myexample.magiccounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Dice extends AppCompatActivity {

    Button b_zufall;
    TextView tv_ergebniss;
    ImageView iv_wuerfel1, iv_wuerfel2;
    int Speicher;
    int theRoll1;
    int theRoll2;
    String ausgabe = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);


      b_zufall = (Button) findViewById(R.id.b_zufall);
       tv_ergebniss = (TextView) findViewById(R.id.tv_ergebniss);
        iv_wuerfel1 = (ImageView) findViewById(R.id.iv_wuerfel1);
       iv_wuerfel2 = (ImageView) findViewById(R.id.iv_wuerfel2);

        b_zufall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();



                //Zahfallszahl zwischen 1 und 6
                theRoll1 = r.nextInt(6) + 1;
                theRoll2 = r.nextInt(6) +1;
                Speicher = theRoll1;
                tv_ergebniss.setText("Spieler1 hat eine: " + theRoll1 );
                switch (theRoll1) {
                    case 1: {

                        iv_wuerfel1.setImageResource(R.drawable.one);
                        break;
                    }
                    case 2: {

                        iv_wuerfel1.setImageResource(R.drawable.two);
                        break;
                    }
                    case 3: {

                        iv_wuerfel1.setImageResource(R.drawable.three);
                        break;
                    }
                    case 4: {

                        iv_wuerfel1.setImageResource(R.drawable.four);
                        break;
                    }
                    case 5: {

                        iv_wuerfel1.setImageResource(R.drawable.five);
                        break;
                    }
                    case 6: {
                        iv_wuerfel1.setImageResource(R.drawable.six);
                        break;
                    }

                }

                switch (theRoll2) {
                    case 1: {
                        iv_wuerfel2.setImageResource(R.drawable.one);
                        break;
                    }
                    case 2: {
                        iv_wuerfel2.setImageResource(R.drawable.two);
                        break;
                    }
                    case 3: {
                        iv_wuerfel2.setImageResource(R.drawable.three);
                        break;
                    }
                    case 4: {
                        iv_wuerfel2.setImageResource(R.drawable.four);
                        break;
                    }
                    case 5: {
                        iv_wuerfel2.setImageResource(R.drawable.five);
                        break;
                    }
                    case 6: {
                        iv_wuerfel2.setImageResource(R.drawable.six);
                        break;
                    }

                }

                if (theRoll2 == theRoll1){
                    tv_ergebniss.setText("Unentscheiden");
                    ausgabe="Unentschieden";
                    Toast.makeText(Dice.this, "Unentschieden ", Toast.LENGTH_SHORT).show();

                }
                else

                if (theRoll1 > theRoll2){
                    tv_ergebniss.setText("Spieler1 gewinnt.");
                    ausgabe="Spieler1 gewinnt.";
                    Toast.makeText(Dice.this, "Spieler1 gewinnt. ", Toast.LENGTH_SHORT).show();

                } else
                    tv_ergebniss.setText("Spieler2 gewinnt.");
                    ausgabe="Spieler2 gewinnt.";
                Toast.makeText(Dice.this, "Spieler2 gewinnt. ", Toast.LENGTH_SHORT).show();



            }
           /** AlertDialog.Builder myAlert = new AlertDialog.Builder(this);

            public AlertDialog.Builder getMyAlert() {
                myAlert.setMessage(ausgabe)
                .create();
                myAlert.show();

            }  */

        });

    }





}
