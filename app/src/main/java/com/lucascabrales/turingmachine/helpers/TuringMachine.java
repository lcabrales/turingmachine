package com.lucascabrales.turingmachine.helpers;

import android.util.Log;

import com.lucascabrales.turingmachine.models.TuringMachineOutput;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by lucascabrales on 11/29/17.
 */

/**
 * Realiza el proceso de una Máquina de Turing
 */
public class TuringMachine {
    private Set<String> states;
    private Set<Transition> transitions;
    private String initialState;
    private String finalState;
    private String rejectState;

    private String tape;
    private String currentState;
    private int currentSymbol;

    public String name;
    public String operationSymbol;

    class Transition {
        String readState;
        char readSymbol;
        String writeState;
        char writeSymbol;
        boolean moveDirection; //true is right, false is left

        boolean isConflicting(String state, char symbol) {
            return state.equals(readState) && symbol == readSymbol;
        }
    }

    public TuringMachine() {
        states = new HashSet<>();
        transitions = new HashSet<>();
        initialState = "";
        finalState = "";
        rejectState = "";
        tape = "";
        currentState = "";
        currentSymbol = 0;
        name = "";
        operationSymbol = "";
    }

    /**
     * Reliza la configuración inicial de la Máquina de Turing
     *
     * @param input    cadena de prueba
     * @param fastStep saltar los pasos
     * @return modelo de salida para la vista
     */
    public TuringMachineOutput setup(String input, boolean fastStep) {
        currentState = initialState;

        //Añade espacios vacíos iniciales a la cadena introducida
        String blankSpaces = "_____";
        tape = blankSpaces + input + blankSpaces;

        currentSymbol = blankSpaces.length();

        //Objeto inicial de salida
        TuringMachineOutput output = new TuringMachineOutput();
        output.tape = tape;
        output.done = false;
        output.currentSymbol = currentSymbol;

        //Si fastStep == true, realiza toda la máquina hasta llegar al estado final
        if (fastStep) {
            while (!currentState.equals(finalState)) {
                output = nextStep();
            }
        }

        return output;
    }

    /**
     * Reliza el siguiente paso. Solo puede ser llamado luego de ejecutar el método setup()
     *
     * @return modelo de salida para la vista
     */
    public TuringMachineOutput nextStep() {
        boolean foundTransition = false;
        Transition currentTransition = null;

        //Recorre todas las transiciones hasta encontrar una que pueda usar
        Iterator<Transition> iterator = transitions.iterator();
        while (iterator.hasNext() && !foundTransition) {
            Transition nextTransition = iterator.next();
            if (nextTransition.readState.equals(currentState) && nextTransition.readSymbol == tape.charAt(currentSymbol)) {
                foundTransition = true;
                currentTransition = nextTransition;
            }
        }

        if (!foundTransition) {
            //La máquina está mal
            Log.e("TuringMachine", "There is no valid transition for this phase! (state=" + currentState + ", symbol=" + tape.charAt(currentSymbol) + ")");
            return null;
        } else {
            //Realiza el paso de transiciones
            currentState = currentTransition.writeState;
            char[] tempTape = tape.toCharArray();
            tempTape[currentSymbol] = currentTransition.writeSymbol;
            tape = new String(tempTape);

            if (currentTransition.moveDirection) {
                currentSymbol++;
            } else {
                currentSymbol--;
            }

            if (currentSymbol < 0)
                currentSymbol = 0;

            //Añade tantos espacios vacíos cuanto sean necesarios;
            if (tape.charAt(tape.length() - 1) != '_') tape += "_";
            if (tape.charAt(0) != '_') tape = "_" + tape;
        }

        TuringMachineOutput output = new TuringMachineOutput();
        output.tape = tape;
        output.done = currentState.equals(finalState);
        output.currentSymbol = currentSymbol;

        return output;
    }

    /**
     * Añade un estado a la Máquina, sólo si ese estado no existe
     *
     * @param newState identificador del estado, debe ser único
     * @return true = se añadió
     */
    public boolean addState(String newState) {
        if (states.contains(newState)) {
            return false;
        } else {
            states.add(newState);
            return true;
        }
    }

    /**
     * Establece el estado inicial de la Máquina
     *
     * @param newInitialState identificador del estado inicial
     * @return true = se estableció correctamente
     */
    public boolean setInitialState(String newInitialState) {
        if (states.contains(newInitialState)) {
            initialState = newInitialState;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Establece el estado final de la Máquina
     *
     * @param newFinalState identificador del estado final
     * @return true = se estableció correctamente
     */
    public boolean setFinalState(String newFinalState) {
        if (states.contains(newFinalState) && !rejectState.equals(newFinalState)) {
            finalState = newFinalState;
            return true;
        } else {
            return false;
        }
    }

    public boolean setRejectState(String newRejectState) {
        if (states.contains(newRejectState) && !finalState.equals(newRejectState)) {
            rejectState = newRejectState;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Agrega una transición a la Máquina, sólo si ésta no existe
     *
     * @param rState     estado origen
     * @param rSymbol    símbolo de lectura
     * @param wState     estado destino
     * @param wSymbol    símbolo de escritura
     * @param mDirection dirección a la que se mueve el cabezal (true = right, false = left)
     * @return true = se añadió correctamente
     */
    public boolean addTransition(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection) {
        if (!states.contains(rState) || !states.contains(wState)) {
            return false;
        }

        boolean conflict = false;

        //Verifica si la transición existe
        Iterator<Transition> TransitionsIterator = transitions.iterator();
        while (TransitionsIterator.hasNext() && !conflict) {
            Transition nextTransition = TransitionsIterator.next();
            if (nextTransition.isConflicting(rState, rSymbol)) {
                conflict = true;
            }

        }

        if (conflict) {
            return false;
        } else {
            Transition newTransition = new Transition();
            newTransition.readState = rState;
            newTransition.readSymbol = rSymbol;
            newTransition.writeState = wState;
            newTransition.writeSymbol = wSymbol;
            newTransition.moveDirection = mDirection;
            transitions.add(newTransition);
            return true;
        }
    }
}
