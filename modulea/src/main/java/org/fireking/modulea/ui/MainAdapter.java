package org.fireking.modulea.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.fireking.modulea.R;
import org.fireking.modulea.data.GankIOEntity;
import org.fireking.modulea.databinding.AGankIoLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<GankIOEntity> entityList = new ArrayList<>();

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.a_gank_io_layout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
        mainViewHolder.bind(entityList.get(position));
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public void submitList(List<GankIOEntity> entities) {
        entityList.clear();
        entityList.addAll(entities);
        notifyDataSetChanged();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_grils_image;

        public MainViewHolder(View itemView) {
            super(itemView);
            iv_grils_image = itemView.findViewById(R.id.iv_grils_image);
        }

        public void bind(GankIOEntity item) {
            Picasso.get().load(item.url).into(iv_grils_image);
        }
    }
}
