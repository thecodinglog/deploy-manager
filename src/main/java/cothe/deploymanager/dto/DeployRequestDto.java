package cothe.deploymanager.dto;

import cothe.deploymanager.domain.*;
import cothe.deploymanager.repository.ProgramRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@AllArgsConstructor
@Getter
public final class DeployRequestDto {
    private final Long deployRequestId;
    private final Chain chain;
    private final LocalDateTime deployRequestDateTime;
    private final User deployRequester;
    private final String description;
    private final String modifiedPrograms;
    private final String modifiedFiles;
    private final RequestStatus requestStatus;

    public DeployRequest toEntity(ProgramRepository programRepository) {
        String[] programIds = modifiedPrograms.split(",");
        List<Program> programs = new
                ArrayList<>();
        for (String programId : programIds) {
            programs.add(programRepository.findById(programId).orElseThrow(() -> new IllegalArgumentException("program id error")));
        }
        return new DeployRequest(
                this.chain,
                this.deployRequestDateTime,
                this.deployRequester,
                this.description,
                programs,
                Arrays.stream(this.modifiedFiles.split(",")).map(s -> new File(s, s)).collect(Collectors.toList()),
                this.requestStatus
        );
    }
}
