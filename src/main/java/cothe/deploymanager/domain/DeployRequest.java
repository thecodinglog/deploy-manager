package cothe.deploymanager.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Entity
@Getter
@Setter
public class DeployRequest implements Request {
    @Id
    @GeneratedValue
    private Long deployRequestId;
    @ManyToOne
    private Chain chain;
    private LocalDateTime deployRequestDateTime;
    @ManyToOne
    private User deployRequester;
    private String description;
    @ManyToMany
    @JoinTable(name = "MODIFIED_PROGRAMS_IN_REQUESTED",
            joinColumns = @JoinColumn(name = "DEPLOY_REQUEST_ID", unique = false),
            inverseJoinColumns = @JoinColumn(name = "PROGRAM_ID", unique = false))
    private List<Program> modifiedPrograms;
    @ElementCollection
    @CollectionTable(name = "MODIFIED_FILES", joinColumns = @JoinColumn(name = "DEPLOY_REQUEST_ID"))
    private List<File> modifiedFiles;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;

    public DeployRequest(Chain chain, LocalDateTime deployRequestDateTime, User deployRequester, String description, List<Program> modifiedPrograms, List<File> modifiedFiles, RequestStatus requestStatus) {
        this.chain = chain;
        this.deployRequestDateTime = deployRequestDateTime;
        this.deployRequester = deployRequester;
        this.description = description;
        this.modifiedPrograms = modifiedPrograms;
        this.modifiedFiles = modifiedFiles;
        this.requestStatus = requestStatus;
    }

    public DeployRequest() {
    }

    public void updateRequestStatus(RequestStatus status) {
        this.requestStatus = status;
    }
}