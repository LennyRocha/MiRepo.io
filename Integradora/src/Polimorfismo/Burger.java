package Polimorfismo;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Burger extends Combos
{
    public Burger()
    {   
        this.nombre = "Combo Burger";
        this.precio = 155;
        this.refresco = "Coca-Cola sin azucar 355ml";
        this.agregado = "Adereso BBQ";
        this.sabor = "Ke-Tiras";
        this.postre = "Ninguno";
        this.incluyePapas = true;
    }
    
    @Override
    public void crearCombo()
    {
        Alert success =  new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("¡Exito!");
            success.setHeaderText("Pedido realizado");
            success.setContentText("Ha añadido un "+getNombre()+ " a su pedido");
            success.showAndWait(); 
    }
    
    @Override
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }

    @Override
    public String getRefresco() {
        return this.refresco;
    }

    @Override
    public String getComplemento() {
        return this.agregado;
    }

    @Override
    public String getSabor() {
        return this.sabor;
    }

    @Override
    public String getPostre() {
        return this.postre;
    }
    
    @Override
    public boolean getIncluyePapas() {
        return this.incluyePapas;
    }
    
    @Override
    public ImageView dameImagen(){
        ImageView imageView = new ImageView(new Image("Imagenes/Burger.png")){};
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(150);
        return imageView;
    }
}
