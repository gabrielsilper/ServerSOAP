package com.github.gabrielsilper.daos;

import com.github.gabrielsilper.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulacaoDAO {
    public String getPopulacaoTotal(String codigoMunicipio){
        try (Connection con = DatabaseConnection.getConnection()){
            return  getPopulacaoTotal(con, codigoMunicipio);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getPopulacaoTotal(Connection con, String codigoMunicipio) {
        String sql = """
                SELECT populacao_masculina + populacao_feminina AS populacao_total
                FROM populacao_total
                WHERE municipio = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigoMunicipio);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getString("populacao_total");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getPopulacaoFeminina(String codigoMunicipio){
        try (Connection con = DatabaseConnection.getConnection()){
            return  getPopulacaoFeminina(con, codigoMunicipio);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getPopulacaoFeminina(Connection con, String codigoMunicipio) {
        String sql = """
                SELECT populacao_feminina
                FROM populacao_total
                WHERE municipio = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigoMunicipio);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getString("populacao_feminina");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getPopulacaoMasculina(String municipio) {
        try (Connection con = DatabaseConnection.getConnection()){
            return  getPopulacaoMasculina(con, municipio);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getPopulacaoMasculina(Connection con, String codigoMunicipio) {
        String sql = """
                SELECT populacao_masculina
                FROM populacao_total
                WHERE municipio = ?
                """;

        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, codigoMunicipio);
            try (ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return rs.getString("populacao_masculina");
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
