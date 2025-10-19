package Tarea4;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

/**
 * La clase Main permite registrar datos de alumnos introducidos por teclado
 * y guardarlos en un archivo binario especificado por el usuario.
 *
 * <p>Campos solicitados para cada alumno:</p>
 * <ul>
 *   <li>NIA (número entero)</li>
 *   <li>Nombre</li>
 *   <li>Apellidos</li>
 *   <li>Curso</li>
 *   <li>Ciclo</li>
 *   <li>Grupo</li>
 *   <li>Género (M/F)</li>
 *   <li>Fecha de nacimiento (año, mes, día)</li>
 * </ul>
 * 
 * @author DanielAlonso
 * @version 1.0
 */
public class Main {

    /**
     * Solicita al usuario la ruta del fichero donde se almacenarán los datos.
     * Si el fichero existe, se abre en modo escritura binaria y se permite
     * introducir uno o varios registros de alumnos.
     * 
     */
    public static void main(String[] args) throws GeneroNoValidoException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indiqueme donde se encuetra el fichero donde guardar los datos");
        File f = new File(sc.nextLine());

        // Verifica que el fichero exista
        if (f.exists()) {
            // Declaración del DataOutputStream (lo metemos en el try para que se cierre automaticamente)
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))) {

                System.out.println("¿Desea introducir un alumno?");
                String respuesta = sc.nextLine();

                while (respuesta.equalsIgnoreCase("si")) {
                    System.out.println("Nia:");
                    dos.writeInt(sc.nextInt());
                    sc.nextLine(); // limpia el buffer

                    System.out.println("Nombre:");
                    dos.writeUTF(sc.nextLine());

                    System.out.println("Apellidos:");
                    dos.writeUTF(sc.nextLine());

                    System.out.println("Curso:");
                    dos.writeUTF(sc.nextLine());

                    System.out.println("Ciclo:");
                    dos.writeUTF(sc.nextLine());

                    System.out.println("Grupo:");
                    dos.writeUTF(sc.nextLine());

                    System.out.println("Genero (M/F):");
                    dos.writeChar(sc.nextLine().charAt(0));

                    System.out.println("Año de nacimiento:");
                    dos.writeInt(sc.nextInt());

                    System.out.println("Mes de nacimiento:");
                    dos.writeInt(sc.nextInt());

                    System.out.println("Dia de nacimiento:");
                    dos.writeInt(sc.nextInt());
                    sc.nextLine(); // limpia el buffer

                    System.out.println("¿Desea introducir otro alumno?");
                    respuesta = sc.nextLine();
                }

            } catch (Exception e) {
                // En caso de cualquier error, muestra la traza del error
                e.printStackTrace();
            }
        } else {
            System.err.println("No existe dicho fichero");
        }

        sc.close();
    }
}
