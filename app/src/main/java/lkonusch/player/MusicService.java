package lkonusch.player;

import java.util.ArrayList;
import android.content.ContentUris;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.provider.MediaStore;
import android.util.Log;
import android.app.Service;
import android.content.Intent;


public class MusicService extends Service implements
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {

    private final IBinder musicBind = new MusicBinder();

    // media player
    private MediaPlayer player;
    // song list
    private ArrayList<Song> songs;
    // current postition
    private int songPos;

    public void onCreate() {
        // create service
        super.onCreate();
        // initialize position
        songPos = 0;
        // create player
        player = new MediaPlayer();
        initMusicPlayer();
    }

    public void initMusicPlayer() {
        // set player properties
        // wake lock lets playback continue when device comes idle
        player.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }


    public void setList(ArrayList<Song> theSongs) {
        songs = theSongs;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        return false;
    }


    public class MusicBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        player.stop();
        player.release();
        return false;
    }


    public void playSong() {
        // play a song
        player.reset();
        // get song
        Song playSong = songs.get(songPos);
        // get id
        long currSong = playSong.getId();
        // set URI
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong);
        try {
            player.setDataSource(getApplicationContext(), trackUri);
        }
        catch (Exception e) {
            Log.e("MUSIC SERVICE", "Error setting data source", e);
        }
        player.prepareAsync();
    }


    @Override
    public void onPrepared(MediaPlayer mp) {
        // start playback
        mp.start();
    }

    public void setSong(int songIndex) {
        songPos = songIndex;
    }
}
