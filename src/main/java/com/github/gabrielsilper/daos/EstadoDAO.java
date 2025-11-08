package com.github.gabrielsilper.daos;

import com.github.gabrielsilper.db.DatabaseConnection;
import com.github.gabrielsilper.models.Estado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoDAO {
    public Estado get(String siglaUf) throws SQLException {
        try(Connection con = DatabaseConnection.getConnection()){
            return get(con, siglaUf);
        }
    }

    public Estado get(Connection con, String siglaUf){
        String sql = """
                SELECT codigo_ibge, sigla_uf, unidade_federativa
                FROM estados
                WHERE sigla_uf = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, siglaUf);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Estado estado = new Estado();
                    estado.setCodigoIbge(rs.getString("codigo_ibge"));
                    estado.setSiglaUf(rs.getString("sigla_uf"));
                    estado.setUnidadeFederativa(rs.getString("unidade_federativa"));
                    return estado;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
