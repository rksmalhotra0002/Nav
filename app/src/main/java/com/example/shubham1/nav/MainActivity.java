package com.example.shubham1.nav;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {

private Toolbar toolbar;
private DrawerLayout drawerlayout;
private NavigationView navigation_view;
private ActionBarDrawerToggle toogle;
private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setDrawer();
    }

    private void setDrawer()
    {
        drawerlayout=findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.toolbar);
        navigation_view=findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);

toogle=new ActionBarDrawerToggle(this,drawerlayout,toolbar,R.string.open,R.string.close);
drawerlayout.addDrawerListener(toogle);
toogle.syncState();

        View view=navigation_view.getHeaderView(0);
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_email=view.findViewById(R.id.tv_email);

        tv_name.setText("Arjun");
        tv_email.setText("rks.malhotra0001@gmail.com");

   navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
       @Override
       public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      drawerlayout.closeDrawer(GravityCompat.START);

      switch (item.getItemId())
      {
          case R.id.login:
              Toast.makeText(MainActivity.this, "Login...", Toast.LENGTH_SHORT).show();
              break;
          case R.id.my_order:

              Toast.makeText(MainActivity.this, "Order...", Toast.LENGTH_SHORT).show();

              break;

          case R.id.logout:

              builder=new AlertDialog.Builder(MainActivity.this);
              builder.setTitle("Logout Nav")
                      .setCancelable(false)
                      .setMessage("Do You Want to Logout ?")
                      .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                          @Override
                          public void onClick(DialogInterface dialog, int which) {
                              finish();
                          }
                      }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialog, int which) {
                      dialog.cancel();
                  }
              });

              AlertDialog dialog=builder.create();
              dialog.show();

           break;

      }
           return true;
       }
   });

    }

    @Override
    public void onBackPressed() {

        if (drawerlayout.isDrawerOpen(GravityCompat.START))
        {
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();

        }

    }
}
