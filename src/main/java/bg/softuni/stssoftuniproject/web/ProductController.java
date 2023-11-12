package bg.softuni.stssoftuniproject.web;

import bg.softuni.stssoftuniproject.model.dto.AddProductDTO;
import bg.softuni.stssoftuniproject.model.dto.AllProductsDTO;
import bg.softuni.stssoftuniproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public ModelAndView getAddProductPage(){

        return new ModelAndView("product-add");
    }

    @GetMapping("/all")
    public ModelAndView getAllProducts(){

        ModelAndView mv = new ModelAndView();

        AllProductsDTO allProductsDTO = this.productService.getAllProducts();

        mv.setViewName("products-all");
        mv.addObject("AllProductsDTO",allProductsDTO);

        return mv;
    }

    @PostMapping("/add")
    public ModelAndView postAddProductPage(@Valid AddProductDTO addProductDTO,
                                           BindingResult bindingResult,
                                           RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addProductDTO",addProductDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);

            return new ModelAndView("redirect:/products/add");
        }

        productService.save(addProductDTO);
        return new ModelAndView("redirect:/products/all");
    }

    @ModelAttribute
    public AddProductDTO addProductDTO(){
        return new AddProductDTO();
    }
}
