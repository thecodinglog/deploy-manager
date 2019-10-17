package cothe.deploymanager.service;

import cothe.deploymanager.domain.*;
import cothe.deploymanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Jeongjin Kim
 * @since 2019-10-15
 */
@Configuration
public class Startup {
    @Autowired
    DeployRequestRepository deployRequestRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ChainRepository chainRepository;
//    @Autowired
//    FileRepository fileRepository;
    @Autowired
    ProgramRepository programRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void settingDefaultData() {
//        File file_newfile = fileRepository.save(new File("newfile.java", "newfile.java"));
//        File file_newfile2 = fileRepository.save(new File("newfile2.java", "newfile2.java"));
//
        User user_kjj = userRepository.save(new User("kjj"));
//
        Chain chain_m47 = chainRepository.save(new Chain("M47", "조업관리"));
        Chain chain_m26 = chainRepository.save(new Chain("M26", "구내운송"));
        Chain chain_m30 = chainRepository.save(new Chain("M30", "부재료관리"));

        Program program_p1 = programRepository.save(new Program("p1", chain_m26, "p1_name"));
        Program program_p2 = programRepository.save(new Program("p2", chain_m47, "p2_name"));
        Program program_p3 = programRepository.save(new Program("p3", chain_m30, "p3_name"));


//        Chain chain_m47 = new Chain("M47", "조업관리");
//        Chain chain_m30 = new Chain("M30", "부재료관리");
//        Chain chain_m26 = new Chain("M26", "구내운송");
//        Program program_p2 = new Program("p2", chain_m47, "p2_name");
//        Program program_p3 = new Program("p3", chain_m30, "p3_name");
//        Program program_p1 = new Program("p1", chain_m26, "p1_name");
        File file_newfile = new File("newfile.java", "newfile.java");
        File file_newfile2 = new File("newfile2.java", "newfile2.java");

        deployRequestRepository.save(
                new DeployRequest(
                        chain_m26,
                        LocalDateTime.now(),
                        user_kjj,
                        "디플로이",
                        Arrays.asList(program_p1, program_p2),
                        Arrays.asList(file_newfile2),
                        RequestStatus.REQUESTED));
        deployRequestRepository.save(
                new DeployRequest(
                        chain_m47,
                        LocalDateTime.now(),
                        user_kjj,
                        "디플로이 하자",
                        Arrays.asList(program_p3),
                        Arrays.asList(file_newfile2),
                        RequestStatus.CONFIRM));
    }
}
