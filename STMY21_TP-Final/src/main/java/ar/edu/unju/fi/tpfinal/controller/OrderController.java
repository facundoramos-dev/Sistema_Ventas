package ar.edu.unju.fi.tpfinal.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@Controller
public class OrderController {

	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@Autowired
	@Qualifier("customerService")
	private ICustomerService customerService;
	
	@Autowired
	@Qualifier("orderDetailService")
	private IOrderDetailService detailService;
	
	@Autowired
	@Qualifier("productService")
	private IProductService productService;
	
	@GetMapping("/order/nuevo")
	public String getOrderPage(Model model) {
		if((customerService.getCustomers().size()!=0)&&(productService.getProducts().size()!=0)) {
			model.addAttribute("order",orderService.getOrder());
			model.addAttribute("detail",detailService.getOrderDetail());
			model.addAttribute("customers",customerService.getCustomers());
			model.addAttribute("products", productService.getProducts());
			return ("nuevo-order");
		}else {
			return("redirect:/order/error");
		}
	}
	
	@GetMapping("/order/error")
	public String getOrderPageError1() {
		if(customerService.getCustomers().size()==0) {
			return("error-order");
		}
		return("error-order2");
	}
	
	@PostMapping("/order/guardar")
	public ModelAndView agregarOrder(@Valid @ModelAttribute("order") Order order, BindingResult resulValidacion,@Valid @ModelAttribute("detail") OrderDetail detail){
		ModelAndView modelView;
		if (resulValidacion.hasErrors()) { //errores presentes
			modelView = new ModelAndView("nuevo-order");
			modelView.addObject("order",order);
			modelView.addObject("detail",detail);
			modelView.addObject("customers",customerService.getCustomers());
			modelView.addObject("products", productService.getProducts());
			return modelView;
		}else {//no se encuentran errores
			modelView = new ModelAndView("redirect:/order/listado"); //lista de order
			order.setCustomer1(customerService.getCustomerPorNumber(order.getCustomer1().getCustomerNumber()));
			orderService.agregarOrder(order);
			detail.getId().setOrderNumber(order);
			detail.getId().setProductCode(productService.getProductPorCodigo(detail.getId().getProductCode().getProductCode()));
			detailService.agregarOrderDetail(detail);
			return modelView;
		}
	}
	
	@GetMapping("/order/listado")
	public ModelAndView getOrderPage() {
		ModelAndView modelView = new ModelAndView("orders");
		modelView.addObject("orders", orderService.getOrders());
		System.out.println("Productos: "+productService.obtenerCache().size());
		return modelView;
	}
	
	@GetMapping("/order/editar/{id}")
	public ModelAndView getOrderEditPage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("nueva-compra");
		Optional<Order> order =  orderService.getOrderPorOrderNumber(orderNumber);
		modelView.addObject("order",order);
		//modelView.addObject("detail", detailService.getOrdeDetailPorOrderNumber(orderNumber));
		modelView.addObject("customers",customerService.getCustomers());
		modelView.addObject("products", productService.getProducts());
		return modelView;
	}
	
	@GetMapping("/order/eliminar/{id}")
	public ModelAndView getOrderDeletePage(@PathVariable(value="id")Long orderNumber) {
		ModelAndView modelView = new ModelAndView("redirect:/order/listado");
		if(detailService.getOrdeDetailPorOrderNumber(orderNumber)!=null) {
			detailService.eliminarOrderDetailPorOrderNumber(orderNumber);
		}
		orderService.eliminarOrder(orderNumber);
		return modelView;
	}
	
	@GetMapping("/pedido/nuevo")
	public String getCompraPage(Model model) {
		if((customerService.getCustomers().size()!=0)&&(productService.getProducts().size()!=0)) {
			model.addAttribute("order",orderService.getOrder());
			model.addAttribute("customers",customerService.getCustomers());
			model.addAttribute("products",productService.getProducts());
			return("nueva-compra");
		}
		return("redirect:/order/error");
	}
	
	@PostMapping("/pedido/guardar")
	public ModelAndView agregarPedido(@Valid @ModelAttribute("order") Order order, BindingResult resulValidacion,@RequestParam List<String> valores) throws IOException{
		ModelAndView modelView;
		if (!resulValidacion.hasErrors()) {//sinErrores
			System.out.println("Cantidad de valores: "+valores.size());
			if(valores.size()!=1) {
				modelView=new ModelAndView("nuevo-detail");
				order.setCustomer1(customerService.getCustomerPorNumber(order.getCustomer1().getCustomerNumber()));
				orderService.agregarOrder(order);
				productService.cacheProducto(productService.selecionarProductos(valores));
				modelView.addObject("orderDetails",detailService.obtenerCompras(productService.selecionarProductos(valores), order));
				return modelView;
			}
		}
		modelView=new ModelAndView("nueva-compra");
		modelView.addObject("order",order);
		modelView.addObject("customers",customerService.getCustomers());
		modelView.addObject("products",productService.getProducts());
		return modelView;
	}
}
