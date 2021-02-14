/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorDao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
// *
 * @author joe
 */
public class Conexion {
    private  String REPO = "datos";
    private XStream xtrStream; 
    /**
     * Metodo para establecer conexion con Xstream
     */
    public Conexion() {
        xtrStream = new XStream(new JettisonMappedXmlDriver());
        xtrStream.setMode(XStream.NO_REFERENCES);
    }

    public void setREPO(String REPO) {
        this.REPO = REPO;
    }

    public String getREPO() {
        return REPO;
    }
    public XStream getXtrStream() {
        return xtrStream;
    }
    
    
}
