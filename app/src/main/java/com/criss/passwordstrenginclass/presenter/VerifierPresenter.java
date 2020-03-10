package com.criss.passwordstrenginclass.presenter;

import com.criss.passwordstrenginclass.model.Verifier;

public class VerifierPresenter {

    IVerifierView iVerifierView;
    Verifier verifier;

    public VerifierPresenter(IVerifierView iVerifierView) {
        this.iVerifierView = iVerifierView;
        this.verifier = new Verifier();
    }

    public void evaluatePass(String pass) {
        int res = verifier.evaluatePassword(pass);
        switch (res ){
            case Verifier.WEAK_PASS:
                this.iVerifierView.showWeekPassword();
                break;
            case Verifier.MEDIUM_PASS:
                this.iVerifierView.showMediumPassword();
                break;
            case Verifier.STRONG_PASS:
                this.iVerifierView.showStrongPassword();
                break;
            case Verifier.VERY_STRONG_PASS:
                this.iVerifierView.showVeryStrongPassword();
                break;
        }
    }



}
