package hello.hello_spring.service.Impl;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
//@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

//    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원 가입
    @Override
    public Long join(Member member) {

        long start = System.currentTimeMillis();

        try {
            //같은 이름의 중복 회원X
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //값이 있으면 로직 동작
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> { //값이 있으면 로직 동작
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

    //전체 회원 조회
    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
