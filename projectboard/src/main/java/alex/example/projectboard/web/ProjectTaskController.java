package alex.example.projectboard.web;

import alex.example.projectboard.domain.ProjectTask;
import alex.example.projectboard.service.ProjectTaskService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/board")
@CrossOrigin
public class ProjectTaskController {

    @Autowired
    private ProjectTaskService projectTaskService;

    @PostMapping("")
    public ResponseEntity<?> addProjectToBoard(@Valid @RequestBody ProjectTask projectTask, BindingResult result) {
        ResponseEntity<?> responseEntity;
        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            responseEntity = new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        } else {
            ProjectTask newProject = projectTaskService.saveOrUpdateProjectTask(projectTask);
            responseEntity = new ResponseEntity<ProjectTask>(newProject, HttpStatus.CREATED);
        }
        return responseEntity;
    }

    @GetMapping("/all")
    public Iterable<ProjectTask> getAllProjectTasks(){
        return projectTaskService.findAll();
    }

    @GetMapping("/{pt_id}")
    public ResponseEntity<?> getProjectTaskById(@PathVariable Long pt_id){
        ProjectTask projectTask = projectTaskService.findById(pt_id);
        return new ResponseEntity<ProjectTask>(projectTask, HttpStatus.OK);
    }

    @DeleteMapping("/{pt_id}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable Long pt_id){
        projectTaskService.delete(pt_id);
        return new ResponseEntity<String>("Project Task deleted", HttpStatus.OK);
    }
}
