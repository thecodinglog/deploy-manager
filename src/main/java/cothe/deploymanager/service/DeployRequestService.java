package cothe.deploymanager.service;

import cothe.deploymanager.domain.*;
import cothe.deploymanager.dto.DeployRequestDto;
import cothe.deploymanager.repository.DeployRequestRepository;
import cothe.deploymanager.repository.ProgramRepository;
import cothe.deploymanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Service
public class DeployRequestService {
    @Autowired
    DeployRequestRepository deployRequestRepository;
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    UserRepository userRepository;

    public List<DeployRequestDto> getDeployRequests() {
        List<DeployRequestDto> deployRequestDtos = new ArrayList<>();
        List<DeployRequest> all = deployRequestRepository.findAll();

        for (DeployRequest deployRequest : all) {
            DeployRequestDto dto = new DeployRequestDto(
                    deployRequest.getDeployRequestId(),
                    deployRequest.getChain(),
                    deployRequest.getDeployRequestDateTime(),
                    deployRequest.getDeployRequester(),
                    deployRequest.getDescription(),
                    deployRequest.getModifiedPrograms().stream().map(Program::getProgramId)
                            .collect(Collectors.joining(", ")),
                    deployRequest.getModifiedFiles().stream().map(File::getFile).collect(Collectors.joining(",")),
                    deployRequest.getRequestStatus()
            );
            deployRequestDtos.add(dto);

        }
        return deployRequestDtos;
    }

    public DeployRequest addDeployRequest(DeployRequestDto requestDto) {
        DeployRequest deployRequest = requestDto.toEntity(programRepository);

        User kjj = userRepository.findByUserName("kjj");
        deployRequest.setDeployRequester(kjj);
        deployRequest.setDeployRequestDateTime(LocalDateTime.now());
        deployRequest.setRequestStatus(RequestStatus.REQUESTED);

        DeployRequest request = deployRequestRepository.save(deployRequest);
        return request;
    }

    public DeployRequest updateRequestStatusToConfirms(DeployRequestDto deployRequestDto) {
        DeployRequest deployRequest = deployRequestRepository.findById(deployRequestDto.getDeployRequestId()).orElseThrow(() -> new IllegalArgumentException("no id"));
        deployRequest.updateRequestStatus(RequestStatus.CONFIRM);

        return deployRequest;
    }

    public void removeRqquest(){


    }
}
