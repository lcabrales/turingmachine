package com.lucascabrales.turingmachine.helpers;

/**
 * Created by lucascabrales on 11/29/17.
 */

/**
 * Librería de Máquinas de Turing, agregue aquí todas las que desee usar en la aplicación
 */
public final class MachinesLibrary {

    /**
     * Definición de la Máquina de Turing de suma binaria
     * @return objeto de la Máquina de Turing
     */
    public static TuringMachine binaryAddition() {
        TuringMachine tm = new TuringMachine();

        tm.name = "Suma Binaria";
        tm.operationSymbol = "+";

        tm.addState("q13");
        tm.addState("q0");
        tm.addState("q1");
        tm.addState("q2");
        tm.addState("q3");
        tm.addState("q4");
        tm.addState("q5");
        tm.addState("q6");
        tm.addState("q7");
        tm.addState("q10");
        tm.addState("q11");
        tm.addState("q12");

        tm.setInitialState("q13");
        tm.setFinalState("q12");

        //Q13
        tm.addTransition("q13", '1', "q13", '1', true);
        tm.addTransition("q13", '0', "q13", '0', true);
        tm.addTransition("q13", '+', "q13", '+', true);
        tm.addTransition("q13", '_', "q0", '_', false);

        //Q0
        tm.addTransition("q0", '0', "q6", '_', false);
        tm.addTransition("q0", '1', "q1", '_', false);
        tm.addTransition("q0", '+', "q10", '+', false);

        //Q1
        tm.addTransition("q1", 'y', "q1", 'y', false);
        tm.addTransition("q1", 'x', "q1", 'x', false);
        tm.addTransition("q1", '0', "q1", '0', false);
        tm.addTransition("q1", '1', "q1", '1', false);
        tm.addTransition("q1", '+', "q2", '+', false);

        //Q2
        tm.addTransition("q2", 'y', "q2", 'y', false);
        tm.addTransition("q2", 'x', "q2", 'x', false);
        tm.addTransition("q2", '1', "q3", 'x', false);
        tm.addTransition("q2", '0', "q4", 'y', true);
        tm.addTransition("q2", '_', "q4", 'y', true);

        //Q3
        tm.addTransition("q3", '1', "q3", '0', false);
        tm.addTransition("q3", '0', "q4", '1', true);
        tm.addTransition("q3", '_', "q4", '1', true);

        //Q4
        tm.addTransition("q4", 'y', "q4", 'y', true);
        tm.addTransition("q4", 'x', "q4", 'x', true);
        tm.addTransition("q4", '0', "q4", '0', true);
        tm.addTransition("q4", '1', "q4", '1', true);
        tm.addTransition("q4", '+', "q5", '+', true);

        //Q5
        tm.addTransition("q5", 'y', "q5", 'y', true);
        tm.addTransition("q5", 'x', "q5", 'x', true);
        tm.addTransition("q5", '0', "q5", '0', true);
        tm.addTransition("q5", '1', "q5", '1', true);
        tm.addTransition("q5", '_', "q0", '_', false);

        //Q6
        tm.addTransition("q6", 'y', "q6", 'y', false);
        tm.addTransition("q6", 'x', "q6", 'x', false);
        tm.addTransition("q6", '0', "q6", '0', false);
        tm.addTransition("q6", '1', "q6", '1', false);
        tm.addTransition("q6", '+', "q7", '+', false);

        //Q7
        tm.addTransition("q7", 'x', "q7", 'x', false);
        tm.addTransition("q7", 'y', "q7", 'y', false);
        tm.addTransition("q7", '_', "q4", 'x', true);
        tm.addTransition("q7", '0', "q4", 'x', true);
        tm.addTransition("q7", '1', "q4", 'y', true);

        //Q10
        tm.addTransition("q10", 'y', "q10", '1', false);
        tm.addTransition("q10", 'x', "q10", '0', false);
        tm.addTransition("q10", '1', "q11", '1', true);
        tm.addTransition("q10", '0', "q11", '0', true);

        //Q11
        tm.addTransition("q11", 'x', "q11", 'x', true);
        tm.addTransition("q11", 'y', "q11", 'y', true);
        tm.addTransition("q11", '0', "q11", '0', true);
        tm.addTransition("q11", '1', "q11", '1', true);
        tm.addTransition("q11", '+', "q12", '_', false);

        return tm;
    }

