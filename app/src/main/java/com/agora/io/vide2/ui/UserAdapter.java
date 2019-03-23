package com.agora.io.vide2.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.agora.io.vide2.R;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<User> mUserList;
    public static class UserViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mtextView1;
        public TextView mtextview2;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mtextView1 = itemView.findViewById(R.id.textview);
            mtextview2 = itemView.findViewById(R.id.textview2);
        }

    }

    public UserAdapter(ArrayList<User>  userList){
        mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.liveusers,viewGroup,false);
        UserViewHolder uvh = new UserViewHolder(v);
        return uvh;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder userViewHolder, int i) {
            User currentUser = mUserList.get(i);
            userViewHolder.mImageView.setImageResource(currentUser.getImageResource());
            userViewHolder.mtextView1.setText(currentUser.getText1());
            userViewHolder.mtextview2.setText(currentUser.getText2());

    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }
}
