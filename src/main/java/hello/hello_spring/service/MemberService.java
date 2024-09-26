package hello.hello_spring.service;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    Long join(Member member);

    //전체 회원 조회
    List<Member> findMembers();

    Optional<Member> findOne(Long memberId);
}
