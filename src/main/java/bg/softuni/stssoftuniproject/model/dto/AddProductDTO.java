package bg.softuni.stssoftuniproject.model.dto;

import bg.softuni.stssoftuniproject.validation.anotations.UniqueProductSerialNumber;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class AddProductDTO {

    @NotNull(message = "Product name cannot be null")
    @Size(min = 5,max = 50)
    private String productName;

    @UniqueProductSerialNumber(message = "Serial number already exists")
    @NotNull (message = "Serial number cannot be null")
    private String serialNumber;
    private String partNumber;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
}
