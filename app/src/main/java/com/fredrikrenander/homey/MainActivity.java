package com.fredrikrenander.homey;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    NavController navController;
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




        //navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);;


//       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//           @Override
//           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//               return false;
//           }
//       });
//            @Override
//            public boolean onNavigationItemSelected(MenuItem menuItem) {
//                int id = menuItem.getItemId();
//                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), menuItem.getItemId(), Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), menuItem.toString(), Toast.LENGTH_LONG).show();
//                if(id == R.id.nav_home) {
//                    navController.navigate(R.id.action_global_nav_home);
//                } else if(id == R.id.nav_gallery) {
//                    navController.navigate(R.id.action_global_nav_gallery);
//                } else if(id == R.id.nav_slideshow) {
//                    navController.navigate(R.id.action_global_nav_slideshow);
//                }
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });









//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                NavController navController = Navigation.findNavController(getParent(), R.id.nav_host_fragment);
//                return NavigationUI.onNavDestinationSelected(menuItem, navController)
//                        || onNavigationItemSelected(menuItem);
//
//
//
//            }
//        });

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id=menuItem.getItemId();
//                Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), menuItem.getItemId(), Toast.LENGTH_LONG).show();
//                Toast.makeText(getApplicationContext(), menuItem.toString(), Toast.LENGTH_LONG).show();
//
//                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
//                if (id==R.id.nav_home){
//                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
//                }
//                else if (id==R.id.nav_gallery){
//                    //Toast.makeText(getApplicationContext(), "Gallery", Toast.LENGTH_LONG).show();
//                    //Navigation.findNavController(menuItem).navigate(R.id.action_nav_home_to_nav_gallery);
//                    navController.navigate(R.id.action_nav_home_to_nav_gallery);
////                return true;
//                }
//                //This is for maintaining the behavior of the Navigation view
//                NavigationUI.onNavDestinationSelected(menuItem,navController);
//                //This is for closing the drawer after acting on it
//                drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

        // Test
        //navController.navigate(R.id.action_nav_home_to_nav_slideshow);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item)  {
//        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.onNavDestinationSelected(item, navController)
//                || super.onNavigationItemSelected(item);
//    }

//    @Override
//    public boolean onNavDestinationSelected(MenuItem menuItem, NavController navController) {
//
//        int id = menuItem.getItemId();
//        if (id == R.id.action_global_nav_slideshow) {
//            Intent intent = new Intent(Intent.ACTION_CALL);
//
//            intent.setData(Uri.parse("tel:" + "XXXxxxXXX"));
//
//            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
//            }
//            else
//            {
//                startActivity(intent);
//            }
//        }
//        else
//        {
//            // Make your navController object final above
//            // or call Navigation.findNavController() again here
//            NavigationUI.onNavDestinationSelected(menuItem, navController);
//        }
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }




//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.onNavDestinationSelected(item, navController)
//                || onNavigationItemSelected(item);
//    }




//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//
//
//                //Navigation.findNavController(item).navigate(R.id.action_nav_home_to_nav_gallery);
//                //navController.navigate(R.id.action_nav_home_to_nav_slideshow);
//                return true;
////            case R.id.action_settings:
////                showHelp();
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


}