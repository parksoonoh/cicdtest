package cicd.cicdtest.login;

import cicd.cicdtest.entity.Member;
import cicd.cicdtest.function.Security;
import cicd.cicdtest.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;
    private final Security security;

    public String signUp(){
        if (memberRepository.findById(form.getId()).isEmpty()){
            memberRepository.save(new Member(form.getId(), security.loginHashing(form.getPassword()), form.getName()));
            log.info("Insert New User Id : {}", form.getId());
            return "Id Saved";
        }else{
            return "Id Duplicate Error";
        }
    }

    public String login() {
        Optional<Member> findMemberOpt = memberRepository.findById(form.getId());

        if (findMemberOpt.isEmpty()){
            return "User Id No Exist";
        }else{
            Member findMember = findMemberOpt.get();
            if (!findMember.getPassword().equals(security.loginHashing(form.getPassword()))){
                return "Password Error";
            }else{
                log.info("User Login id : {}", form.getId());
                return "Login Success";
            }
        }
    }

}
