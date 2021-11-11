package models;

public class Product {

    private String productType;
    private String departament;
    private String city;
    private String subtype;
    private String productName;
    private String reference;
    private String supplier;
    private String quantity;
    private String observations;

    public Product(String productType, String departament, String city, String subtype, String productName, String reference,
            String supplier, String quantity, String observations) {
        this.productType = productType;
        this.departament = departament;
        this.city = city;
        this.subtype = subtype;
        this.productName = productName;
        this.reference = reference;
        this.supplier = supplier;
        this.quantity = quantity;
        this.observations = observations;
    }

    public Product(String productType, String departament, String city, String subtype, String productName, String supplier, 
            String quantity, String observations) {
        this.productType = productType;
        this.departament = departament;
        this.city = city;
        this.subtype = subtype;
        this.productName = productName;
        this.supplier = supplier;
        this.quantity = quantity;
        this.observations = observations;
    }
    
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    } 
}
