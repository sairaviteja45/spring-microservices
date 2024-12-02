package entityTables;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "java_file_methods")
public class JavaFileMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "file_method_name")
    @NotBlank(message = "Please Enter the FileMethodName")
    private String fileMethodName;

    @Column(name = "method_description")
    @NotBlank(message = "Please Enter the FileMethodDescription")
    private String methodDescription;

    @Column(name = "method_response")
    @NotBlank(message = "Please Enter the FileMethodResponse")
    private String methodResponse;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileMethodName() {
        return fileMethodName;
    }

    public void setFileMethodName(String fileMethodName) {
        this.fileMethodName = fileMethodName;
    }

    public String getMethodDescription() {
        return methodDescription;
    }

    public void setMethodDescription(String methodDescription) {
        this.methodDescription = methodDescription;
    }

    public String getMethodResponse() {
        return methodResponse;
    }

    public void setMethodResponse(String methodResponse) {
        this.methodResponse = methodResponse;
    }
}
