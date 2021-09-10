/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas.dto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author tribunal
 */
public class ListaEmpresas {
    
    private static List<Empresa> listaEmpresas = new ArrayList<>();
    
    public static List<Empresa> getListaEmpresas() {
        return Operaciones.listaEmpresas();
    }
    
    public static boolean comprobarCodigo(String codigo) {
        boolean testigo = false;
        listaEmpresas = Operaciones.listaEmpresas();
        for (Empresa empresa : listaEmpresas ){
            if (empresa.codigo.equals(codigo))                
                testigo = true;
        }
        return testigo;
    }
}
