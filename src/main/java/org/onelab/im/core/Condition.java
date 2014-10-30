package org.onelab.im.core;

import java.util.Collection;
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
    Map<String,String> match ;

    Map<String,Collection<String>> in ;
    Map<String,Collection<String>> notIn ;

    Condition or = null;
    Condition and = null;

    Condition parent;

    public Condition(){}

    public boolean isEmpty(){
        if (eq!=null&&!eq.isEmpty()) return false;
        if (nq!=null&&!nq.isEmpty()) return false;
        if (gt!=null&&!gt.isEmpty()) return false;
        if (lt!=null&&!lt.isEmpty()) return false;
        if (gte!=null&&!gte.isEmpty()) return false;
        if (lte!=null&&!lte.isEmpty()) return false;
        if (match!=null&&!match.isEmpty()) return false;

        if (in!=null&&!in.isEmpty()) return false;
        if (notIn!=null&&!notIn.isEmpty()) return false;

        if (or!=null&&!or.isEmpty()) return false;
        if (and!=null&&!and.isEmpty()) return false;
        return true;
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

    public Condition match(String name,String regex){
        if (match==null) match = new HashMap<String, String>();
        match.put(name, regex);
        return this;
    }

    public Condition in(String name,Collection<String> values){
        if (in==null) in = new HashMap<String, Collection<String>>();
        in.put(name, values);
        return this;
    }

    public Condition notIn(String name,Collection<String> values){
        if (notIn==null) notIn = new HashMap<String, Collection<String>>();
        notIn.put(name, values);
        return this;
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

    public Map<String, String> getMatch() {
        return match;
    }

    public Map<String, Collection<String>> getIn() {
        return in;
    }

    public Map<String, Collection<String>> getNotIn() {
        return notIn;
    }

    public Condition getOr() {
        return or;
    }

    public Condition getAnd() {
        return and;
    }
}
