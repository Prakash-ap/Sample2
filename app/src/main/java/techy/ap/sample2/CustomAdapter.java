package techy.ap.sample2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    private Context context;
    private List<Population> populationList;

    public CustomAdapter(Context context, List<Population> populationList) {
        this.context = context;
        this.populationList = populationList;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.child_list,viewGroup,false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder customViewHolder, int i) {
        customViewHolder.rank.setText(populationList.get(i).getRank());
        customViewHolder.country.setText(populationList.get(i).getCountry());

        Picasso.Builder builder=new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(populationList.get(i).getFlag())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(customViewHolder.flag);

    }

    @Override
    public int getItemCount() {
       List<Population> populationList=new ArrayList<>();

        return populationList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView rank,country;
        ImageView flag;
        private View mview;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mview=itemView;

            rank=(TextView)itemView.findViewById(R.id.child_rank);
            country=(TextView)itemView.findViewById(R.id.child_country);
            flag=(ImageView) itemView.findViewById(R.id.child_profile);

        }
    }
}
