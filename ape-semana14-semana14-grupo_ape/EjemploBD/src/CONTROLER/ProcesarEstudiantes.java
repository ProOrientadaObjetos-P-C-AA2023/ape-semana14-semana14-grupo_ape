package CONTROLER;

import MODEL.Estudiante;
import MODEL.ConeccionDB;
import java.sql.Connection;
import java.util.List;

public class ProcesarEstudiantes {

    public List<Estudiante> lstEstudiantes;
    public ProcesarEstudiantes(List<Estudiante> lstEstudiantes) {
        this.lstEstudiantes = lstEstudiantes;
    }
    public void calculoPromedios() {
        for (Estudiante est : lstEstudiantes) {
            est.promedio = (est.nota1 + est.nota2) / 2;
        }
    }
    public void calculoEstados() {
        for (Estudiante est : lstEstudiantes) {
            est.estado = (est.promedio >= 7) ? "Aprobado" : "Reprobado";
        }
    }
    public void insertarEstudiante(Estudiante estudiante) {
        (new ConeccionDB()).insertarEstudiante(estudiante);
        lstEstudiantes.add(estudiante);
    }
    public List<Estudiante> getLstEstudiantes() {
        return (new ConeccionDB()).getLstEstudiantes();
    }
    public void eliminarEstudiante(String nombreEstudiante) {
        (new ConeccionDB()).eliminarEstudiante(nombreEstudiante);
    }
    public void actualizarEstudiante(Estudiante estudiante) {
        (new ConeccionDB()).actualizarEstudiante(estudiante);
    }
}