package com.ilalux.observatorio;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.VH> {
    private final int[] imagenes;

    SlideAdapter(int[] imagenes) { this.imagenes = imagenes; }

    static class VH extends RecyclerView.ViewHolder {
        final ImageView img;
        VH(ImageView v) { super(v); img = v; }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageView v = new ImageView(parent.getContext());
        v.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        v.setScaleType(ImageView.ScaleType.CENTER_CROP);
        v.setContentDescription("Fotografía del Observatorio Ilalux");
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.img.setImageResource(imagenes[position]);
    }

    @Override
    public int getItemCount() { return imagenes.length; }
}
