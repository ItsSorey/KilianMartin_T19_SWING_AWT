package controlador;

import modelo.consultas;
import modelo.suministra;
import vista.frmMenu;
import vista.frmMenuCRUD;

public class controlador {
	public static void main(String[] args) {
		frmMenu frmMenu = new frmMenu();
		consultas consulta = new consultas();
		frmMenuCRUD frmMenuCRUD = new frmMenuCRUD();
		
		int opc=0, opc2=0; //opciones de los 2 MENUS
		do { //MENU PRINCIPAL
			frmMenu.setVisible(true); //lo hacemos visible
			opc = frmMenu.menu(); //las opciones selecionadas
			switch(opc) {
			case 1: // Inicializar Tabla
				frmMenu.msg(consulta.inicializacionTabla());  //enviamos el mensage en vista en funcion de si la consulta ha funcionado o no con un msg
				break;
			case 2: //Insertar datos Automaticos
				frmMenu.msg(consulta.inserirDatos());
				break;
			case 3: //Borrar Tabla
				frmMenu.msg(consulta.borrarTabla());
				break;
			case 4: //MENU CRUD
				frmMenu.setVisible(false); //menu anterior a false para esconderlo
				do {
					frmMenuCRUD.setVisible(true); //Menu CRUD visible 
					opc2 = frmMenuCRUD.menu(); //opciones del menu 2
					switch(opc2) {
					case 1: // Añadir Registro
						try {
							frmMenuCRUD.msg("Datos del registro:");
							//creo una clase suministra pidiendole datos al usuario
							suministra registrar=new suministra(frmMenuCRUD.getIdPieza(),frmMenuCRUD.getidProveedor(),frmMenuCRUD.getPrecio());
							frmMenuCRUD.msg(consulta.registrar(registrar)); //segundo paso envio el suministro y lo registro en la BD
							//tercer paso muestro el msg por la vista en funcion de la consulta
						}catch(Exception ex) {
					    	//System.out.println("Cancelado"); control de errores por si cancelan
					    }
						break;
						
					case 2: //Buscar Registro por Precio
						try {
							frmMenuCRUD.msg("Inserte el Precio que quiere buscar");
							frmMenuCRUD.listarRegistros(consulta.buscar(frmMenuCRUD.getPrecio())); //busco en dependiendo del precio en este caso
						}catch(Exception ex) {
						}
						break;
						
					case 3: // Listar Registros
						try {
							frmMenuCRUD.listarRegistros(consulta.mostrarTabla()); //creamos una matriz en consulta y la pasamos a vista y la enseñamos
						}catch(Exception ex) {
						}
						break;
						
					case 4: //Modificar Registro
						try {
							frmMenuCRUD.msg("Datos nuevos del registro:");
							//creo una clase suministra pidiendole datos al usuario
							suministra modificar=new suministra(frmMenuCRUD.getIdPieza(),frmMenuCRUD.getidProveedor(),frmMenuCRUD.getPrecio());
							
							frmMenuCRUD.msg("Registro que quiere modificar:");
							frmMenuCRUD.msg(consulta.actualizar(modificar,frmMenuCRUD.getIdPieza(),frmMenuCRUD.getidProveedor()));
							//pedimos los cambios y modificamos el que quiere
						}catch(Exception ex) {
						}
						break;
						
					case 5: //Borrar Registro
						try {
							frmMenuCRUD.msg("Registro que quiere eliminar");
							frmMenuCRUD.msg(consulta.eliminar(frmMenuCRUD.getIdPieza(),frmMenuCRUD.getidProveedor())); //pido IdPieza y IdProveedor
							//ya que son 2 PK y los elimino
						}catch(Exception ex) {
						}
						break;
						
					case 6: //Salir
						frmMenu.msg("Bye");
						frmMenuCRUD.setVisible(false); //Menu CRUD en false
						break;
					}
				}while(opc2!=6);
				opc2=frmMenuCRUD.limpiar(); //limpiamos el buffer del menu antes de salir para seguir utilizandolo
				break;
				
				
			case 5: //salimos del menu y mostramps un msg al usuario
				frmMenu.msg("Bye");
				System.exit(0);
				break;
			}
		}while(opc!=5);
	}
}