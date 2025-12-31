# Pattern Compound (MVC) — Explication détaillée (FR)

## 1) Intention
Un **compound pattern** est une **composition** de patterns qui coopèrent pour résoudre un problème complet.
Ici : l’exemple “Beat Model” combine **MVC** avec Observer (et parfois Strategy/Adapter selon versions).

## 2) MVC en 10 secondes
- **Model** : état + logique (ex: BPM, start/stop)
- **View** : affichage (console/GUI)
- **Controller** : reçoit les actions utilisateur et pilote le modèle

## 3) Pourquoi on combine des patterns
MVC seul ne suffit pas : la vue doit être notifiée quand le modèle change.
Donc on ajoute **Observer** :
- la vue s’abonne au modèle
- le modèle notifie au changement de BPM / beat

## 4) Dans ce projet
- `BeatModel` (ou équivalent) : modèle, gère BPM et beat
- `DJView` (ou équivalent) : vue, affiche “Beat!” et BPM
- `BeatController` : contrôle, change BPM, start/stop

## 5) Déroulé du run
Point d’entrée : `DJTestDrive` (ou main)
Scénario :
1) start → émission de beats
2) setBPM (90, 120) → affichage BPM
3) stop → arrêt

## 6) Avantages
- Séparation claire responsabilités
- Vue réactive via Observer
- Testable : modèle testable sans UI

## 7) Inconvénients
- Beaucoup de classes
- Nécessite discipline sur les dépendances (vue ne doit pas contenir la logique)

## 8) Erreurs classiques
- Controller qui fait de la logique modèle
- Vue qui modifie le modèle directement (court-circuite le controller)

## 9) Liens avec d’autres patterns
- Observer : notifications modèle → vues
- Strategy : variantes d’algorithmes (si utilisées)
