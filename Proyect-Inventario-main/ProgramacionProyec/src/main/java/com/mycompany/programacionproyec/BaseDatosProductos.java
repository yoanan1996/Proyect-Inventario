/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.programacionproyec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author HP
 */
public class BaseDatosProductos {
  
    private HashMap < Integer , Producto > listaProductos = new HashMap < > ( ) ;

    public BaseDatosProductos() {
        this.listaProductos.put( 1 , new Producto ( 1 , " Manzanas " , 2.50 , 65 ) ) ;
        this.listaProductos.put( 2 , new Producto ( 2 , " Limones " , 3, 15 ) ) ;
        this.listaProductos.put( 3 , new Producto ( 3 , " Granadilla " , 4 , 38 ) ) ;
        this.listaProductos.put( 4 , new Producto ( 4 , " Arandanos " , 5 , 55 ) ) ;
        this.listaProductos.put( 5 , new Producto ( 5 , " Tomates " , 10 , 42 ) ) ;
        this.listaProductos.put( 6 , new Producto ( 6 , " Fresas " , 15 , 3 ) ) ;
        this.listaProductos.put( 7 , new Producto ( 7 , " Helado " , 8 , 41 ) ) ;
        this.listaProductos.put( 8 , new Producto ( 8 , " Galletas " , 10 , 8 ) ) ;
        this.listaProductos.put( 9 , new Producto ( 9 , " Chocolates " , 7, 806 ) ) ;
        this.listaProductos.put( 10 , new Producto ( 10 , " Jamon " , 12 , 10 ) ) ;
        
    }
    public List < Producto > getListaProductos ( ) {
    return new ArrayList < > 
        ( this.listaProductos.values ( ) ) ;
    }
    
    
    
    public void setListaProductos ( HashMap < Integer , 
            Producto > listaFroductos ) {
     this.listaProductos = listaProductos ;
    }

    public boolean verificarExistencias ( Producto producto ) {
     return this.listaProductos.containsKey ( producto.getCodigo ( ) ) ;
    }
    
    public boolean verificarExistencias ( String nombre ) {
    for ( Producto p : this.listaProductos.values ( ) ){
        if( nombre.toLowerCase().equals(p.getNombre().toLowerCase ( ) ) ) {
            return true ;
        }
    }
    return false;
    
}  
    public int ultimoCodigo(){
        int codigo = 0;
        for ( Producto p : this.listaProductos.values ( ) ) {
            codigo = p.getCodigo();       
     }
        return codigo;   
    }
    
    public void agregar ( Producto p ) {
       this.listaProductos.put( p.getCodigo() , p );
    }
    
    public void actualizar ( Producto p ) {
    this.listaProductos . replace ( p.getCodigo ( ) , p ) ;
    }
    
    public void borrar ( Producto p ) {
    this.listaProductos . remove ( p.getCodigo ( ) ) ;
    }
    
    public String generarInforme ( ) {
      List<Producto> listaM = obtenerMayores();
      return listaM.get ( 0 ) .getNombre ( ) + " " + listaM.get ( 1 ) .getNombre ( ) + " " + listaM.get ( 2 ) .getNombre ( ) ;
    }
    
    private List<Producto> obtenerMayores () {
        List<Producto> lista = new ArrayList<>(this.listaProductos.values());
        List<Producto> listaMayores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
        Producto p = new Producto();
        for (Producto pTemp : lista){
            if (pTemp.getPrecio() > p.getPrecio()){
                p = pTemp;
            }
        
           }
            listaMayores.add(p);
            lista.remove(p);
            
        }
         return listaMayores;
    }
        
    
} //Final
