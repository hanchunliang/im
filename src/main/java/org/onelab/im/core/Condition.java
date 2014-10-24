package org.onelab.im.core;

import java.util.ArrayList;
import java.util.List;

/**
 * 筛选条件
 * Created by chunliangh on 14-10-24.
 */
public class Condition {

    String name;
    String value;

    List<Condition> and = new ArrayList<Condition>();
    List<Condition> or = new ArrayList<Condition>();
    List<Condition> not = new ArrayList<Condition>();

    public Condition(String name,String value){
        this.name = name;
        this.value = value;
    }

    public Condition and(Condition condition){
        and.add(condition);
        return this;
    }

    public Condition or(Condition condition){
        or.add(condition);
        return this;
    }

    public Condition not(Condition condition){
        not.add(condition);
        return this;
    }
}
