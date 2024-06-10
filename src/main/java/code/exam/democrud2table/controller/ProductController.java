package code.exam.democrud2table.controller;

import code.exam.democrud2table.entity.Product;
import code.exam.democrud2table.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model){
        model.addAttribute("products", productService.getProducts());
        return "hienthi";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model){
        model.addAttribute("categories", productService.getCategories());
        return "add";
    }

    @PostMapping
    public String add(Product product){
        productService.addProduct(product);
        return "redirect:/product/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Product product){
        productService.updateProduct(id, product);
        return "redirect:/product/hien-thi";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findProductById(id));
        model.addAttribute("categories", productService.getCategories());
        return "update";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.findProductById(id));
        model.addAttribute("categories", productService.getCategories());
        return "detail";
    }

    @GetMapping("/xoa/{id}")
    public String xoa(@PathVariable Long id){
        productService.removeProduct(id);
        return "redirect:/product/hien-thi";
    }

}
