package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    
   //Creaciòn de Stage
    Stage inicio;
    
   //Creaciòn de Scene
    Scene scene2;
    
   //Creaciòn de TableView y ObservableList
    TableView<Cliente> table;
    ObservableList data;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        inicio = primaryStage;
        
        //Conexiòn de BD
        DBManager accesoDB = new DBManager();
        OperacionesClientes opCliente = new OperacionesClientes(accesoDB.getConnection());

        //Creaciòn de RadioButton
        RadioButton radiobtnId = new RadioButton ("Id");
        RadioButton radiobtnNom = new RadioButton ("Nombre");
        RadioButton radiobtnApe = new RadioButton ("Apellidos");
        RadioButton radiobtnId2 = new RadioButton ("Id");
        RadioButton radiobtnNom2 = new RadioButton ("Tabla");
        
        //Creaciòn de Group de RadioButton
        ToggleGroup radioGroup = new ToggleGroup ();
 
        //Agregar en el grupo y desabilitarlos
        radiobtnId.setToggleGroup (radioGroup);
        radiobtnId.setDisable(true);
        radiobtnNom.setToggleGroup (radioGroup);
        radiobtnNom.setDisable(true);
        radiobtnApe.setToggleGroup (radioGroup);
        radiobtnApe.setDisable(true);
        radiobtnId2.setToggleGroup (radioGroup);
        radiobtnId2.setDisable(true);
        radiobtnNom2.setToggleGroup (radioGroup);
        radiobtnNom2.setDisable(true);

        //Creacion de la TableView
        table = new TableView();

        //Creaciòn de Columnas en la tabla
        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory("clienteId"));
        TableColumn nombreCol = new TableColumn("Nombre");
        nombreCol.setCellValueFactory(new PropertyValueFactory("nombre"));
        TableColumn apellidosCol = new TableColumn("Apellidos");
        apellidosCol.setCellValueFactory(new PropertyValueFactory("apellidos"));
        TableColumn direccionCol = new TableColumn("Direcciòn");
        direccionCol.setCellValueFactory(new PropertyValueFactory("direccion"));
        
        //Tamaño de TableView
        table.getColumns().setAll(idCol, nombreCol, apellidosCol, direccionCol);
        table.setPrefWidth(200);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //Creacion de Labels

        Label lblCliente = new Label("CLIENTES");
        lblCliente.setFont(Font.font("Calisto MT", 30));

        Label lblid = new Label("Id");
        lblid.setFont(Font.font("Calisto MT", 20));

        Label lblnombre = new Label("Nombre");
        lblnombre.setFont(Font.font("Calisto MT", 20));

        Label lblapellido = new Label("Apellido");
        lblapellido.setFont(Font.font("Calisto MT", 20));

        Label lbldireccion = new Label("Direccion");
        lbldireccion.setFont(Font.font("Calisto MT", 20));

        //Creacion de TextField
        TextField txtId = new TextField();
        TextField txtNombre = new TextField();
        TextField txtApellido = new TextField();
        TextField txtDireccion = new TextField();
        
        //Estado de los TextField
        txtId.setDisable(true);
        txtNombre.setDisable(true);
        txtApellido.setDisable(true);
        txtDireccion.setDisable(true);

        //Button Añadir
        Button btnconfirmarA = new Button("Confirmar");
        btnconfirmarA.setMaxSize(100, 200);
        btnconfirmarA.setDisable(true);
        Button btnañadir = new Button("Añadir");
        btnañadir.setMaxSize(100, 300);
        //Button Consultar
        Button btnconfirmarC = new Button("Confirmar");
        btnconfirmarC.setMaxSize(100, 200);
        btnconfirmarC.setDisable(true);
        Button btnConsultar = new Button("Consultar");
        btnConsultar.setMaxSize(100, 300);
        //Button Eliminar
        Button btnconfirmarE = new Button("Confirmar");
        btnconfirmarE.setMaxSize(100, 200);
        btnconfirmarE.setDisable(true);
        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setMaxSize(100, 200);
        btnEliminar.setDisable(true);
        //Button Modificar
        Button btnModificar = new Button("Modificar");
        btnModificar.setMaxSize(100, 200);
        btnModificar.setDisable(true);
        Button btnconfirmarM = new Button("Confirmar");
        btnconfirmarM.setMaxSize(100, 200);
        btnconfirmarM.setDisable(true);
        
        //Muestra todos los valores en la tabla
        data = opCliente.getClienteTodo();
        table.setItems(data);
    
        //Eventos de RadioButtons
        radiobtnNom.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txtNombre.setDisable(false);
            	txtId.setDisable(true);
            	txtApellido.setDisable(true);
            	txtDireccion.setDisable(true);

            }
            });
        
        radiobtnId.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txtNombre.setDisable(true);
            	txtId.setDisable(false);
            	txtApellido.setDisable(true);
            	txtDireccion.setDisable(true);

            }
            });

        radiobtnNom2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txtNombre.setDisable(true);
            	txtId.setDisable(true);
            	txtApellido.setDisable(true);
            	txtDireccion.setDisable(true);

            }
            });

        radiobtnId2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txtNombre.setDisable(true);
            	txtId.setDisable(false);
            	txtApellido.setDisable(true);
            	txtDireccion.setDisable(true);

            }
            });

        radiobtnApe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	txtNombre.setDisable(true);
            	txtId.setDisable(true);
            	txtApellido.setDisable(false);
            	txtDireccion.setDisable(true);

            }
            });

        
        //Evento de Buttons
        btnconfirmarA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtDireccion.getText().length()==0){
            		Alertas aviso = new Alertas();
            		aviso.alertas();
            	} else {
            		  String Nom = txtNombre.getText();
                      String Ape = (txtApellido.getText());
                      String Dir = (txtDireccion.getText());

                      opCliente.insertCliente(Nom, Ape, Dir);
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Correcto");
                      alert.setHeaderText(null);
                      alert.setContentText("Cliente ingresado");

                      alert.showAndWait();
            	}

            }
        });


        btnañadir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	btnconfirmarE.setDisable(true);
            	btnconfirmarC.setDisable(true);
            	btnconfirmarA.setDisable(false);
            	btnconfirmarM.setDisable(true);

               	radiobtnId.setDisable(true);
            	 radiobtnNom.setDisable(true);
           	     radiobtnApe.setDisable(true);

            	 radiobtnId2.setDisable(true);
            	 radiobtnNom2.setDisable(true);

            	txtId.setDisable(true);

                txtNombre.setDisable(false);

                txtApellido.setDisable(false);

                txtDireccion.setDisable(false);

                /*txtId.clear();
                txtNombre.clear();
                txtApellido.clear();
                txtDireccion.clear();*/

            }
        });


        btnconfirmarC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if(radiobtnId.isSelected()==true){
                int Id1 = Integer.parseInt(txtId.getText());
                Cliente Consultas = opCliente.getCliente(Id1);


                txtNombre.setText(Consultas.getNombre());

                txtNombre.setDisable(true);
                txtApellido.setText(Consultas.getApellidos());

                txtApellido.setDisable(true);
                txtDireccion.setText(Consultas.getDireccion());
                
                //LLamo al metodo y envio el Id1
                data = opCliente.getClienteIdMostrar(Id1);
                
                //
                table.setItems(data);

                txtDireccion.setDisable(true);

                }
            	if(radiobtnNom.isSelected()==true){

                	data = opCliente.getClienteNom(txtNombre.getText());
                    table.setItems(data);
                }
            	if(radiobtnApe.isSelected()==true){

                	data = opCliente.getClienteApe(txtApellido.getText());
                    table.setItems(data);
                }
            	btnEliminar.setDisable(false);
            	btnModificar.setDisable(false);

            }
        });


        btnConsultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	btnconfirmarE.setDisable(true);
            	btnconfirmarA.setDisable(true);
            	btnconfirmarM.setDisable(true);

            	radiobtnId.setDisable(false);
           	    radiobtnNom.setDisable(false);
           	    radiobtnApe.setDisable(false);

            	 radiobtnId2.setDisable(true);
            	 radiobtnNom2.setDisable(true);
            	 //radiobtnApe2.setDisable(true);

            	btnconfirmarC.setDisable(false);
                radiobtnId.setDisable(false);
           	    radiobtnNom.setDisable(false);
           	    radiobtnApe.setDisable(false);

                txtId.setDisable(false);

                txtNombre.setDisable(true);

                txtApellido.setDisable(true);

                txtDireccion.setDisable(true);

            }
        });

        btnconfirmarE.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            if(radiobtnId2.isSelected()==true)
            {
            	int Id1 = Integer.parseInt(txtId.getText());
                opCliente.deleteCliente(Id1);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(":)");
                alert.setHeaderText(null);
                alert.setContentText("El cliente con el id" + "" + Id1+ "" + "fue borrado exito");

                alert.showAndWait();
            }if(radiobtnNom2.isSelected()==true){
            	Cliente client = table.getSelectionModel().getSelectedItem();
            	
            	//Metodo para Eliminar lo seleccionado 
            	int id=client.getClienteId();
            	opCliente.deleteCliente(id);
            	
            	//Alerta para Borrado Exitosamente
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(":)");
                alert.setHeaderText(null);
                alert.setContentText("El cliente con el id" + "" + id+ "" + "fue borrado exitosamente");
                alert.showAndWait();
            }
            
            }
        });

        btnEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            
            public void handle(ActionEvent event) {
            	
            	txtId.setDisable(true);
            	txtNombre.setDisable(true);
            	txtApellido.setDisable(true);
            	txtDireccion.setDisable(true);
        
            	btnconfirmarE.setDisable(false);
            	btnconfirmarC.setDisable(true);
            	btnconfirmarA.setDisable(true);
            	btnconfirmarM.setDisable(true);

             radiobtnId.setDisable(true);
           	 radiobtnNom.setDisable(true);
           	 radiobtnApe.setDisable(true);

            	 radiobtnId2.setDisable(false);
            	 radiobtnNom2.setDisable(false);
        

                txtNombre.setDisable(true);

                txtApellido.setDisable(true);

                txtDireccion.setDisable(true);

            }
        });


        btnModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	txtId.setDisable(true);

            	//Cambio de boton

            	btnconfirmarE.setDisable(true);
            	btnconfirmarC.setDisable(true);
            	btnconfirmarA.setDisable(true);
            	btnconfirmarM.setDisable(false);

                radiobtnId.setDisable(true);
           	    radiobtnNom.setDisable(true);
           	    radiobtnApe.setDisable(true);

            	 radiobtnId2.setDisable(true);
            	 radiobtnNom2.setDisable(true);


                txtDireccion.setDisable(false);
                txtNombre.setDisable(false);
                txtApellido.setDisable(false);
                btnconfirmarM.setDisable(false);


            }
        });

        btnconfirmarM.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	if (txtNombre.getText().length()==0 || txtApellido.getText().length()==0 || txtDireccion.getText().length()==0){
            		Alertas aviso = new Alertas();
            		aviso.alertas();
            	} else {
            		int Id1 = Integer.parseInt(txtId.getText());
                	String nom=txtNombre.getText();
                	String ape=txtApellido.getText();
                	String direc=txtDireccion.getText();
                	opCliente.ModifCliente(Id1,nom,ape,direc);
                	
                	txtId.setDisable(false);

                    txtNombre.setDisable(true);

                    txtApellido.setDisable(true);

                    txtDireccion.setDisable(true);

                    data = opCliente.getClienteIdMostrar(Id1);
                    table.setItems(data);
                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Correcto");
                    alert.setHeaderText(null);
                    alert.setContentText("Cliente Modificado correctamente");

                    alert.showAndWait();
            	}

            }
        });


        lblCliente.setFont(Font.font("Calisto MT", FontWeight.BOLD, 35));
        BorderPane layout2 = new BorderPane();
        layout2.setStyle("-fx-background-color: #ADFF2F;");
        layout2.getChildren().addAll(lblCliente, lblid, lblnombre,lblapellido,lbldireccion, txtId, txtNombre, txtApellido, txtDireccion);
        scene2 = new Scene(layout2, 1000,850 );
        layout2.setCenter(addGridPane2( lblCliente, lblid,lblnombre,lblapellido,lbldireccion, txtId, txtNombre, txtApellido, txtDireccion));
        layout2.setBottom(addGridPane3(btnconfirmarA, btnconfirmarC, btnconfirmarE, btnModificar, btnañadir, btnConsultar, btnEliminar, radiobtnId, radiobtnNom, radiobtnApe, radiobtnId2, radiobtnNom2, btnconfirmarM ));
        layout2.setTop(table);
        inicio.setScene(scene2);
        inicio.setTitle("Programa Final");
        inicio.show();

    }




    public GridPane addGridPane2( Label lblCliente, Label lblid, Label lblnombre, Label lblapellido, Label lbldireccion, TextField txtId, TextField txtNombre, TextField txtApellido, TextField txtDireccion) {

        GridPane grid2 = new GridPane();
        grid2.setStyle("-fx-background-color: #ADFF2F;");
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(0, 10, 40, 10));
        grid2.add(lblCliente, 0, 2);
        grid2.add(lblid, 0, 4);
        grid2.add(lblnombre, 0, 6);
        grid2.add(lblapellido, 0, 8);
        grid2.add(lbldireccion, 0, 10);
        grid2.add(txtId,1,4);
        grid2.add(txtNombre,1,6);
        grid2.add(txtApellido,1,8);
        grid2.add(txtDireccion,1,10);

        return grid2;
    }

    public GridPane addGridPane3(Button btnconfirmarA, Button btnconfirmarC, Button btnconfirmarE, Button btnModificar, Button btnañadir, Button btnConsultar, Button btnEliminar, RadioButton radiobtnId, RadioButton radiobtnNom, RadioButton radiobtnApe, RadioButton radiobtnId2, RadioButton radiobtnNom2, Button btnconfirmarM) {

        GridPane grid3 = new GridPane();
        grid3.setStyle("-fx-background-color: #ADFF2F;");
        grid3.setHgap(50);
        grid3.setVgap(50);
        grid3.setPadding(new Insets(0, 10, 40, 10));
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(0, 20, 50, 20));
        grid3.add(btnconfirmarA, 5, 3);
        grid3.add(btnconfirmarE, 30,4);
        grid3.add(btnconfirmarC, 20, 4);
        grid3.add(btnModificar,40,0);
        grid3.add(btnañadir,5,0);
        grid3.add(btnConsultar,20,0);
        grid3.add(btnEliminar,30,0);
        grid3.add(radiobtnId, 20,1);
        grid3.add(radiobtnNom, 20,2);
        grid3.add(radiobtnApe, 20,3);
        grid3.add(radiobtnId2, 30,1);
        grid3.add(radiobtnNom2, 30,2);
        grid3.add(btnconfirmarM, 40, 3);

        return grid3;
    }
}