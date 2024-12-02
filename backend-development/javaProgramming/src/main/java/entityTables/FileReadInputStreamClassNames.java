package entityTables;

import jakarta.persistence.*;

@Entity
@Table(name = "file_read_input_stream_methods")
public class FileReadInputStreamClassNames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_input_stream_class_id")
    private Integer fileInputStreamClassId;

    @Column(name = "file_input_stream_class_name")
    private String fileInputStreamClassName;

    public Integer getFileInputStreamClassId() {
        return fileInputStreamClassId;
    }

    public void setFileInputStreamClassId(Integer fileInputStreamClassId) {
        this.fileInputStreamClassId = fileInputStreamClassId;
    }

    public String getFileInputStreamClassName() {
        return fileInputStreamClassName;
    }

    public void setFileInputStreamClassName(String fileInputStreamClassName) {
        this.fileInputStreamClassName = fileInputStreamClassName;
    }
}
