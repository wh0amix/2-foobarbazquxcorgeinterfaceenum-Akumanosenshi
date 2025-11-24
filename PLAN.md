# Plan d'implémentation - Activité 2

## Objectif
Transformer l'architecture en utilisant la programmation par interface pour améliorer la flexibilité et la testabilité.

## Classes et interfaces

### Interfaces
- IBar, IBaz, IQux, ICorge, IFoo

### Classes concrètes
- Bar implements IBar
- EBaz (enum) implements IBaz
- Qux implements IQux
- Corge implements ICorge
- Foo implements IFoo

### Énumération
- EBaz : BAZ1, BAZ2, BAZ3

## Ordre d'implémentation

### Phase 1 : Méthodes no-op
- Bar.doSomethingLikeABar() → no-op
- Qux.doSomethingLikeAQux() → no-op
- EBaz.doSomethingLikeABaz() → no-op

### Phase 2 : Bidirectionnalité
- Corge.setFoo(IFoo) avec gestion bidirectionnelle
- Foo.setCorge(ICorge) avec gestion bidirectionnelle

## Choix clés

### Interface IBar
Permet de remplacer Bar sans modifier Foo. Facilite les tests avec mocks.

### Énumération EBaz
Type-safe avec 3 valeurs fixes. Implémente IBaz pour respecter le contrat.

### Interfaces IFoo et ICorge
Bidirectionnalité sans couplage fort entre classes concrètes.

## Changements vs Activité 1

| Aspect | Activité 1 | Activité 2 |
|--------|------------|------------|
| Baz | Classe | Enum |
| Types | Classes concrètes | Interfaces |
| Baz dans Foo | Liste | 1 seul (constructeur) |
| Bar dans Foo | 1 seul | Liste |

## Principes SOLID

- SRP : Chaque classe a une responsabilité unique
- OCP : Ouvert à l'extension, fermé à la modification
- DIP : Dépendance sur abstractions (interfaces)
