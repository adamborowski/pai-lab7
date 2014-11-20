/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.adamborowski.pai.lab7.toa;

import java.util.Collection;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.adamborowski.pai.lab7.persistence.Project;
import pl.adamborowski.pai.lab7.persistence.ProjectManager;

@Stateless
@LocalBean
public class ProjectDetailsAssembler {

    @PersistenceContext
    private EntityManager em;

    public ProjectDetailsAssembly getData(Long projectId) {
        // Tworzenie złożonego obiektu danych
        ProjectDetailsAssembly pData = new ProjectDetailsAssembly();
        // Pobieranie danych projektu
        Project project = em.find(Project.class, projectId);
        Project projTO = project;//nie musimy tworzyć TransferObject, gdyż J2EE sam wygeneruje WSDL i użyje tej klasy
        // Dodawanie danych projektu do złożonego obiektu danych
        pData.projectData = projTO;
        // Pobieranie danych menedżera projektu
        ProjectManager projectManager = em.find(ProjectManager.class, projTO.getManager().getId());
        ProjectManager projMgrTO = projectManager;
        // Dodawanie danych menedżera do złożonego obiektu danych
        pData.projectManagerData = projMgrTO;
        // Pobieranie listy projektów
        Collection projTaskList = project.getTasks();
        // Tworzenie listy zasobów dla zadania

        // Dodanie listy zadań do obiektu złożonego
        pData.listOfTasks = projTaskList;
        // Pobieranie innych danych obiektu transferowego

        // Zwracany złożony obiekt danych
        return pData;
    }
}
