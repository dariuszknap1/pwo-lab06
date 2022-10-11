/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.app;

import pwo.utils.SequenceTools;

/**
 * Klasa rozbudowująca działanie funkcji {@link pwo.app.SeqToFileApp}. Klasa dodaje
 * możliwość wypisania wyników na ekran konsoli.
 *
 * @author dariusz
 * @version 1.0.0
 */
public class SeqToOutApp extends SeqToFileApp {

    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) {
            return true;
        }
        return seqType != null && from >= 0 && to >= 0;
    }

    @Override
    protected boolean writeSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(
                seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Funkcja wypisująca wyrazy ciągu na ekran konsoli. Funkcja sprawdza
     * argumenty linii poleceń. Jeżeli argument odpowiadający za nazwę pliku
     * wynikowego jest pusty, wtedy zostaje wywołana ta funkcja.
     *
     * @param args Argumenty linii poleceń
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }
        writeSeq();
    }

}
