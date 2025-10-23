package repositoryInterfaces;

import entityTables.JavaFileMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JavaFileMethodsRepository extends JpaRepository<JavaFileMethods, Integer> {

    JavaFileMethods findByFileMethodName(String fileMethodName);
}
