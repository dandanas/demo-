package com.dandan.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Objects;

/**
 * @date：2020/12/7
 * @author：suchao
 */
@Slf4j
public class ReflectionUtil {

    /**
     * 获取指定对象的指定属性名的值，此属性必须有getter 方法，否则无法访问，属性名支持级联访问，如：obj1.obj2.name
     *
     * @param target
     * @param fieldName
     */
    public static Object getFieldValue(Object target, String fieldName) {
        if (target == null) {
            return null;
        }
        String[] fieldNames = splitFields(fieldName);
        if (Objects.nonNull(fieldNames)) {
            Object innerObject = getFieldValue(target, fieldNames[0]);
            return getFieldValue(innerObject, fieldNames[1]);
        } else {
            PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(target.getClass(), fieldName);
            if (pd == null) {
                throw new NullPointerException(fieldName + " not included in class " + target.getClass().getName());
            }
            try {
                return pd.getReadMethod().invoke(target, new Object[0]);
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("invoke readMethod:[%s] of class:[%s] failed."
                        , pd.getReadMethod(), target.getClass().getName()), e);
            }
        }
    }

    private static String[] splitFields(String fieldName) {
        int index = fieldName.indexOf(".");
        int length = fieldName.length();
        if (index > 0 && index < length - 1) {
            String prefix = fieldName.substring(0, index);
            String suffix = fieldName.substring(index + 1, length);
            return new String[]{prefix, suffix};
        }
        return null;
    }

    /**
     * 设置指定对象的指定属性名的值，此属性必须有setter 方法，否则无法访问，属性名支持级联访问，如：obj1.obj2.name
     *
     * @param target
     * @param fieldName
     */
    public static void setFieldValue(Object target, String fieldName, Object value) {
        if (target == null) {
            return;
        }
        String[] fieldNames = splitFields(fieldName);
        if (Objects.nonNull(fieldNames)) {
            Object innerObject = getFieldValue(target, fieldNames[0]);
            setFieldValue(innerObject, fieldNames[1], value);
        } else {
            PropertyDescriptor pd = org.springframework.beans.BeanUtils.getPropertyDescriptor(target.getClass(), fieldName);
            if (pd == null) {
                throw new NullPointerException(fieldName + " not included in class " + target.getClass().getName());
            }
            try {
                pd.getWriteMethod().invoke(target, new Object[]{value});
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format("invoke writeMethod:[%s] of class:[%s] failed."
                        , pd.getWriteMethod(), target.getClass().getName()), e);
            }
        }
    }


    /**
     * 获取注解，如果是方法而且方法上没有该注解则从类上获取
     */
    public static <A extends Annotation> A getAnnotation(AnnotatedElement annotatedElement, Class<A> annType) {
        A ann = AnnotationUtils.getAnnotation(annotatedElement, annType);
        if (ann == null && annotatedElement instanceof Method) {
            ann = AnnotationUtils.getAnnotation(((Method) annotatedElement).getDeclaringClass(), annType);
        }
        return ann;
    }

    /**
     * 获取参数值，如果方法有指定名称的参数，没有则从第一个参数的字段里拿
     */
    public static Object getArgValue(Object[] args, Method method, String fieldName) {
        Object value = null;
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < method.getParameters().length; i++) {
            Parameter parameter = parameters[i];
            if (Objects.equals(parameter.getName(), fieldName)) {
                value = args[i];
            }
        }
        if (value == null) {
            Class<?> type = method.getParameters()[0].getType();
            Field field = ReflectionUtils.findField(type, fieldName);
            if (field == null) {
                log.debug("找不到字段 {}", fieldName);
                return null;
            }
            field.setAccessible(true);
            value = ReflectionUtils.getField(field, args[0]);
        }
        return value;
    }

    /**
     * 检查是否包含某个参数
     */
    public static boolean hasArg(Object[] args, Method method, String fieldName) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < method.getParameters().length; i++) {
            Parameter parameter = parameters[i];
            if (Objects.equals(parameter.getName(), fieldName)) {
                return true;
            }
        }
        if (args[0] == null) {
            return false;
        }
        Class<?> type = method.getParameters()[0].getType();
        Field field = ReflectionUtils.findField(type, fieldName);
        return field != null;
    }

    /**
     * 设置参数值，如果方法有指定名称的参数，没有则从第一个参数的字段里拿
     */
    public static void setArgValue(Object[] args, Method method, String fieldName, Object value) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < method.getParameters().length; i++) {
            Parameter parameter = parameters[i];
            if (Objects.equals(parameter.getName(), fieldName)) {
                args[i] = value;
            }
        }
        if (args[0] == null) {
            return;
        }
        Class<?> type = method.getParameters()[0].getType();
        Field field = ReflectionUtils.findField(type, fieldName);
        if (field == null) {
            log.debug("找不到字段 {}", fieldName);
            return;
        }
        field.setAccessible(true);
        ReflectionUtils.setField(field, args[0], value);
    }


}
