package br.com.eduardoklitzkee.todolist.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.ObjectError;

public class Utils {

    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    //VAI PEGAR TUDO QUE É NULO E VAI ATRIBUIR INFORMAÇÔES ANTERIORES

    public static String [] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        
        Set<String> emptyNames = new HashSet<>();

        for(PropertyDescriptor pd: pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if(srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);

    }
    
}
