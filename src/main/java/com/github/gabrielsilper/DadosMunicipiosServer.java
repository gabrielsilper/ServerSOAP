package com.github.gabrielsilper;

import com.github.gabrielsilper.soap.DadosMunicipiosServiceImpl;
import jakarta.xml.ws.Endpoint;

public class DadosMunicipiosServer {
    public static void main(String[] args) {
        DadosMunicipiosServiceImpl dadosMunicipiosService = new DadosMunicipiosServiceImpl();
        String url = "http://localhost:8080/dadosmunicipios";
        Endpoint.publish(url, dadosMunicipiosService);
        System.out.println("Servidor iniciado em: " + url);
        System.out.println("WSDL disponível em: " + url + "?wsdl");
    }
}