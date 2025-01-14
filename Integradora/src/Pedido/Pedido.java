package Pedido;

public class Pedido {
    
    private int idPedido;
    private String nombrePedido;
    private String fecha;
    private double precio;
    
    public Pedido(int idPedido, String nombrePedido, String fecha, double precio){
        this.idPedido = idPedido;
        this.nombrePedido = nombrePedido;
        this.fecha = fecha;
        this.precio = precio;
    }
    
    public int getIdPedido()
    {
        return idPedido;
    }
    public String getNombrePedido()
    {
        return nombrePedido;
    }
    public String getFecha()
    {
        return fecha;
    }
    public double getPrecio()
    {
        return precio;
    }
}
