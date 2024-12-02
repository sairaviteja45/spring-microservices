package daoImplementationMethods;

import daoInterfaceMethods.InputStreamMethodNamesDaoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class InputStreamMethodNamesDao implements InputStreamMethodNamesDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;
}
