package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect //시간측정 공통 로직
@Component
public class TimeTraceAop {
    //hello.hellospring 하위 파일에 모두 적용
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        Long start = System.currentTimeMillis();
        System.out.println("시작시간: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            Long finish = System.currentTimeMillis();
            Long timeMs = finish - start; //종료시간 - 시작시간
            System.out.println("소요시간: " + joinPoint.toString() + timeMs + "Ms");
        }
    }
}
