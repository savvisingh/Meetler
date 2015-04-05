package co.in.meetler.meetler;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.software.shell.fab.ActionButton;

/**
 * Created by savvi.singh on 3/21/2015.
 */
public class CardActivity extends ActionBarActivity {

    android.support.v7.app.ActionBar mActionBar;
    public String[] rectangle1={"#01632B","#802225","#01538E" ,"#0E7c68" ,"#BD7617"};
    public String[] rectangle2 = {"#1EA02A", "#C04343", "#448CCB", "#10BFA0", "#ECA744"};

    int no_of_cards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardactivity_layout);
        final RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);

        Intent intent =getIntent();
        final int card_no=intent.getIntExtra("card_no",0);
        mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(rectangle1[card_no % 5])));
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(true);
        mActionBar.setTitle(" ");


        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);



        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();




        no_of_cards= pref.getInt("count"+ String.valueOf(card_no) , 1);

        Log.i("no_of_cards", String.valueOf(no_of_cards));


        ActionButton fab = (ActionButton) findViewById(R.id.action_button);
        fab.setButtonColor(Color.parseColor(rectangle2[card_no % 5]));
        fab.setImageResource(R.drawable.fab_plus_icon);
        fab.setButtonColorPressed(Color.parseColor(rectangle1[card_no % 5]));

        final CardActivity_Adapter adapter = new CardActivity_Adapter(getApplicationContext(),card_no, no_of_cards);
        recList.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_of_cards++;
                editor.putInt("count" + String.valueOf(card_no), no_of_cards);
                editor.commit();
                recList.setAdapter(new CardActivity_Adapter(getApplication(),card_no,no_of_cards));


            }
        });


        adapter.SetOnItemClickListener(new CardActivity_Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v , int position) {
                // do something with position

                LinearLayout ll=(LinearLayout)v.findViewById(R.id.rectangle1);
                ll.setPadding(0,150,0,150);
               Toast.makeText(getApplication(), "clicked", Toast.LENGTH_SHORT).show();

            }
        });

       /* recList.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                LinearLayout ll=(LinearLayout)v.findViewById(R.id.rectangle1);
                ll.setPadding(0,150,0,150);
                Toast.makeText(getApplication(),"clicked",Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meetler__home_, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                super.onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
