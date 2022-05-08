package ECproject.miniproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ECproject.miniproject.domain.Member;
import ECproject.miniproject.service.MemberService;

@Controller
@RequestMapping("/signup/*")
public class MemberController {
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/members/new")
  public String createForm() {
    return "members/createMemberForm";
  }

  @PostMapping(value="/members/add")
  public String create(MemberForm form) {
    Member member = new Member();
    member.setId(form.getId());  
    member.setName(form.getName());
    //member.setBirth(Date.valueOf(request.getParameter("birthday")))
    member.setAddress(form.getAddress());

    memberService.join(member);

    return "redirect:/";
  }

}
