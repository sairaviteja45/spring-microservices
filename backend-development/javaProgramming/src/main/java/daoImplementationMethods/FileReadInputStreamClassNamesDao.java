package daoImplementationMethods;

import daoInterfaceMethods.FileReadInputStreamClassNamesDaoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class FileReadInputStreamClassNamesDao implements FileReadInputStreamClassNamesDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;

}
