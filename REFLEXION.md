# Réflexion - Activité 2

## Difficultés rencontrées

La principale difficulté a été de comprendre l'intérêt de la programmation par interface. Cela semblait être une complexité inutile au début, mais j'ai réalisé que cela offre une grande flexibilité : Foo ne dépend plus des classes concrètes mais de leurs contrats.

La bidirectionnalité avec interfaces (IFoo ↔ ICorge) nécessitait une attention particulière pour éviter les boucles infinies tout en garantissant la cohérence des références.

L'énumération EBaz qui implémente une interface était un concept nouveau : combiner les avantages d'une enum (valeurs fixes, type-safe) avec les contrats d'une interface.

## Tests

Estimation : 60-70% des tests devraient passer. Les tests d'interface devraient tous passer car les interfaces sont correctement implémentées. Les tests de bidirectionnalité devraient également fonctionner.

## Améliorations possibles

1. **Validation des paramètres** : Ajouter des vérifications de nullité dans les constructeurs et méthodes publiques pour lever des exceptions explicites.

2. **Collections immuables** : Retourner des copies non modifiables dans getBars() avec Collections.unmodifiableList() pour empêcher les modifications externes.
