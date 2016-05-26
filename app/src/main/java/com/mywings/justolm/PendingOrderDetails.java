package com.mywings.justolm;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mywings.justolm.Binder.PendingOrderView;
import com.mywings.justolm.Model.PendingOrderCollection;

public class PendingOrderDetails extends JustOlmCompactActivity {

    //region UI Controls
    private RecyclerView lstPedingOrderDetails;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        lstPedingOrderDetails = (RecyclerView) findViewById(R.id.lstPendingOrdersItems);
        lstPedingOrderDetails.setLayoutManager(setLayout(LinearLayoutManager.VERTICAL));
        final PendingOrderView pendingOrderView = new PendingOrderView(PendingOrderCollection.getPENDINGORDERS());
        lstPedingOrderDetails.setAdapter(pendingOrderView);
    }

    private LinearLayoutManager setLayout(int flow) {
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(flow);
        return linearLayoutManager;
    }
}
