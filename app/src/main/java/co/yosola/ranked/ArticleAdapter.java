package co.yosola.ranked;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristina on 7/19/18.
 */


public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(@NonNull Context context, @NonNull List<Article> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);
        }

        // Set up the current ranked article
        Article currentArticle = getItem(position);

        TextView sectionTextView = listItemView.findViewById(R.id.section_name);
        //Grabbing the section of the Article because I'll use that info for the image
        String articleSection = currentArticle.getSection();
        sectionTextView.setText(articleSection);

        TextView titleTextView = listItemView.findViewById(R.id.news_title);
        titleTextView.setText(currentArticle.getTitle());

        TextView dateTextView = listItemView.findViewById(R.id.news_date);
        dateTextView.setText(currentArticle.getPublishedDate());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView articleImageView = listItemView.findViewById(R.id.news_image);
        String imageUrl = currentArticle.getImageUrl();

        if (imageUrl != null) {
            Picasso.get().load(imageUrl).into(articleImageView);
        } else {
            articleImageView.setImageResource(R.drawable.defaultranked);
        }

        return listItemView;
    }

}
