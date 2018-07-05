package gr.pr.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.get*(..))")
	private void getters() {}
	
	@Pointcut("execution(* gr.pr.udemy.spring.aop.dao.*.set*(..))")
	private void setters() {}
	
	@Pointcut("forDaoPackage() && !(getters() || setters())")
	private void forDaoPackgeNotGettersSetters() {}
	
	@Before("forDaoPackgeNotGettersSetters()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Executing @Before advice on AddAccount()");
	}
	
	@Before("forDaoPackgeNotGettersSetters()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing Api Analytics");
	}
}
