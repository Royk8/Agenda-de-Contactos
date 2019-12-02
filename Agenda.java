import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
    ArrayList<Contacto> listaContactos;
    ArrayList<String> categoryList = new ArrayList();
    Scanner leer = new Scanner(System.in);

    public void menu(){
        listaContactos = new ArrayList<Contacto>();
        categoryList.add("Familia");
        categoryList.add("Amigos");
        categoryList.add("Trabajo");
        categoryList.add("Universidad");
        int opcion;
        do{
            System.out.println("Bienvenido a la agenda.");
            System.out.println("1. Ver contactos.");
            System.out.println("2. Agregar nuevo contacto.");
            System.out.println("3. Borrar contacto.");
            System.out.println("4. Modificar contacto. ");
            System.out.println("0. Salir");
            System.out.println("Seleccione la opcion deseada ingresando los numeros de 1 a 5. ");
            opcion = leerEntero(4);
            switch (opcion){
                case 1:
                    System.out.println("1. Ver todos.");
                    System.out.println("2. Ver categorias. ");
                    System.out.println("Seleccione una opcion 1-2");
                    int opcionSegundaria = leerEntero(2);
                    switch (opcionSegundaria){
                        case 1:
                            verContactos();
                            break;
                        case 2:
                            verCategorias();
                            break;
                    }
                    break;
                case 2:
                    agregarContacto();
                    break;
                case 3:
                    borrarContacto();
                    break;
                case 4:
                    modificarContacto();
                    break;
            }
        }while(opcion !=0);
    }

    public void verContactos(){
        if(listaContactos.size() == 0) System.out.println("No tiene contactos almacenados.");
        else {
            mostrarContactos();
            System.out.println("Seleccione el contacto que desea ver 1 -" + listaContactos.size());
            int ver = leerEntero(listaContactos.size()) - 1;
            System.out.println("Informacion de " + listaContactos.get(ver).getName());
            informacionDeContacto(ver);
        }
    }

    public void verCategorias(){
        if(listaContactos.size() == 0) System.out.println("No tiene contactos almacenados.");
        else {
            System.out.println("Las categorias disponibles son:");
            for (int i = 0; i < categoryList.size(); i++)
                System.out.println(i + 1 + ". " + categoryList.get(i));
            System.out.println("Seleccione la categoria que desea ver 1-" + categoryList.size());
            int categoryIndex = leerEntero(categoryList.size());
            categoryIndex--;
            System.out.println("Los contactos de la categoria " + categoryList.get(categoryIndex) + " son: ");
            for (int i = 0; i < listaContactos.size(); i++) {
                if (categoryList.get(categoryIndex) == listaContactos.get(i).getCategory()) {
                    System.out.println(i + 1 + ". " + listaContactos.get(i).getName() + " " + listaContactos.get(i).getLastName() +
                            "\"" + listaContactos.get(i).getNickName() + "\".");
                }
            }
            System.out.println("Seleccione el contacto que desea ver 1 -" + listaContactos.size());
            int ver = leerEntero(listaContactos.size()) - 1;
            if(categoryList.get(categoryIndex) == listaContactos.get(ver).getCategory()){
            System.out.println("Informacion de " + listaContactos.get(ver).getName());
            informacionDeContacto(ver);
            }else
                System.out.println("Opcion invalida.");
        }
    }

    public void agregarContacto(){
        System.out.print("Ingrese el nombre ");
        String name = leer.nextLine();
        System.out.print("Ingrese el apellido ");
        String lastName = leer.nextLine();
        System.out.print("Ingrese el apodo ");
        String nickName = leer.nextLine();
        System.out.print("Ingrese la dirección de correo electronico ");
        String eMail = leer.nextLine();
        System.out.print("Ingrese el numero telefonico ");
        Float telephone = leerFloat();
        System.out.println("Seleccione una categoria para su contacto ");
        for (int i = 0; i< categoryList.size(); i++)
            System.out.println(i+1+ ". "+categoryList.get(i));
        System.out.println("0. Agregar nueva categoria");
        int categoryIndex = leerEntero(categoryList.size());
        if (categoryIndex == 0) {
            System.out.println("Ingrese la nueva categoria para su contacto ");
            String nueva = leer.nextLine();
            categoryList.add(nueva);
            categoryIndex = categoryList.size();
        }
        categoryIndex--;
        Contacto contacto = new Contacto(name, lastName, nickName, eMail, categoryList.get(categoryIndex), telephone);
        listaContactos.add(contacto);
    }

    public void borrarContacto(){
        if(listaContactos.size() == 0) System.out.println("No tiene contactos almacenados.");
        else {
            mostrarContactos();
            System.out.println("Seleccione el contacto que desea borrar 1-" + listaContactos.size());
            int borrar = leerEntero(listaContactos.size()) - 1;
            if (borrar <= listaContactos.size()) {
                System.out.println("El contacto de " + listaContactos.get(borrar).getName() + " "
                        + listaContactos.get(borrar).getLastName() + " ha sido eliminado de la agenda exitosamente.");
                listaContactos.remove(borrar);
            } else System.out.println("Indice invalido.");
        }
    }

    public void modificarContacto(){
        if(listaContactos.size() == 0) System.out.println("No tiene contactos almacenados.");
        else {
            mostrarContactos();
            System.out.println("Seleccione el contacto que desea modificar 1-" + listaContactos.size());
            int modificar = leerEntero(listaContactos.size()) - 1;
            informacionDeContacto(modificar);
            System.out.println("Seleccione el campo que desea modificar 1-6.\nPrecione 0 para modificar todo el contacto");
            int campo = leerEntero(6);
            String nuevo;
            switch (campo) {
                case 0:
                    agregarContacto();
                    listaContactos.remove(modificar);
                    break;
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    nuevo = leer.nextLine();
                    listaContactos.get(modificar).setName(nuevo);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo apellido: ");
                    nuevo = leer.nextLine();
                    listaContactos.get(modificar).setLastName(nuevo);
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo apodo: ");
                    nuevo = leer.nextLine();
                    listaContactos.get(modificar).setNickName(nuevo);
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo e-Mail: ");
                    nuevo = leer.nextLine();
                    listaContactos.get(modificar).setEmail(nuevo);
                    break;
                case 5:
                    System.out.println("Seleccione una nueva categoria para su contacto ");
                    for (int i = 0; i < categoryList.size(); i++)
                        System.out.println(i + 1 + ". " + categoryList.get(i));
                    System.out.println("0. Agregar nueva categoria");
                    int categoryIndex = leerEntero(categoryList.size());
                    if (categoryIndex == 0) {
                        System.out.println("Ingrese la nueva categoria para su contacto ");
                        String nueva = leer.nextLine();
                        categoryList.add(nueva);
                        categoryIndex = categoryList.size();
                    }
                    categoryIndex--;
                    listaContactos.get(modificar).setCategory(categoryList.get(categoryIndex));
                    break;
                case 6:
                    System.out.print("Ingrese el nuevo numero telefonico: ");
                    float numero = leerFloat();
                    listaContactos.get(modificar).setTelephone(numero);
                    break;
                default:
                    System.out.println("Indice invalido");
                    return;
            }
            System.out.println("El contacto ha sido modificado exitosamente. ");
        }
    }

    public void mostrarContactos(){
        System.out.println("Sus contactos son: ");
        for( int i = 0; i< listaContactos.size(); i++){
            System.out.println(i+1+". "+listaContactos.get(i).getName()+" "+listaContactos.get(i).getLastName()+
                    "\""+ listaContactos.get(i).getNickName()+ "\".");
        }
    }

    public void informacionDeContacto(int i){
        System.out.println("1. Nombre: "+listaContactos.get(i).getName());
        System.out.println("2. Apellido: "+listaContactos.get(i).getLastName());
        System.out.println("3. Apodo: "+listaContactos.get(i).getNickName());
        System.out.println("4. eMail: "+listaContactos.get(i).getEmail());
        System.out.println("5. Categoria: "+listaContactos.get(i).getCategory());
        System.out.println("6. Telefono: "+String.format("%.0f", listaContactos.get(i).getTelephone()));
    }

    public int leerEntero(int max){
        int n = -1;
        while(true) {
            try {
                n = leer.nextInt();
            } catch (NumberFormatException e){
                leer.next();
                System.out.print("Debe ser un numero entero ");
            } catch (java.util.InputMismatchException e){
                leer.next();
                System.out.print("Debe ser un numero entero ");
            }
            if(n >= 0 && n <= max) {
                leer.nextLine();
                break;
            }
            else System.out.println("Debe ser positivo y menor/igual que "+max);
        }
        return n;
    }

    public float leerFloat(){
        float r = 0;
        while(true) {
            try {
                r = Float.parseFloat(leer.nextLine());
            } catch (java.util.InputMismatchException e) {
                leer.next();
                System.out.print("Debe ser un numero entero y ");
            }
            if(r>=0f) break;
            else System.out.println("Debe ser positivo.");
        }
        return r;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.menu();
    }
}
