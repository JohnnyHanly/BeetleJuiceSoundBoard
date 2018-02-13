package com.johnny.hanly.beetlejuicesoundboard;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;


public class ClassicFragment extends Fragment {
    View view;
    Button bMe;
    Button bAge;
    Button bWeight;
    Button bVomit;
    Button bRed;
    Button bCoobee;
    Button bSpanish;
    Button bChinese;
    Button bOne;
    Button bPuerto;
    Button bDown;
    Button bAint;

    SoundPool classicSoundPool;
    HashMap<Integer, Integer> classicSoundpoolMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classic, container, false);
        classicSoundPool = new SoundPool(8, AudioManager.STREAM_MUSIC, 100);
        classicSoundpoolMap = new HashMap<Integer, Integer>();

        final Vibrator x= (Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        classicSoundpoolMap.put(1, classicSoundPool.load(getActivity(), R.raw.beet_me, 1));
        classicSoundpoolMap.put(2, classicSoundPool.load(getActivity(), R.raw.beet_coobee, 1));
        classicSoundpoolMap.put(3, classicSoundPool.load(getActivity(), R.raw.beet_red, 1));
        classicSoundpoolMap.put(4, classicSoundPool.load(getActivity(), R.raw.beet_vomit, 1));
        classicSoundpoolMap.put(5, classicSoundPool.load(getActivity(), R.raw.beet_age, 1));
        classicSoundpoolMap.put(6, classicSoundPool.load(getActivity(), R.raw.beet_spanish, 1));
        classicSoundpoolMap.put(7, classicSoundPool.load(getActivity(), R.raw.beet_chinese, 1));
        classicSoundpoolMap.put(8,classicSoundPool.load(getActivity(),R.raw.beet_1,1));
        classicSoundpoolMap.put(9,classicSoundPool.load(getActivity(),R.raw.beet_puerto,1));
        classicSoundpoolMap.put(19,classicSoundPool.load(getActivity(),R.raw.beet_aint,1));


        bMe = (Button) view.findViewById(R.id.b_me);
        bAge = (Button) view.findViewById(R.id.b_age);
        bVomit = (Button) view.findViewById(R.id.b_vomit);
        bRed = (Button) view.findViewById(R.id.b_red);
        bCoobee = (Button) view.findViewById(R.id.b_coobee);
        bSpanish = (Button) view.findViewById(R.id.b_spanish);
        bChinese = (Button) view.findViewById(R.id.b_chinese);
        bOne=(Button) view.findViewById(R.id.b_one);
        bPuerto= (Button) view.findViewById(R.id.b_puerto);
        bAint= (Button) view.findViewById(R.id.b_aint);



        bMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1,x);
            }
        });
        bCoobee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2,x);
            }
        });
        bRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3,x);
            }
        });
        bVomit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4,x);
            }
        });
        bAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(5,x);
            }
        });
        bSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(6,x);
            }
        });
        bChinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(7,x);
            }
        });
        bOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(8,x);
            }
        });
        bPuerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(9,x);
            }
        });
        bAint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(10,x);
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

        for(int i=0;i<=12;i++){
            classicSoundPool.stop(i);
        }
classicSoundPool.play(integer, leftVol,rightVol,1,0,1f);
        vibrator.vibrate(10);
    }


}