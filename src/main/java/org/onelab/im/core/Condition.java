package org.onelab.im.core;

import java.util.*;

/**
 * 筛选条件
 * Created by chunliangh on 14-10-24.
 */
public class Condition {

    public enum Operator {
        EQ,NE,GT,LT,GE,LE,MT,IN,NI
    }

    private Operator operator;

    private String name ;
    private String value ;
    private Collection<String> values;

    private List<Condition> or ;
    private List<Condition> and ;

    private Condition parent ;

    public Condition(){}

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
    public boolean isEmpty(){
        if (this.operator!=null || this.and!=null || this.or!=null) {
            return false;
        }
        return true;
    }
    public Condition or(Condition condition){
        assert condition!=this;
        assert condition.parent == null;
        if (or==null) or = new LinkedList<Condition>();
        or.add(condition);
        condition.parent = this;
        return this;
    }

    public Condition and(Condition condition){
        assert condition!=this;
        assert condition.parent == null;
        if (and==null) and = new LinkedList<Condition>();
        and.add(condition);
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

    public List<Condition> getOr() {
        return or;
    }

    public List<Condition> getAnd() {
        return and;
    }
}
