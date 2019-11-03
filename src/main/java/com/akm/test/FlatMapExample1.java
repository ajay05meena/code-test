package com.akm.test;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.Iterator;
import java.util.UUID;

public class FlatMapExample1 {

    private Flowable<UUID> getNUuids(int N){
        return Flowable.fromCallable(UUID::randomUUID)
                .repeat()
                .take(N);
    }
    
    public void runUsingSubscribe(){
        Flowable<UUID> nUuids = getNUuids(20);
        nUuids.subscribe(id -> slowProdcess(id));
    }

    public void runUsingMap(){
        getNUuids(20).map(id -> slowProdcess(id)).subscribe();
    }

    public void runUsingMapOnDifferentThread(){
        getNUuids(20).subscribeOn(Schedulers.io()).map(id -> slowProdcess(id)).subscribe();
    }

    public void runUsingFlatMap(){
        getNUuids(20).subscribeOn(Schedulers.io()).flatMap(id -> asyncSlowProcess(id)).subscribe();
    }

    private Flowable<String> asyncSlowProcess(UUID id){
        return Flowable.fromCallable(() -> slowProdcess(id));
    }

    private String slowProdcess(UUID id) {
        try {
            Thread.sleep(100);
            System.out.println("Run by thread " + Thread.currentThread().getName() + " value " + id.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "done";
    }


}
