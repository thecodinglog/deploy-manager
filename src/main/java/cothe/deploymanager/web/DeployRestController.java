package cothe.deploymanager.web;

import cothe.deploymanager.domain.DeployRequest;
import cothe.deploymanager.dto.DeployRequestDto;
import cothe.deploymanager.repository.DeployRequestRepository;
import cothe.deploymanager.repository.UserRepository;
import cothe.deploymanager.service.DeployRequestService;
import cothe.deploymanager.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@RestController
public class DeployRestController {
    @Autowired
    DeployRequestRepository deployRequestRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DeployRequestService deployRequestService;
    @Autowired
    SampleService sampleService;

    @PostMapping("/request_deploy")
    public DeployRequest listDeployRequests(DeployRequestDto requestDto) {
        return deployRequestService.addDeployRequest(requestDto);
    }

    @PostMapping("/confirm")
    public DeployRequest updateDeployRequest(DeployRequestDto requestDto) {
        return deployRequestService.updateRequestStatusToConfirms(requestDto);
    }
}
