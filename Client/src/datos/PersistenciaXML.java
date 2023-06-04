package datos;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;

public class PersistenciaXML {

    private XMLEncoder xmlEncoder;
    private XMLDecoder xmlDecoder;
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;


    public PersistenciaXML() {
        super();
    }

    public void abrirInput(String nombre) throws IOException {
        fileInput = new FileInputStream(nombre);
        xmlDecoder = new XMLDecoder(fileInput);
    }

    public void abrirOutput(String nombre) throws IOException {
        fileOutput = new FileOutputStream(nombre);
        xmlEncoder = new XMLEncoder(fileOutput);
    }

    public void cerrarOutput() throws IOException {
        this.xmlEncoder.close();
    }

    public void cerrarInput() throws IOException {
        this.xmlDecoder.close();
    }

    public void escribir(SistemaSeguridadDTO sistema) throws IOException {
        this.xmlEncoder.writeObject(sistema);
    }
    
    public SistemaSeguridadDTO leer() throws IOException, ClassNotFoundException {
        SistemaSeguridadDTO p = null;
        if(this.xmlDecoder != null)
            p = (SistemaSeguridadDTO) xmlDecoder.readObject();
        return p;
    }

}
