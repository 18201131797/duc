package com.redis.core;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

/**
 * @description:切换核心代码
 * @author: liwt
 * @date: 2020/2/28 14:20
 * @version: 1.0.1
 */
@Component
public class RedisSpElProcessor extends RedisConfiguration {

    private DefaultParameterNameDiscoverer discoverer = new DefaultParameterNameDiscoverer();

    private ExpressionParser parser = new SpelExpressionParser();


    /**
     * @param
     * @return
     * @description:spel转换
     * @author liwt
     * @date 2020/2/29 15:11
     * @version 1.0.1
     */
    public String generateSpEL(String spELString, ProceedingJoinPoint joinPoint) throws Exception {
        if (StringUtils.isBlank(spELString)) {
            throw new Exception("Cache name must not be null");
        }
        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            String[] paramNames = discoverer.getParameterNames(methodSignature.getMethod());
            Expression expression = parser.parseExpression(spELString);
            EvaluationContext context = new StandardEvaluationContext();
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                context.setVariable(paramNames[i], args[i]);
            }
            spELString = expression.getValue(context).toString();
            //自定义前缀
            String prefix = redisConstant.getPrefix();
            spELString = prefix.concat(":").concat(spELString);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return spELString;
    }


}
