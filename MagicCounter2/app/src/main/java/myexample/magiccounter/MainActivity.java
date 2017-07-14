package myexample.magiccounter;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;


public class MainActivity extends AppCompatActivity {


    String arrayName [] = {
            "Muenze",
            "Wuerfel",
            "Reset"
    };


    Button b_plus1, b_plus2, b_minus1, b_minus2, b_wuerfel, b_rest;
    TextView tv_counter1, tv_counter2, tv_poison1;
    SeekBar sb_poison1;
    int zaehler1 = 50;
    int zaehler2 = 50;

    private static SeekBar seek_bar;
    private static TextView text_view;

    private static SeekBar seek_bar2;
    private static TextView text_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seebbarr();
        seebbarr2();

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.CircleMenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.magic,R.drawable.magic)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.muenze)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.wuerfel)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.one)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(MainActivity.this, "You selected "+arrayName[index], Toast.LENGTH_SHORT).show();


                        switch (index) {
                            case 0: {
                                startActivity(new Intent(MainActivity.this, Main3Activity.class));
                                break;
                            }
                            case 1: {
                                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                                break;
                            }
                            case 2: {

                                break;
                            }}



                    }
                });



        b_plus1 = (Button) findViewById(R.id.b_plus1);
        b_plus2 = (Button) findViewById(R.id.b_plus2);
        b_minus1 = (Button) findViewById(R.id.b_minus1);
        b_minus2 = (Button) findViewById(R.id.b_minus2);
        b_wuerfel = (Button) findViewById(R.id.b_wuerfel);
        b_rest = (Button) findViewById(R.id.b_rest);
        tv_counter1 = (TextView) findViewById(R.id.tv_counter1);
        tv_counter2 = (TextView) findViewById(R.id.tv_counter2);
        



        b_minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zaehler1 = zaehler1 - 1;
                tv_counter1.setText(Integer.toString(zaehler1));


            }
        });

        b_plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zaehler1 = zaehler1 + 1;
                tv_counter1.setText(Integer.toString(zaehler1));

            }
        });
        b_minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zaehler2 = zaehler2 - 1;
                tv_counter2.setText(Integer.toString(zaehler2));

            }
        });

        b_plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zaehler2 = zaehler2 + 1;
                tv_counter2.setText(Integer.toString(zaehler2));

            }
        });


        b_rest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Reset();

            }
        });

        b_wuerfel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Main2Activity.class));


            }
        });


    }





    public void Test(View view) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));

    }


    public void seebbarr() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        text_view = (TextView) findViewById(R.id.textView);
        text_view.setText("Poison : " + seek_bar.getProgress() + " / " + seek_bar.getMax());

        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        text_view.setText("Poison : " + progress + " / " + seek_bar.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in StartTracking", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view.setText("Poison : " + progress_value + " / " + seek_bar.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in StopTracking", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }



    public void seebbarr2() {
        seek_bar2 = (SeekBar) findViewById(R.id.seekBar2);
        text_view2 = (TextView) findViewById(R.id.textView2);
        text_view2.setText("Poison : " + seek_bar2.getProgress() + " / " + seek_bar2.getMax());

        seek_bar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        text_view2.setText("Poison : " + progress + " / " + seek_bar2.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in progress", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MainActivity.this, "SeekBar in StartTracking", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view2.setText("Poison : " + progress_value + " / " + seek_bar2.getMax());
                        Toast.makeText(MainActivity.this, "SeekBar in StopTracking", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }


public void Reset (){
    zaehler2 = 50;
    zaehler1 = 50;
    tv_counter1.setText(Integer.toString(zaehler1));
    tv_counter2.setText(Integer.toString(zaehler2));
    seek_bar.setProgress(0);
    text_view.setText("Poison : " + seek_bar.getProgress() + " / " + seek_bar.getMax());
    seek_bar2.setProgress(0);
    text_view2.setText("Poison : " + seek_bar2.getProgress() + " / " + seek_bar2.getMax());


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);


        return super .onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.Optionen:
                Toast.makeText(MainActivity.this, "Optionen", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Muenzwurf:
                Toast.makeText(MainActivity.this, "Münzwurf", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Reset:
                Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                Reset();
                return true;
            case R.id.Wuerfel4:
                Toast.makeText(MainActivity.this, "Würfel", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                return true;

            case R.id.Regeln:
                Toast.makeText(MainActivity.this, "Regeln", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.Hintergrund:
                Toast.makeText(MainActivity.this, "Hintergrunf", Toast.LENGTH_SHORT).show();

                return true;

            default:
        }


        return super.onOptionsItemSelected(item);
    }







/**
 public void Wuerfeln (View view) {
 setContentView(R.layout.dice);

 Button b_roll;
 TextView tv_sieger;
 ImageView iv_dice1, iv_dice2;
 b_roll = (Button) findViewById(R.id.b_roll);
 tv_sieger = (TextView) findViewById(R.id.tv_sieger);
 iv_dice1 = (ImageView) findViewById(R.id.iv_dice1);
 iv_dice2 = (ImageView) findViewById(R.id.iv_dice2);


 }

 */


}

