package alex.example.projectboard.service;

import alex.example.projectboard.domain.ProjectTask;
import alex.example.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask saveOrUpdateProjectTask(ProjectTask projectTask){
        if(projectTask.getStatus()==null || projectTask.getStatus().equals("")){
            projectTask.setStatus("TO DO");
        }
        return projectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findAll(){
        return projectTaskRepository.findAll();
    }

    public ProjectTask findById(Long id){
        return projectTaskRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
        ProjectTask projectTask = findById(id);
        projectTaskRepository.delete(projectTask);
    }
}
