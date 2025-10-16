package Func;

import java.net.URL;
import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class TrabalhoClient {
	
	public static void main(String [] args) throws Exception {
		URL url = new URL("http://127.0.0.1:9786/Func?wsdl");
		QName qname = new QName("http://Func/","TrabalhoServerImplService");
		
		Service tb = Service.create(url, qname);
		TrabalhoServer trab = tb.getPort(TrabalhoServer.class);
		
		//trab.adicionarFuncionarioNaEmpresa("Gustaco", "07467197950", "02102005", "gustavowbaum@gmail.com", 8, "Misto", "Produção");
		//trab.adicionarFuncionarioNaEmpresa("Guilherme", "12345678910", "12041989", "guilherme@gmail.com", 12, "Noturno", "RH");
		
		
		System.out.println(trab.readAllFuncionarios());
	}
}