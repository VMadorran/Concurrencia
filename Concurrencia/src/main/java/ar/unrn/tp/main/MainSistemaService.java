package ar.unrn.tp.main;

import ar.unrn.tp.api.CategoriaService;
import ar.unrn.tp.api.ClienteService;
import ar.unrn.tp.api.DescuentoService;
import ar.unrn.tp.api.ProductoService;
import ar.unrn.tp.modelo.ProveedorDeFecha;
import ar.unrn.tp.servicios.CategoriaServiceImplementacion;
import ar.unrn.tp.servicios.ClienteServiceImplementacion;
import ar.unrn.tp.servicios.DescuentoServiceImplementacion;
import ar.unrn.tp.servicios.ProductoServiceImplementacion;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainSistemaService {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-mysql");
		// TODO Auto-generated method stub

		CategoriaService catService = new CategoriaServiceImplementacion();
		catService.CategoriaService(emf);
		catService.crearCategoria(1L, "Indumentaria");

		ProductoService productService = new ProductoServiceImplementacion();
		productService.ProductoService(emf);

		try {
			productService.crearProducto(1L, "Remera corta", 1000, 1L, "Nope");
			productService.crearProducto(3L, "Medias", 500, 1L, "Acme");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DescuentoService descService = new DescuentoServiceImplementacion();
		descService.DescuentoService(emf);

		var fecha = new ProveedorDeFecha();

		descService.crearDescuento("Acme", fecha.now().minusMonths(1), fecha.now().plusMonths(1), 0.05f);
		descService.crearDescuentoSobreTotal("Memecard", fecha.now().minusWeeks(1), fecha.now().plusMonths(2), 0.08f);

		ClienteService clientService = new ClienteServiceImplementacion();
		clientService.ClienteService(emf);

		try {
			clientService.crearCliente("Jose", "Perez", "12345678", "jose@acdc.com");
			clientService.agregarTarjeta(1L, "123123", "Visa");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		emf.close();

//		clientService.agregarTarjeta(6L, "123123", "Visa");
//		CategoriaService catService = new CategoriaServiceImplementacion();
//		catService.CategoriaService(emf);
//
//		ProductoService productService = new ProductoServiceImplementacion();
//		productService.ProductoService(emf);
//
//		DescuentoService descService = new DescuentoServiceImplementacion();
//		descService.DescuentoService(emf);
//
//		ClienteService clientService = new ClienteServiceImplementacion();
//		clientService.ClienteService(emf);
//		List<Tarjeta> tarjetas = clientService.listarTarjetas(1L);
//		emf.close();
//
//		System.out.println(tarjetas.get(0).marcaTarjeta());
//		System.out.println(tarjetas.get(1).marcaTarjeta());

//		catService.crearCategoria(1L, "Indumentaria");
//
//		productService.crearProducto(1L, "Remera corta", 1000, 1L, "Nope");
//		productService.crearProducto(3L, "Medias", 500, 1L, "Acme");
//
//		var fecha = new ProveedorDeFecha();
//		descService.crearDescuento("Acme", fecha.now().minusMonths(1), fecha.now().plusMonths(1), 0.05f);
//		descService.crearDescuentoSobreTotal("Memecard", fecha.now().minusWeeks(1), fecha.now().plusMonths(2), 0.08f);
//

//		var monto = ventaService.calcularMonto(List.of(1L, 2L), 123123L, 1L);
//		ventaService.realizarVenta(1L, List.of(1L, 2L), 123123L);
//		System.out.println(monto);

//		List<Producto> productos = productService.listarProductos();
//		System.out.println(productos.get(0).descripcion());
//		System.out.println(productos.get(1).descripcion());

	}

}
