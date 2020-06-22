package PracticaSistemaDistribuido.principal;
import PracticaSistemaDistribuidos.session.ProductosJpaController;
import PracticaSistemaDistribuido.entidades.Productos;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    static int select = -1; 

    public static void main(String[] args) {
        //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXION
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
       //LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXION  
        ProductosJpaController pjc = new ProductosJpaController(emf);
        int select = 1;
        while(select != 0){
            int codigo = 0;
            String nombre = "";
            double precio = 0;
            String detalle = "";
            
            System.out.println("Elige opción:");
            System.out.println("1.- Crear ");
            System.out.println("2.- Actualizar ");
            System.out.println("3.- Eliminar");
            System.out.println("0.- Salir");
            System.out.println("Ingrese el número de la opción:");
            select = Integer.parseInt(scanner.nextLine());
            switch(select){
				case 1:     
                                        //CREAMOS UN NUEVO PRODUCTO
                                        Productos p = new Productos();
                                        System.out.println("Ingrese el codigo:");
                                        codigo = Integer.parseInt(scanner.nextLine()); 
                                        p.setCodigo(codigo);
                                        System.out.println("Ingrese el nombre:");
                                        nombre = scanner.nextLine ();
                                        p.setNombre(nombre);
                                        System.out.print("Introduzca su precio: \n");
                                        precio = Double.parseDouble(scanner.nextLine());
                                        BigDecimal bd1 = BigDecimal.valueOf(precio);
                                        p.setPrecio(bd1);
                                        System.out.println("Ingrese el detalle:");
                                        detalle = scanner.nextLine ();
                                        p.setDetalle(detalle);
                                        try {
                                            pjc.create(p);
                                            //pjc.edit(p);
                                        } catch (Exception ex) {
                                            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);

                                            System.out.println(ex.getMessage());
                                        }
					break;
				case 2: 
					//CREAMOS UN NUEVO PRODUCTO
                                        Productos p1 = new Productos();
                                        System.out.println("Ingrese el codigo:");
                                        codigo = Integer.parseInt(scanner.nextLine()); 
                                        p1.setCodigo(codigo);
                                        System.out.println("Ingrese el nombre:");
                                        nombre = scanner.nextLine ();
                                        p1.setNombre(nombre);
                                        System.out.print("Introduzca su precio: \n");
                                        precio = Double.parseDouble(scanner.nextLine());
                                        BigDecimal bd2 = BigDecimal.valueOf(precio);
                                        p1.setPrecio(bd2);
                                        System.out.println("Ingrese el detalle:");
                                        detalle = scanner.nextLine ();
                                        p1.setDetalle(detalle);
                                        try {
                                            //pjc.create(p);
                                            pjc.edit(p1);
                                        } catch (Exception ex) {
                                            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);

                                            System.out.println(ex.getMessage());
                                        }
					break;
				case 3: 
                                        //CREAMOS UN NUEVO PRODUCTO
                                        //Productos p3 = new Productos();
                                        System.out.println("Ingrese el codigo:");
                                        codigo = Integer.parseInt(scanner.nextLine()); 
                                        try {
                                            //pjc.create(p);
                                            //pjc.edit(p3);
                                            pjc.destroy(codigo);
                                        } catch (Exception ex) {
                                            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                                            System.out.println(ex.getMessage());
                                        }
					break;
				case 0: 
					System.out.println("Usted a salido del sistema");
					break;
				default:
					System.out.println("Número no reconocido");
                                        break;
            }
        
        
                        System.out.println("\n");
            
            
        }
        
       
    }
    
}
