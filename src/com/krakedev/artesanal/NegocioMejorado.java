package com.krakedev.artesanal;

import java.util.ArrayList;


public class NegocioMejorado {
	private ArrayList<Maquina> maquinas; 
	private ArrayList<Cliente> clientes = new ArrayList<>();
	private int ultimoCodigo = 100;

	public NegocioMejorado() {
		this.maquinas = new ArrayList<Maquina>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}
	
	public ArrayList<Cliente> getClientes() {
	    return clientes;
	}
	
	public String generarCodigo() {
		// En la clase maquina hay un atributo codigo pero no estaba con un formato para esto existe este metodo
		int numeroAleatorio = (int)(Math.random() * 100) + 1;
		return "M-" + numeroAleatorio;
	}
	
	public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
		// Metodo que agrega maquinas a la lista existente adicionando el codigo del metodo anterior
	    String codigo = generarCodigo();
	    
	    // Se modifica para validar el codigo generado no exista en la lista de maquinas invocando al metodo recuperarMaquina

	    if (recuperarMaquina(codigo) != null) {
	        return false;
	    }
	    
	    Maquina nueva = new Maquina(nombreCerveza, descripcion, precioPorMl, codigo);
	    return maquinas.add(nueva);
	}
	
	public void cargarMaquinas() {
	    // Recorre todas las maquinas y las llena con el metodo de maquina de llenar
	    for (int i = 0; i < maquinas.size(); i++) {
	        Maquina maquina = maquinas.get(i);
	        maquina.llenarMaquina();
	    }
	}
	
	public Maquina recuperarMaquina(String codigo) {
	    // Metodo que Busca la máquina por codigo y sino null
	    for (int i = 0; i < maquinas.size(); i++) {
	        Maquina maquinaEncontrada = maquinas.get(i);
	        if (maquinaEncontrada.getCodigo().equals(codigo)) {
	            return maquinaEncontrada;
	        }
	    }
	    return null;
	}
	
	public boolean registrarCliente(String nombre, String cedula) {
	    // Se agrega un cliente siguienda la logica del metodo de negocio que va sumando el codigo de cliente en 100
	    Cliente cliente = new Cliente(nombre, cedula);
	    cliente.setCodigo(ultimoCodigo);
	    ultimoCodigo++;
	    return clientes.add(cliente);
	}
	
	public Cliente buscarClientePorCedula(String cedula) {
	    // Busca un cliente pasandole la cedula, sino existe null
	    for (int i = 0; i < clientes.size(); i++) {
	        Cliente clienteEncontrado = clientes.get(i);
	        if (clienteEncontrado.getCedula().equals(cedula)) {
	            return clienteEncontrado;
	        }
	    }
	    return null;
	}
	
	public Cliente buscarClientePorCodigo(int codigo) {
	    // Busca un cliente pasandole ahor el codigo, sino existe null
	    for (int i = 0; i < clientes.size(); i++) {
	        Cliente clienteEncontrado = clientes.get(i);
	        if (clienteEncontrado.getCodigo() == codigo) {
	            return clienteEncontrado;
	        }
	    }
	    return null;
	}
	
	public double consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
	    // Integracion del negocio con las maquinas por el consumo del cliente, asigna el consumo por codigo del cliente
	    Maquina maquina = recuperarMaquina(codigoMaquina);
	    Cliente cliente = buscarClientePorCodigo(codigoCliente);

	    if (maquina == null || cliente == null) {
	        return 0;
	    }
	    // Si existe la maquina y el codigo del cliente procede al calculo:
	    double valor = maquina.servirCerveza(cantidad);
	    registrarConsumo(codigoCliente, valor); // Se agrega posterior
	    return valor;
	}
	
	public void registrarConsumo(int codigoCliente, double valor) {
		
	    Cliente cliente = buscarClientePorCodigo(codigoCliente);

	    if (cliente != null) {
	        // Acumular (NO reemplazar)
	        cliente.setTotalConsumido(
	            cliente.getTotalConsumido() + valor
	        );
	    }
	}
	
	public double consultarValorVendido() {
	    double total = 0;

	    for (int i = 0; i < clientes.size(); i++) {
	        Cliente cliente = clientes.get(i);
	        total += cliente.getTotalConsumido();
	    }

	    return total;
	}

	
	
}
