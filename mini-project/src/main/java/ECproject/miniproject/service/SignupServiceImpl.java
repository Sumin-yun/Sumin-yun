package ECproject.miniproject.service;

import org.springframework.stereotype.Service;
import ECproject.miniproject.dao.SignupDAO;
import ECproject.miniproject.domain.Member;

@Service
public class SignupServiceImpl implements SignupSerivice{

  @Inject
  private SignupDAO dao;

  @Override
  public void insertMember(Member member) {
    dao.insertMember(member);
  }


}
