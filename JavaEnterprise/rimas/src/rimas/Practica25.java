package rimas;

import java.util.ArrayList;
import java.util.Arrays;

public class Practica25 {

    int sumavocal;
    int cona = 0;

    public int getSumavocal() {
        return sumavocal;
    }

    public void setSumavocal(int sumavocal) {
        this.sumavocal = sumavocal;
    }
    int cone = 0;
    int coni = 0;
    int cono = 0;
    int conu = 0;
    int conA = 0;
    int conE = 0;
    int conI = 0;
    int conO = 0;

    public int getCona() {
        return cona;
    }

    public void setCona(int cona) {
        this.cona = cona;
    }

    public int getCone() {
        return cone;
    }

    public void setCone(int cone) {
        this.cone = cone;
    }

    public int getConi() {
        return coni;
    }

    public void setConi(int coni) {
        this.coni = coni;
    }

    public int getCono() {
        return cono;
    }

    public void setCono(int cono) {
        this.cono = cono;
    }

    public int getConu() {
        return conu;
    }

    public void setConu(int conu) {
        this.conu = conu;
    }

    public int getConA() {
        return conA;
    }

    public void setConA(int conA) {
        this.conA = conA;
    }

    public int getConE() {
        return conE;
    }

    public void setConE(int conE) {
        this.conE = conE;
    }

    public int getConI() {
        return conI;
    }

    public void setConI(int conI) {
        this.conI = conI;
    }

    public int getConO() {
        return conO;
    }

    public void setConO(int conO) {
        this.conO = conO;
    }

    public int getConU() {
        return conU;
    }

    public void setConU(int conU) {
        this.conU = conU;
    }

    public int getContadormin() {
        return contadormin;
    }

    public void setContadormin(int contadormin) {
        this.contadormin = contadormin;
    }

    public int getContadormay() {
        return contadormay;
    }

    public void setContadormay(int contadormay) {
        this.contadormay = contadormay;
    }

    int conU = 0;
    int contadormin = 0;
    int contadormay = 0;
    // char conteomin[]= new char[contadormin];
    //char conteomay[]= new char[contadormay];

    ArrayList<Character> conteomin = new ArrayList<>();
    ArrayList<Character> conteomay = new ArrayList<>();

    public void minandmayus(String texto1) {
        char[] palabras = texto1.toCharArray();
        for (int i = 0; i < texto1.length(); i++) {

            if (Character.isLowerCase(palabras[i])) {
                contadormin++;
                conteomin.add(palabras[i]);

            } else {
                contadormay++;
                conteomay.add(palabras[i]);
            }

        }

        for (int i = 0; i < conteomin.size(); i++) {
            if ('a'==conteomin.get(i)) {
                cona++;
            } else if ('e'==conteomin.get(i)) {
                cone++;
            } else if ('i'==conteomin.get(i)) {
                coni++;
            } else if ('o'==conteomin.get(i)) {
                cono++;
            } else {
                conu++;
            }
        }
        for (int i = 0; i < conteomay.size(); i++) {
            if ('A'==conteomay.get(i)) {
                conA++;
            } else if ('E'==conteomay.get(i)) {
                conE++;
            } else if ('I'==conteomay.get(i)) {
                conI++;
            } else if ('O'==conteomay.get(i)) {
                conO++;
            } else {
                conU++;
            }
        }

        sumavocal = conA + conE + conI + conO + conU + cona + cone + coni + cono + conu;

    }
}
