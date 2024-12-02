package daoImplementationMethods;

import daoInterfaceMethods.JavaFileMethodsDaoInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class JavaFileMethodsDao implements JavaFileMethodsDaoInterface {

    @PersistenceContext
    private EntityManager entityManager;
}
