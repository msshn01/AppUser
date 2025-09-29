package com.example.appuser.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appuser.databinding.ActivityAppMainBinding;
import com.example.appuser.databinding.ActivityMenuBinding;
import com.example.appuser.model.Users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.auth.User;

public class AppMainActivity extends AppCompatActivity {
    private ActivityAppMainBinding binding;
    public Users selectUser;
    public String kisaYol = "";
    FirebaseAuth auth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);





        binding.editTextText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN)) {
                    // ENTER ya da "Done" tuşu

                    Intent intent = new Intent(view.getContext(),SearchActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("search",v.getText().toString());
                    startActivity(intent);
                    binding.editTextText.setText("");
                return true;
                }
                return false;
            }
        });




    }

    public void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            System.out.println("Giriş başarılı. UID: " + user.getUid());
                        }
                    } else {
                        System.out.println("Hata: " + task.getException().getMessage());
                    }
                });
    }

    public void registerUser(String email,String password){

        auth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        System.out.println("Kullanıcı kaydı oldu");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("Kullanıcı kaydı olmadı");

                    }
                });

    }

    public void searchGo(View view){
        Intent intent = new Intent(this,SearchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void goMenu(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void onBerber(View view){
        kisaYol = "berber";
        binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }

    public void onElektrik(View view){
        kisaYol = "Elektrik";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }
    public void onOgretmen(View view){
        kisaYol = "Ogretmen";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }
    public void onMarangoz(View view){
        kisaYol = "Marangoz";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }
    public void onTamirci(View view){
        kisaYol = "tamirci";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }
    public void onTemizlikci(View view){
        kisaYol = "temizlikci";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }

    public void onTaxi(View view){
        kisaYol = "Taksi";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }

    public void onAsci(View view){
        kisaYol = "Aşcı";binding.editTextText.setText(kisaYol);
        KeyEvent enterEvent = new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER);
        binding.editTextText.dispatchKeyEvent(enterEvent);
    }

}