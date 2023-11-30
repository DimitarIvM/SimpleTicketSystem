package bg.softuni.stssoftuniproject.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsControllerTestIT {

    @Autowired
    private MockMvc mockMvc;





    @Test
    void getAddProductPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/products/add")

                        .with(csrf())

        ).andExpect(status().is3xxRedirection());
    }



    @Test
    void postAddProductPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/products/add")
                        .param("productName","testProductName")
                        .param("serialNumber","testProductSN")
                        .param("partNumber","testProductPN")
                        .with(csrf())

        ).andExpect(status().is3xxRedirection());
    }


}
