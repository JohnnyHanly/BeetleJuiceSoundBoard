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


public class InsultsFragment extends Fragment {
    View view;
    Button bTakeyou;
    Button bEskimos;
    Button bJews;
    Button bWhites;
    Button bBadHands;
    Button bIsTough;
SoundPool insultSoundPool;
HashMap<Integer,Integer> insultSoundPoolMap;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insults, container, false);
insultSoundPool= new SoundPool(6, AudioManager.STREAM_MUSIC, 100);
insultSoundPoolMap= new HashMap<Integer, Integer>();

insultSoundPoolMap.put(1,insultSoundPool.load(getActivity(),R.raw.beet_takeyoulikeaman,1));
        insultSoundPoolMap.put(2,insultSoundPool.load(getActivity(),R.raw.beet_eskimos,1));
        insultSoundPoolMap.put(3,insultSoundPool.load(getActivity(),R.raw.beet_jews,1));
        insultSoundPoolMap.put(4,insultSoundPool.load(getActivity(),R.raw.beet_white,1));
        insultSoundPoolMap.put(5,insultSoundPool.load(getActivity(),R.raw.beet_killaguy,1));
        insultSoundPoolMap.put(6,insultSoundPool.load(getActivity(),R.raw.beet_imistough,1));

        bTakeyou = (Button) view.findViewById(R.id.b_takeyou);
        bEskimos = (Button) view.findViewById(R.id.b_eskimos);
        bJews = (Button) view.findViewById(R.id.b_jews);
        bWhites = (Button) view.findViewById(R.id.b_whites);
        bBadHands = (Button) view.findViewById(R.id.b_killaguy);
        bIsTough = (Button) view.findViewById(R.id.b_tough);



        bTakeyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1);
            }
        });
        bEskimos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2);
            }
        });
        bJews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3);
            }
        });
        bWhites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4);
            }
        });
        bBadHands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(5);
            }
        });
        bIsTough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(6);
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
        for(int i=0;i<=6;i++){
            insultSoundPool.stop(i);
        }
insultSoundPool.play(integer,leftVol,rightVol,1,0,1f);
    }
}