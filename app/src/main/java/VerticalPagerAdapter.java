package seproject.pratikninadmayekar.shortz;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Pratik Ninad Mayekar on 15-04-2018.
 */

public class VerticalPagerAdapter extends PagerAdapter {

    String arrayHeadings[] = {"Spiderman is back to being the funny and sarcastic hero from comics",
            "Ironman acting as a paternal figure in the upcoming Avengers movie"};
    String arrayContents[] = {"Spider-Man is a fictional superhero appearing in American comic books published by Marvel Comics. The character was created by writer-editor Stan Lee and writer-artist Steve Ditko, and first appeared in the anthology comic book Amazing Fantasy #15 (Aug. 1962) in the Silver Age of Comic Books.",
            "Iron Man is a 2008 American superhero film based on the Marvel Comics character of the same name, produced by Marvel Studios and distributed by Paramount Pictures.1 It is the first film in the Marvel Cinematic Universe. The film was directed by Jon Favreau, with a screenplay by Mark Fergus & Hawk Ostby and Art Marcum."};

    Context mContext;
    LayoutInflater mLayoutInflater;

    public VerticalPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.cardview_main, container, false);

        TextView heading = (TextView) itemView.findViewById(R.id.articleHeading);

        TextView content = (TextView) itemView.findViewById(R.id.articleContent);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);

        if (position % 2 == 0) {
            heading.setText(arrayHeadings[0]);
            content.setText(arrayContents[0]);
            imageView.setImageResource(R.drawable.shortz_logo);
        }
        else{
            heading.setText(arrayHeadings[1]);
            content.setText(arrayContents[1]);
            imageView.setImageResource(R.drawable.shortz_logo);
        }

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