    /**
     * Definición de la Máquina de Turing de resta binaria
     * @return objeto de la Máquina de Turing
     */
    public static TuringMachine binarySubstraction() {
        TuringMachine tm = new TuringMachine();

        tm.name = "Resta Binaria";
        tm.operationSymbol = "-";

        tm.addState("q0");
        tm.addState("q1");
        tm.addState("q2");
        tm.addState("q3");
        tm.addState("q4");
        tm.addState("q5");
        tm.addState("q6");
        tm.addState("q7");
        tm.addState("q8");
        tm.addState("q9");
        tm.addState("q10");
        tm.addState("q11");
        tm.addState("q12");
        tm.addState("q13");
        tm.addState("q14");
        tm.addState("q15");
        tm.addState("q16");
        tm.addState("q17");

        tm.setInitialState("q0");
        tm.setFinalState("q12");

        //Q0
        tm.addTransition("q0", '0', "q0", '0', true);
        tm.addTransition("q0", '1', "q0", '1', true);
        tm.addTransition("q0", '-', "q14", '-', true);

        //Q1
        tm.addTransition("q1", '0', "q2", '_', false);
        tm.addTransition("q1", '1', "q3", '_', false);
        tm.addTransition("q1", '-', "q5", '-', false);

        //Q2
        tm.addTransition("q2", 'y', "q2", 'y', false);
        tm.addTransition("q2", 'x', "q2", 'x', false);
        tm.addTransition("q2", '0', "q2", '0', false);
        tm.addTransition("q2", '1', "q2", '1', false);
        tm.addTransition("q2", '-', "q6", '-', false);

        //Q3
        tm.addTransition("q3", 'y', "q3", 'y', false);
        tm.addTransition("q3", 'x', "q3", 'x', false);
        tm.addTransition("q3", '0', "q3", '0', false);
        tm.addTransition("q3", '1', "q3", '1', false);
        tm.addTransition("q3", '-', "q4", '-', false);

        //Q4
        tm.addTransition("q4", 'y', "q4", 'y', false);
        tm.addTransition("q4", 'x', "q4", 'x', false);
        tm.addTransition("q4", '1', "q7", 'x', false);
        tm.addTransition("q4", '_', "q8", 'y', true);
        tm.addTransition("q4", '0', "q8", 'y', true);

        //Q5
        tm.addTransition("q5", 'y', "q5", '1', false);
        tm.addTransition("q5", 'x', "q5", '0', false);
        tm.addTransition("q5", '1', "q10", '1', true);
        tm.addTransition("q5", '0', "q10", '0', true);

        //Q6
        tm.addTransition("q6", 'y', "q6", 'y', false);
        tm.addTransition("q6", 'x', "q6", 'x', false);
        tm.addTransition("q6", '_', "q8", 'x', true);
        tm.addTransition("q6", '0', "q8", 'x', true);
        tm.addTransition("q6", '1', "q8", 'y', true);

        //Q7
        tm.addTransition("q7", '1', "q7", '0', false);
        tm.addTransition("q7", '_', "q8", '1', true);
        tm.addTransition("q7", '0', "q8", '1', true);

        //Q8
        tm.addTransition("q8", 'y', "q8", 'y', true);
        tm.addTransition("q8", 'x', "q8", 'x', true);
        tm.addTransition("q8", '0', "q8", '0', true);
        tm.addTransition("q8", '1', "q8", '1', true);
        tm.addTransition("q8", '-', "q9", '-', true);

        //Q9
        tm.addTransition("q9", 'y', "q9", 'y', true);
        tm.addTransition("q9", 'x', "q9", 'x', true);
        tm.addTransition("q9", '0', "q9", '0', true);
        tm.addTransition("q9", '1', "q9", '1', true);
        tm.addTransition("q9", '_', "q1", '_', false);

        //Q9
        tm.addTransition("q10", 'y', "q10", 'y', true);
        tm.addTransition("q10", 'x', "q10", 'x', true);
        tm.addTransition("q10", '0', "q10", '0', true);
        tm.addTransition("q10", '1', "q10", '1', true);
        tm.addTransition("q10", '-', "q11", '_', false);

        //Q11
        tm.addTransition("q11", '0', "q11", '0', false);
        tm.addTransition("q11", '1', "q11", '1', false);
        tm.addTransition("q11", '_', "q17", '_', true);

        //Q13
        tm.addTransition("q13", '0', "q13", '0', true);
        tm.addTransition("q13", '1', "q13", '1', true);
        tm.addTransition("q13", '_', "q1", '_', false);

        //Q14
        tm.addTransition("q14", '1', "q14", '1', true);
        tm.addTransition("q14", '0', "q14", '0', true);
        tm.addTransition("q14", '_', "q15", '_', false);

        //Q15
        tm.addTransition("q15", '0', "q15", '0', false);
        tm.addTransition("q15", '1', "q16", '1', false);

        //Q16
        tm.addTransition("q16", '1', "q16", '0', false);
        tm.addTransition("q16", '0', "q16", '1', false);
        tm.addTransition("q16", '-', "q13", '-', true);

        //Q17
        tm.addTransition("q17", '0', "q17", '_', false);
        tm.addTransition("q17", '1', "q17", '_', false);
        tm.addTransition("q17", '_', "q12", '_', true);

        return tm;
    }

