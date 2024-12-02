package repositoryInterfaces;

import entityTables.FileReadInputStreamClassNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileReadInputStreamClassNamesRepository extends JpaRepository<FileReadInputStreamClassNames, Integer> {

}
