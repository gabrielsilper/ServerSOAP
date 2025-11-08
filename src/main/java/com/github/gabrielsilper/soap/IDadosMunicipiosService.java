package com.github.gabrielsilper.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.sql.SQLException;

@WebService
public interface IDadosMunicipiosService {

    @WebMethod
    String getCodigoIBGEEstado(String uf) throws SQLException;

    @WebMethod
    String getCodigoIBGEMunicipio(String codigoUf, String municipio);

    @WebMethod
    String getPopulacaoTotal(String municipio);

    @WebMethod
    String getPopulacaoFeminina(String municipio);

    @WebMethod
    String getPopulacaoMasculina(String municipio);
}
