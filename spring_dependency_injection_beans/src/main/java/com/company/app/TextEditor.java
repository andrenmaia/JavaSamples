package com.company.app;

/**
 * Created by caio on 2/1/15.
 */
public class TextEditor {
    private SpellChecker spellChecker;
    private SpecialEffect specialEffect;

    public TextEditor(SpellChecker spellChecker){
        this.spellChecker = spellChecker;
        System.out.println("TextEditor Constructor");
    }

    public void spellCheck(){
        this.spellChecker.checkSpelling();
    }

    public SpecialEffect getSpecialEffect() {
        return specialEffect;
    }

    public void setSpecialEffect(SpecialEffect specialEffect) {
        System.out.println("Setting SpecialEffect in TextEditor");
        this.specialEffect = specialEffect;
    }

    public void applySpecialEffect() {
        this.specialEffect.doSomethingNice();
    }
}
