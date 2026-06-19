package com.grabbag.data;

import com.grabbag.model.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataService implements ProductDataInterface
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductDataService(DataSource dataSource)
    {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> findAll() {

        String sql = "SELECT * FROM productinfo;";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new ProductModel(
                rs.getInt("ID"),
                rs.getString("TYPE"),
                rs.getString("TITLE"),
                (rs.getString("AUTHOR") == null) ? null : rs.getString("AUTHOR"),
                rs.getInt("duration"),
                (rs.getString("NUM_PLAYERS") == null) ? null : rs.getString("NUM_PLAYERS"),
                (rs.getString("REQUIRED_EQUIPMENT") == null) ? null : rs.getString("REQUIRED_EQUIPMENT"),
                rs.getString("AGE_RATING"),
                rs.getString("GENRE"),
                rs.getString("DATE"),
                rs.getString("PUBLISHER_OR_STUDIO")
        ));
    }

    @Override
    public ProductModel findById(int id)
    {
        String sql = "SELECT * FROM productinfo WHERE ID = ?";
        SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
        srs.next();
        return new ProductModel(
                srs.getInt("ID"),
                srs.getString("TYPE"),
                srs.getString("TITLE"),
                srs.getString("AUTHOR"),
                srs.getInt("DURATION"),
                srs.getString("NUM_PLAYERS"),
                srs.getString("REQUIRED_EQUIPMENT"),
                srs.getString("AGE_RATING"),
                srs.getString("GENRE"),
                srs.getString("DATE"),
                srs.getString("PUBLISHER_OR_STUDIO"));
    }

    @Override
    public int create(ProductModel product) {
        String sql =
        """
        INSERT INTO productinfo
        (TYPE, TITLE, AUTHOR, DURATION, NUM_PLAYERS, REQUIRED_EQUIPMENT, AGE_RATING, GENRE, DATE, PUBLISHER_OR_STUDIO)
        VALUES (?, ?, ?, ?, ?, ?)
        """;
        return jdbcTemplate.update(sql,
                product.getType().toString(),
                product.getTitle(),
                product.getAuthor(),
                product.getDurationInHours(),
                product.getNumPlayers(),
                product.getRequiredEquipment(),
                product.getAgeRating(),
                product.getGenre(),
                product.getDate(),
                product.getPublisherOrStudio()
        );
    }

    @Override
    public int update(ProductModel productModel) {
    	
    	String sql =
    	        """
    	        UPDATE productinfo SET TYPE = ?, TITLE = ?, AUTHOR = ?, DURATION = ?, NUM_PLAYERS = ?, REQUIRED_EQUIPMENT = ?, AGE_RATING = ?, GENRE = ?, DATE = ?, PUBLISHER_OR_STUDIO = ?
    	        WHERE ID = ?
    	        """;
    	        return jdbcTemplate.update(sql,
    	        		productModel.getId(),
    	                productModel.getType().toString(),
    	                productModel.getTitle(),
                        productModel.getAuthor(),
                        productModel.getDurationInHours(),
                        productModel.getNumPlayers(),
                        productModel.getRequiredEquipment(),
    	                productModel.getAgeRating(),
    	                productModel.getGenre(),
    	                productModel.getDate(),
    	                productModel.getPublisherOrStudio()
    	        );
    }

    @Override
    public void delete(ProductModel productModel) {
    	
    	String sql = "DELETE FROM productinfo WHERE ID = ?";
    	
    	jdbcTemplate.update(sql, productModel.getId());
    	
    }
}
