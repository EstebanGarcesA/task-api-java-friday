package tasks.datasources; // ruta de la case

import tasks.models.Task; // Importacion de la clase Task

// El contenedor del enrutador de las acciones.
public class TaskDatasource {

    public DATA_BASE database; // Declaracion de la variable database de tipo DATA_BASE

    // Constructor
    public TaskDatasource() {
        this.database = new DATA_BASE(); // Inicializacion de la variable database
    }

    // en ruta la accion de obtener todos
    public String all(){
        return this.database.all(); // llamar todas las tareas.
    }

    // en ruta la accion de obtener por indice
    public String findByIndex(int index){
        return this.database.findByIndex(index); // llamar la accion de buscar por indice.
    }

    // en ruta la accion de crear
    public String create(String name, String description, boolean status){
        return this.database.create(new Task(name, description, status)); // llamar la accion de crear tarea.
    }

    // en ruta la accion de actualizar
    public String update(int index, String name, String description, boolean status){
        return this.database.update(index, new Task (name, description, status)); // llamar la accion de actualizar tarea.
    }

    // en ruta la accion de eliminar
    public String delete (int index){
        return this.database.delete(index);
    }
}