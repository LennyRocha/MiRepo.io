package Polimorfismo;

import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class kidsBucket extends Combos
{
    public kidsBucket()
    {
        this.nombre = "Kids Bucket";
        this.precio = 139;
        this.refresco = "Ciel 600ml";
        this.agregado = "Jugete Bob Esponja©";
        this.sabor = "PopCorn";
        this.postre = "Ninguno";
        this.incluyePapas = false;
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
        ImageView imageView = new ImageView(new Image("Imagenes/KidsBuck.png")){};
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(150);
        return imageView;
    }
}