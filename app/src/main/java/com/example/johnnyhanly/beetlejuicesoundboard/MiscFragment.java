package com.example.johnnyhanly.beetlejuicesoundboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;


public class MiscFragment extends Fragment {
    ArrayList<MediaPlayer> MiscMediaPlayer = new ArrayList<MediaPlayer>();
    View view;
    Button b_laugh;
    Button b_ifuck;
    Button b_lose;
    Button b_crack;


    SoundPool miscSoundPool;
    HashMap<Integer, Integer> miscSoundPoolMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_misc, containter, false);
        miscSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        miscSoundPoolMap = new HashMap<Integer, Integer>();


        miscSoundPoolMap.put(1, miscSoundPool.load(getActivity(), R.raw.beet_laugh, 1));
        miscSoundPoolMap.put(2, miscSoundPool.load(getActivity(), R.raw.beet_ifuck, 1));
        miscSoundPoolMap.put(3, miscSoundPool.load(getActivity(), R.raw.beetsmokecrack, 1));
        miscSoundPoolMap.put(4, miscSoundPool.load(getActivity(), R.raw.beet_ifyoulose, 1));
        b_laugh = (Button) view.findViewById(R.id.b_laughter);
        b_crack = (Button) view.findViewById(R.id.b_crack);
        b_ifuck = (Button) view.findViewById(R.id.b_ifuck);
        b_lose = (Button) view.findViewById(R.id.b_lose);


        b_laugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1);
            }
        });
        b_ifuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2);

            }
        });
        b_crack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3);
            }

        });
        b_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4);
            }
        });


        return view;
    }

    public void Play(Integer integer) {
        AudioManager audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        float currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVol = currentVol / maxVol;
        float rightVol = currentVol / maxVol;
        for(int i=0;i<=4;i++){
            miscSoundPool.stop(i);
        }

        miscSoundPool.play(integer, leftVol, rightVol, 1, 0, 1f);


    }
}
