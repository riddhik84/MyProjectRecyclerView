package com.riddhik.myapps.myprojectrecyclerview;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerAdapter mAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootview.findViewById(R.id.recycler_view);

        mAdapter = new RecyclerAdapter(getContext());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        //Apply GridLayout
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        //Apply LinearLayout
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Apply StaggeredGridLayoutManager
        //mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        return rootview;
    }
}
