package org.koreait.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Order(2)
// @Aspect = Proxy Class 임을 명시하는 Annotation
@Aspect
public class SpringProxyCalculator {

    // 반환값 *(전체)
    // 적용대상 ..*(해당 패키지 포함한 하위 패키지의 모든 클래스)
    // 메서드 (..) 모든 메서드..?


   /* @Before("publicTarget()")
    public void beforeProcess(JoinPoint joinPoint) throws Throwable{
        System.out.println("@Before!!");
    }

    @After("publicTarget()")
    public void afterProcess(JoinPoint joinPoint) throws Throwable{
        System.out.println("@After!!");
    }*/

//    @Around("publicTarget()")
    @Around("CommonPointcut.pulicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable{

        long stime = System.nanoTime();
        try {
        Object result = joinPoint.proceed(); // 핵심 기능을 대신 수행

        System.out.println("호출!!");

        return result;

        }finally {
            long etime = System.nanoTime();
            System.out.printf("걸린시간 : %d%n", etime - stime);
        }
    }
}
