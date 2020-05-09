package com.ibm.spring;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JdbcCustomerDAO extends JdbcDaoSupport implements CustomerDAO {


    public void addCustomer(final CustomerTO cto) {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement("insert into customers1 values(?,?,?,?,?)");
                ps.setInt(1,cto.getCid());
                ps.setString(2,cto.getCname());
                ps.setString(3,cto.getEmail());
                ps.setLong(4,cto.getPhone());
                ps.setString(5,cto.getCity());
                return ps;
            }
        };

        getJdbcTemplate().update(psc);


    }

    public List<CustomerTO> getAllCustomers() {

        PreparedStatementCreator psc = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {

                PreparedStatement ps = connection.prepareStatement("select * from customers1");
                return ps;
            }
        };
        List list = getJdbcTemplate().query(psc, new CustomerRowMapper());
        return list;
    }
}
