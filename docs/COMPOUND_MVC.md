# Compound Patterns (MVC) – Explications (FR)

## 1) Pourquoi “Compound” ?
Le livre appelle **Compound Pattern** le fait de **composer plusieurs patterns ensemble** pour résoudre un problème plus réaliste (architecture, interaction, évolutivité), plutôt qu’un pattern isolé.

Dans Head First, l’exemple typique est le chapitre “Compound Patterns” qui finit par présenter **MVC**.

---

## 2) MVC en clair
### Model
- Contient **l’état** (ici `bpm`) et la **logique** (génération de “beats”).
- N’a aucune dépendance directe vers l’interface utilisateur.

### View
- S’abonne au modèle (Observer) pour **réagir** :
  - quand un “beat” arrive
  - quand le BPM change
- Ici : vue **console** (plus stable et portable que Swing en TP).

### Controller
- Reçoit des intentions “utilisateur” (start/stop, setBPM, etc.)
- Appelle le modèle.
- Ne fait pas de logique métier lourde.

---

## 3) Observer (dans ce projet)
Deux canaux d’observation :
- `BeatObserver` : événement “beat”
- `BPMObserver` : événement “bpm changed”

Le modèle maintient deux listes d’observateurs et notifie au bon moment.

---

## 4) Scénario de test (MVCTestDrive)
- Démarre le modèle
- Fixe le BPM à 120 puis 90
- Observe les logs console
- Arrête le modèle

---

## 5) Ce que tu dois obtenir
- Une exécution `./gradlew run` qui affiche :
  - des “Beat!” à intervalles
  - des lignes quand le BPM change

---

## 6) Extensions (si tu veux coller encore plus au chapitre)
- Ajouter une **Factory** pour instancier différentes implémentations de Model
- Ajouter une **Adapter** pour brancher un autre “générateur de beat”
- Ajouter une mini **Composite** d’éléments d’UI (si tu repasses en Swing)
