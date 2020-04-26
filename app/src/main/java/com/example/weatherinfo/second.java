//package com.example.weatherinfo;
//
//import android.Manifest;
//import android.app.Activity;
//import android.content.Context;
//import android.location.Location;
//import android.text.Layout;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.constraintlayout.widget.ConstraintLayout;
//import androidx.core.app.ActivityCompat;
//import androidx.recyclerview.widget.RecyclerView;
//
//    public class second extends RecyclerView.Adapter<second.ViewHolder> {
//
//        int[] pos={R.mipmap.img0,R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4, };
//        private LayoutInflater mInflater;
//       Context context;
//        int l;
//
//       // private int[] colorArray = new int[]{android.R.color.black, android.R.color.holo_blue_dark, android.R.color.holo_green_dark, android.R.color.holo_red_dark};
//
//        second(Context context, int l) {
//
//            this.mInflater = LayoutInflater.from(context);
//            this.context=context;
//                this.l=l;    }
//
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View view = mInflater.inflate(l, parent, false);
//            return new ViewHolder(view);
//        }
//
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.myTextView.setImageResource(pos[position]);
//            //holder.relativeLayout.setBackgroundResource(colorArray[position]);
//        }
//
//        @Override
//        public int getItemCount() {
//            return pos.length;
//        }
//
//
//        public class ViewHolder extends RecyclerView.ViewHolder {
//            ImageView myTextView;
//
//
//            ViewHolder(final View itemView) {
//                super(itemView);
//                myTextView = itemView.findViewById(R.id.imageView);
//
//            }
//                  }
//        }
