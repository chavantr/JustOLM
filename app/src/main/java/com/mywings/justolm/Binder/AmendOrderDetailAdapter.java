package com.mywings.justolm.Binder;

import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mywings.justolm.R;

/**
 * Created by Tatyabhau Chavan on 5/26/2016.
 */
public class AmendOrderDetailAdapter extends RecyclerView.Adapter<AmendOrderDetailAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.amend_order_detail_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView lblPrescribeName;
        AppCompatTextView lblSchedule;
        AppCompatTextView lblPeriod;
        AppCompatEditText txtQty;
        AppCompatTextView lblScheduler;


        public ViewHolder(View itemView) {
            super(itemView);

            lblPrescribeName = (AppCompatTextView) itemView.findViewById(R.id.lblPrescribeName);
            lblSchedule = (AppCompatTextView) itemView.findViewById(R.id.lblSchedule);
            lblPeriod = (AppCompatTextView) itemView.findViewById(R.id.lblPeriod);
            txtQty = (AppCompatEditText) itemView.findViewById(R.id.txtQty);
            lblScheduler = (AppCompatTextView) itemView.findViewById(R.id.lblScheduler);

        }
    }

}
