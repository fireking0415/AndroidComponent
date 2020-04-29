package org.fireking.moduleb.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.fireking.moduleb.R;
import org.fireking.moduleb.data.ZhihuEntity;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<ZhihuEntity> dasets = new ArrayList<>();

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MainViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.b_zhihu_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.bind(dasets.get(i));
    }

    @Override
    public int getItemCount() {
        return dasets.size();
    }

    public void submitList(List<ZhihuEntity> result) {
        dasets.clear();
        dasets.addAll(result);
        notifyDataSetChanged();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_logo;
        private TextView tv_title;
        private TextView tv_up;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_logo = itemView.findViewById(R.id.iv_logo);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_up = itemView.findViewById(R.id.tv_up);
        }

        public void bind(ZhihuEntity zhihuEntity) {

            if (zhihuEntity.images != null && zhihuEntity.images.size() > 0) {
                iv_logo.setVisibility(View.VISIBLE);
                Picasso.get().load(zhihuEntity.images.get(0)).into(iv_logo);
            } else {
                iv_logo.setVisibility(View.GONE);
            }

            tv_title.setText(zhihuEntity.title);
            tv_up.setText(zhihuEntity.hint);
        }
    }
}
