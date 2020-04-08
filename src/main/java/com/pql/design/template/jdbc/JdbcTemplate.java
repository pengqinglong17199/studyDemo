package com.pql.design.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> execteQuery(String sql, RowMapper<?> rowMapper, Object[] values){
        try{
            // 获取连接
            Connection connection = this.getConnection();

            // 创建语句集
            PreparedStatement prepareStatement = this.createPrepareStatement(connection, sql);

            // 执行语句集
            ResultSet resultSet = this.executeQuery(prepareStatement, values);

            // 处理结果集
            List<?> result = this.paresResultSet(resultSet, rowMapper);

            // 关闭结果集
            this.closeResultSet(resultSet);

            // 关闭语句集
            this.closeStatement(prepareStatement);

            // 关闭连接
            this.closeStatment(connection);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private void closeStatment(Connection connection) throws SQLException {
        // 假装归还到连接池
        connection.close();
    }

    private void closeStatement(PreparedStatement prepareStatement) throws SQLException {
        prepareStatement.close();
    }

    private void closeResultSet(ResultSet resultSet) throws SQLException {
        resultSet.close();
    }


    private List<?> paresResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (resultSet.next()){
            result.add(rowMapper.mapRow(resultSet, rowNum++));
        }
        return result;
    }

    private ResultSet executeQuery(PreparedStatement prepareStatement, Object[] values) throws SQLException {
        for (int p = 0; p < values.length; p++) {
            prepareStatement.setObject(p, values[p]);
        }
        return prepareStatement.executeQuery();
    }

    private PreparedStatement createPrepareStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
