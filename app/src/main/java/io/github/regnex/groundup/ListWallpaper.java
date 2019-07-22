    package io.github.regnex.groundup;

    import android.content.Intent;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;

    import androidx.appcompat.widget.Toolbar;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import android.util.Log;
    import android.view.LayoutInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.view.ViewGroup;

    import com.firebase.ui.database.FirebaseRecyclerAdapter;
    import com.firebase.ui.database.FirebaseRecyclerOptions;
    import com.google.firebase.database.FirebaseDatabase;
    import com.google.firebase.database.Query;
    import com.squareup.picasso.Callback;
    import com.squareup.picasso.NetworkPolicy;
    import com.squareup.picasso.Picasso;

    import io.github.regnex.groundup.Common.Common;
    import io.github.regnex.groundup.Interface.ItemClickListener;
    import io.github.regnex.groundup.Model.WallpaperItem;
    import io.github.regnex.groundup.ViewHolder.ListWallpaperViewHolder;

    public class ListWallpaper extends AppCompatActivity {
    Query query;
    FirebaseRecyclerAdapter<WallpaperItem,ListWallpaperViewHolder> adapter;
    FirebaseRecyclerOptions<WallpaperItem> options;
    RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_wallpaper);

            Toolbar toolbar = findViewById(R.id.toolbar);
            toolbar.setTitle(Common.CATEGORY_SELECTED);
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            recyclerView = findViewById(R.id.recycler_list_wallpaper);
            recyclerView.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
            recyclerView.setLayoutManager(gridLayoutManager);

            loadBackground();
        }

        private void loadBackground() {
            query = FirebaseDatabase.getInstance().getReference(Common.STR_WALLPAPER)
            .orderByChild("categoryId").equalTo(Common.CATEGORY_ID_SELECTED);

            options = new FirebaseRecyclerOptions.Builder<WallpaperItem>()
                    .setQuery(query,WallpaperItem.class)
                    .build();

            adapter = new FirebaseRecyclerAdapter<WallpaperItem, ListWallpaperViewHolder>(options) {
                @Override
                protected void onBindViewHolder(@NonNull final ListWallpaperViewHolder holder, int position, @NonNull final WallpaperItem model) {
                    Picasso.get()
                            .load(model.getImageUrl())
                            .networkPolicy(NetworkPolicy.OFFLINE)
                            .into(holder.wallpaper, new Callback() {
                                @Override
                                public void onSuccess() {

                                }

                                @Override
                                public void onError(Exception e) {
                                    Picasso.get()
                                            .load(model.getImageUrl())
                                            .error(R.drawable.ic_terrain_black_24dp)
                                            .into(holder.wallpaper, new Callback() {
                                                @Override
                                                public void onSuccess() {

                                                }

                                                @Override
                                                public void onError(Exception e) {
                                                    Log.e("ERROR_GROUNDUP","Could not load image");

                                                }

                                            });
                                }

                            });

                    holder.setItemClickListener(new ItemClickListener() {
                        @Override
                        public void onClick(View view, int position) {
                            Common.select_background = model;
                            startActivity(new Intent(ListWallpaper.this,ViewWallpaper.class));
                        }
                    });
                }

                @Override
                public ListWallpaperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    View itemView = LayoutInflater.from(parent.getContext())
                            .inflate(R.layout.layout_wallpaper_item,parent,false);
                    int height = parent.getMeasuredHeight()/2;
                    itemView.setMinimumHeight(height);
                    return new ListWallpaperViewHolder(itemView);
                }
            };

            adapter.startListening();
            recyclerView.setAdapter(adapter);
        }

        @Override
        protected void onStart() {
            super.onStart();
            if (adapter != null)
                adapter.startListening();
        }

        @Override
        protected void onStop() {
            if (adapter != null)
                adapter.stopListening();
            super.onStop();
        }

        @Override
        protected void onResume() {
            super.onResume();
            if (adapter != null)
                adapter.startListening();
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId()==android.R.id.home)
                finish();
            return super.onOptionsItemSelected(item);
        }
    }
