package org.onelab.im.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 筛选条件
 * Created by chunliangh on 14-10-24.
 */
public class Condition {

    Map<String,String> eq ;
    Map<String,String> nq ;
    Map<String,String> gt ;
    Map<String,String> lt ;
    Map<String,String> gte ;
    Map<String,String> lte ;

    Condition or = null;

    public Condition(){}

    public boolean isEmpty(){
        if (eq!=null&&!eq.isEmpty()) return false;
        if (nq!=null&&!nq.isEmpty()) return false;
        if (gt!=null&&!gt.isEmpty()) return false;
        if (lt!=null&&!lt.isEmpty()) return false;
        if (or!=null&&!or.isEmpty()) return false;
        return true;
    }

    public Condition or(Condition condition){
        this.or = condition;
        return this;
    }

    public Condition eq(String name, String value){
        if (eq==null) eq = new HashMap<String, String>();
        eq.put(name, value);
        return this;
    }

    public Condition nq(String name, String value){
        if (nq==null) nq = new HashMap<String, String>();
        nq.put(name, value);
        return this;
    }

    public Condition gt(String name,String value){
        if (gt==null) gt = new HashMap<String, String>();
        gt.put(name, value);
        return this;
    }

    public Condition lt(String name,String value){
        if (lt==null) lt = new HashMap<String, String>();
        lt.put(name, value);
        return this;
    }

    public Condition gte(String name,String value){
        if (gte==null) gte = new HashMap<String, String>();
        gte.put(name, value);
        return this;
    }

    public Condition lte(String name,String value){
        if (lte==null) lte = new HashMap<String, String>();
        lte.put(name, value);
        return this;
    }

    public Map<String,String> getEq() {
        return eq;
    }

    public Map<String,String> getNq() {
        return nq;
    }

    public Map<String,String> getGt(){
        return gt;
    }

    public Map<String,String> getLt(){
        return lt;
    }

    public Map<String, String> getGte() {
        return gte;
    }

    public Map<String, String> getLte() {
        return lte;
    }

    public Condition getOr() {
        return or;
    }
}
