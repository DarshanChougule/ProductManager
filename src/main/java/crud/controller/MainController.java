package crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import crud.dao.ProductDao;
import crud.model.Product;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productdao;
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> allProducts = productdao.getAllProducts();
		m.addAttribute("product", allProducts);
		return "index";
	}
	//show add product page
	@RequestMapping("/add-product")
	public String add(Model m) {
		m.addAttribute("title" , "ADD Product");
		return "add_product_form";
	}
	//handle add form
	@RequestMapping(value="/handleproduct" , method = RequestMethod.POST)
	public RedirectView handleform(@ModelAttribute("product") Product product,HttpServletRequest request) {
		System.out.println(product);
		productdao.create(product);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	//delete product
	@RequestMapping("/delete/{productId}")
	public RedirectView delete(@PathVariable("productId") int productId , HttpServletRequest request) {
		productdao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	@RequestMapping("/update/{productId}")
	public String update(@PathVariable("productId") int pid , Model m) {
		
		m.addAttribute("product", productdao.getOneProduct(pid));
		return "update_form";
	}
}
