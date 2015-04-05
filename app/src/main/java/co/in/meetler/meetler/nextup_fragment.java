package co.in.meetler.meetler;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;

;

/**
 * Created by savvi.singh on 4/1/2015.
 */
public class nextup_fragment extends Fragment {

    public String[] rectangle1 = {"#01632B", "#802225", "#01538E", "#0E7c68", "#BD7617"};

    public String[] rectangle2 = {"#1EA02A", "#C04343", "#448CCB", "#10BFA0", "#ECA744"};
    int no_of_cards = 1;
    ArrayList Rec1 = new ArrayList<String>();
    ArrayList Rec2 = new ArrayList<String>();


    public nextup_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View nextup = inflater.inflate(R.layout.fragment_meetler_nextup, container, false);

        final RecyclerView recList = (RecyclerView) nextup.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        SharedPreferences pref = getActivity().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();


        no_of_cards = pref.getInt("count", 5);

        Log.i("no_of_cards", String.valueOf(no_of_cards));
        set_bg_array(no_of_cards);

        FloatingActionButton fab = (FloatingActionButton) nextup.findViewById(R.id.fab);
        fab.attachToRecyclerView(recList);

        final nextupfragment_CardView_Adapter adapter = new nextupfragment_CardView_Adapter(Rec1, Rec2);
        recList.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_of_cards++;
                editor.putInt("count", no_of_cards);
                editor.commit();
                set_bg_array(no_of_cards);
                adapter.notifyDataSetChanged();

            }
        });

        adapter.SetOnItemClickListener(new nextupfragment_CardView_Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                // do something with position

                Intent intent= new Intent(getActivity(),CardActivity.class);
                intent.putExtra("card_no",position);
                startActivity(intent);

            }
        });

        return nextup;
    }


    public void set_bg_array(int count) {
        Rec1.clear();
        Rec2.clear();
        for (int i = 0; i < count; i++) {
            Rec1.add(rectangle1[i % 5]);
            Rec2.add(rectangle2[i % 5]);

        }
    }
}
