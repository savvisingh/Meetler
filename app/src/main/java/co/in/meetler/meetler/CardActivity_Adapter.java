package co.in.meetler.meetler;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by savvi.singh on 3/21/2015.
 */
public class CardActivity_Adapter extends RecyclerView.Adapter<CardActivity_Adapter.MyViewHolder>  {
    Context context;
    OnItemClickListener mItemClickListener;
    ArrayList list_of_items =new ArrayList<String>();
    public String[] rectangle2={"#1EA02A","#C04343","#448CCB","#10BFA0","#ECA744"};

    int card_color , no_of_cards;
    public CardActivity_Adapter(Context app_context ,int card_no , int no_of_card){
     card_color=card_no%5;
        no_of_cards=no_of_card;
        context=app_context;
    }

    @Override
    public CardActivity_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.card_activity_card_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CardActivity_Adapter.MyViewHolder holder, int position) {
        holder.rec1.setBackgroundColor(Color.parseColor(rectangle2[card_color]));  }



    @Override
    public int getItemCount() {
        return no_of_cards;
    }


    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout rec1;

        public MyViewHolder(View itemView) {
            super(itemView);
            rec1=(LinearLayout) itemView.findViewById(R.id.rectangle1);

        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
