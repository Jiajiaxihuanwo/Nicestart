package com.example.nicestart;

import static kotlinx.coroutines.android.HandlerDispatcherKt.Main;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //长按菜单
        TextView mycontext = findViewById(R.id.myText);
        registerForContextMenu(mycontext);
        //下滑刷新
        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    //        ImageView profileImage = findViewById(R.id.profileImage);
    //        Glide.with(this)
    //                .load(R.drawable.xinbo)
    //                .circleCrop()
    //                .into(profileImage);
    //
    //        String username = getIntent().getStringExtra("NOMBRE");
    //        TextView nom = findViewById(R.id.username);
    //        nom.setText( username);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(MainActivity.this,"Hi here!",Toast.LENGTH_LONG);
            toast.show();
            swipeLayout.setRefreshing(false);
        }
    };
    //长按的选择
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
        } else if (item.getItemId() == R.id.item2) {
            Toast toast = Toast.makeText(this, "Downloasd item...", Toast.LENGTH_LONG);
            toast.show();
        }
        return false;
    }

    //顶部菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }

}