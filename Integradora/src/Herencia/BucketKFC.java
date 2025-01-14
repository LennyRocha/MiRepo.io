package Herencia;

public class BucketKFC
{
    //Variables de clase padre
    private int cantPiezas, cantBiskets;
    private String sabor;
    private String tipoPiezas;
    private double precio;
    private String comp1, comp2, refresco;
    //Constructor parametrizado
    public BucketKFC(int cantPiezas, String sabor, String tipoPiezas, double precio)
    {
        this.cantPiezas = cantPiezas;
        this.sabor = sabor;
        this.tipoPiezas = tipoPiezas;
        this.precio = precio;
        this.cantBiskets = 4;
        this.comp1 = "Ensalada";
        this.comp2 = "Puré";
        this.refresco = "No incluido";
    }
    //Setters y Getters
    public void setPiezas(int cantPiezas)
    {
        this.cantPiezas = cantPiezas;
    }
        //El sabor por defecto es "cruji", pero puedes especificar si puede ser BBQ, o "Receta Secreta" , o "habanero"  
    public void setSabor(String sabor)
    {
        this.sabor = sabor;
    }
        //O son piezas de pollo, o KeTiras
    public void setTiposPiezas(String tipoPiezas)
    {
        this.tipoPiezas = tipoPiezas;
    }
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
        //¿Quieres añadir un refresco?
    public void setRefresco(String refresco)
    {
        this.refresco = refresco;
    }
        //Quieres más biskets
    public void setBiskets(int cantBiskets)
    {
        this.cantBiskets = cantBiskets;
    }
    
    public int getCantPiezas()
    {
        return cantPiezas;
    }
    public int getCantBiskets()
    {
        return cantBiskets;
    }
    public String getSabor()
    {
        return sabor;
    }
    public String getTipoPiezas()
    {
        return tipoPiezas;
    }
    public double getPrecio()
    {
        return precio;
    }
    public String getComp1()
    {
        return comp1;
    }
    public String getComp2()
    {
        return comp2;
    }
    public String getRefresco()
    {
        return refresco;
    }
    //Funciones modificadoras
    public int KeMiercoles()
    {
        return cantPiezas + 4;
    }
    public double Descuentito()
    {
        double min = 10.0;
        double max = 20.0;
        double descuento = min + (max - min) * Math.random();
        double desc = precio - descuento;
        return Math.round(desc);
    }
}
