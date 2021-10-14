package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RankFragment#} factory method to
 * create an instance of this fragment.
 */
public class RankFragment extends Fragment {

    private FragmentManager manager;
    private FragmentTransaction ft;
    private ImageView bt;
    private TextView tv;
    private int  xx=0;
    Button bt_share;
    Button bt_change_friends;
    Button bt_change_public;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        manager = getFragmentManager();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rank, container, false);
    }




    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        bt = getActivity().findViewById(R.id.heart1);
        tv = getActivity().findViewById(R.id.number1);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String text = tv.getText().toString()+"";
                int number = Integer.valueOf(text);
                number++;
                tv.setText(""+number);
//                tv.setText(Integer.valueOf(tv.getText().toString())+1);
  //                tv.setText(""+xx++);
//                if (xx==10){
//                    Toast.makeText(MainActivity.this, "牛逼", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        bt_share = getActivity().findViewById(R.id.button_share);
        bt_share.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "Your body here";
                String sub = "Your Subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });



        bt_change_friends = getActivity().findViewById(R.id.button_change_friends);
        bt_change_friends.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                getActivity().setContentView(R.layout.fragment_friend_rank);
            }
        });





    }
}