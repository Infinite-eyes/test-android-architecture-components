package com.example.android.contentprovidersample;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.contentprovidersample.data.Cheese;
import com.example.android.contentprovidersample.provider.SampleContentProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int LOADER_CHEESES  = 1;

    private CheeseAdapter mCheeseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(list.getContext()));

        mCheeseAdapter = new CheeseAdapter();
        list.setAdapter(mCheeseAdapter);

        getSupportLoaderManager().initLoader(LOADER_CHEESES,null, mLoaderCallbacks);
    }

    private LoaderManager.LoaderCallbacks<Cursor> mLoaderCallbacks =
            new LoaderManager.LoaderCallbacks<Cursor>() {
                @NonNull
                @Override
                public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
                    switch (id){
                        case LOADER_CHEESES:
                            return new CursorLoader(getApplicationContext(),
                                                    SampleContentProvider.URI_CHEESE,
                                                    new String[]{Cheese.COLUMN_NAME},
                                                null, null,null);
                           default:
                               throw new IllegalArgumentException();
                    }
                }

                @Override
                public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
                    switch (loader.getId()){
                        case LOADER_CHEESES:
                            mCheeseAdapter.setCheeses(data);
                            break;
                    }
                }

                @Override
                public void onLoaderReset(@NonNull Loader<Cursor> loader) {
                    switch (loader.getId()){
                        case LOADER_CHEESES:
                            mCheeseAdapter.setCheeses(null);
                            break;
                    }
                }
            };



    private static class CheeseAdapter extends RecyclerView.Adapter<CheeseAdapter.ViewHolder>{

        private Cursor mCursor;


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            if(mCursor.moveToPosition(position)){
                holder.mText.setText(mCursor.getString(mCursor.getColumnIndexOrThrow(Cheese.COLUMN_NAME)));
            }
        }

        @Override
        public int getItemCount() {
            return mCursor == null ? 0 : mCursor.getCount();
        }


        void setCheeses(Cursor cursor){
            mCursor = cursor;
            notifyDataSetChanged();
        }


        static class ViewHolder extends RecyclerView.ViewHolder{

            TextView mText;

             ViewHolder(ViewGroup parent) {
                super(LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent,false));
                mText = itemView.findViewById(android.R.id.text1);
            }
        }

    }





}
