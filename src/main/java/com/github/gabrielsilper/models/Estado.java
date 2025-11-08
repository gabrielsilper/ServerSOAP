package com.github.gabrielsilper.models;

public class Estado {
    private String codigoIbge;
    private String siglaUf;
    private String unidadeFederativa;

    public Estado() {
    }

    public Estado(String codigoIbge, String siglaUf, String unidadeFederativa) {
        this.codigoIbge = codigoIbge;
        this.siglaUf = siglaUf;
        this.unidadeFederativa = unidadeFederativa;
    }

    public String getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(String codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getSiglaUf() {
        return siglaUf;
    }

    public void setSiglaUf(String siglaUf) {
        this.siglaUf = siglaUf;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "codigoIbge='" + codigoIbge + '\'' +
                ", siglaUf='" + siglaUf + '\'' +
                ", unidadeFederativa='" + unidadeFederativa + '\'' +
                '}';
    }
}
