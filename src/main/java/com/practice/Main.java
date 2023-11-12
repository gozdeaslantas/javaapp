package com.practice;
import java.util.Properties;
import java.util.Scanner;

import org.python.util.PythonInterpreter;
import org.python.core.*;

public class Main {
    public static void main(String[] args) {
        initializeJython();
        System.out.println("Please enter a text: ");
        try (
            Scanner in = new Scanner(System.in);
            
            PythonInterpreter interpreter = new PythonInterpreter()) {
            String s = in.nextLine();

            if (s == null || s.length() == 0) {
                System.out.println("You didn't enter a text");
            } else {
                System.out.println("You entered: "+ s);
            }
            
            interpreter.exec("import transformers\n" + "from sentiment_intent_analyzer import SentimentIntentionAnalyzer");
            String funcName = "analyze_transcript";
            PyObject someFunc = interpreter.get(funcName);
            try {
                someFunc.__call__(new PyString(s));
            } catch (PyException e) {
                e.printStackTrace();
            }
                
        }
    }

    private static void initializeJython() {
        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.import.site", "false");
        
        props.setProperty("python.path", System.getenv("PATH")+";" + "/sentiment_intent_analyzer-0.1/src");
    
        PythonInterpreter.initialize(System.getProperties(), props, new String[0]);
    }

}