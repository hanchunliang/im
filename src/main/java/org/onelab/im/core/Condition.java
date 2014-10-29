package org.onelab.im.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 筛选条件
 * Created by chunliangh on 14-10-24.
 */
public class Condition {

    Map<String,String> must = new HashMap<String, String>();
    Map<String,String> or = new HashMap<String,String>();
    Map<String,String> mustNot = new HashMap<String,String>();

    public Condition(){}

    public boolean isEmpty(){
        return must.isEmpty()&&or.isEmpty()&&mustNot.isEmpty();
    }

    public Condition must(String name,String value){
        must.put(name, value);
        return this;
    }

    public Condition or(String name,String value){
        or.put(name, value);
        return this;
    }

    public Condition not(String name,String value){
        mustNot.put(name, value);
        return this;
    }

    public Map<String,String> getMust() {
        return must;
    }

    public Map<String,String> getOr() {
        return or;
    }

    public Map<String,String> getMustNot() {
        return mustNot;
    }
}
