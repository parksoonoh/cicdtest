package cicd.cicdtest.login;

import cicd.cicdtest.entity.Member;
import cicd.cicdtest.function.Security;
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
public class LoginService {

    private final MemberRepository memberRepository;
    private final Security security;

    public String signUp(Member member){
        if (memberRepository.findById(member.getId()).isEmpty()){
            memberRepository.save(new Member(member.getId(), security.loginHashing(member.getPassword()), member.getName(), 0));
            log.info("Insert New User Id : {}", member.getId());
            return "Id Saved";
        }else{
            log.info("Id Duplicate Error");
            return "Id Duplicate Error";
        }
    }

    public String login(LoginForm form, HttpServletRequest request, Model model) {
        Optional<Member> findMemberOpt = memberRepository.findById(form.getId());

        if (findMemberOpt.isEmpty()){
            log.info("User Id No Exist");
            return "User Id No Exist";
        }else{
            Member findMember = findMemberOpt.get();
            if (!findMember.getPassword().equals(security.loginHashing(form.getPassword()))){
                log.info("Password Error");
                return "Password Error";
            }else{
                HttpSession session = request.getSession();
                session.setAttribute(session.getId(), form.getId());
                log.info("User Login id : {}", form.getId());
                model.addAttribute("member", findMember);
                List<Member> allMember = memberRepository.findAll();
                model.addAttribute("members", allMember);
                return "Login Success";
            }
        }
    }

}
