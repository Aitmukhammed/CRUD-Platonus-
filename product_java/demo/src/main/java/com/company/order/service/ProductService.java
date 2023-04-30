package com.company.order.service;

import com.company.order.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {


    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    public Product createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (product_name, quantities, amount) VALUES ( ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getQuantities());
            stmt.setInt(3, product.getAmount());
            stmt.executeUpdate();

            ResultSet resultSet = stmt.getGeneratedKeys();
            resultSet.next();
            product.setId( resultSet.getLong(1));
        }

        return product;
    }


    public Product updateProduct(Product product) throws SQLException {
        String sql = "update product set product_name = ? , quantities=?, amount=? where id=?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getQuantities());
            stmt.setInt(3, product.getAmount());
            stmt.setLong(4, product.getId());
            stmt.executeUpdate();
        }

        return product;
    }
}
