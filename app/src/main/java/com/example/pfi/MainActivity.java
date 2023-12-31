package com.example.pfi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {
    //region title
    private TextView title;
    private String textToType = "Stardew Valley Resto";
    private int currentIndex = 0;
    private static final int INITIAL_TEXT_SIZE = 40;
    private static final int ENLARGED_TEXT_SIZE = 80;
    private static final long DELAY_PER_CHARACTER = 200;
    MediaPlayer mp;
    //endregion

    /**
     * Commence l'application, la musique et l'animation du titre
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.justthetwofofus);
        titleAnimation();


        initializeLogin();
    }

    /**
     * Initialise le login (TextViews et bouton)
     */
    private void initializeLogin() {
        TextView username = findViewById(R.id.usernameEditText);
        TextView password = findViewById(R.id.passwordEditText);
        Button loginbtn = findViewById(R.id.loginButton);
        TextView errorMessage = findViewById(R.id.messageTextView);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin(username.getText().toString(), password.getText().toString(), errorMessage);
            }
        });
    }

    /**
     * Vérifie l'information du login donné par l'usager
     * @param enteredUsername
     * @param enteredPassword
     * @param errorMessage
     */
    private void performLogin(String enteredUsername, String enteredPassword, TextView errorMessage) {
        if (enteredUsername.equals("admin") && enteredPassword.equals("admin")) {
            Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
            mp.stop();
            Intent intent = new Intent(MainActivity.this, MenuPage.class);
            intent.putExtra("user", "salut");
            startActivity(intent);
        }
        else {

            Toast.makeText(MainActivity.this, "Invalid login.", Toast.LENGTH_SHORT).show();

            // Wrong username
            if (!enteredUsername.equals("admin")) {
                errorMessage.setText("Wrong username");
            }
            // Wrong password
            if (!enteredPassword.equals("admin")) {
                errorMessage.setText("Wrong password");
            }
            if (!enteredUsername.equals("admin") && !enteredPassword.equals("admin")){
                errorMessage.setText("Wrong login");
            }

        }
        mp.stop();
        Intent intent = new Intent(this, MenuPage.class);
        intent.putExtra("user", "salut");

    }
    //endregion


    /**
     * L'animation de la porte
     * @param view
     */
    //region animations
    public void onDoor1Click(View view) {
        ImageButton doorButton = findViewById(R.id.enterDoor);
        View loginForm = findViewById(R.id.loginForm);

        doorButton.setEnabled(false);
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

    /**
     * Modifie la police du titre
     */
    private void setFont(){
        TextView textView = findViewById(R.id.Title);
        Typeface customTypeface = ResourcesCompat.getFont(this, R.font.stardew_font);

        textView.setTypeface(customTypeface);
        textView.setTextColor(ContextCompat.getColor(this,R.color.white));
        textView.setTextSize(5,5);
        textView.setGravity(Gravity.CENTER);
    }

    /**
     * L'animation du titre
     */
    private void titleAnimation() {
        final Handler handler = new Handler();
        title = findViewById(R.id.Title);
        setFont();
        new Thread(() -> {
            while (true) {
                mp.start();
                for (int i = 0; i < textToType.length(); i++) {
                    final char currentChar = textToType.charAt(i);
                    currentIndex = i;

                    handler.post(() -> {
                        updateTextView();
                    });

                    try {
                        Thread.sleep(DELAY_PER_CHARACTER);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    private void updateTextView() {
        SpannableString spannableString = new SpannableString(textToType);

        for (int i = 0; i < textToType.length(); i++) {
            if (i == currentIndex) {
                // Enlarge the currently typed letter
                spannableString.setSpan(new AbsoluteSizeSpan(ENLARGED_TEXT_SIZE, true), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            } else {
                spannableString.setSpan(new AbsoluteSizeSpan(INITIAL_TEXT_SIZE, true), i, i + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        title.setText(spannableString);
    }
    //endregion



}

