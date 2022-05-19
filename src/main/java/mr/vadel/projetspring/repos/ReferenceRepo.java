package mr.vadel.projetspring.repos;

import mr.vadel.projetspring.models.Reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReferenceRepo extends JpaRepository<Reference, Long> {

}
