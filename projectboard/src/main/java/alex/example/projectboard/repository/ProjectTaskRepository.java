package alex.example.projectboard.repository;

import alex.example.projectboard.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

}
