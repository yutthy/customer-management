package com.myproject.dao;

import com.myproject.connection.DBCP2DataSourceUtils;
import com.myproject.model.CustomerModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by uyutthy on 3/2/2017.
 */
public class CustomerDao {

    private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DBCP2DataSourceUtils.getDataSource());

    public boolean addNew(CustomerModel customer){
        int isInsert = 0;

        isInsert = jdbcTemplate.update("INSERT INTO customer (first_name, last_name, gender, dob, email, address, phone, created_date, modified_date)" +
                            "VALUES ( '" + customer.getFirstName() + "','" +
                                         customer.getLastName() + "','" +
                                         customer.getGender() + "','" +
                                         customer.getDobFormat() + "','" +
                                         customer.getEmail() + "','" +
                                         customer.getAddress() + "','" +
                                         customer.getPhone() + "','" +
                                         customer.getCreatedDateFormat() + "'," +
                                         "NULL" +
                            " )");

        if(isInsert > 0) return true;
        else return false;
    }

    public boolean update(int id, CustomerModel customer){
        int isUpdate = 0;
        isUpdate = jdbcTemplate.update("UPDATE customer SET " +
                                            "first_name = '" + customer.getFirstName() + "'," +
                                            "last_name = '" + customer.getLastName() + "'," +
                                            "gender = '" + customer.getGender() + "'," +
                                            "dob = '" + customer.getDobFormat() + "'," +
                                            "email = '" + customer.getEmail() + "'," +
                                            "address = '" + customer.getAddress() + "'," +
                                            "phone = '" + customer.getPhone() + "'," +
                                            "modified_date = '" + customer.getModifiedDateFormat() +"' WHERE id = ?", id
                                        );
        if(isUpdate > 0 ) return true;
        else return false;
    }

    public boolean delete(int id){
        int isDelete = 0;
        isDelete = jdbcTemplate.update("DELETE FROM customer WHERE id = ?", id);
        if(isDelete > 0) return true;
        else return false;
    }

    public CustomerModel getByID(int id){
        CustomerModel customer = null;
        customer = jdbcTemplate.queryForObject(
                "SELECT * FROM customer WHERE id = ?",
                new Object[]{id},
                new CustomerMapper()

        );
        return customer;
    }

    public List<CustomerModel> getAll(int limit, int offset){
        String sql;
        sql = "SELECT * FROM customer LIMIT " + offset + "," + limit;
        return jdbcTemplate.query(sql , new CustomerMapper());
    }

    public int getTotalRows(){
        String sql;
        sql = "SELECT count(*) AS num FROM customer";
        return jdbcTemplate.queryForObject(sql , Integer.class);
    }

    private static final class CustomerMapper implements RowMapper<CustomerModel> {

        final static private String ID= "id";

        public CustomerModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            CustomerModel customer = new CustomerModel();
            customer.setId(rs.getInt("id"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setGender(rs.getInt("gender"));
            customer.setDob(rs.getDate("dob"));
            customer.setEmail(rs.getString("email"));
            customer.setAddress(rs.getString("address"));
            customer.setPhone(rs.getString("phone"));
            customer.setCreatedDateToString(rs.getString("created_date"));
            customer.setModifiedDateToString(rs.getString("modified_date"));
            return customer;
        }

        /*public JsonObject mapJsonRow(ResultSet rs, int rowNum) throws SQLException {
            JsonObject customer = new JsonObject();
            customer.addProperty(ID,rs.getInt(ID));
            customer.addProperty(rs.getString("first_name"));
            customer.addProperty(rs.getString("last_name"));
            customer.addProperty(rs.getInt("gender"));
            customer.addProperty(rs.getDate("dob"));
            customer.addProperty(rs.getString("email"));
            customer.addProperty(rs.getString("address"));
            customer.addProperty(rs.getString("phone"));
            customer.addProperty(rs.getDate("created_date"));
            customer.addProperty(rs.getDate("modified_date"));
            return customer;
        }*/
    }




}
