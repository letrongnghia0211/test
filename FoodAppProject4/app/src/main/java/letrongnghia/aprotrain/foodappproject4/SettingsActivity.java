package letrongnghia.aprotrain.foodappproject4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void MainActivity(View view) {
        startActivity(new Intent(SettingsActivity.this, MainActivity.class));
    }
}