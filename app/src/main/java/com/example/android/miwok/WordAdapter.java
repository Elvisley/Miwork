package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Solution Process Web on 06/01/2017.
 */

public class WordAdapter  extends ArrayAdapter<Word>{

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context , 0 , words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word wordgetitem = getItem(position);

        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwok_text_view.setText(wordgetitem.getMiwokTranslation());

        TextView dafault_text_view = (TextView) listItemView.findViewById(R.id.dafault_text_view);
        dafault_text_view.setText(wordgetitem.getDefaultTranslation());

        ImageView default_image_view = (ImageView) listItemView.findViewById(R.id.image_root);
        default_image_view.setImageResource(wordgetitem.getImageResourceId());

        return listItemView;
    }
}
