package com.taller.domain.entity;

public class Estadisticas {
    private String pj;
    private String pg;
    private String pe;
    private String pp;
    private String gf;
    private String gc;
    private String tp;

    // Constructor sin argumentos
    public Estadisticas() {
    }

    // Constructor con argumentos
    public Estadisticas(String pj, String pg, String pe, String pp, String gf, String gc, String tp) {
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.tp = tp;
    }

    // Getters y setters
    public String getPj() {
        return pj;
    }

    public void setPj(String pj) {
        this.pj = pj;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getGf() {
        return gf;
    }

    public void setGf(String gf) {
        this.gf = gf;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    @Override
    public String toString() {
        return "Estadisticas [pj=" + pj + ", pg=" + pg + ", pe=" + pe + ", pp=" + pp + ", gf=" + gf + ", gc=" + gc
                + ", tp=" + tp + "]";
    }
}