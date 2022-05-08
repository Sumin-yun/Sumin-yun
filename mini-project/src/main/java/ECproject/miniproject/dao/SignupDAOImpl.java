package ECproject.miniproject.dao;

import ECproject.miniproject.domain.Member;

public class SignupDAOImpl implements SignupDAO{

  @Inject
  private SqlSession session;

  @Override
  public void insertMember(Member member) {
    session.insert("inserMember", member);
  }
}
