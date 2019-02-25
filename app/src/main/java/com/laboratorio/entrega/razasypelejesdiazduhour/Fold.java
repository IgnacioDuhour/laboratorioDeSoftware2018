package com.laboratorio.entrega.razasypelejesdiazduhour;

public class Fold {

    static <A, B> A foldLeft(Iterable<B> xs, A z, FoldFunction<A, B> f) {
        A p = z;
        for (B x : xs) {
            p = f.apply(p, x);
        }
        return p;
    }

    interface FoldFunction<A, B> {
        A apply(A a, B b);
    }

}