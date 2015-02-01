package com.company.app;

/**
 * Created by caio on 2/1/15.
 */
public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
        System.out.println("TextEditor Constructor");
    }

    public void spellCheck(){
        this.spellChecker.checkSpelling();
    }
}
