package com.lucascabrales.turingmachine;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lucascabrales.turingmachine.helpers.AlertDialogHelper;
import com.lucascabrales.turingmachine.helpers.MachinesLibrary;
import com.lucascabrales.turingmachine.helpers.SimpleValidator;
import com.lucascabrales.turingmachine.helpers.TuringMachine;
import com.lucascabrales.turingmachine.models.TuringMachineOutput;

import static com.lucascabrales.turingmachine.helpers.SimpleValidator.BINARY;

public class ResultsActivity extends AppCompatActivity {

    public static final String TM_KEY = "TMKey";
    public static final String ADDITION = "ADDITION";
    public static final String SUBSTRACTION = "SUBSTRACTION";
    public static final String MULTIPLICATION = "MULTIPLICATION";

    private ResultsActivity mContext = this;
    private TuringMachine mTuringMachine;
    private boolean isRunning = false;
    private AlertDialogHelper mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mAlertDialog = new AlertDialogHelper(mContext);

        setupTM();

        setupToolbar();
        setOnClickListeners();
    }

    /**
     * Configura la Máquina de Turing que se va a ejecutar
     */
    private void setupTM() {
        String tm = getIntent().getStringExtra(TM_KEY);
        switch (tm) {
            case ADDITION:
                mTuringMachine = MachinesLibrary.binaryAddition();
                break;
            case SUBSTRACTION:
                mTuringMachine = MachinesLibrary.binarySubstraction();
                break;
            case MULTIPLICATION:
                mTuringMachine = MachinesLibrary.binaryMultiplication();
                break;
        }

        if (mTuringMachine == null) {
            mAlertDialog.showWithFinish("Error", "Algo salió mal. Lo sentimos");
        } else
            ((TextView) findViewById(R.id.tv_operation)).setText(mTuringMachine.operationSymbol);
    }

    /**
     * Valida e inicializa la corrida de la TM
     */
    private void runTM() {
        String value1 = ((EditText) findViewById(R.id.et_value1)).getText().toString();
        String value2 = ((EditText) findViewById(R.id.et_value2)).getText().toString();

        int val1 = Integer.parseInt(value1, 2);
        int val2 = Integer.parseInt(value2, 2);

        boolean trust = val1 >= val2
                && SimpleValidator.validate(BINARY, value1)
                && SimpleValidator.validate(BINARY, value2);

        if (trust) {
            String input = value1 + mTuringMachine.operationSymbol + value2;

            isRunning = true;
            toggleNextStepButton(true);
            toggleFastStepButton(true);
            toggleStartButton();

            TuringMachineOutput output = mTuringMachine.setup(input, false);

            updateViews(output);
        } else
            mAlertDialog.show("Error", "La entrada no es válida. " +
                    "Solo permite números binarios, y el primer valor debe ser mayor que el segundo.");
    }

    /**
     * Actualiza las vistas para el usuario
     *
     * @param output modelo de salida para las vistas
     */
    private void updateViews(TuringMachineOutput output) {
        if (output != null) {
            Spannable tape = new SpannableString(output.tape);

            tape.setSpan(new ForegroundColorSpan(Color.RED),
                    output.currentSymbol, output.currentSymbol + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            ((TextView) findViewById(R.id.tv_tape)).setText(tape);
        } else {
            rejectRun();
        }
    }

    /**
     * Habilita/deshabilita el botón "Next Step"
     *
     * @param enable true = habilita
     */
    private void toggleNextStepButton(boolean enable) {
        if (enable) {
            findViewById(R.id.btn_next_step).setEnabled(true);
            findViewById(R.id.btn_next_step).setBackgroundResource(R.drawable.ripple_rounded);
        } else {
            findViewById(R.id.btn_next_step).setEnabled(false);
            findViewById(R.id.btn_next_step).setBackgroundResource(R.drawable.ripple_rounded_disabled);
        }
    }

    /**
     * Habilita/deshabilita el botón "Fast Step"
     *
     * @param enable true = habilita
     */
    private void toggleFastStepButton(boolean enable) {
        if (enable) {
            findViewById(R.id.btn_fast_step).setEnabled(true);
            findViewById(R.id.btn_fast_step).setBackgroundResource(R.drawable.ripple_rounded);
        } else {
            findViewById(R.id.btn_fast_step).setEnabled(false);
            findViewById(R.id.btn_fast_step).setBackgroundResource(R.drawable.ripple_rounded_disabled);
        }
    }

    /**
     * Modifica el botón de iniciar
     */
    private void toggleStartButton() {
        if (!isRunning) {
            ((Button) findViewById(R.id.btn_start)).setText("Iniciar");
            findViewById(R.id.ll_results).setVisibility(View.GONE);
        } else {
            ((Button) findViewById(R.id.btn_start)).setText("Reiniciar");
            findViewById(R.id.ll_results).setVisibility(View.VISIBLE);
        }
    }

    /**
     * Acepta la entrada a la TM, actualizando las vistas
     */
    private void acceptRun() {
        toggleNextStepButton(false);
        toggleFastStepButton(false);
        ((TextView) findViewById(R.id.tv_result)).setText("La entrada ha sido ACEPTADA");
        isRunning = false;
    }

    /**
     * Rechaza la entrada a la TM, actualizando las vistas
     */
    private void rejectRun() {
        ((TextView) findViewById(R.id.tv_result)).setText("La entrada ha sido RECHAZADA");
        isRunning = false;
    }

    /**
     * Define el comportamiento de los botones
     */
    private void setOnClickListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TuringMachineOutput output = null;

                switch (view.getId()) {
                    case R.id.btn_start:
                        runTM();

                        //Ocultar el teclado del dispositivo
                        try {
                            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.btn_next_step:
                        output = mTuringMachine.nextStep();
                        updateViews(output);

                        if (output.done) {
                            acceptRun();
                        }
                        break;
                    case R.id.btn_fast_step:
                        try {
                            output = mTuringMachine.nextStep();

                            while (!output.done) {
                                output = mTuringMachine.nextStep();
                            }
                        } catch (Exception e) {
                            rejectRun();
                            e.printStackTrace();
                        }

                        updateViews(output);
                        acceptRun();
                        break;
                }
            }
        };

        findViewById(R.id.btn_start).setOnClickListener(listener);
        findViewById(R.id.btn_next_step).setOnClickListener(listener);
        findViewById(R.id.btn_fast_step).setOnClickListener(listener);
    }

    /**
     * Configura el toolbar de la actividad
     */
    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        String title = (String) getTitle();
        if (mTuringMachine != null) title = mTuringMachine.name;

        if (toolbar != null) {
            toolbar.setTitle(title);
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}