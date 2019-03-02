package mybatis.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


public class PojoAspectJ {
	
	public PojoAspectJ() {
		System.out.println("::PojoAspectJ Default Constructor");
	}
	
	
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("[Around before]"+getClass()+".invoke() start.........");
		System.out.println("[Around before] Ÿ�� ��ü : "+joinPoint.getTarget().getClass().getName());
		System.out.println("[Around before] Ÿ�� ��ü�� ȣ�� �� method : "+joinPoint.getSignature().getName());
		
		if(joinPoint.getArgs().length!=0) {
			System.out.println("[Around before] Ÿ�� ��ü�� ȣ�� �� method�� ���޵Ǵ� ���� : "+joinPoint.getArgs()[0]);
		}
		
		Object obj=joinPoint.proceed();
		
		System.out.println("[Around after] Ÿ�� ��ü�� ȣ���� return value : "+obj);
		System.out.println("[Around after]"+getClass()+"invoke() end............");
		
		return obj;
	}
	

}
