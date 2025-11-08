package com.github.gabrielsilper.soap;


import com.github.gabrielsilper.daos.EstadoDAO;
import com.github.gabrielsilper.daos.MunicipioDAO;
import com.github.gabrielsilper.daos.PopulacaoDAO;
import jakarta.jws.WebService;

import java.sql.SQLException;

@WebService(endpointInterface = "com.github.gabrielsilper.soap.IDadosMunicipiosService")
public class DadosMunicipiosServiceImpl implements IDadosMunicipiosService {

    private final EstadoDAO estadoDAO;
    private final MunicipioDAO municipioDAO;
    private final PopulacaoDAO populacaoDAO;

    public DadosMunicipiosServiceImpl() {
        this.estadoDAO = new EstadoDAO();
        this.municipioDAO = new MunicipioDAO();
        this.populacaoDAO = new PopulacaoDAO();
    }

    @Override
    public String getCodigoIBGEEstado(String uf) throws SQLException {
        return estadoDAO.get(uf).getCodigoIbge();
    }

    @Override
    public String getCodigoIBGEMunicipio(String codigoUf, String municipio) {
        return municipioDAO.get(codigoUf, municipio).getCodigoIbge();
    }

    @Override
    public String getPopulacaoTotal(String municipio) {
        return populacaoDAO.getPopulacaoTotal(municipio);
    }

    @Override
    public String getPopulacaoFeminina(String municipio) {
        return populacaoDAO.getPopulacaoFeminina(municipio);
    }

    @Override
    public String getPopulacaoMasculina(String municipio) {
        return populacaoDAO.getPopulacaoMasculina(municipio);
    }
}