    /**
     * Definición de la Máquina de Turing de multiplicación binaria
     * @return objeto de la Máquina de Turing
     */
    public static TuringMachine binaryMultiplication() {
        TuringMachine tm = new TuringMachine();

        tm.name = "Multiplicación Binaria";
        tm.operationSymbol = "*";

        tm.addState("q45");
        tm.addState("q0");
        tm.addState("q1");
        tm.addState("q2");
        tm.addState("q3");
        tm.addState("q10");
        tm.addState("q11");
        tm.addState("q12");
        tm.addState("q15");
        tm.addState("q16");
        tm.addState("q17");
        tm.addState("q20");
        tm.addState("q21");
        tm.addState("q22");
        tm.addState("q23");
        tm.addState("q24");
        tm.addState("q25");
        tm.addState("q26");
        tm.addState("q27");
        tm.addState("q28");
        tm.addState("q30");
        tm.addState("q31");
        tm.addState("q32");
        tm.addState("q33");
        tm.addState("q34");
        tm.addState("q35");
        tm.addState("q36");
        tm.addState("q37");
        tm.addState("q40");
        tm.addState("q41");
        tm.addState("q42");
        tm.addState("q43");
        tm.addState("q44");

        tm.setInitialState("q45");
        tm.setFinalState("q44");

        //Q45
        tm.addTransition("q45", '*', "q45", '*', true);
        tm.addTransition("q45", '0', "q45", '0', true);
        tm.addTransition("q45", '1', "q45", '1', true);
        tm.addTransition("q45", '_', "q0", '_', false);

        //Q0
        tm.addTransition("q0", '*', "q1", '_', false);
        tm.addTransition("q0", '0', "q10", '_', false);
        tm.addTransition("q0", '1', "q20", '_', false);

        //Q1
        tm.addTransition("q1", '0', "q1", '_', false);
        tm.addTransition("q1", '1', "q1", '_', false);
        tm.addTransition("q1", '_', "q2", '_', false);

        //Q2
        tm.addTransition("q2", '@', "q2", '0', false);
        tm.addTransition("q2", '$', "q2", '1', false);
        tm.addTransition("q2", '0', "q3", '0', true);
        tm.addTransition("q2", '1', "q3", '1', true);
        tm.addTransition("q2", '_', "q3", '_', true);

        //Q3
        tm.addTransition("q3", '0', "q3", '0', true);
        tm.addTransition("q3", '1', "q3", '1', true);
        tm.addTransition("q3", '_', "q44", '_', false);

        //Q10
        tm.addTransition("q10", '@', "q10", '@', false);
        tm.addTransition("q10", '$', "q10", '$', false);
        tm.addTransition("q10", 'y', "q10", 'y', false);
        tm.addTransition("q10", 'x', "q10", 'x', false);
        tm.addTransition("q10", '0', "q10", '0', false);
        tm.addTransition("q10", '1', "q10", '1', false);
        tm.addTransition("q10", '*', "q11", '*', false);

        //Q11
        tm.addTransition("q11", '@', "q11", '@', false);
        tm.addTransition("q11", '$', "q11", '$', false);
        tm.addTransition("q11", 'y', "q11", 'y', false);
        tm.addTransition("q11", 'x', "q11", 'x', false);
        tm.addTransition("q11", '0', "q11", '0', false);
        tm.addTransition("q11", '1', "q11", '1', false);
        tm.addTransition("q11", '_', "q12", '_', false);

        //Q12
        tm.addTransition("q12", '@', "q12", '@', false);
        tm.addTransition("q12", '$', "q12", '$', false);
        tm.addTransition("q12", '1', "q15", '$', true);
        tm.addTransition("q12", '0', "q15", '@', true);
        tm.addTransition("q12", '_', "q15", '@', true);

        //Q15
        tm.addTransition("q15", '@', "q15", '@', true);
        tm.addTransition("q15", '$', "q15", '$', true);
        tm.addTransition("q15", 'y', "q15", 'y', true);
        tm.addTransition("q15", 'x', "q15", 'x', true);
        tm.addTransition("q15", '0', "q15", '0', true);
        tm.addTransition("q15", '1', "q15", '1', true);
        tm.addTransition("q15", '_', "q16", '_', true);

        //Q16
        tm.addTransition("q16", '@', "q16", '@', true);
        tm.addTransition("q16", '$', "q16", '$', true);
        tm.addTransition("q16", 'y', "q16", 'y', true);
        tm.addTransition("q16", 'x', "q16", 'x', true);
        tm.addTransition("q16", '0', "q16", '0', true);
        tm.addTransition("q16", '1', "q16", '1', true);
        tm.addTransition("q16", '*', "q17", '*', true);

        //Q17
        tm.addTransition("q17", '@', "q17", '@', true);
        tm.addTransition("q17", '$', "q17", '$', true);
        tm.addTransition("q17", 'y', "q17", 'y', true);
        tm.addTransition("q17", 'x', "q17", 'x', true);
        tm.addTransition("q17", '0', "q17", '0', true);
        tm.addTransition("q17", '1', "q17", '1', true);
        tm.addTransition("q17", '_', "q0", '_', false);

        //Q20
        tm.addTransition("q20", '0', "q20", '0', false);
        tm.addTransition("q20", '1', "q20", '1', false);
        tm.addTransition("q20", '*', "q21", '*', false);

        //Q21
        tm.addTransition("q21", '0', "q22", 'x', false);
        tm.addTransition("q21", '1', "q26", 'y', false);

        //Q22
        tm.addTransition("q22", '@', "q22", '@', false);
        tm.addTransition("q22", '$', "q22", '$', false);
        tm.addTransition("q22", 'y', "q22", 'y', false);
        tm.addTransition("q22", 'x', "q22", 'x', false);
        tm.addTransition("q22", '0', "q22", '0', false);
        tm.addTransition("q22", '1', "q22", '1', false);
        tm.addTransition("q22", '_', "q23", '_', false);

        //Q23
        tm.addTransition("q23", '@', "q23", '@', false);
        tm.addTransition("q23", '$', "q23", '$', false);
        tm.addTransition("q23", 'y', "q23", 'y', false);
        tm.addTransition("q23", 'x', "q23", 'x', false);
        tm.addTransition("q23", '1', "q24", '$', true);
        tm.addTransition("q23", '0', "q24", '@', true);
        tm.addTransition("q23", '_', "q24", '@', true);

        //Q24
        tm.addTransition("q24", '@', "q24", '@', true);
        tm.addTransition("q24", '$', "q24", '$', true);
        tm.addTransition("q24", 'y', "q24", 'y', true);
        tm.addTransition("q24", 'x', "q24", 'x', true);
        tm.addTransition("q24", '0', "q24", '0', true);
        tm.addTransition("q24", '1', "q24", '1', true);
        tm.addTransition("q24", '_', "q25", '_', true);

        //Q25
        tm.addTransition("q25", '@', "q25", '@', true);
        tm.addTransition("q25", '$', "q25", '$', true);
        tm.addTransition("q25", '0', "q25", '0', true);
        tm.addTransition("q25", '1', "q25", '1', true);
        tm.addTransition("q25", 'x', "q30", 'x', false);
        tm.addTransition("q25", 'y', "q30", 'y', false);

        //Q26
        tm.addTransition("q26", '@', "q26", '@', false);
        tm.addTransition("q26", '$', "q26", '$', false);
        tm.addTransition("q26", 'y', "q26", 'y', false);
        tm.addTransition("q26", 'x', "q26", 'x', false);
        tm.addTransition("q26", '0', "q26", '0', false);
        tm.addTransition("q26", '1', "q26", '1', false);
        tm.addTransition("q26", '_', "q27", '_', false);

        //Q27
        tm.addTransition("q27", '@', "q27", '@', false);
        tm.addTransition("q27", '$', "q27", '$', false);
        tm.addTransition("q27", 'y', "q27", 'y', false);
        tm.addTransition("q27", 'x', "q27", 'x', false);
        tm.addTransition("q27", '1', "q28", '@', false);
        tm.addTransition("q27", '0', "q24", '$', true);
        tm.addTransition("q27", '_', "q24", '$', true);

        //Q28
        tm.addTransition("q28", '1', "q28", '0', false);
        tm.addTransition("q28", '0', "q24", '1', true);
        tm.addTransition("q28", '_', "q24", '1', true);

        //Q30
        tm.addTransition("q30", '0', "q31", 'x', false);
        tm.addTransition("q30", '1', "q35", 'y', false);
        tm.addTransition("q30", '_', "q40", '_', false);

        //Q31
        tm.addTransition("q31", '@', "q31", '@', false);
        tm.addTransition("q31", '$', "q31", '$', false);
        tm.addTransition("q31", 'y', "q31", 'y', false);
        tm.addTransition("q31", 'x', "q31", 'x', false);
        tm.addTransition("q31", '0', "q31", '0', false);
        tm.addTransition("q31", '1', "q31", '1', false);
        tm.addTransition("q31", '_', "q32", '_', false);

        //Q32
        tm.addTransition("q32", '@', "q32", '@', false);
        tm.addTransition("q32", '$', "q32", '$', false);
        tm.addTransition("q32", 'y', "q32", 'y', false);
        tm.addTransition("q32", 'x', "q32", 'x', false);
        tm.addTransition("q32", '1', "q33", 'y', true);
        tm.addTransition("q32", '0', "q33", 'x', true);
        tm.addTransition("q32", '_', "q33", 'x', true);

        //Q33
        tm.addTransition("q33", '@', "q33", '@', true);
        tm.addTransition("q33", '$', "q33", '$', true);
        tm.addTransition("q33", 'y', "q33", 'y', true);
        tm.addTransition("q33", 'x', "q33", 'x', true);
        tm.addTransition("q33", '0', "q33", '0', true);
        tm.addTransition("q33", '1', "q33", '1', true);
        tm.addTransition("q33", '_', "q34", '_', true);

        //Q34
        tm.addTransition("q34", '@', "q34", '@', true);
        tm.addTransition("q34", '$', "q34", '$', true);
        tm.addTransition("q34", '0', "q34", '0', true);
        tm.addTransition("q34", '1', "q34", '1', true);
        tm.addTransition("q34", 'x', "q30", 'x', false);
        tm.addTransition("q34", 'y', "q30", 'y', false);

        //Q35
        tm.addTransition("q35", '@', "q35", '@', false);
        tm.addTransition("q35", '$', "q35", '$', false);
        tm.addTransition("q35", 'y', "q35", 'y', false);
        tm.addTransition("q35", 'x', "q35", 'x', false);
        tm.addTransition("q35", '0', "q35", '0', false);
        tm.addTransition("q35", '1', "q35", '1', false);
        tm.addTransition("q35", '_', "q36", '_', false);

        //Q36
        tm.addTransition("q36", '@', "q36", '@', false);
        tm.addTransition("q36", '$', "q36", '$', false);
        tm.addTransition("q36", 'y', "q36", 'y', false);
        tm.addTransition("q36", 'x', "q36", 'x', false);
        tm.addTransition("q36", '1', "q37", 'x', false);
        tm.addTransition("q36", '0', "q33", 'y', true);
        tm.addTransition("q36", '_', "q33", 'y', true);

        //Q37
        tm.addTransition("q37", '1', "q37", '0', false);
        tm.addTransition("q37", '1', "q37", '0', false);
        tm.addTransition("q37", '_', "q33", '1', true);
        tm.addTransition("q37", '0', "q33", '1', true);

        //Q40
        tm.addTransition("q40", '@', "q40", '@', false);
        tm.addTransition("q40", '$', "q40", '$', false);
        tm.addTransition("q40", 'y', "q40", 'y', false);
        tm.addTransition("q40", 'x', "q40", 'x', false);
        tm.addTransition("q40", '0', "q40", '0', false);
        tm.addTransition("q40", '1', "q40", '1', false);
        tm.addTransition("q40", '_', "q41", '_', true);

        //Q41
        tm.addTransition("q41", '@', "q41", '@', true);
        tm.addTransition("q41", '$', "q41", '$', true);
        tm.addTransition("q41", '0', "q41", '0', true);
        tm.addTransition("q41", '1', "q41", '1', true);
        tm.addTransition("q41", 'y', "q41", '1', true);
        tm.addTransition("q41", 'x', "q41", '0', true);
        tm.addTransition("q41", '_', "q42", '_', true);

        //Q42
        tm.addTransition("q42", '@', "q42", '@', true);
        tm.addTransition("q42", '$', "q42", '$', true);
        tm.addTransition("q42", '0', "q42", '0', true);
        tm.addTransition("q42", '1', "q42", '1', true);
        tm.addTransition("q42", 'y', "q42", '1', true);
        tm.addTransition("q42", 'x', "q42", '0', true);
        tm.addTransition("q42", '*', "q43", '*', true);

        //Q43
        tm.addTransition("q43", '@', "q43", '@', true);
        tm.addTransition("q43", '$', "q43", '$', true);
        tm.addTransition("q43", 'y', "q43", 'y', true);
        tm.addTransition("q43", 'x', "q43", 'x', true);
        tm.addTransition("q43", '0', "q43", '0', true);
        tm.addTransition("q43", '1', "q43", '1', true);
        tm.addTransition("q43", '_', "q0", '_', false);

        return tm;
    }
}
