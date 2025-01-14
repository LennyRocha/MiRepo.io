package Polimorfismo;

import javafx.scene.image.ImageView;

public abstract class Combos 
{
    //Declarar las variables que modificarán su valor segun la clase
    public String nombre;
    public double precio;
    public String refresco;
    public String agregado;
    public String sabor;
    public String postre;
    public boolean incluyePapas;
    public static String tipoCombo = "Individual";
    
    //Constructor que cambiará
    public Combos(String nombre, double precio, String refresco, String agregado, String sabor, String postre, boolean incluyePapas, String tipoCombo)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.refresco = refresco;
        this.agregado = agregado;
        this.sabor = sabor;
        this.postre = postre;
        this.incluyePapas = incluyePapas;
        this.tipoCombo = tipoCombo;
    }
    public Combos ()
    {
        //Constructor desparametrizado, con valores por defecto
    }
        //Setters
        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }
        public void setPrecio(double precio)
        {
            this.precio = precio;
        }
        //¿Quieres otro refresco?
        public void setRefresco(String refresco)
        {
            this.refresco = refresco;
        }
        //Cambiar tu agregado
        public void setAgregado(String agregado)
        {
            this.agregado = agregado;
        }
        //puedes cambiar el sabor de tus pedidos
        public void setSabor(String sabor)
        {
            this.sabor = sabor;
        }
        //Añadir postre
        public void setPostre(String postre)
        {
            this.postre = postre;
        }
        public void setPapas(boolean incluyePapas)
        {
            this.incluyePapas = incluyePapas;
        }
        
    public abstract void crearCombo();
    public abstract String getNombre();
    public abstract double getPrecio();
    public abstract String getRefresco();
    public abstract String getComplemento();
    public abstract String getSabor();
    public abstract String getPostre();
    public abstract boolean getIncluyePapas();
    public abstract ImageView dameImagen();
}
