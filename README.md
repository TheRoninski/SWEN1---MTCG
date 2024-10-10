# Protokoll: MTCG
## Design-Entscheidungen
Sprache: Das Projekt wurde in Java entwickelt.
Server-Implementierung: Es wurde ein benutzerdefinierter HTTP-Server implementiert, der auf eingehende Client-Anfragen hört, ohne dass ein externes HTTP-Framework (wie Spring Boot) verwendet wird. Die Klassen Server, Request und Response handhaben die Kernlogik der HTTP-Anfragen und -Antworten.
Routing: Die Klasse Router sorgt für die Verteilung von Anfragen an die entsprechenden Services. Es wurden REST-Endpoints für die Registrierung und Anmeldung von Benutzern implementiert.
## Struktur
Das Projekt ist in verschiedene Pakete unterteilt:

## HTTP-Server-Kern:
Handhabt die HTTP-Protokollverarbeitung (Anfragen/Antworten) und das Routing.

## Benutzerverwaltung (MTCG):
Bietet Funktionen zur Registrierung und Anmeldung von Benutzern, sowie die Verwaltung von Spielkarten.


## Klassendiagramm 
Der Server verwendet einen Router, um Anfragen an die passenden Services weiterzuleiten.
Request und Response kapseln die Kommunikation zwischen Client und Server.
Die UserService verwaltet die Benutzer und nutzt dafür UserRepository zur Datenspeicherung im Speicher.

Projekt compilt noch nicht, habe ein paar errors die ich nicht rechtzeitig fixen konnte.

## Link zum Git-Repository
https://github.com/TheRoninski/SWEN1---MTCG.git
