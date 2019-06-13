package com.example.myy.qizhong;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<DbBean> list;
    private Context context;

    public RvAdapter(ArrayList<DbBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View inflate = View.inflate(context, R.layout.item_1, null);
            ViewHolder1 viewHolder1 = new ViewHolder1(inflate);
            return viewHolder1;
        }else if (i==1){
            View inflate = View.inflate(context, R.layout.item_2, null);
            ViewHolder2 viewHolder2 = new ViewHolder2(inflate);
            return viewHolder2;
        }else if (i==2){
            View inflate = View.inflate(context, R.layout.item_3, null);
            ViewHolder3 viewHolder3 = new ViewHolder3(inflate);
            return viewHolder3;
        }else if (i==3){
            View inflate = View.inflate(context, R.layout.item_4, null);
            ViewHolder4 viewHolder4 = new ViewHolder4(inflate);
            return viewHolder4;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof ViewHolder1){
            Glide.with(context).load(list.get(i).getImg()).into(((ViewHolder1) viewHolder).iv1);
            ((ViewHolder1) viewHolder).name1.setText(list.get(i).getTitle());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onClickListener!=null){
                        onClickListener.OnItemClick(i,list.get(i));
                    }
                }
            });
        }else if (viewHolder instanceof ViewHolder2){
            Glide.with(context).load(list.get(i).getImg()).into(((ViewHolder2) viewHolder).iv2);
            ((ViewHolder2) viewHolder).name2.setText(list.get(i).getTitle());
        }else if (viewHolder instanceof ViewHolder3){
            Glide.with(context).load(list.get(i).getImg()).into(((ViewHolder3) viewHolder).iv3);
            ((ViewHolder3) viewHolder).name3.setText(list.get(i).getTitle());
        }else if (viewHolder instanceof ViewHolder4){
            Glide.with(context).load(list.get(i).getImg()).into(((ViewHolder4) viewHolder).iv4);
            ((ViewHolder4) viewHolder).name4.setText(list.get(i).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else if (position==2){
            return 2;
        }else if (position==3){
            return 3;
        }
        return super.getItemViewType(position);
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView name1;
        private final ImageView iv1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            name1 = itemView.findViewById(R.id.name1);
            iv1 = itemView.findViewById(R.id.iv1);
        }
    }
    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private final TextView name2;
        private final ImageView iv2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            name2 = itemView.findViewById(R.id.name2);
            iv2 = itemView.findViewById(R.id.iv2);
        }
    }
    public class ViewHolder3 extends RecyclerView.ViewHolder {

        private final TextView name3;
        private final ImageView iv3;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);
            name3 = itemView.findViewById(R.id.name3);
            iv3 = itemView.findViewById(R.id.iv3);
        }
    }
    public class ViewHolder4 extends RecyclerView.ViewHolder {

        private final TextView name4;
        private final ImageView iv4;

        public ViewHolder4(@NonNull View itemView) {
            super(itemView);
            name4 = itemView.findViewById(R.id.name4);
            iv4 = itemView.findViewById(R.id.iv4);
        }
    }
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener{
        void OnItemClick(int p,DbBean dbBean);
    }
}
