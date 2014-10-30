package org.onelab.im.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 筛选条件
 * Created by chunliangh on 14-10-24.
 */
public class Condition {

    private Operator operator;
    private String name ;
    private String value ;
    private Collection<String> values;

    public static enum Operator {
        EQ,NQ,GT,LT,GTE,LTE,MATCH,IN,NOT_IN
    }
    private Condition or ;
    private Condition and ;
    private Condition parent ;

    public Condition(Operator operator,String name,String value){
        assert operator !=null;
        assert name!=null;
        this.operator = operator;
        this.name = name;
        this.value = value;
    }
    public Condition(Operator operator,String name,Collection<String> values){
        assert operator !=null;
        assert name!=null;
        this.operator = operator;
        this.name = name;
        this.values = values;
    }

    public Condition or(Condition condition){
        assert condition!=this;
        assert condition.parent == null;
        this.or = condition;
        condition.parent = this;
        return this;
    }

    public Condition and(Condition condition){
        assert condition!=this;
        assert condition.parent == null;
        this.and = condition;
        condition.parent = this;
        return this;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public Collection<String> getValues() {
        return values;
    }

    public Condition getOr() {
        return or;
    }

    public Condition getAnd() {
        return and;
    }
}
