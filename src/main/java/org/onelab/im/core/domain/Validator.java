package org.onelab.im.core.domain;

import org.onelab.im.core.Condition;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 数据验证器
 * 验证数据是否符合条件
 * Created by chunliangh on 14-10-31.
 */
public class Validator {

    public static boolean validate(Condition condition,Map<String,String> data){
        boolean res = true;
        switch (condition.getOperator()){
            case EQ:
                res = eq(data,condition);
                break;
            case NQ:
                res = nq(data, condition);
                break;
            case GT:
                res = gt(data, condition);
                break;
            case LT:
                res = lt(data, condition);
                break;
            case GE:
                res = gte(data, condition);
                break;
            case LE:
                res = lte(data, condition);
                break;
            case MATCH:
                res = match(data, condition);
                break;
            case IN:
                res = in(data, condition);
                break;
            case NOT_IN:
                res = notIn(data, condition);
                break;
        }
        List<Condition> and = condition.getAnd();
        if (res && and!=null){
            for (Condition c:and){
                res = validate(c, data);
                if (!res) break;
            }
        }
        List<Condition> or = condition.getOr();
        if (!res && or!=null){
            for (Condition c:or){
                res = validate(c, data);
                if (res) break;
            }
        }
        return res;
    }
    //如果相比较的两元素同为null认为相等
    private static boolean eq(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_2!=null){
            if (!val_2.equals(val_1)) return false;
        }else{
            if (val_1!=null) return false;
        }
        return true;
    }
    //如果相比较的两元素同为null认为相等
    private static boolean nq(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_2!=null){
            if (val_2.equals(val_1)) return false;
        }else{
            if (val_1==null) return false;
        }
        return true;
    }
    //如果相比较的两元素存在null认为没有比较关系，返回false
    private static boolean gt(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_1==null || val_2==null) return false;
        try {
            BigDecimal v1 = new BigDecimal(val_1);
            BigDecimal v2 = new BigDecimal(val_2);
            if (v2.compareTo(v1)>=0) return false;
        } catch (NumberFormatException e){
            if (val_2.compareTo(val_1)>=0) return false;
        }
        return true;
    }
    //如果相比较的两元素存在null认为没有比较关系，返回false
    private static boolean lt(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_1==null || val_2==null) return false;
        try {
            BigDecimal v1 = new BigDecimal(val_1);
            BigDecimal v2 = new BigDecimal(val_2);
            if (v2.compareTo(v1)<=0) return false;
        } catch (NumberFormatException e){
            if (val_2.compareTo(val_1)<=0) return false;
        }
        return true;
    }
    //如果相比较的两元素存在null认为没有比较关系，返回false
    private static boolean gte(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_1==null || val_2==null) return false;
        try {
            BigDecimal v1 = new BigDecimal(val_1);
            BigDecimal v2 = new BigDecimal(val_2);
            if (v2.compareTo(v1)>0) return false;
        } catch (NumberFormatException e){
            if (val_2.compareTo(val_1)>0) return false;
        }
        return true;
    }
    //如果元素存在null认为没有比较关系，返回false
    private static boolean lte(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_1==null || val_2==null) return false;
        try {
            BigDecimal v1 = new BigDecimal(val_1);
            BigDecimal v2 = new BigDecimal(val_2);
            if (v2.compareTo(v1)<0) return false;
        } catch (NumberFormatException e){
            if (val_2.compareTo(val_1)<0) return false;
        }
        return true;
    }
    //如果相比较的两元素存在null认为没有比较关系，返回false
    private static boolean match(Map<String, String> map, Condition condition) {
        String val_1 = map.get(condition.getName());
        String val_2 = condition.getValue();
        if (val_1==null || val_2==null) return false;
        if (!val_1.matches(val_2)) return false;
        return true;
    }
    private static boolean in(Map<String, String> map, Condition condition){
        Collection<String> val_2 = condition.getValues();
        if (val_2!=null){
            if (!val_2.contains(map.get(condition.getName()))) return false;
        } else {
            return false;
        }
        return true;
    }
    private static boolean notIn(Map<String, String> map, Condition condition){
        Collection<String> val_2 = condition.getValues();
        if (val_2!=null){
            if (val_2.contains(map.get(condition.getName()))) return false;
        }
        return true;
    }
}
