/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsrc.interfaces;

import java.sql.ResultSet;

public interface SQLConnectionInterface {
    
    public void send(String sqlUpdate);
    
    public ResultSet receive(String sqlQuery);
    
}
