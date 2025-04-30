package com.java.reactive.day4;

import com.java.reactive.utils.Singleton;
import com.java.reactive.utils.Utils;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class EGenerate {
    public static void main(String[] args) {
//        Flux.create(fluxSink -> {
//           fluxSink.next(11);
//           fluxSink.next(22);
//           fluxSink.next(33);
//           fluxSink.complete();
//        }).subscribe(System.out::println);

    // flux.generate
        // we can set condition in flux and can only emit 1 valeu pertime and infinit loop till meet condition
        //case wanna emit 10 elements
//        AtomicInteger atomicInteger=new AtomicInteger(0);
//        Flux.generate(synchronousSink -> {
//
//            synchronousSink.next(Singleton.faker().country().name());
//            atomicInteger.incrementAndGet();
//            if(atomicInteger.get()>10){
//                synchronousSink.complete();
//            }
//        }).subscribe(Singleton.subscriber("Country: "));


        Flux.generate(()->1,(counter,sink)->{
            sink.next(Singleton.faker().country().name());
            if(counter==10){
                sink.complete();
            }
            return counter+1;
        }).subscribe(Singleton.subscriber("Country"));



    }
}
