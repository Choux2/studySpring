package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.service.Impl.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberServiceImpl memberService;

    @Autowired
    public MemberController(MemberServiceImpl memberService) {
        this.memberService = memberService;
        System.out.println("memberService =" + memberService.getClass());
    }

    @GetMapping("/members/new")
    public String creatForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
