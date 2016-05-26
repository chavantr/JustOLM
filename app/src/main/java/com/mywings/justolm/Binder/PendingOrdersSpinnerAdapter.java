package com.mywings.justolm.Binder;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mywings.justolm.Model.Order;
import com.mywings.justolm.R;

import java.util.List;

/**
 * Created by Tatyabhau Chavan on 5/25/2016.
 */
public class PendingOrdersSpinnerAdapter extends RecyclerView.Adapter<PendingOrdersSpinnerAdapter.ViewHolder> {


    //region Variables
    public List<Order> orders;
    private OnItemClickListener onItemClickListener;
    //endregion

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PendingOrdersSpinnerAdapter(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_order_item_spinner, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.lblOrderNo.setText("Order No : " + orders.get(position).getOrderNo());
        holder.lblOrderDate.setText("Order Date : " + orders.get(position).getOrderDate());
        holder.lblOrderType.setText("Order Type : " + orders.get(position).getOrderType());

        if (orders.get(position).isActionDelete()) {
            holder.imgDeleteIcon.setVisibility(View.VISIBLE);
        } else {
            holder.imgDeleteIcon.setVisibility(View.GONE);
        }

        if (orders.get(position).isConfirmDeleted()) {
            holder.btnDelete.setVisibility(View.VISIBLE);
            holder.lnrStatus.setVisibility(View.GONE);
        } else {
            holder.btnDelete.setVisibility(View.GONE);
            holder.lnrStatus.setVisibility(View.VISIBLE);
        }

        holder.imgDeleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orders.get(position).setConfirmDeleted(true);
                notifyDataSetChanged();
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orders.remove(position);
                notifyDataSetChanged();
            }
        });


        holder.panel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != onItemClickListener) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView lblOrderNo;
        AppCompatTextView lblOrderDate;
        AppCompatTextView lblOrderType;
        LinearLayout lnrStatus;
        Button btnDelete;
        AppCompatImageView imgDeleteIcon;
        CardView panel;

        public ViewHolder(View itemView) {
            super(itemView);
            lblOrderNo = (AppCompatTextView) itemView.findViewById(R.id.lblOrderNo);
            lblOrderDate = (AppCompatTextView) itemView.findViewById(R.id.lblOrderDate);
            lblOrderType = (AppCompatTextView) itemView.findViewById(R.id.lblOrderType);
            lnrStatus = (LinearLayout) itemView.findViewById(R.id.lnrStatus);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            imgDeleteIcon = (AppCompatImageView) itemView.findViewById(R.id.imgDeleteIcon);
            panel = (CardView) itemView.findViewById(R.id.panel);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

}
