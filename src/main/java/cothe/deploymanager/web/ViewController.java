package cothe.deploymanager.web;

import cothe.deploymanager.domain.DeployRequest;
import cothe.deploymanager.dto.DeployRequestDto;
import cothe.deploymanager.service.DeployRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Controller
public class ViewController {
    @Autowired
    DeployRequestService deployRequestService;

    @GetMapping("/requests")
    public String requestsView(Model model) {
        List<DeployRequestDto> deployRequests = deployRequestService.getDeployRequests();

        model.addAttribute("requests", deployRequests);
        return "requests";
    }
    @GetMapping("/request")
    public String deployRequestView(){
        return "request_deploy";
    }

}
