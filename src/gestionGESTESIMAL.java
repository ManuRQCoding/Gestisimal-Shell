import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Pedido;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class gestionGESTESIMAL {
		Scanner s = new Scanner(System.in);
		
		private ArrayList<Cliente> clientes = new ArrayList<>();
		private ArrayList<Articulo> listaArticulos = new ArrayList<>();
		private ArrayList<Pedido> pedidos = new ArrayList<>();
		private ArrayList<Factura> facturas = new ArrayList<>();
		
		public ArrayList<Articulo> getArticulos() {
				return listaArticulos;
		}
		
		public void setArticulos(ArrayList<Articulo> articulos) {
				this.listaArticulos = articulos;
		}
		
		public ArrayList<Cliente> getClientes() {
				return clientes;
		}
		
		public ArrayList<Factura> getFacturas() {
				return facturas;
		}
		
		public void setClientes(ArrayList<Cliente> clientes) {
				this.clientes = clientes;
		}
		
		public ArrayList<Pedido> getPedidos() {
				return pedidos;
		}
		
		public void setPedidos(ArrayList<Pedido> pedidos) {
				this.pedidos = pedidos;
		}
		
		//Otros métodos
		//Gestion de pedidos
		public String generaCodigoPedido() {
				String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
				String resultado = "";
				long longitudClave = 6;
				do {
						for (long i = 0; i < longitudClave; i -= -1) {
								if ((int) (Math.random() * 2) == 0) {
										resultado += (int) (Math.random() * 10);
								} else resultado += abc[(int) (Math.random() * 10)];
						}
				} while (buscaCodigoPedido(resultado) != null);
				return resultado;
		}
		
		public Pedido buscaCodigoPedido(String codigo) {
				for (Pedido p : pedidos) {
						if (p.getId().equals(codigo)) return p;
				}
				return null;
		}
		
		public String generaCodigoFactura() {
				String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
				String resultado = "";
				long longitudClave = 6;
				do {
						for (long i = 0; i < longitudClave; i -= -1) {
								if ((int) (Math.random() * 2) == 0) {
										resultado += (int) (Math.random() * 10);
								} else resultado += abc[(int) (Math.random() * 10)];
						}
				} while (buscaCodigoFactura(resultado) != null);
				return resultado;
		}
		
		public Factura buscaCodigoFactura(String codigo) {
				for (Factura f : facturas) {
						if (f.getId().equals(codigo)) return f;
				}
				return null;
		}
		
		public float calculaImporteTotalFactura(ArrayList<Articulo> a) {
				float importeTotal = 0f;
				for (Articulo ar : a) {
						importeTotal += ar.getPrecioVenta();
				}
				return importeTotal;
		}
		
		public void addFacturaACliente(Factura factura, Cliente cliente) {
				cliente.getFacturas().add(factura);
		}
		
		public boolean addPedido(Pedido pedido) {
				
				if (pedido.getTipoEnvio().equalsIgnoreCase("A domicilio") || pedido.getTipoEnvio().equalsIgnoreCase("domicilio")) {
						int suma = 0;
						for (Articulo a :
							pedido.getArticulos()) {
								suma += a.getPrecioVenta();
						}
						if (suma > 100) {
								pedidos.add(pedido);
								return true;
						}
				} else {
						pedidos.add(pedido);
						return true;
				}
				return false;
		}
		
		public ArrayList<Pedido> listarPedidosPendientes() {
				ArrayList<Pedido> pedidosTemp = new ArrayList<>();
				for (Pedido p : pedidos) {
						if (p.isEstado()) {
								pedidosTemp.add(p);
						}
				}
				return pedidosTemp;
		}
		
		public ArrayList<Pedido> listarPedidosRealizados() {
				ArrayList<Pedido> pedidosTemp = new ArrayList<>();
				for (Pedido p :
					pedidos) {
						if (!p.isEstado()) {
								pedidosTemp.add(p);
						}
				}
				return pedidosTemp;
		}
		
		//Gestion de clientes
		
		public int contarClientes() {
				int conta = 0;
				for (Cliente cliente : clientes) {
						if (cliente.isActivo()) conta++;
				}
				return conta;
		}
		
		public boolean aniadirCliente(String movil, String id, String nombre, boolean tipoCliente) {
				
				Cliente cliente = new Cliente(movil, id, nombre, tipoCliente);
				
				if (buscaCliente(id) == null) {
						clientes.add(cliente);
						return true;
				}
				return false;
				
		}
		
		public void listarClientes() {
				for (Cliente cliente : clientes) {
						System.out.println(cliente);
						System.out.println();
				}
		}
		
		public boolean borrarCliente(String id) {
				if (buscaCliente(id) == null) return false;
				else {
						buscaCliente(id).setActivo(false);
				}
				return true;
		}
		
		public Cliente buscaCliente(String id) {
				for (Cliente c : clientes) {
						if (c.getIdentificacion().equalsIgnoreCase(id)) return c;
				}
				return null;
		}
		
		//Gestion de productos
		public boolean borrarArticuloEnAlmacen(String codigo) {
				if (buscaCodigoArticulo(listaArticulos, codigo) == null) return false;
				listaArticulos.remove(buscaCodigoArticulo(listaArticulos, codigo));
				return true;
		}
		
		public void listarArticulosEnAlmacen() {
				for (Articulo a : listaArticulos) {
						System.out.println(a);
				}
		}
		
		public ArrayList<Articulo> listarArticulosConStockDisponible() {
				ArrayList<Articulo> temp = new ArrayList<>();
				for (Articulo a : listaArticulos) {
						if (a.getStock() > 0) temp.add(a);
				}
				return temp;
		}
		
		public boolean aniadirArticulosEnAlmacen(String descripcion, float precioCompra, float precioVenta) {
				listaArticulos.add(new Articulo(generaCodigo(listaArticulos), descripcion, precioCompra, precioVenta));
				return true;
		}
		
		public boolean quitarStockEnAlmacen(String codigo, int unidades) {
				if (buscaCodigoArticulo(listaArticulos, codigo) == null) return false;
				return buscaCodigoArticulo(listaArticulos, codigo).deleteStock(unidades);
		}
		
		public boolean aniadirStockEnAlmacen(String codigo, int cantidad) {
				if (cantidad > 0) {
						buscaCodigoArticulo(listaArticulos, codigo).addStock(cantidad);
						return true;
				}
				return false;
		}
		
		public int stockTotal(ArrayList<Articulo> lista) {
				int total = 0;
				for (Articulo a : lista) {
						total += a.getStock();
				}
				return total;
		}
		
		public String generaCodigo(ArrayList<Articulo> lista) {
				String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
				String resultado = "";
				int longitudClave = 6;
				do {
						for (int i = 0; i < longitudClave; i -= -1) {
								if ((int) (Math.random() * 2) == 0) {
										resultado += (int) (Math.random() * 10);
								} else resultado += abc[(int) (Math.random() * 10)];
						}
				} while (buscaCodigoArticulo(lista, resultado) != null);
				return resultado;
		}
		
		public Articulo buscaCodigoArticulo(ArrayList<Articulo> lista, String codigo) {
				for (Articulo a : lista) {
						if (a.getCodigo().equalsIgnoreCase(codigo)) return a;
				}
				return null;
		}
		
		public ArrayList<Cliente> buscaClientePorNombre(String nombre) {
				ArrayList<Cliente> clienteNombre = new ArrayList<>();
				for (Cliente c : clientes) {
						if (c.getNombre().contains(nombre)) {
								clienteNombre.add(c);
						}
				}
				return clienteNombre;
		}
		
		public void addMockCliente() {
				clientes.add(new Cliente("12345", "12345678J", "David", true));
				clientes.add(new Cliente("123456", "J12345678", "Manu", false));
				clientes.add(new Cliente("123457", "12945678J", "Dani", true));
				clientes.add(new Cliente("123458", "A12345678", "Romeo", false));
		}
		
		public void addMockArticulos() {
				listaArticulos.add(new Articulo("f27fh1", "Iphone 11", 123.56f, 325.25f));
				listaArticulos.add(new Articulo("h7ae21", "TV LG", 423.56f, 521.25f));
				listaArticulos.add(new Articulo("6dg9cb", "Mac de Flavio", 10.56f, 35.25f));
				listaArticulos.add(new Articulo("dc2109", "Raton inalambrico", 123.56f, 452.25f));
		}
		
		public void addMockFacturas() {
				ArrayList<Articulo> temp = new ArrayList<>();
				Articulo tempArt = buscaCodigoArticulo(listaArticulos, "dc2109");
				tempArt.setCantidad(1);
				temp.add(tempArt);
				Factura facturaTemp = new Factura("c47474", 19446.75f, new Pedido("6e55hc", buscaCliente("12945678J"), "fisico", temp));
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, -1);
				Date result = cal.getTime();
				facturaTemp.setFecha(result);
				
				facturas.add(facturaTemp);
				addFacturaACliente(facturaTemp, buscaCliente("12945678J"));
				
				
				temp = new ArrayList<>();
				tempArt = buscaCodigoArticulo(listaArticulos, "h7ae21");
				tempArt.setCantidad(12);
				temp.add(tempArt);
				facturaTemp = new Factura("c43456", 12446.75f, new Pedido("te2124", buscaCliente("12345678J"), "fisico", temp));
				facturas.add(facturaTemp);
				addFacturaACliente(facturaTemp, buscaCliente("12345678J"));
				
				
				temp = new ArrayList<>();
				tempArt = buscaCodigoArticulo(listaArticulos, "f27fh1");
				tempArt.setCantidad(12);
				temp.add(tempArt);
				facturaTemp = new Factura("c48656", 446.75f, new Pedido("t3424", buscaCliente("A12345678"), "fisico", temp));
				cal = Calendar.getInstance();
				cal.add(Calendar.YEAR, -1);
				result = cal.getTime();
				facturaTemp.setFecha(result);
				facturas.add(facturaTemp);
				addFacturaACliente(facturaTemp, buscaCliente("A12345678"));
				
		}
		
}
