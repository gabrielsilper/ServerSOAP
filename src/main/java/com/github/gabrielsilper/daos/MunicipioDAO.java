package com.github.gabrielsilper.daos;

import com.github.gabrielsilper.models.Municipio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MunicipioDAO {
    public Municipio get(String codigoUf, String nomeMunicipio){
        try(Connection con = com.github.gabrielsilper.db.DatabaseConnection.getConnection()){
            return get(con, codigoUf, nomeMunicipio);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Municipio get(Connection con, String codigoUf, String nomeMunicipio){
        String sql = """
                SELECT codigo_ibge, uf, municipio
                FROM municipios
                WHERE uf = ? AND municipio = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigoUf);
            ps.setString(2, nomeMunicipio);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Municipio municipio = new Municipio();
                    municipio.setCodigoIbge(rs.getString("codigo_ibge"));
                    municipio.setUf(rs.getString("uf"));
                    municipio.setMunicipio(rs.getString("municipio"));
                    return municipio;
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
