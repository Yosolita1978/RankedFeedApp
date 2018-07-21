package co.yosola.ranked;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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

//        Setting the date with Format. I preffer only the month and the year of publication
        TextView dateTextView = listItemView.findViewById(R.id.news_date);
        String dateWithoutFormat = currentArticle.getPublishedDate();
        Date date = fromISO8601UTC(dateWithoutFormat);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.US);
        String dateStr = dateFormat.format(date);
        dateTextView.setText(dateStr);

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

    //    Helper method to format the Date String
    private Date fromISO8601UTC(String dateStr) {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        df.setTimeZone(tz);

        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
