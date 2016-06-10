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

public class BSimpleActivity extends AppCompatActivity {

    EditText textoBusqueda;
    TextView textViewResBSimple;
    Button buttonBSimple;

    String dirIp = "192.168.1.36:8080";
    String NAMESPACE = "http://webservice";
    String URL = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME = "busquedaSimpleCont";

    String textBSimple;
    String respuesta;
    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsimple);

        textoBusqueda = (EditText) findViewById(R.id.editTextBSimple);
        textViewResBSimple = (TextView) findViewById(R.id.textViewResBSimple);
        buttonBSimple = (Button) findViewById(R.id.buttonBSimple);

        buttonBSimple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!textoBusqueda.getText().toString().equals("") && textoBusqueda.getText().length() != 0){
                    textBSimple = textoBusqueda.getText().toString();
                    generateAsyncTask task = new generateAsyncTask();
                    task.execute();
                }else{
                    textViewResBSimple.setText("Cadena de Busqueda");
                }
            }
        });
    }

    public void getResult(String criteria){
        SoapObject query = new SoapObject(NAMESPACE, METHOD_NAME);
        PropertyInfo propInf = new PropertyInfo();
        propInf.setName("cadenaBusqueda");
        propInf.setValue(criteria);
        propInf.setType(String.class);

        query.addProperty(propInf);

        SoapSerializationEnvelope toSend = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        toSend.dotNet = true;

        toSend.setOutputSoapObject(query);

        HttpTransportSE transportHttp = new HttpTransportSE(URL);

        try{
            transportHttp.call(SOAP_ACTION, toSend);

            SoapPrimitive response = (SoapPrimitive) toSend.getResponse();

            respuesta = response.toString();//jsonformat
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private class generateAsyncTask extends AsyncTask<String, Void, Void>{
        @Override
        protected Void doInBackground(String... params){
            Log.i(TAG, "doInBackground");
            getResult(textBSimple);
            return null;
        }

        @Override
        protected void onPostExecute(Void results){
            Log.i(TAG, "onPostExecute");
            textViewResBSimple.setText(respuesta);
        }

        @Override
        protected void onPreExecute(){
            Log.i(TAG, "onPreExecute");
            textViewResBSimple.setText("Buscando");
        }

        @Override
        protected void  onProgressUpdate(Void... values){
            Log.i(TAG, "onProgressUpdate");
        }
    }

}
