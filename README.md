# Pattern Compound (MVC) – Head First Design Patterns

## Ce que tu implémentes ici
Chapitre **Compound Patterns** (juste après **Proxy**) : on combine plusieurs patterns pour construire une petite architecture **MVC**.

- **Model** : logique + état (`BeatModel`)
- **View** : affichage (ici version console pour rester simple)
- **Controller** : pilote le modèle (`BeatController`)
- **Observer** : la vue s’abonne au modèle (beats + BPM)
- (Optionnel dans le livre) **Factory/Adapter/Composite** apparaissent aussi dans ce chapitre, mais ici on se concentre sur la partie MVC.

## Lancer
> Si tu n’as pas de wrapper Gradle dans ce projet : copie le wrapper depuis un autre projet (ex: `strategy/strategy`) comme tu le fais déjà.

```bash
./gradlew clean run
```

## Structure
- `src/main/java/headfirst/designpatterns/compound/mvc/*`
- `docs/COMPOUND_MVC.md` : explication détaillée (FR)
