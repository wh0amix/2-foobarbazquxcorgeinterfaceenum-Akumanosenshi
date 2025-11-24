package com.jad.classe;

import com.jad.ICorge;
import com.jad.IFoo;

public class Corge implements ICorge {
    private IFoo foo;

    public Corge(IFoo foo) {
        this.foo = null; // Initialise à null pour éviter les boucles
        if (foo != null) {
            foo.setCorge(this); // Établit la bidirectionnalité
        }
    }

    @Override
    public IFoo getFoo() {
        return foo;
    }

    @Override
    public void setFoo(IFoo newFoo) {
        if (this.foo == newFoo) {
            return; // Protection contre appels redondants
        }

        // Nettoie l'ancienne relation
        if (this.foo != null) {
            IFoo oldFoo = this.foo;
            this.foo = null; // Évite les boucles
            oldFoo.setCorge(null);
        }

        // Établit la nouvelle relation
        this.foo = newFoo;
        if (newFoo != null && newFoo.getCorge() != this) {
            newFoo.setCorge(this);
        }
    }
}