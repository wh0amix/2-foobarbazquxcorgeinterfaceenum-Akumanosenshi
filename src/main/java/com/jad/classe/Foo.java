package com.jad.classe;

import com.jad.*;

import java.util.ArrayList;
import java.util.List;

public class Foo implements IFoo {
    private IBaz baz;
    private List<IBar> bars;
    private IQux qux;
    private ICorge corge;


    public Foo(IBaz baz) {
        this.baz = baz;
        this.bars = new ArrayList<>();
        this.qux = new Qux();
    }

    public IBaz getBaz() {
        return baz;
    }

    public List<IBar> getBars() {
        return bars;
    }

    public void addBar(IBar bar) {
        bars.add(bar);
    }

    public IQux getQux() {
        return qux;
    }


    @Override
    public ICorge getCorge() {
        return corge;
    }

    @Override
    public void setCorge(ICorge newCorge) {
        if (this.corge == newCorge) {
            return; // Protection contre appels redondants
        }

        // Nettoie l'ancienne relation
        if (this.corge != null) {
            ICorge oldCorge = this.corge;
            this.corge = null; // Évite les boucles
            oldCorge.setFoo(null);
        }

        // Établit la nouvelle relation
        this.corge = newCorge;
        if (newCorge != null && newCorge.getFoo() != this) {
            newCorge.setFoo(this);
        }
    }

}