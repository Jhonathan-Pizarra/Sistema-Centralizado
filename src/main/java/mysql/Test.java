/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;


import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mysql_entidades.Productos;
import mysql_sesion.ProductosJpaController;

/**
 *
 * @author Jhonathan :) 
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("supermercado");

        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductosJpaController pjc = new ProductosJpaController(emf);
        
        
        //CREAMOS UN NUEVO PRODUCTO
        Productos miProducto = new Productos();
        
        miProducto.setNombre("Amplificador");
      
        Double d1 = 99.99;
        BigDecimal bd1 = BigDecimal.valueOf(d1.doubleValue());
        
        miProducto.setPrecio(bd1);
        
        try {
            
            pjc.create(miProducto);
            //pjc.edit(p);
        } catch (Exception ex) {
            
            Logger.getLogger(Test.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
    }
    
}
