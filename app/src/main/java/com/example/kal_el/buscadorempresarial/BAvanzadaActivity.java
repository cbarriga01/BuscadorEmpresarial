package com.example.kal_el.buscadorempresarial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BAvanzadaActivity extends AppCompatActivity {

    String dirIp = "192.168.1.36:8080";
    String NAMESPACE = "http://webservice";
    String URL = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor?wsdl";
    String SOAP_ACTION = "http://"+dirIp+"/TallerJSP/services/WebServiceProveedor";
    String METHOD_NAME = "busquedaSimpleCont";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bavanzada);
    }
}
