package com.example.user.searchproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.user.searchproject.Model.SearchItem;

import org.json.JSONException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private ImageButton btnSearch;
    private EditText etSearch;
    private RecyclerView mRecyclerView;

    public SearchFragment() {
        // Required empty public constructor

        //Log.d("myLogs", getArguments().getInt("age"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        btnSearch = (ImageButton) view.findViewById(R.id.btn_search);
        etSearch = (EditText) view.findViewById(R.id.et_search);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request(etSearch.getText().toString());
            }
        });

        return view;
    }

    private void request(String query) {
        App.getApi().searchQuery(query, Const.API_KEY, Const.SEARCH_ENGINE_ID, Const.RESULT_FORMAT, Const.RESULT_COUNT).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                List<SearchItem> items;

                try {
                    items = Util.parseJson(response.body());
                    mRecyclerView.setAdapter(new RecyclerViewAdapter(items));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }

}
