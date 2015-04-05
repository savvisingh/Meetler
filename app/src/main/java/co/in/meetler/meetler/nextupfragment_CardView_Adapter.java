package co.in.meetler.meetler;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by savvi.singh on 4/5/2015.
 */
public class nextupfragment_CardView_Adapter extends RecyclerView.Adapter<nextupfragment_CardView_Adapter.MyViewHolder> {

    ArrayList Rec1 =new ArrayList<String>();
    ArrayList Rec2 =new ArrayList<String>();
    OnItemClickListener mItemClickListener;
    public nextupfragment_CardView_Adapter( ArrayList<String> rec1,ArrayList<String> rec2){
        Rec1=rec1;
        Rec2=rec2;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.nextup_fragment_cardview, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.rec1.setBackgroundColor(Color.parseColor(String.valueOf(Rec1.get(position))));
        holder.rec2.setBackgroundColor(Color.parseColor(String.valueOf(Rec2.get(position))));
    }



    @Override
    public int getItemCount() {
        return Rec1.size();
    }



    public  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayout rec1,rec2;

        public MyViewHolder(View itemView) {
            super(itemView);
            rec1=(LinearLayout) itemView.findViewById(R.id.rectangle1);
            rec2=(LinearLayout) itemView.findViewById(R.id.rectangle2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }


    public interface OnItemClickListener {
        public void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}

