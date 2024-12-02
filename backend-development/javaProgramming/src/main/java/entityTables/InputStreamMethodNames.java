package entityTables;

import jakarta.persistence.*;

@Entity
@Table(name = "input_stream_method_name")
public class InputStreamMethodNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "input_stream_method_id")
    private Integer inputStreamMethodId;

    @Column(name = "input_stream_method_name")
    private String inputStreamMethodName;

    @OneToOne
    @JoinColumn(name = "file_input_stream_class_id", referencedColumnName = "file_input_stream_class_id")
    private FileReadInputStreamClassNames fileReadInputStreamClassNames;

    public Integer getInputStreamMethodId() {
        return inputStreamMethodId;
    }

    public void setInputStreamMethodId(Integer inputStreamMethodId) {
        this.inputStreamMethodId = inputStreamMethodId;
    }

    public String getInputStreamMethodName() {
        return inputStreamMethodName;
    }

    public void setInputStreamMethodName(String inputStreamMethodName) {
        this.inputStreamMethodName = inputStreamMethodName;
    }

    public FileReadInputStreamClassNames getFileReadInputStreamClassNames() {
        return fileReadInputStreamClassNames;
    }

    public void setFileReadInputStreamClassNames(FileReadInputStreamClassNames fileReadInputStreamClassNames) {
        this.fileReadInputStreamClassNames = fileReadInputStreamClassNames;
    }
}
