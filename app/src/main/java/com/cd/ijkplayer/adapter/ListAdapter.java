package com.cd.ijkplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cd.ijkplayer.R;

import java.util.List;

/**
 * 项目名称：IjKPlayer.
 * 创建人： CT.
 * 创建时间: 2017/4/24.
 * GitHub:https://github.com/CNHTT
 */

public class ListAdapter  extends BaseListAdapter<String>{
    public ListAdapter(Context context) {
        super(context);
    }

    public ListAdapter(Context mContext, List<String> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if (convertView==null){
           convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_list,parent,false);
       }
        TextView tvContent = (TextView) convertView.findViewById(R.id.tv_content);
        tvContent.setText(mDatas.get(position));
        return convertView;
    }
}
