package com.lowes.swapna.service;

import com.lowes.swapna.model.AirthOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class CalculatorService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public double storeData(Double value1, Double value2, char c) {

        double result = 0;
        switch(c) {
            case '+':
                result= value1 + value2;
                break;
            case '-':
                result= value1 - value2;
                break;
            case '*':
                result= value1 * value2;
                break;
            case '/':
                result= value1 / value2;
                break;
            default:
                System.out.println("No Operation done for the case "+ c);
        }

        StringBuffer expression = new StringBuffer().append(value1).append(c).append(value2);

        String INSERT_QUERY = "INSERT INTO AIRTHOP(DATA1, DATA2, RESULT, EXPRESSION)" +
                "VALUES (?,?,?,?);";

        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update(INSERT_QUERY, value1, value2, result, expression);

        return result;
    }

    public List<AirthOp> getAllTheData() throws SQLException {

        String SQL = "SELECT * FROM AIRTHOP";

        List list = new ArrayList();

        ResultSet rs = dataSource.getConnection().prepareStatement(SQL).executeQuery();

        while(rs.next()) {
            AirthOp ar = new AirthOp();
            ar.setData1(rs.getDouble(1));
            ar.setData2(rs.getDouble(2));
            ar.setResult(rs.getDouble(3));
            ar.setExpression(rs.getString(4));
            list.add(ar);
        }
        return list;
    }
}
