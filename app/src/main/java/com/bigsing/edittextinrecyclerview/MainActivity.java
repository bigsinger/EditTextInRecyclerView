package com.bigsing.edittextinrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemLayout = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_edit, parent, false);
                return new ItemHolder(itemLayout);
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
                final int position = i;
                final ItemHolder viewHolder = (ItemHolder) holder;
                viewHolder.tv.setText("item " + position);
            }

            @Override
            public int getItemCount() {
                return 50;
            }

            class ItemHolder extends RecyclerView.ViewHolder {
                private TextView tv;
                private EditText et;

                public ItemHolder(View itemView) {
                    super(itemView);
                    tv = (TextView) itemView.findViewById(R.id.tv);
                    et = (EditText) itemView.findViewById(R.id.et);
                }


            }
        });
    }
}
