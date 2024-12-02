package serviceImplementationMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositoryInterfaces.InputStreamMethodNamesRepository;
import serviceInterfaceMethods.InputStreamMethodNamesServiceInterfaceMethods;

@Service
public class InputStreamMethodNamesServiceImplementation implements InputStreamMethodNamesServiceInterfaceMethods {

    @Autowired
    private InputStreamMethodNamesServiceInterfaceMethods inputStreamMethodNamesServiceInterfaceMethods;

    @Autowired
    private InputStreamMethodNamesRepository inputStreamMethodNamesRepository;

}
