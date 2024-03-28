package com.example.healthapp;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int selectedTab=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        final LinearLayout homeLayout=findViewById(R.id.home_layout);
        final LinearLayout consultLayout=findViewById(R.id.consult_layout);
        final LinearLayout productLayout=findViewById(R.id.product_layout);
        final LinearLayout profileLayout=findViewById(R.id.profile_layout);

        final ImageView homeImage=findViewById(R.id.home_icon);
        final ImageView consultImage=findViewById(R.id.consult_icon);
        final ImageView productImage=findViewById(R.id.products_icon);
        final ImageView profileImage=findViewById(R.id.profile_icon);

        final TextView homeText=findViewById(R.id.home_text);
        final TextView consultText=findViewById(R.id.consult_text);
        final TextView productText=findViewById(R.id.products_text);
        final TextView profileText=findViewById(R.id.profile_text);


        getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                                .replace(R.id.fragmentContainer,homeFragment.class,null)
                                        .commit();

        homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTab !=1){


                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,homeFragment.class,null)
                            .commit();

                    consultText.setVisibility(View.GONE);
                    productText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    consultImage.setImageResource(R.drawable.consult_icon_navbar);
                    productImage.setImageResource(R.drawable.products_icon_navbar);
                    profileImage.setImageResource(R.drawable.profile_icon_navbar);


                    consultLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    productLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    homeText.setVisibility(View.VISIBLE);
                    homeImage.setImageResource(R.drawable.home_icon_home);
                    homeLayout.setBackgroundResource(R.drawable.bottom_nav_bg);

                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setFillAfter(true);
                    homeLayout.startAnimation(scaleAnimation);

                    selectedTab=1;

                }
            }
        });

        consultLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedTab !=2){


                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,consultFragment.class,null)
                            .commit();



                    homeText.setVisibility(View.GONE);
                    productText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon_home);
                    productImage.setImageResource(R.drawable.products_icon_navbar);
                    profileImage.setImageResource(R.drawable.profile_icon_navbar);


                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    productLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    consultText.setVisibility(View.VISIBLE);
                    consultImage.setImageResource(R.drawable.consult_icon_navbar);
                    consultLayout.setBackgroundResource(R.drawable.bottom_nav_bg);

                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setFillAfter(true);
                    consultLayout.startAnimation(scaleAnimation);

                    selectedTab=2;

                }

            }
        });



        productLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (selectedTab !=3){



                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,productFragment.class,null)
                            .commit();




                    homeText.setVisibility(View.GONE);
                    consultText.setVisibility(View.GONE);
                    profileText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon_home);
                    consultImage.setImageResource(R.drawable.consult_icon_navbar);
                    profileImage.setImageResource(R.drawable.profile_icon_navbar);


                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    consultLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    profileLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    productText.setVisibility(View.VISIBLE);
                    productImage.setImageResource(R.drawable.products_icon_navbar);
                    productLayout.setBackgroundResource(R.drawable.bottom_nav_bg);

                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setFillAfter(true);
                    productLayout.startAnimation(scaleAnimation);

                    selectedTab=3;
                }

            }
        });



        profileLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (selectedTab !=4){


                    getSupportFragmentManager().beginTransaction()
                            .setReorderingAllowed(true)
                            .replace(R.id.fragmentContainer,profileFragment.class,null)
                            .commit();

                    homeText.setVisibility(View.GONE);
                    consultText.setVisibility(View.GONE);
                    productText.setVisibility(View.GONE);

                    homeImage.setImageResource(R.drawable.home_icon_home);
                    consultImage.setImageResource(R.drawable.consult_icon_navbar);
                    productImage.setImageResource(R.drawable.products_icon_navbar);


                    homeLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    consultLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    productLayout.setBackgroundColor(getResources().getColor(android.R.color.transparent));


                    profileText.setVisibility(View.VISIBLE);
                    profileImage.setImageResource(R.drawable.profile_icon_navbar);
                    profileLayout.setBackgroundResource(R.drawable.bottom_nav_bg);

                    ScaleAnimation scaleAnimation=new ScaleAnimation(0.8f,1.0f,1f,1f,Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,0.0f);
                    scaleAnimation.setFillAfter(true);
                    profileLayout.startAnimation(scaleAnimation);

                    selectedTab=4;
                }


            }
        });















    }
}