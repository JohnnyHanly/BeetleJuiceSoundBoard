package com.johnny.hanly.beetlejuicesoundboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
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
    Button bLaugh;
    Button bIfuck;
    Button bLose;
    Button bCrack;
    Button bEskimos;
    Button bJews;
    Button bWhites;
    Button bDrugs;
    Button bWomen;
    Button bGay;
    Button bDiet;
    Button bHell;

    SoundPool miscSoundPool;
    HashMap<Integer, Integer> miscSoundPoolMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup containter, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_misc, containter, false);
        miscSoundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 100);
        miscSoundPoolMap = new HashMap<Integer, Integer>();
        final Vibrator x = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        miscSoundPoolMap.put(1, miscSoundPool.load(getActivity(), R.raw.beet_laugh, 1));
        miscSoundPoolMap.put(2, miscSoundPool.load(getActivity(), R.raw.beet_ifuck, 1));
        miscSoundPoolMap.put(3, miscSoundPool.load(getActivity(), R.raw.beetsmokecrack, 1));
        miscSoundPoolMap.put(4, miscSoundPool.load(getActivity(), R.raw.beet_ifyoulose, 1));
        miscSoundPoolMap.put(5, miscSoundPool.load(getActivity(), R.raw.beet_white, 1));
        miscSoundPoolMap.put(6, miscSoundPool.load(getActivity(), R.raw.beet_eskimos, 1));
        miscSoundPoolMap.put(7, miscSoundPool.load(getActivity(), R.raw.beet_jews, 1));
        miscSoundPoolMap.put(8, miscSoundPool.load(getActivity(), R.raw.beet_drugs, 1));
        miscSoundPoolMap.put(9, miscSoundPool.load(getActivity(), R.raw.beet_women, 1));
        miscSoundPoolMap.put(10, miscSoundPool.load(getActivity(), R.raw.beet_gay, 1));
        miscSoundPoolMap.put(11, miscSoundPool.load(getActivity(), R.raw.beet_diet, 1));
        miscSoundPoolMap.put(12, miscSoundPool.load(getActivity(), R.raw.beet_hell, 1));


        bLaugh = (Button) view.findViewById(R.id.b_laughter);
        bCrack = (Button) view.findViewById(R.id.b_crack);
        bIfuck = (Button) view.findViewById(R.id.b_ifuck);
        bLose = (Button) view.findViewById(R.id.b_lose);
        bWhites = (Button) view.findViewById(R.id.b_whites);
        bEskimos = (Button) view.findViewById(R.id.b_eskimos);
        bJews = (Button) view.findViewById(R.id.b_jews);
        bDrugs = (Button) view.findViewById(R.id.b_drugs);
        bWomen = (Button) view.findViewById(R.id.b_women);
        bGay = (Button) view.findViewById(R.id.b_gay);
        bDiet = (Button) view.findViewById(R.id.b_diet);
        bHell = (Button) view.findViewById(R.id.b_hell);

        bLaugh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1, x);
            }
        });
        bIfuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2, x);

            }
        });
        bCrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3, x);
            }

        });
        bLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4, x);
            }
        });
        bWhites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(5, x);
            }
        });
        bEskimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(6, x);
            }
        });
        bJews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(7, x);
            }
        });
        bDrugs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(8, x);
            }
        });
        bWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(9, x);
            }
        });
        bGay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(10, x);
            }
        });
        bDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(11, x);
            }
        });
        bHell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(12, x);
            }
        });
        return view;
    }


    public void Play(Integer integer, Vibrator vibrator) {
        AudioManager audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        float currentVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float leftVol = currentVol / maxVol;
        float rightVol = currentVol / maxVol;
        for (int i = 0; i <= 12; i++) {
            miscSoundPool.stop(i);
        }

        miscSoundPool.play(integer, leftVol, rightVol, 1, 0, 1f);
        vibrator.vibrate(10);

    }
}
