package clases;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

import exception.UsuarioNoExisteException;
import exception.ContraseñaInvalidaExcepcion;
import exception.FechaConLetras;
import utilidades.DAO;

public class Usuario extends ElementoConNombre {

	private String email;
	private String contraseña;
	private LocalDate fechaNacimiento;
	private float pesoCorporal;
	private float altura;
	private PlanEntrenamiento planEntreno;
	
	
	public Usuario(String nombre, String email, String contraseña, LocalDate fechaNacimiento, float pesoCorporal,
			float altura, PlanEntrenamiento planEntreno) {
		super(nombre);
		this.email = email;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
		this.pesoCorporal = pesoCorporal;
		this.altura = altura;
		this.planEntreno = planEntreno;
	}
	public Usuario(String nombre, String email, String contraseña, LocalDate fechaNacimiento) throws SQLException, FechaConLetras {
		super(nombre);
		 HashMap <String, Object> hs=new HashMap <String, Object>();
		    hs.put("nombre",nombre);
		    hs.put("email",email);
		    hs.put("contraseña",contraseña);
		    hs.put("fechaNacimiento", fechaNacimiento);
		DAO.insertar("usuario", hs);
		this.email=email;
		this.nombre=nombre;
		this.fechaNacimiento=fechaNacimiento;
		
	}
	
	 public Usuario( String email, String contraseña2) throws SQLException, UsuarioNoExisteException, ContraseñaInvalidaExcepcion {
		 super();
		  LinkedHashSet<String> lhs=new LinkedHashSet<String>();
		  lhs.add("email");
		  lhs.add("nombre");		  
		  lhs.add("contraseña");
		  lhs.add("fechaNacimiento");
		  HashMap<String, Object> hm=new HashMap<String, Object>();
		  hm.put("email", email);
		  ArrayList<Object> resultado=DAO.consultar("usuario", lhs, hm);
		  if(resultado.isEmpty()) {
			  throw new UsuarioNoExisteException("El usuario no está en la base de datos");
		  }else {
			  String contraseñaAlmacenada=(String) resultado.get(2);//Llama al arrayList de la posicion de la contraseña que es en este caso 2
			  if(!contraseñaAlmacenada.equals(contraseña2)) {
				  throw new ContraseñaInvalidaExcepcion("La contraseña es invalida papi");		  
			  }else {
				  this.email= (String) resultado.get(0);
				  this.nombre=(String) resultado.get(1);
				  this.fechaNacimiento= (LocalDate) resultado.get(3);
			  }
		  }
		  
	  }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public float getPesoCorporal() {
		return pesoCorporal;
	}


	public void setPesoCorporal(float pesoCorporal) {
		this.pesoCorporal = pesoCorporal;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public PlanEntrenamiento getPlanEntreno() {
		return planEntreno;
	}


	public void setPlanEntreno(PlanEntrenamiento planEntreno) {
		this.planEntreno = planEntreno;
	}


	@Override
	public String toString() {
		return "Usuario [email=" + email + ", contraseña=" + contraseña + ", fechaNacimiento=" + fechaNacimiento
				+ ", pesoCorporal=" + pesoCorporal + ", altura=" + altura + ", planEntreno=" + planEntreno + "]";
	}
	
	
	
}
