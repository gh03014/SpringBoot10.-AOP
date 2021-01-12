package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//다중상속
// 스프링 데이터 JPA가 인터페이스 구현체를 만들고 자동으로 스프링 빈에 등록하도록 한다
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
