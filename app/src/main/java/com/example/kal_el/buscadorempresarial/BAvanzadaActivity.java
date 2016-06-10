package com.example.kal_el.buscadorempresarial;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class BAvanzadaActivity extends AppCompatActivity {

    String dirIp = "192.168.1.36:8080";
    String NAMESPACE = "http://webservice";
    String URL = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME = "busquedaSimpleCont";

    EditText textoRun;
    EditText textoNombre;
    EditText textoApellido;
    EditText textoMail;
    EditText textoTelefono;
    EditText textoPais;
    EditText textoRegion;
    EditText textoCiudad;
    EditText textoDireccion;

    TextView textViewResBAvanzada;
    Button buttonBAvanzada;

    String run;
    String nombre;
    String apellido;
    String mail;
    String telefono;
    String pais;
    String region;
    String ciudad;
    String direccion;

    String respuesta;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bavanzada);

        textoRun = (EditText) findViewById(R.id.editTextBARun);
        textoNombre = (EditText) findViewById(R.id.editTextBANombre);
        textoApellido = (EditText) findViewById(R.id.editTextBAApellido);
        textoMail = (EditText) findViewById(R.id.editTextBAMail);
        textoTelefono = (EditText) findViewById(R.id.editTextBATelefono);
        textoPais =(EditText) findViewById(R.id.editTextBAPais);
        textoRegion = (EditText) findViewById(R.id.editTextBARegion);
        textoCiudad = (EditText) findViewById(R.id.editTextBACiudad);
        textoDireccion = (EditText) findViewById(R.id.editTextBADireccion);

        textViewResBAvanzada = (TextView) findViewById(R.id.textViewBAvanzada);
        buttonBAvanzada = (Button) findViewById(R.id.buttonBAvanzada);

        buttonBAvanzada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textoRun.getText().toString().equals("") && textoRun.getText().length() != 0){
                    run = textoRun.getText().toString();
                } else {
                    run = "";
                }

                if (!textoNombre.getText().toString().equals("") && textoNombre.getText().length() != 0){
                    nombre = textoNombre.getText().toString();
                } else {
                    nombre = "";
                }

                if (!textoApellido.getText().toString().equals("") && textoApellido.getText().length() != 0){
                    apellido = textoApellido.getText().toString();
                } else {
                    apellido = "";
                }
                if (!textoMail.getText().toString().equals("") && textoMail.getText().length() != 0){
                    mail = textoMail.getText().toString();
                } else {
                    mail = "";
                }

                if (!textoTelefono.getText().toString().equals("") && textoTelefono.getText().length() != 0){
                    telefono = textoTelefono.getText().toString();
                } else {
                    telefono = "";
                }

                if (!textoPais.getText().toString().equals("") && textoPais.getText().length() != 0){
                    pais = textoPais.getText().toString();
                } else {
                    pais = "";
                }

                if (!textoRegion.getText().toString().equals("") && textoRegion.getText().length() != 0){
                    region = textoRegion.getText().toString();
                } else {
                    region = "";
                }

                if (!textoCiudad.getText().toString().equals("") && textoCiudad.getText().length() != 0){
                    ciudad = textoCiudad.getText().toString();
                } else {
                    ciudad = "";
                }

                if (!textoDireccion.getText().toString().equals("") && textoDireccion.getText().length() != 0){
                    direccion = textoDireccion.getText().toString();
                } else {
                    direccion = "";
                }

                generateAsyncTask task = new generateAsyncTask();
                task.execute();

            }
        });

    }

    public void getResult(String run, String nombre, String apellido, String mail, String telefono,
                          String pais, String region, String ciudad, String direccion){

        SoapObject query = new SoapObject(NAMESPACE, METHOD_NAME);
        List<PropertyInfo> properties = new ArrayList<PropertyInfo>();
        PropertyInfo propInf = new PropertyInfo();

        propInf.setName("run");
        propInf.setValue(run);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("nombre");
        propInf.setValue(nombre);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("apellido");
        propInf.setValue(apellido);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("mail");
        propInf.setValue(mail);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("telefono");
        propInf.setValue(telefono);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("pais");
        propInf.setValue(pais);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("región");
        propInf.setValue(region);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("ciudad");
        propInf.setValue(ciudad);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        propInf = new PropertyInfo();
        propInf.setName("dirección");
        propInf.setValue(direccion);
        propInf.setType(String.class);
        properties.add(propInf);
        query.addProperty(propInf);

        SoapSerializationEnvelope toSend = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        toSend.dotNet = true;

        toSend.setOutputSoapObject(query);

        HttpTransportSE transportHttp = new HttpTransportSE(URL);

        try{
            transportHttp.call(SOAP_ACTION, toSend);

            SoapPrimitive response = (SoapPrimitive) toSend.getResponse();

            respuesta = response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private class generateAsyncTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params){
            Log.i(TAG, "doInBackground");
            getResult(run, nombre, apellido, mail, telefono, pais, region, ciudad, direccion);
            return null;
        }

        @Override
        protected void onPostExecute(Void results){
            Log.i(TAG, "onPostExecute");
            textViewResBAvanzada.setText(respuesta);
        }

        @Override
        protected void onPreExecute(){
            Log.i(TAG, "onPreExecute");
            textViewResBAvanzada.setText("Buscando");
        }

        @Override
        protected void  onProgressUpdate(Void... values){
            Log.i(TAG, "onProgressUpdate");
        }
    }
}
