package br.com.storepcs.dao;


import br.com.storepcs.dto.PCDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PCDao {

    private final JdbcTemplate mysql;

    public PCDao (JdbcTemplate mysql)
    {
        this.mysql = mysql;

    }

    private final RowMapper <PCDTO> transformarlinhasqlemPCdto = new RowMapper<PCDTO>() {

        @Override
        public PCDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

            PCDTO pc = new PCDTO();
            pc.setId(rs.getString("id"));
            pc.setProcessador(rs.getString("Processador"));
            pc.setPlacaDeVideo(rs.getString("PlacaDeVideo"));
            pc.setRam(rs.getString("Ram"));


            return pc;
        }
    };



    public List<PCDTO> findAll(){

        String sql = "SELECT * FROM PC";

        return mysql.query(sql, transformarlinhasqlemPCdto);


    }

    public void save(PCDTO pc)
    {
        String sql = "INSERT INTO PC (Processador, PlacaDeVideo, Ram) VALUES (?, ?, ?)";

        mysql.update(sql, pc.getProcessador(), pc.getPlacaDeVideo(), pc.getRam() );

    }


    public void deleteByID(String id)
    {

        String sql = "DELETE FROM PC WHERE id = ? ";

        mysql.update(sql,Long.valueOf(id));


    }

    public void update (PCDTO pc, String id)
    {

        String sql = "UPDATE PC set Processador = ?, PlacaDeVideo = ?, Ram = ? WHERE id = ?";


        mysql.update(sql, pc.getProcessador(), pc.getPlacaDeVideo(), pc.getRam(), Long.valueOf(id) );
    }

    public PCDTO findByID(String id)
    {
        String sql = "SELECT * FROM PC WHERE id = ?";

        return mysql.queryForObject(sql, transformarlinhasqlemPCdto, Long.valueOf(id));
    }




}
