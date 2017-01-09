package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.miwok.R.id.colors;

/**
 * Created by Solution Process Web on 06/01/2017.
 */

public class WordAdapter  extends ArrayAdapter<Word>{

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words , int BackgroundColor ){
        super(context , 0 , words);
        mColorResourceId = BackgroundColor;
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

        if(wordgetitem.hasImage()){
            default_image_view.setImageResource(wordgetitem.getImageResourceId());
            default_image_view.setVisibility(View.VISIBLE);
        }else{
            default_image_view.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
