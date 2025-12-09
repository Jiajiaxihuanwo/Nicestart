package com.example.nicestart;

import static kotlinx.coroutines.android.HandlerDispatcherKt.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ContentView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main);

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

        WebView webView = findViewById(R.id.vistaweb);
        registerForContextMenu(webView);

        miVisorWeb = (WebView) findViewById(R.id.vistaweb);
        String html = "<html>" +
                "<head><style>" +
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }" +
                "img { width:100%; height:100%; object-fit:cover; }" +   // ❤️ el equivalente a centerCrop
                "</style></head>" +
                "<body>" +
                "<img src='https://thispersondoesnotexist.com' />" +
                "</body></html>";
        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
    }

    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast = Toast.makeText(MainActivity.this,"Hi here!",Toast.LENGTH_LONG);
            toast.show();
            miVisorWeb.reload();
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

    public void showAlertDialogButtonClicked(MainActivity mainActivity) {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Donde quieres ir?");
        builder.setIcon(R.drawable.hombre);
        builder.setCancelable(true);

        // add the buttons
        builder.setPositiveButton("Scrolling",(dialog,which)-> {
                Intent intent = new Intent(MainActivity.this, Login.class);
                Toast toast = Toast.makeText(this,"Scrolling",Toast.LENGTH_LONG);
                toast.show();
        });
        builder.setNegativeButton("Do nothing", (dialog,which)-> {
            dialog.dismiss();
        });
        builder.setNeutralButton("Other",  (dialog,which)-> {
                System.exit(0);
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.item113){
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

}