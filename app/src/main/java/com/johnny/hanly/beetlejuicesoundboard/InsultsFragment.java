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


public class InsultsFragment extends Fragment {
    View view;
    Button bTakeyou;
    Button bBadHands;
    Button bIsTough;
    Button bHospital;
    Button bFatBoy;
    Button bFU;
    Button bSuck;
    Button bKnock;
    Button bRemember;
    Button bSituation;
    Button bPsycho;
    Button bWatcha;

    SoundPool insultSoundPool;
    HashMap<Integer, Integer> insultSoundPoolMap;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_insults, container, false);
        insultSoundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 100);
        insultSoundPoolMap = new HashMap<Integer, Integer>();
        final Vibrator x = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        insultSoundPoolMap.put(1, insultSoundPool.load(getActivity(), R.raw.beet_takeyoulikeaman, 1));
        insultSoundPoolMap.put(2, insultSoundPool.load(getActivity(), R.raw.beet_killaguy, 1));
        insultSoundPoolMap.put(3, insultSoundPool.load(getActivity(), R.raw.beet_imistough, 1));
        insultSoundPoolMap.put(4, insultSoundPool.load(getActivity(), R.raw.beet_hospital, 1));
        insultSoundPoolMap.put(5, insultSoundPool.load(getActivity(), R.raw.beet_fatboy, 1));
        insultSoundPoolMap.put(6, insultSoundPool.load(getActivity(), R.raw.beet_fu, 1));
        insultSoundPoolMap.put(7, insultSoundPool.load(getActivity(), R.raw.beet_suck, 1));
        insultSoundPoolMap.put(8, insultSoundPool.load(getActivity(), R.raw.beet_knockyouout, 1));
        insultSoundPoolMap.put(9, insultSoundPool.load(getActivity(), R.raw.beet_take, 1));
        insultSoundPoolMap.put(10, insultSoundPool.load(getActivity(), R.raw.beet_situation, 1));
        insultSoundPoolMap.put(11, insultSoundPool.load(getActivity(), R.raw.beet_psycho, 1));
        insultSoundPoolMap.put(12, insultSoundPool.load(getActivity(), R.raw.beet_watcha, 1));

        bTakeyou = (Button) view.findViewById(R.id.b_takeyou);
        bBadHands = (Button) view.findViewById(R.id.b_badhands);
        bIsTough = (Button) view.findViewById(R.id.b_tough);
        bHospital = (Button) view.findViewById(R.id.b_hospital);
        bFatBoy = (Button) view.findViewById(R.id.b_fatboy);
        bFU = (Button) view.findViewById(R.id.b_FU);
        bSuck = (Button) view.findViewById(R.id.b_suck);
        bKnock = (Button) view.findViewById(R.id.b_knock);
        bRemember = (Button) view.findViewById(R.id.b_remember);
        bSituation = (Button) view.findViewById(R.id.b_situation);
        bPsycho = (Button) view.findViewById(R.id.b_psycho);
        bWatcha = (Button) view.findViewById(R.id.b_watcha);


        bTakeyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(1, x);
            }
        });

        bBadHands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(2, x);
            }
        });
        bIsTough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(3, x);
            }
        });
        bHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(4, x);
            }
        });
        bFatBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(5, x);
            }
        });
        bFU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(6, x);
            }
        });
        bSuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(7, x);
            }
        });
        bKnock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(8, x);
            }
        });
        bRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(9, x);
            }
        });
        bSituation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(10, x);
            }
        });
        bPsycho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Play(11, x);
            }
        });
        bWatcha.setOnClickListener(new View.OnClickListener() {
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
            insultSoundPool.stop(i);
        }
        insultSoundPool.play(integer, leftVol, rightVol, 1, 0, 1f);
        vibrator.vibrate(10);
    }
}