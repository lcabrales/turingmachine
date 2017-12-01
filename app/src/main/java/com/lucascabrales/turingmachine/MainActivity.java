package com.lucascabrales.turingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.lucascabrales.turingmachine.ResultsActivity.TM_KEY;

public class MainActivity extends AppCompatActivity {

    private MainActivity mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar();
        setOnClickListeners();
    }

    /**
     * Define el comportamiento de los botones
     */
    private void setOnClickListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ResultsActivity.class);

                String tm = null;

                switch (view.getId()) {
                    case R.id.btn_addition:
                        tm = ResultsActivity.ADDITION;
                        break;
                    case R.id.btn_substraction:
                        tm = ResultsActivity.SUBSTRACTION;
                        break;
                    case R.id.btn_multiplication:
                        tm = ResultsActivity.MULTIPLICATION;
                        break;
                }

                intent.putExtra(TM_KEY, tm);
                startActivity(intent);
            }
        };

        findViewById(R.id.btn_addition).setOnClickListener(listener);
        findViewById(R.id.btn_substraction).setOnClickListener(listener);
        findViewById(R.id.btn_multiplication).setOnClickListener(listener);
    }

    /**
     * Configura el toolbar de la actividad
     */
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null) {
            toolbar.setTitle(getTitle());
        }
    }
}