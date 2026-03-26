# Exercices pour apprendre à maitriser techniquement les règles d'accessibilité sur android

## Installation

Pour installer le projet, il vous faut:

- Android Studio (ici Panda 2025.3.2)
- Un émulateur ou un appareil android (un émulateur Android 36 sera plus pratique)
- Cloner le projet
- Faire une synchronisation gradle

### Déroulement des exercices

Les exercices vous seront donnés par le formateur au fur et à mesure de la formation.
Vous devrez les réaliser dans l'ordre.

- Ouvrir le projet dans Android Studio
- Lancer l'émulateur ou connecter un appareil android
- Builder et lancer l'application
- Naviguer dans l'application
- Tester l'accessibilité de l'application
- Corriger les problèmes d'accessibilité
- Tester à nouveau l'accessibilité de l'application

## Structure du projet

Dans le package `ui.components` vous trouverez les composants custom de l'application qui ne sont
pas accessibles. C'est ceux la que vous devrez rendre accessible.

Dans le package `ui.screens` vous trouverez les écrans de l'application, vous aurez aussi des
changements à faire dessus.

Dans le fichier `MainActivity.kt` vous trouverez la liste des écrans de l'application, vous pouvez y
changer l'écran de démarrage de l'application pour plus de facilité dans les exercices.

## Liste des exercices

Voir le powerPoint de la formation.

En attendant, voici
le [support pour les formateurs](https://www.notion.so/m33/Exercices-Android-13c8f3776f4f80e99418f83d42ccf40e)

## Ressources

- [Documentation officielle sur l'accessibilité sur Android](https://developer.android.com/develop/ui/compose/accessibility)
- [Naviguer avec Talkback](https://support.google.com/accessibility/android/answer/6006598?hl=fr)
- Sur ce [site web](https://www.magentaa11y.com/#/native-criteria/controls/overview) vous trouverez
  plusieurs conseils et APIs à utiliser pour rendre vos composants Compose et XML accessibles.
- Sur ce [repo](https://github.com/cvs-health/android-compose-accessibility-techniques) git vous
  trouverez des bons et mauvais exemples d'utilisations des APIs d'accessibilité dans différents
  cas. Nous allons aborder les principaux dans cette formation.

### Activer et désactiver talkback avec adb

activation:

```bash
adb shell settings put secure enabled_accessibility_services com.google.android.marvin.talkback/com.google.android.marvin.talkback.TalkBackService
```

Désactivation:

```bash
adb shell settings put secure enabled_accessibility_services null
```

### Tester les regles semantiques avec des TUs compose

https://developer.android.com/develop/ui/compose/accessibility/testing

### Accessibility Scanner sur android Studio

https://developer.android.com/guide/topics/ui/accessibility/testing#accessibility-scanner

### Compose UI check Mode sur android Studio

https://developer.android.com/guide/topics/ui/accessibility/testing#compose-ui-check
