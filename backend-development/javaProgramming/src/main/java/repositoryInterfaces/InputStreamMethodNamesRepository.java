package repositoryInterfaces;

import entityTables.InputStreamMethodNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputStreamMethodNamesRepository extends JpaRepository<InputStreamMethodNames, Integer> {
}
