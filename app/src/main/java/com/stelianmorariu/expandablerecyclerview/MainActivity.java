package com.stelianmorariu.expandablerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stelianmorariu.expandablerecyclerview.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private ExpandableRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();

       mAdapter.setItems( DataUtils.getDummyData());
    }

    private void setupRecyclerView() {
        if (mRecyclerView != null) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false));

            mAdapter = new ExpandableRecyclerAdapter(this);

            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
