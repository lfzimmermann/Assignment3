Markdown

# Assignment3 - Video Store Simulation

Dieses Projekt ist eine Implementierung des klassischen "Video Store" Beispiels, das oft in Softwareentwicklungskursen verwendet wird. Es simuliert einen Videothek-Verleih, bei dem Kunden Filme ausleihen können.

## Kernklassen

* **Movie:** Repräsentiert einen Film mit Titel, Preiskategorie und Methoden zur Berechnung der Leihgebühr und der Bonuspunkte.
* **Rental:** Repräsentiert einen Leihvorgang für einen bestimmten Film und eine Anzahl von Tagen.
* **Customer:** Repräsentiert einen Kunden mit einem Namen und einer Liste von ausgeliehenen Filmen. Die Klasse bietet Methoden zur Berechnung des Gesamtbetrags und zur Erstellung einer detaillierten Abrechnung.
* **Price:** Abstrakte Basisklasse für verschiedene Preismodelle (RegularPrice, NewReleasePrice, ChildrensPrice).

## Designmuster

Das Projekt verwendet folgende Designmuster:

* **State:** Die Preiskategorie eines Films wird durch ein Price-Objekt dargestellt, das seinen Zustand (Preisberechnung, Bonuspunkte) kapselt.
* **Replace Conditional with Polymorphism:** Anstatt komplexe bedingte Anweisungen zur Berechnung von Preisen und Bonuspunkten zu verwenden, wird Polymorphismus eingesetzt, um das Verhalten basierend auf der Preiskategorie zu variieren.

## Build-Anleitung

Dieses Projekt verwendet den Gradle Wrapper als Build-Tool. Um das Projekt zu bauen und auszuführen, folgen Sie diesen Schritten:

1. Stellen Sie sicher, dass Sie eine Java-Entwicklungsumgebung auf Ihrem System installiert haben.
2. Öffnen Sie ein Terminal oder eine Eingabeaufforderung und navigieren Sie zum Projektverzeichnis.
3. Führen Sie den folgenden Befehl aus, um das Projekt zu kompilieren und zu packen:

```bash
./gradlew build