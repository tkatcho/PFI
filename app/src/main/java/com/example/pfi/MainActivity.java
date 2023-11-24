package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //stardew valley themed selling plateform
    }


    //region animations
    public void onDoor1Click(View view) {
        ImageButton doorButton = findViewById(R.id.enterDoor);
        View loginForm = findViewById(R.id.loginForm);

        // Set pivot point to the hinge edge
        doorButton.setPivotX(0);
        doorButton.setPivotY(doorButton.getHeight());

        // Create ObjectAnimator for rotation around Y-axis
        ObjectAnimator rotationAnimator = ObjectAnimator.ofFloat(doorButton, "rotationY", 0f, -75f);
        rotationAnimator.setDuration(1000);

        // Play animation
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotationAnimator);
        animatorSet.start();


        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                loginFadeAnim();
            }
        });
    }
    private void loginFadeAnim(){
        View loginForm = findViewById(R.id.loginForm);

        ObjectAnimator loginFormAlphaAnimator = ObjectAnimator.ofFloat(loginForm, "alpha", 0f, 1f);
        loginFormAlphaAnimator.setDuration(1000);

        loginForm.setVisibility(View.VISIBLE);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(loginFormAlphaAnimator);
        animatorSet.start();
    }

    //endregion

}