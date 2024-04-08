package cicd.cicdtest;


import cicd.cicdtest.entity.Member;
import cicd.cicdtest.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CICDTestService {
    private final MemberRepository memberRepository;


    public String increase(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String findMemberId = String.valueOf(session.getAttribute(session.getId()));
        Optional<Member> findMemberOpt = memberRepository.findById(findMemberId);
        if (findMemberOpt.isEmpty()){
            log.info("findMember EMPTY");
            return "redirect:/";
        }
        else{
            Member findMember = findMemberOpt.get();
            findMember.addMoney();
            memberRepository.save(findMember);
            log.info("{} add Money", findMemberId);
            model.addAttribute("member", findMember);
            List<Member> allMember = memberRepository.findAll();
            model.addAttribute("members", allMember);
            return "./click";
        }
    }

}
