package capaNegocio;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kal-el on 10-06-16.
 */
public class Contacto {

    private int idContacto;
    private String run;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String pais;
    private String region;
    private String ciudad;
    private String direccion;
    private String imagen;
    private Empresa empresa;

    String dirIp = "192.168.1.36:8080";
    String NAMESPACE = "http://webservice";
    String URL = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME = "busquedaSimpleCont";

    public Contacto(){
        NAMESPACE = "http://webservice";
        //URL = "http://localhost:8080/TallerJSP/services/WebServiceProveedor?wsdl";
        URL = "http://192.168.1.36:8080/TallerJSP/services/WebServiceProveedor?wsdl";
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


    public List<Contacto> transformarJsonToListaContacto(String textoBusqueda){
        List<Contacto> lista=new ArrayList<Contacto>();

        if(!textoBusqueda.equals("error")){
            Gson gson=new Gson();
            Contacto[] arrayContacto =gson.fromJson(textoBusqueda,Contacto[].class);
            lista= Arrays.asList(arrayContacto);
        }
        return lista;
    }


}
