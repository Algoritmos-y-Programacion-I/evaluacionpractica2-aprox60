package model;

public class Controller {

    private Pillar[] pillars;


    public Controller() {

        pillars = new Pillar[4];
        pillars[0] = new Pillar("Agua");
        pillars[1] = new Pillar("Energía");
        pillars[2] = new Pillar("Tratamiento de Basura");
        pillars[3] = new Pillar("Biodiversidad");

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     * 
     * @return boolean true si se logra añadir el Prject en el Pillar, false en caso
     *         contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description,boolean status) {
        if (pillarType < 0 || pillarType >= pillars.length) {
            System.out.println("Tipo de pilar no válido: " + pillarType);
            return false; 
        }

        Project newProject = new Project(id, name, description, status);
        Pillar pillar = pillars[pillarType];
    
        boolean result = pillar.registerProject(newProject);
        if (result) {
            System.out.println("Proyecto registrado exitosamente: " + name);
        } else {
            System.out.println("Error al registrar el proyecto: " + name);
        }
    
        return result;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios
     * pre: El arreglo edificios debe estar inicializado
     * 
     * @return String cadena en formato lista con la información de los
     * Project registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {

        if (pillarType < 0 || pillarType >= pillars.length) {
            return "Tipo de pilar no válido.";
        }
        Pillar pillar = pillars[pillarType];
        if (pillar == null) {
            return "El pilar no está registrado.";
        }
        String query = pillar.getProjectList(); 
    
        return query;

       

    }

}