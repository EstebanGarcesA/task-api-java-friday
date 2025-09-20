package tasks.repositories; // ruta de la case

import tasks.datasources; // Importacion de la clase TaskDatasource
import tasks.models.Task; // Importacion de la clase Task

// El contenedor del enrutador de las acciones.
public class TaskRepository {

    public TaskDatasource taskDataSource; // Declaracion de la clase TaskDatasource se convierte como tipo objecto

    // Constructor
    public TaskController() {
        this.taskDataSource = new TaskDatasource(); // Instancia de la clase TaskUseCase
    }

    // en ruta la accion de obtener todos
    public String all(){
        return this.taskDataSource.all(); // llamar todas las tareas.
    }

    // en ruta la accion de obtener por indice
    public String findByIndex(int index){
        return this.taskDataSource.findByIndex(index); // llamar la accion de buscar por indice.
    }

    // en ruta la accion de crear
    public String create(String name, String description, boolean status){
        return this.taskDataSource.create(new Task(name, description, status)); // llamar la accion de crear tarea.
    }

    // en ruta la accion de actualizar
    public String update(int index, String name, String description, boolean status){
        return this.taskDataSource.update(index, new Task (name, description, status)); // llamar la accion de actualizar tarea.
    }

    // en ruta la accion de eliminar
    public String delete (int index){
        return this.taskDataSource.delete(index);
    }
}