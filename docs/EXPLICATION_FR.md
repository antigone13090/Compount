# Pattern Compound (Compound Patterns) — MVC + patterns combinés (FR)

## 1) Intention
Un **compound pattern** n’est pas “un pattern unique” : c’est une **composition de plusieurs patterns** qui travaillent ensemble pour résoudre un problème plus large.

Dans Head First, l’exemple classique est **MVC**, qui combine souvent :
- **Observer** (la vue s’abonne au modèle)
- **Strategy** (variation d’algorithmes / comportements)
- **Composite** (structure hiérarchique de vues/composants)
- parfois **Adapter**, **Factory**, etc.

## 2) Problème typique
Construire une application interactive sans mélanger :
- logique métier (modèle)
- affichage (vue)
- gestion des actions utilisateur (contrôleur)

Sans séparation :
- code difficile à maintenir
- UI couplée au métier
- modifications en cascade

## 3) Principe (MVC)
- **Model** : état + règles métier. Il notifie les vues quand ça change.
- **View** : affiche l’état du modèle. Ne contient pas la logique métier.
- **Controller** : traduit les actions utilisateur en opérations sur le modèle.

## 4) Dans ce projet (Beat Model)
Le projet simule un “beat” (rythme) :
- le **modèle** gère le BPM + l’événement “beat”
- la **vue** affiche les changements (BPM/beat)
- le **contrôleur** demande start/stop et change le BPM

On observe dans la sortie :
- “Beat!”
- “BPM = ...”
- “Stopped.”

## 5) Déroulé du run
Point d’entrée : classe `...TestDrive` / `main`
1) initialisation MVC
2) démarrage du modèle
3) modifications de BPM
4) arrêt

## 6) Avantages
- découplage fort : UI ≠ métier
- testabilité améliorée (modèle testable sans UI)
- évolution plus simple (changer la vue sans toucher au modèle)

## 7) Inconvénients
- plus de classes / architecture plus lourde
- nécessite une discipline (sinon on casse MVC)

## 8) Erreurs classiques
- mettre de la logique métier dans la vue
- contrôleur trop “intelligent” (devient un second modèle)
- notifications mal gérées (boucles, updates inutiles)

## 9) Liens avec d’autres patterns
- Observer : vues abonnées au modèle
- Composite : arbres de composants UI
- Strategy : comportements remplaçables (ex: calculs/algos)
- Factory : création des vues/contrôleurs
