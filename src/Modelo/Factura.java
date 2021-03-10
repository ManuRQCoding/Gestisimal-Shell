package Modelo;

import java.text.SimpleDateFormat;
import java.util.*;

import Modelo.Articulo;
import Modelo.Pedido;
import Modelo.Cliente;

public class Factura implements Comparable<Factura> {
		private String id;
		private float importe;
		private Date fecha;
		private Pedido pedido;
		
		public Factura(String id, float importe, Pedido pedido) {
				this.id = id;
				this.importe = importe;
				this.fecha = Calendar.getInstance().getTime();
				this.pedido = pedido;
		}
		
		//getter y setter
		
		
		public Pedido getPedido() {
				return pedido;
		}
		
		public void setPedido(Pedido pedido) {
				this.pedido = pedido;
		}
		
		public String getId() {
				return id;
		}
		
		public void setId(String id) {
				this.id = id;
		}
		
		public float getImporte() {
				return importe;
		}
		
		public void setImporte(float importe) {
				this.importe = importe;
		}
		
		public Date getFecha() {
				return fecha;
		}
		
		public void setFecha(Date fecha) {
				this.fecha = fecha;
		}
		
		@Override
		public String toString() {
				return "\n[ ------------------------ Factura ------------------------ ]" +
					       "\n| ID: " + id +
					       "\n| Fecha: " + fecha +
					       "\n| Importe total: " + importe + "€\n" +
					       pedido + "\n" +
					       "\n[ --------------------------------------------------------- ]";
		}
		
		@Override
		public int compareTo(Factura o) {
				if (this.getFecha().compareTo(o.getFecha()) > 0) return  1;
				if (o.getFecha().compareTo(this.getFecha()) > 0) return  -1;
				return 0;
		}
}

