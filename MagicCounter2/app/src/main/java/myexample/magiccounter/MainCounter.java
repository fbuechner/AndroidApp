package myexample.magiccounter;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;


public class MainCounter extends AppCompatActivity {


    String arrayName [] = {
            "Reset",
            "Würfeln",
            "Münzwurf",
            "Play"

    };


    Button b_plus1, b_plus2, b_minus1, b_minus2 ;
    TextView tv_counter1, tv_counter2, spieler1, spieler2;
    int zaehler1 = 20;
    int zaehler2 = 20;
    int maxSeekbar = 10;
    String uebergabe, player1, player2;
    private MusicService musicSrv;

    private boolean paused = false, playbackPaused = false;


    private static SeekBar seek_bar;
    private static TextView text_view;

    private static SeekBar seek_bar2;
    private static TextView text_view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        seebbarr();
        seebbarr2();



        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.CircleMenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.magic,R.drawable.magic)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.resetbutton)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.wuerfel)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.heads)
                .addSubMenu(Color.parseColor("#CDCDCD"), R.drawable.play)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Toast.makeText(MainCounter.this, "You selected "+arrayName[index], Toast.LENGTH_SHORT).show();


                        switch (index) {
                            case 0: {
                                Reset();
                                break;
                            }
                            case 1: {
                                startActivity(new Intent(MainCounter.this, Dice.class));
                                break;
                            }
                            case 2: {
                                startActivity(new Intent(MainCounter.this, CoinFlip.class));
                                break;
                            }
                            case 3: {
                               startActivity(new Intent(MainCounter.this, MainPlayer.class));
                               // playMusic();


                                break;
                            }
                        }



                    }
                });



        b_plus1 = (Button) findViewById(R.id.b_plus1);
        b_plus2 = (Button) findViewById(R.id.b_plus2);
        b_minus1 = (Button) findViewById(R.id.b_minus1);
        b_minus2 = (Button) findViewById(R.id.b_minus2);
        tv_counter1 = (TextView) findViewById(R.id.tv_counter1);
        tv_counter2 = (TextView) findViewById(R.id.tv_counter2);
        spieler1 = (TextView) findViewById(R.id.spieler1);
        spieler2 = (TextView) findViewById(R.id.spieler2);





        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                uebergabe= "20";
                tv_counter1.setText(uebergabe);
                tv_counter2.setText(uebergabe);

            } else {
                uebergabe= extras.getString("toCounter");
                player1= extras.getString("player1");
                player2= extras.getString("player2");
                tv_counter1.setText(uebergabe);
                tv_counter2.setText(uebergabe);
                spieler1.setText(player1);
                spieler2.setText(player2);

            }
        } else {
            uebergabe= (String) savedInstanceState.getSerializable("toCounter");
            tv_counter1.setText(uebergabe);
            tv_counter2.setText(uebergabe);
            player1= (String) savedInstanceState.getSerializable("player1");
            player2= (String) savedInstanceState.getSerializable("player2");
            tv_counter1.setText(uebergabe);
            tv_counter2.setText(uebergabe);
            spieler1.setText(player1);
            spieler2.setText(player2);

        }




        zaehler1 = Integer.parseInt(uebergabe);
        zaehler2 = Integer.parseInt(uebergabe);



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






    }

    public void Test(View view) {
        startActivity(new Intent(MainCounter.this, Dice.class));

    }


    public void seebbarr() {
        seek_bar = (SeekBar) findViewById(R.id.seekBar);
        text_view = (TextView) findViewById(R.id.textView);
        seek_bar.setMax(maxSeekbar);
        text_view.setText("Poison : " + seek_bar.getProgress() + " / " + seek_bar.getMax());

        seek_bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        text_view.setText("Poison : " + progress + " / " + seek_bar.getMax());

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view.setText("Poison : " + progress_value + " / " + seek_bar.getMax());

                    }
                }
        );

    }



    public void seebbarr2() {
        seek_bar2 = (SeekBar) findViewById(R.id.seekBar2);
        text_view2 = (TextView) findViewById(R.id.textView2);
        seek_bar2.setMax(maxSeekbar);
        text_view2.setText("Poison : " + seek_bar2.getProgress() + " / " + seek_bar2.getMax());

        seek_bar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    int progress_value;

                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        progress_value = progress;
                        text_view2.setText("Poison : " + progress + " / " + seek_bar2.getMax());

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        text_view2.setText("Poison : " + progress_value + " / " + seek_bar2.getMax());

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
    seek_bar.setMax(maxSeekbar);
    text_view.setText("Poison : " + seek_bar.getProgress() + " / " + seek_bar.getMax());
    seek_bar2.setProgress(0);
    seek_bar2.setMax(10);
    text_view2.setText("Poison : " + seek_bar2.getProgress() + " / " + seek_bar2.getMax());


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_counter, menu);


        return super .onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {



        switch (item.getItemId()){

            case R.id.Optionen:
                Toast.makeText(MainCounter.this, "Optionen", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Muenzwurf:
                Toast.makeText(MainCounter.this, "Münzwurf", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainCounter.this, CoinFlip.class));
                return true;
            case R.id.Reset:
                Toast.makeText(MainCounter.this, "Reset", Toast.LENGTH_SHORT).show();
                Reset();
                return true;
            case R.id.Wuerfel4:
                Toast.makeText(MainCounter.this, "Würfel", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainCounter.this, Dice.class));
                return true;

            case R.id.Regeln:
                Toast.makeText(MainCounter.this, "Regeln", Toast.LENGTH_SHORT).show();
                goToUrl ( "http://www.wizards.com/magic/rules/MagicRulebook_10E_DE.pdf");

                return true;
            case R.id.MP3Player:
                Toast.makeText(MainCounter.this, "MP3 Player", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainCounter.this, MainPlayer.class));

                return true;

            case R.id.Hintergrund:
                Toast.makeText(MainCounter.this, "Hintergrund", Toast.LENGTH_SHORT).show();

                return true;

            default:
        }


        return super.onOptionsItemSelected(item);
    }

    public void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    public void playMusic() {

musicSrv.playSong();
    }



}

