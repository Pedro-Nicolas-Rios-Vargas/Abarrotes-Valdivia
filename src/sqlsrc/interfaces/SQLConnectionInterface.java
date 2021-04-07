/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsrc.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLConnectionInterface {
    
    public int send(String sqlUpdate) throws SQLException;
    
    public ResultSet receive(String sqlQuery) throws SQLException;
    
}
