import Herencia.*;
import Pedido.Pedido;
import Polimorfismo.*;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static final ArrayList<Pedido>misPedidos = new ArrayList<>();
    //Variables para llenar el ArrayList
    public String nombre;
    public int paqueteElegido;
    public String selectedPack;
    public boolean esBucket;
    public String fechaActual;
    public double elPrecio;
    public boolean ingresoFecha;
    public String elId;
    //Construir objetos bucket
    public BucketKFC [] elegido = new BucketKFC [4];
    //Construir objetos combo
    public Combos [] miCombo = new Combos [4];
    
    @Override
    public void start(Stage primaryStage) {
        // Asignar título
        Label titulo = new Label("¡Bienvenido!");
        titulo.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 30));
        titulo.setStyle("-fx-text-fill: Black");
        
        // Asignar la imagen principal
        ImageView imageView = new ImageView(new Image("Imagenes/KFC_Inicio.jpeg")){};
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(100);
        
        //El boton que te pide tu nombre
        Label getNameLabel = new Label("Ingresa tu nombre:");
        TextField getNameField = new TextField();
        
        //Grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(getNameLabel, 0, 0);
        grid.add(getNameField, 1, 0);
        
        Button btn1 = new Button();
        btn1.setText("Continuar");;
        btn1.setOnAction(event -> {
                
            nombre = getNameField.getText().trim();
            if(nombre.isEmpty()){
                Alert noName = new Alert(Alert.AlertType.ERROR);
                noName.setTitle("Alerta");
                noName.setHeaderText("Nombre no registrado");
                noName.setContentText("Para continuar, debe ingresar su nombre");
                noName.showAndWait();
            }else{
                Alert regisName =  new Alert(Alert.AlertType.INFORMATION);
                regisName.setTitle("¡Nuevo Cliente!");
                regisName.setHeaderText("Registro exitoso");
                regisName.setContentText("Su nombre se ha registrado correctamente");
                regisName.showAndWait();
                primaryStage.close();
                newWindow(primaryStage);
            }
        });
        
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(imageView);
        vbox.getChildren().add(titulo);
        vbox.getChildren().add(grid);
        vbox.getChildren().add(btn1);
        
        
        Scene scene = new Scene(vbox, 350, 300);
        vbox.setStyle("-fx-background-color: white ");
        
        primaryStage.setTitle("Iniciar sesión");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("Imagenes/KFC_Inicio_sin.png"));
        primaryStage.show();
    }
    
    private void newWindow(Stage primaryStage){
        
        Stage principio = new Stage();
        Label titulo2 = new Label("Buen dia "+nombre+", bienvenido a KFC");
        titulo2.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 30));
        titulo2.setStyle("-fx-text-fill: White");
        
        ImageView imageView2 = new ImageView(new Image("Imagenes/Logo rojo.jpeg")){};
        imageView2.setPreserveRatio(true);
        imageView2.setFitWidth(290);
        
        Text preguntaText = new Text("¿Qué deseas ordenar?");
        preguntaText.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 20));
        
        ImageView imageView = new ImageView(new Image("Imagenes/AnimatedBucket.gif")){};
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(200);
        
        Button bucketButton = new Button("Ordenar un Bucket");
        bucketButton.setOnAction(Event ->{
            principio.close();
            bucketWindow(principio);
        });

        Button comboInButton = new Button("Ordenar un combo");
        comboInButton.setOnAction(Event ->{
            principio.close();
            comboWindow(principio);
        });

        Button cancelButton = new Button("Cancelar");
        cancelButton.setOnAction(Event ->
            principio.close()
        );
        
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(15, 25, 5, 25));
        grid2.add(bucketButton, 0, 0);
        grid2.add(comboInButton, 1, 0);
        
        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid2.setVgap(1);
        grid3.setHgap(10);
        grid3.setPadding(new Insets(5, 25, 25, 25));
        grid3.add(cancelButton, 0, 1);
        
        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(5);
        grid4.setPadding(new Insets(10, 10, 10, 10));
        grid4.add(grid2, 0, 0);
        grid4.add(grid3, 0, 1);
        
        VBox vbox2 = new VBox();
        vbox2.setAlignment(Pos.CENTER);
        vbox2.getChildren().add(imageView2);
        vbox2.getChildren().add(titulo2);
        vbox2.getChildren().add(imageView);
        vbox2.getChildren().add(preguntaText);
        vbox2.getChildren().add(grid4);
        
        Scene scene2 = new Scene(vbox2, 500, 520);
        vbox2.setStyle("-fx-background-color: #AD1931");
        
        //Mostrar
        principio.setTitle("Inicio");
        principio.setScene(scene2);
        principio.getIcons().add(new Image("Imagenes/Icono1.png"));
        principio.show();
    }
    
    private void bucketWindow(Stage principio){
        
        //Este array almacerara el menu, y el cliente elegirá uno
        elegido[0] = new Bucket8P(8, "Cruji", "Piezas", 339);
        elegido[1] = new Bucket12P(12, "Cruji", "Piezas", 499);
        elegido[2] = new Bucket15P(15, "Cruji", "Piezas", 565);
        elegido[3] = new Bucket18P(18, "Cruji", "Piezas", 565);
        
        Stage bucket = new Stage();
        Label titulo3 = new Label("Menú de Buckets");
        titulo3.setFont(Font.font("heattenschweiler Normal", FontWeight.EXTRA_BOLD, 30));
        titulo3.setStyle("-fx-text-fill: #AD1931");
        
        ImageView imageView3 = new ImageView(new Image("Imagenes/KFC1952.png")){};
        imageView3.setPreserveRatio(true);
        imageView3.setFitWidth(325);
        
        ImageView imageView4 = new ImageView(new Image("Imagenes/Bucket_Moving.gif")){};
        imageView4.setPreserveRatio(true);
        imageView4.setFitWidth(150);
        
        Text select1Text = new Text("Elige tu bucket");
        select1Text.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 25));
        
        //Añadir un combobox para que se eliga el tamaño del bucket
        String [] tamaño = {"8 piezas", "12 piezas", "15 piezas", "18 piezas"};
        ComboBox<String> bucketSize = new ComboBox<>();
        bucketSize.getItems().addAll(tamaño);
        bucketSize.setOnAction(event ->{
        selectedPack = bucketSize.getValue();
        switch(selectedPack){
            case "8 piezas":
                paqueteElegido = 0;
                break;
            case "12 piezas":
                paqueteElegido = 1;
                break;
            case "15 piezzas":
                paqueteElegido = 2;
                break;
            case "18 piezas":
                paqueteElegido = 3;
                break;
        }   
        });
        
        Button aceptButton = new Button("Aceptar");
        aceptButton.setOnAction(Event ->{
            if( selectedPack == null){
            Alert noPack = new Alert(Alert.AlertType.ERROR);
            noPack.setTitle("¡¡Error!!");
            noPack.setHeaderText("Ningun bucket seleccionado");
            noPack.setContentText("¡No ha seleccionado ningun bucket, por favor elija uno para continuar!");
            noPack.showAndWait();
        }else{
            esBucket = true;
            modificarPedido(); 
            }
        });
        
        Button atrasButton = new Button("  Atrás  ");
        atrasButton.setOnAction(Event ->{
            System.out.println(elegido[paqueteElegido].getCantPiezas());
            bucket.close();
            newWindow(principio);
        });
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20, 25, 5, 25));
        root.add(bucketSize, 0, 0);
        
        GridPane reet = new GridPane();
        reet.setAlignment(Pos.CENTER);
        reet.setHgap(10);
        reet.setVgap(5);
        reet.setPadding(new Insets(5, 25, 25, 25));
        reet.add(atrasButton, 0, 1);
        reet.add(aceptButton, 0, 2);
        
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().add(imageView3);
        vbox3.getChildren().add(titulo3);
        vbox3.getChildren().add(imageView4);
        vbox3.getChildren().add(select1Text);
        vbox3.getChildren().add(root);
        vbox3.getChildren().add(reet);
        
        Scene scene3 = new Scene(vbox3, 325, 500);
        vbox3.setStyle("-fx-background-color: White");
        
        //Mostrar
        bucket.setTitle("Detalles Bucket");
        bucket.setScene(scene3);
        bucket.getIcons().add(new Image("Imagenes/Icono2.jpeg"));
        bucket.show();
    }
    
    private void comboWindow(Stage principio){
        
        //Este array almacerara el menu, y el cliente elegirá uno
        miCombo[0] = new BigBOX();
        miCombo[1] = new Burger();
        miCombo[2] = new Nuggets();
        miCombo[3] = new kidsBucket();
        
        Stage combo = new Stage();
        Label titulo4 = new Label("Menú de Combos");
        Label titulo4_5 = new Label("individuales");
        titulo4.setFont(Font.font("heattenschweiler Normal", FontWeight.EXTRA_BOLD, 30));
        titulo4.setStyle("-fx-text-fill: #AD1931");
        
        ImageView imageView3 = new ImageView(new Image("Imagenes/KFC1952.png")){};
        imageView3.setPreserveRatio(true);
        imageView3.setFitWidth(325);
        
        ImageView imageView4 = new ImageView(new Image("Imagenes/Pollo_Mueve.gif")){};
        imageView4.setPreserveRatio(true);
        imageView4.setFitWidth(150);
        
        Text select2Text = new Text("Elige tu combo");
        select2Text.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 25));
        
        //Añadir un combobox para que se eliga el tamaño del bucket
        String [] tamaño = {"BigBox", "Chicken Burger", "Nuggets", "Kids Bucket"};
        ComboBox<String> bucketSize = new ComboBox<>();
        bucketSize.getItems().addAll(tamaño);
        bucketSize.setOnAction(event ->{
        selectedPack = bucketSize.getValue();
        switch(selectedPack){
            case "BigBox":
                paqueteElegido = 0;
                break;
            case "Chicken Burger":
                paqueteElegido = 1;
                break;
            case "Nuggets":
                paqueteElegido = 2;
                break;
            case "Kids Bucket":
                paqueteElegido = 3;
                break;
        }   
        });
        
        Button aceptButton = new Button("Aceptar");
        aceptButton.setOnAction(Event ->{
        if( selectedPack == null){
            Alert noPack = new Alert(Alert.AlertType.ERROR);
            noPack.setTitle("¡¡Error!!");
            noPack.setHeaderText("Ningun paquete seleccionado");
            noPack.setContentText("¡No ha seleccionado ningun paquete, por favor elija uno para continuar!");
            noPack.showAndWait();
        }else{
            esBucket = false;
            combo.close();
            modificarPedido();
        }   
        });
        
        Button atrasButton = new Button("  Atrás  ");
        atrasButton.setOnAction(Event ->{;
            combo.close();
            newWindow(principio);
        });
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20, 25, 5, 25));
        root.add(bucketSize, 0, 0);
        
        GridPane reet = new GridPane();
        reet.setAlignment(Pos.CENTER);
        reet.setHgap(10);
        reet.setVgap(5);
        reet.setPadding(new Insets(5, 25, 25, 25));
        reet.add(atrasButton, 0, 1);
        reet.add(aceptButton, 0, 2);
        
        VBox vbox3 = new VBox();
        vbox3.setAlignment(Pos.CENTER);
        vbox3.getChildren().add(imageView3);
        vbox3.getChildren().add(titulo4);
        vbox3.getChildren().add(titulo4_5);
        vbox3.getChildren().add(imageView4);
        vbox3.getChildren().add(select2Text);
        vbox3.getChildren().add(root);
        vbox3.getChildren().add(reet);
        
        Scene scene3 = new Scene(vbox3, 325, 500);
        vbox3.setStyle("-fx-background-color: White");
        
        //Mostrar
        combo.setTitle("Detalles Combo");
        combo.setScene(scene3);
        combo.getIcons().add(new Image("Imagenes/Icono2.jpeg"));
        combo.show();
    }
    
    public void modificarPedido()
    {
        if(esBucket == true){
            
        Stage cambiarBuck = new Stage();
        Label titulo5 = new Label("Personaliza tu Bucket");
        titulo5.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 30));
        titulo5.setStyle("-fx-text-fill: #E2E216 ");
            
        ImageView chicken = new ImageView(new Image("Imagenes/BucketFamiliar.jpg")){};
        chicken.setPreserveRatio(true);
        chicken.setFitWidth(150);
        
        ImageView Sanders = new ImageView(new Image("Imagenes/Icono3.jpg")){};
        Sanders.setPreserveRatio(true);
        Sanders.setFitWidth(100);
        
        // Se crean los campos de texto para modificar tu pedido
        Label saborLabel = new Label("Que sabor quieres: (BBQ, Receta o Habanero):");
        saborLabel.setStyle("-fx-text-fill: white");
        TextField saborField = new TextField();

        Label tipoLabel = new Label("Elige entre Cruji o Ke-Tiras:");
        tipoLabel.setStyle("-fx-text-fill: white");
        TextField tipoField = new TextField();

        Label refrescoLabel = new Label("¿Que refresco deseas añadir?:");
        refrescoLabel.setStyle("-fx-text-fill: white");
        TextField refrescoField = new TextField();
        
        Label bisketsLabel = new Label("Puedes agregar más biskets:");
        bisketsLabel.setStyle("-fx-text-fill: white");
        TextField bisketsField = new TextField();
        
        //Una pequeña notaa
        Text notaText = new Text("*NOTA: si no deseas agregar más biskets, escribe '0' en el campo para continuar");
        notaText.setFont(Font.font("heattenschweiler Normal", FontWeight.EXTRA_LIGHT,FontPosture.ITALIC, 10));
        
        // Crear el botón para guardar modificaciones
        Button enviarButton = new Button("Guardar");
        
        // Crear el botón para saltarte este menú
        Button omitirButton = new Button("Omitir");
        
        // Crear el botón para ir atrás
        Button regresarButton = new Button("Regresar");
            
        enviarButton.setOnAction(event -> {
            elegido[paqueteElegido].setSabor(saborField.getText());
            elegido[paqueteElegido].setTiposPiezas(tipoField.getText());
            elegido[paqueteElegido].setRefresco(refrescoField.getText());
            try{
                elegido[paqueteElegido].setBiskets(Integer.parseInt(bisketsField.getText()));
            }
            catch(NumberFormatException e){
                Alert nou = new Alert(Alert.AlertType.ERROR);
                nou.setTitle("Error");
                nou.setHeaderText("Entrada no válida");
                nou.setContentText("Ingresa una entrada válida");
                nou.showAndWait();
            }
            Alert success =  new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("¡Exito!");
            success.setHeaderText("Pedido realizado");
            success.setContentText("Ha añadido un Bucket de "+elegido[paqueteElegido].getCantPiezas()+ " piezas a su pedido");
            success.showAndWait();
            crearRecibo();
            cambiarBuck.close();
        });  
        
        regresarButton.setOnAction(event -> {
            cambiarBuck.close();
            bucketWindow(cambiarBuck);
        });
        
        omitirButton.setOnAction(event -> {
            Alert success =  new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("¡Exito!");
            success.setHeaderText("Pedido realizado");
            success.setContentText("Ha añadido un Bucket de "+elegido[paqueteElegido].getCantPiezas()+ " piezas a su pedido");
            success.showAndWait();
            cambiarBuck.close();
            crearRecibo();
        });
            
        GridPane grid6 = new GridPane();
        grid6.setAlignment(Pos.CENTER);
        grid6.setHgap(10);
        grid6.setVgap(10);
        grid6.setPadding(new Insets(25, 25, 10, 25));
        grid6.add(saborLabel, 0, 0);
        grid6.add(saborField, 1, 0);
        grid6.add(tipoLabel, 0, 1);
        grid6.add(tipoField, 1, 1);
        grid6.add(refrescoLabel, 0, 2);
        grid6.add(refrescoField, 1, 2);
        grid6.add(bisketsLabel, 0, 3);
        grid6.add(bisketsField, 1, 3);
        
        GridPane grid7 = new GridPane();
        grid7.setAlignment(Pos.CENTER);
        grid7.setHgap(10);
        grid7.setVgap(10);
        grid7.setPadding(new Insets(15, 25, 10, 25));
        grid7.add(enviarButton, 0, 0);
        grid7.add(omitirButton, 1, 0);
        grid7.add(regresarButton, 2, 0);
        
        GridPane grid5 = new GridPane();
        grid5.setAlignment(Pos.CENTER);
        grid5.setHgap(10);
        grid5.setVgap(10);
        grid5.setPadding(new Insets(1, 25, 10, 25));
        grid5.add(Sanders, 0, 0);
        grid5.add(titulo5, 1, 0);
        
        VBox vbox4 = new VBox();
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().add(grid5);
        vbox4.getChildren().add(chicken);
        vbox4.getChildren().add(grid6);
        vbox4.getChildren().add(grid7);
        vbox4.getChildren().add(notaText);
        
        // Crear la escena de modficacion del bucket
        Scene scene4 = new Scene(vbox4, 600, 500);
        vbox4.setStyle("-fx-background-color: #AD1931 ");

        // Establecer la escena en la ventana principal
        cambiarBuck.setTitle("Personalizar Pedido");
        cambiarBuck.setScene(scene4);
        cambiarBuck.getIcons().add(new Image("Imagenes/Logo rojo.jpeg"));
        cambiarBuck.show();
        
        }else if(esBucket == false){//Ahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
            
        Stage cambiarCombo = new Stage();
        Label titulo5 = new Label("Personaliza tu Combo");
        titulo5.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 30));
        titulo5.setStyle("-fx-text-fill: #E2E216 ");
        
        ImageView Sanders = new ImageView(new Image("Imagenes/Icono3.jpg")){};
        Sanders.setPreserveRatio(true);
        Sanders.setFitWidth(100);
        
        // Se crean los campos de texto para modificar tu pedido
        Label saborLabel = new Label("Que sabor quieres: (BBQ, Receta o Habanero):");
        saborLabel.setStyle("-fx-text-fill: white");
        TextField saborField = new TextField();

        Label agregadoLabel = new Label("Puedes agregar Papas, Puré, Ensalada, Bisket etc:");
        agregadoLabel.setStyle("-fx-text-fill: white");
        TextField agregadoField = new TextField();

        Label refrescoLabel = new Label("Cambia tu refresco o agrega uno a tu pedido:");
        refrescoLabel.setStyle("-fx-text-fill: white");
        TextField refrescoField = new TextField();
        
        Label postreLabel = new Label("Puedes un postre (Big Cream, Pay, Pastel etc.):");
        postreLabel.setStyle("-fx-text-fill: white");
        TextField postreField = new TextField();
        
        // Crear el botón para guardar modificaciones
        Button enviarButton = new Button("Guardar");
        
        // Crear el botón para saltarte este menú
        Button omitirButton = new Button("Omitir");
        
        // Crear el botón para ir atrás
        Button regresarButton = new Button("Regresar");
            
        enviarButton.setOnAction(event -> {
            miCombo[paqueteElegido].setSabor(saborField.getText());
            miCombo[paqueteElegido].setAgregado(agregadoField.getText());
            miCombo[paqueteElegido].setRefresco(refrescoField.getText());
            miCombo[paqueteElegido].setPostre(postreField.getText());
            miCombo[paqueteElegido].crearCombo();
            cambiarCombo.close();
            crearRecibo();
        });  
        
        regresarButton.setOnAction(event -> {
            cambiarCombo.close();
            bucketWindow(cambiarCombo);
        });
        
        omitirButton.setOnAction(event -> {
            miCombo[paqueteElegido].crearCombo();
            cambiarCombo.close();
            crearRecibo();
        });
            
        GridPane grid6 = new GridPane();
        grid6.setAlignment(Pos.CENTER);
        grid6.setHgap(10);
        grid6.setVgap(10);
        grid6.setPadding(new Insets(25, 25, 10, 25));
        grid6.add(saborLabel, 0, 0);
        grid6.add(saborField, 1, 0);
        grid6.add(agregadoLabel, 0, 1);
        grid6.add(agregadoField, 1, 1);
        grid6.add(refrescoLabel, 0, 2);
        grid6.add(refrescoField, 1, 2);
        grid6.add(postreLabel, 0, 3);
        grid6.add(postreField, 1, 3);
        
        GridPane grid7 = new GridPane();
        grid7.setAlignment(Pos.CENTER);
        grid7.setHgap(10);
        grid7.setVgap(10);
        grid7.setPadding(new Insets(15, 25, 10, 25));
        grid7.add(enviarButton, 0, 0);
        grid7.add(omitirButton, 1, 0);
        grid7.add(regresarButton, 2, 0);
        
        GridPane grid5 = new GridPane();
        grid5.setAlignment(Pos.CENTER);
        grid5.setHgap(10);
        grid5.setVgap(10);
        grid5.setPadding(new Insets(1, 25, 10, 25));
        grid5.add(Sanders, 0, 0);
        grid5.add(titulo5, 1, 0);
        
        VBox vbox4 = new VBox();
        vbox4.setAlignment(Pos.CENTER);
        vbox4.getChildren().add(grid5);
        vbox4.getChildren().add(miCombo[paqueteElegido].dameImagen());
        vbox4.getChildren().add(grid6);
        vbox4.getChildren().add(grid7);
        
        // Crear la escena de modficacion del bucket
        Scene scene5 = new Scene(vbox4, 600, 500);
        vbox4.setStyle("-fx-background-color: #AD1931 ");

        // Establecer la escena en la ventana principal
        cambiarCombo.setTitle("Personalizar Pedido");
        cambiarCombo.setScene(scene5);
        cambiarCombo.getIcons().add(new Image("Imagenes/Logo rojo.jpeg"));
        cambiarCombo.show();
        }
    }
    
    public void crearRecibo()
    {
        Stage recibo = new Stage();
        Label titulo6 = new Label("Total");
        titulo6.setFont(Font.font("heattenschweiler Normal", FontWeight.BOLD, 30));
        titulo6.setStyle("-fx-text-fill: #AD1931 ");
        
        Label fechaLabel = new Label("Ingresa la fecha actual: (Ejemplo: Mar/05/Sep/2024)");
        fechaLabel.setFont(Font.font("Arial", FontPosture.ITALIC, 10));
        TextField fechaField = new TextField();
        fechaActual = fechaField.getText();
        
        Button addDate = new Button("Agregar");
        
        Text detalles = new Text();
        
        ImageView theSanders = new ImageView(new Image("Imagenes/Icono2.jpeg")){};
        theSanders.setPreserveRatio(true);
        theSanders.setFitWidth(100);
        
        ImageView iconAlert = new ImageView(new Image("Imagenes/Icono4.png")){};
        
        //Columna 1: Muestra nombres de detalles
        Label idProd = new Label();
        
        Label nombreProd = new Label();
        
        Label fecha = new Label();
        
        Label precio = new Label();
        
        //Columna 1: Muestra nombres de detalles
        Label showId = new Label();
        
        Label showName = new Label();
        
        Label showDate = new Label();
        
        Label showPrice = new Label();
        
        //Boton para pagar
        Button Pay = new Button("Pagar");
        
        //Grid para lo de arriba 
        GridPane grid8 = new GridPane();
        grid8.setAlignment(Pos.CENTER);
        grid8.setHgap(10);
        grid8.setVgap(10);
        grid8.setPadding(new Insets(25, 25, 10, 25));
        grid8.add(fechaLabel, 0, 0);
        grid8.add(fechaField, 1, 0);
        
        
        //Grid para poner todo simetrico
        GridPane grid9 = new GridPane();
        grid9.setAlignment(Pos.CENTER);
        grid9.setHgap(10);
        grid9.setVgap(10);
        grid9.setPadding(new Insets(25, 25, 10, 25));
        grid9.add(idProd, 0, 0);
        grid9.add(showId, 1, 0);
        grid9.add(nombreProd, 0, 1);
        grid9.add(showName, 1, 1);
        grid9.add(fecha, 0, 2);
        grid9.add(showDate, 1, 2);
        grid9.add(precio, 0, 3);
        grid9.add(showPrice, 1, 3);
        
        addDate.setOnAction((ActionEvent event) ->{
            if(fechaActual.isEmpty()){
                Alert noDate = new Alert(Alert.AlertType.ERROR);
                noDate.setTitle("Alerta");
                noDate.setHeaderText("Nombre no registrado");
                noDate.setContentText("Para continuar, debe ingresar su nombre");
                noDate.showAndWait();
                ingresoFecha = false;
                
            }
            else{
                elId = selectedPack.substring(0,selectedPack.indexOf("_"))+fechaActual.substring(fechaActual.indexOf("2024")+001);
                detalles.setText("DETALLES DE TU PEDIDO");
                idProd.setText("Id de compra: ");
                nombreProd.setText("Nombre: ");
                fecha.setText("Fecha: ");
                precio.setText("Precio: ");
                showId.setText(elId);
                showName.setText(selectedPack);
                showDate.setText(fechaActual);
                try{
                    showPrice.setText(String.valueOf(elPrecio));
                }
                catch(NumberFormatException e){
                    Alert Error = new Alert(Alert.AlertType.ERROR);
                    Error.setTitle("Alerta");
                    Error.setHeaderText("Algo falló");
                    Error.setContentText("Intentelo más tarde");
                    Error.showAndWait();
                }
                
            }
        });
        while(ingresoFecha == false){
            Pay.setOnAction(event ->{
                Alert Error2 = new Alert(Alert.AlertType.ERROR);
                Error2.setTitle("Error");
                Error2.setHeaderText("Fecha no ingresada");
                Error2.setContentText("Ingrese una fecha para continuar");
                Error2.showAndWait();
            });
        }
        while(ingresoFecha != false){
            Pay.setOnAction(event ->{
                Alert fin =  new Alert(Alert.AlertType.INFORMATION);
                fin.setTitle("¡Exito!");
                fin.setHeaderText("Pedido realizado");
                fin.setContentText("¡Ha finalizado la compra, su pedido está en camino!");
                fin.setGraphic(iconAlert);
                fin.showAndWait();
                bucketWindow(recibo);
            });
        }
        
        VBox vbox5 = new VBox();
        vbox5.setAlignment(Pos.CENTER);
        vbox5.getChildren().add(titulo6);
        vbox5.getChildren().add(grid8);
        vbox5.getChildren().add(theSanders);
        vbox5.getChildren().add(grid9);
        
        // Crear la escena de modficacion del bucket
        Scene scene6 = new Scene(vbox5, 600, 500);
        vbox5.setStyle("-fx-background-color: White ");

        // Establecer la escena en la ventana principal
        recibo.setTitle("Finalizar Pedido");
        recibo.setScene(scene6);
        recibo.getIcons().add(new Image("Imagenes/Icono5.png"));
        recibo.show();
        
    }
    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
