package cn.lgw.learn.aspect;


import cn.lgw.learn.enums.ExceptionEnum;
import cn.lgw.learn.exception.CommonException;
import cn.lgw.learn.to.resp.RestResponse;
import cn.lgw.learn.util.LogUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * Controller切面逻辑
 * <p>
 * 1. 请求参数统一校验(待定）；<br>
 * 2. 输入出参数日志打印；<br>
 * 3. 异常响应结果格式化。
 * </p>
 */
@Slf4j
@Aspect
@Component
public class ControllerAspect {
                   //..往下面继续匹配所有目录，.当前目录，×通配符
    @Pointcut(value = "execution(public * cn.lgw.learn.controller..*.*(..))")
    public void doSomething() {
    }

    @Around("doSomething()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
//         反射获取类名
        String controllerName = joinPoint.getTarget().getClass().getSimpleName();
//        反射获取方法名
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();

        // 输入日志
        log.info("[Controller({})] {}, input=[{}]",
//         JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,
//         就可以获取到封装了该方法信息的JoinPoint对象
                controllerName, methodName, LogUtil.buildLogFromArgs((joinPoint.getArgs()))); //获取传入目标方法的参数对象

        Object result;
        try {
            result = joinPoint.proceed();  //执行目标方法

            log.info("[Controller({})] {}, output=[{}]",
                    controllerName, methodName, JSON.toJSONString(result));

        } catch (CommonException e) {
            log.info("[Controller({})] {}, throw exception code={} message={}",
                    controllerName, methodName, e.getCode(), e.getMessage());
            return RestResponse.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            log.info("[Controller({})] {}, throw unmatchable exception message={}",
                    controllerName, methodName, e.getMessage());
            return RestResponse.serverError(ExceptionEnum.SERVER_ERROR.getMessage());
        }

        return result;
    }


//    @Aspect
//    @Component
//    public class aopAspect {
//        /**
//         * 定义一个切入点表达式,用来确定哪些类需要代理
//         * execution(* aopdemo.*.*(..))代表aopdemo包下所有类的所有方法都会被代理
//         */
//        @Pointcut("execution(* aopdemo.*.*(..))")
//        public void declareJoinPointerExpression() {}
//
//        /**
//         * 前置方法,在目标方法执行前执行
//         * @param joinPoint 封装了代理方法信息的对象,若用不到则可以忽略不写
//         */
//        @Before("declareJoinPointerExpression()")
//        public void beforeMethod(JoinPoint joinPoint){
//            System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
//            System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
//            System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
//            System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
//            //获取传入目标方法的参数
//            Object[] args = joinPoint.getArgs();
//            for (int i = 0; i < args.length; i++) {
//                System.out.println("第" + (i+1) + "个参数为:" + args[i]);
//            }
//            System.out.println("被代理的对象:" + joinPoint.getTarget());
//            System.out.println("代理对象自己:" + joinPoint.getThis());
//        }
//
//        /**
//         * 环绕方法,可自定义目标方法执行的时机
//         * @param pjd JoinPoint的子接口,添加了
//         *            Object proceed() throws Throwable 执行目标方法
//         *            Object proceed(Object[] var1) throws Throwable 传入的新的参数去执行目标方法
//         *            两个方法
//         * @return 此方法需要返回值,返回值视为目标方法的返回值
//         */
//        @Around("declareJoinPointerExpression()")
//        public Object aroundMethod(ProceedingJoinPoint pjd){
//            Object result = null;
//
//            try {
//                //前置通知
//                System.out.println("目标方法执行前...");
//                //执行目标方法
//                //result = pjd.proeed();
//                //用新的参数值执行目标方法
//                result = pjd.proceed(new Object[]{"newSpring","newAop"});
//                //返回通知
//                System.out.println("目标方法返回结果后...");
//            } catch (Throwable e) {
//                //异常通知
//                System.out.println("执行目标方法异常后...");
//                throw new RuntimeException(e);
//            }
//            //后置通知
//            System.out.println("目标方法执行后...");
//
//            return result;
//        }
//    }
}
