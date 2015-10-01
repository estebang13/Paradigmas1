/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Brayan
 */
public class ArchivoFiltro extends FileFilter {

    private String descripcion;
    private String extension;

    public ArchivoFiltro(String descripcion, String extension) {
        this.descripcion = descripcion;
        this.extension = extension;
    }

    @Override
    public boolean accept(File f) {
        return (f.isDirectory()) ? true : f.getName().endsWith(extension);
    }

    @Override
    public String getDescription() {
        return descripcion + String.format(" (*%s)", extension);
    }

}
