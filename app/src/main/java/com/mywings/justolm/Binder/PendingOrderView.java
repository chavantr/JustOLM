package com.mywings.justolm.Binder;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mywings.justolm.Model.PendingOrder;
import com.mywings.justolm.R;

import java.util.List;

/**
 * Created by Tatyabhau Chavan on 5/26/2016.
 */
public class PendingOrderView extends RecyclerView.Adapter<PendingOrderView.ViewHolder> {

    //region Variable
    private List<PendingOrder> pendingOrders;
    //endregion

    public PendingOrderView(List<PendingOrder> pendingOrders) {
        this.pendingOrders = pendingOrders;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.uneditableview, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.lblIndex.setText(pendingOrders.get(position).getIndex() + (position + 1));

        holder.lblPeriod.setText(pendingOrders.get(position).getPeriod());

        holder.lblScheduler.setText(pendingOrders.get(position).getScheduler());

        holder.lblPreName.setText(pendingOrders.get(position).getPreName());

        holder.lblQty.setText(pendingOrders.get(position).getQty());

    }

    @Override
    public int getItemCount() {
        return pendingOrders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView lblIndex;
        AppCompatTextView lblPreName;
        AppCompatTextView lblQty;
        AppCompatTextView lblScheduler;
        AppCompatTextView lblPeriod;

        public ViewHolder(View itemView) {
            super(itemView);
            lblIndex = (AppCompatTextView) itemView.findViewById(R.id.lblIndex);
            lblPreName = (AppCompatTextView) itemView.findViewById(R.id.txtName);
            lblQty = (AppCompatTextView) itemView.findViewById(R.id.txtQty);
            lblScheduler = (AppCompatTextView) itemView.findViewById(R.id.txtScheduler);
            lblPeriod = (AppCompatTextView) itemView.findViewById(R.id.txtPeriod);
        }
    }
}
