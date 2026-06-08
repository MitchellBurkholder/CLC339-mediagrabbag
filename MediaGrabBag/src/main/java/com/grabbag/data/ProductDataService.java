package com.grabbag.data;

import com.grabbag.model.products.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductDataService implements DataAccessInterface<ProductModel>
{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public ProductDataService(DataSource dataSource)
    {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> findAll() {

        String sql = "SELECT * FROM PRODUCTS";
        List<ProductModel> products = new ArrayList<ProductModel>();
        try
        {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next())
            {
                products.add(new ProductModel(
                        srs.getInt("ID"),
                        srs.getString("TYPE"),
                        srs.getString("TITLE"),
                        srs.getString("AGE_RATING"),
                        srs.getString("GENRE"),
                        srs.getString("DATE"),
                        srs.getString("PUBLISHER_OR_STUDIO")));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductModel findById(int id) {
        return null;
    }

    @Override
    public boolean create(ProductModel product) {
        String sql = "INSERT INTO PRODUCTS (TYPE, TITLE, AGE_RATING, GENRE, DATE, PUBLISHER_OR_STUDIO) VALUES (?, ?, ?, ?, ?, ?)";
        try
        {
            int rows = jdbcTemplate.update(sql,
                    product.getType(),
                    product.getTitle(),
                    product.getAgeRating(),
                    product.getGenre(),
                    product.getDate(),
                    product.getPublisherOrStudio()
            );
            return rows == 1 ? true : false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(ProductModel productModel) {
        return false;
    }

    @Override
    public boolean delete(ProductModel productModel) {
        return false;
    }
}
