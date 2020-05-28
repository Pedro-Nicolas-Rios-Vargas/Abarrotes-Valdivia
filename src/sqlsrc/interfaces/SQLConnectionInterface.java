/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlsrc.interfaces;

import res.AbarrotesElemento;
/**
 *
 * @author pnrv2
 */
public interface SQLConnectionInterface {
    
    public void send(AbarrotesElemento abElement);
    
    public AbarrotesElemento receive();
    
}
