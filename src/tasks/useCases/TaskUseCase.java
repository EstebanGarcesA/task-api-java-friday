package tasks.useCases;

import java.util.ArrayList;
import java.util.List;

// importar la clase Repository y usarla en esta clase.

import tasks.models.Task;

// Contenedor de metodos y atributos
public class TaskUseCase { // Clase de las acciones a realizar el Use Case

    // Propiedad
    private final List<Task> tasks; // Definicion Lista en memoria

    // Constructor
    public TaskUseCase() {
        this.tasks = new ArrayList<>(); // Inicializacion - Preparar el uso de la lista.
    }

    // Read
    public String all(){
        try {
            StringBuilder result = new StringBuilder(); // preparando la concatenacion de los strings.
            for (int i = 0; i < tasks.size(); i++) { // Se procede a concatenar las tareas al string.
                Task task = tasks.get(i); // Se obtiene la tarea.
                result.append("Tarea ")
                .append(i)
                .append(": ")
                .append(task.getName())
                .append(" Descripcion: ")
                .append(task.getDescription())
                .append("\n"); // Concatenar la tarea al string.
            }

            return result.toString(); // Retornando la concatenacion de las tareas.
            
        } catch (Exception e) {
           return "No ha sido posible listar las tareas.";
        }
    }

    // Read by index
    public String findByIndex(int index){
        try {
             Task taskFound = new Task(); // Todavia no se ha encontrado
            for (int i = 0; i < tasks.size(); i++) { // Se procede a buscar
                if(index == i){ // Se aplica el filtro o condicional
                    Task task = tasks.get(index); // Se obtiene la tarea encontrada
                    taskFound = task; // Se asigna la tarea encontrada
                }
            }
            // Se imprime la tarea encontrada.
            return "Tarea Encontrada:" + taskFound.getName() + " Descripcion:" + taskFound.getDescription();
        }
        catch (Exception e) {
            return "no ha sido posible encontrar la tarea.";
        }
    }

    // Create
    public String create(Task task) {
        try {
            this.tasks.add(task); // Uso de la lista
            // example: this.repository.create(task);
            return "Tarea Creada:" + task.getName() + " Descripcion:" + task.getDescription();
        }
        catch (Exception e) {
            return "Ha ocurrido un error, por favor intentelo nuevo";
        }
    }

    // Update
    public String update(int index, Task taskIn) { //tarea entrante
        try {
            Task taskFound = new Task();
            for (int i = 0; i < tasks.size(); i++) {
               if(index == i){
                Task task = tasks.get(index); // tarea existente
                task.setName(taskIn.getName());
                task.setDescription(taskIn.getDescription());
                task.setStatus(taskIn.getStatus());
                taskFound = task;
               }
            }
            return "Tarea Actualizada:" + taskFound.getName() + " Descripcion:" + taskFound.getDescription();
        }
        catch (Exception e) {
            return "Ha ocurrido un error, por favor intentelo nuevo";
        }
    }

    // Delete
    public String delete(int index){
       try {
            tasks.remove(index);
            return "Se ha eliminado la tarea correctamente.";
       } catch (Exception e) {
            return "no ha sido posible eliminar la tarea.";
       }
    }
}
