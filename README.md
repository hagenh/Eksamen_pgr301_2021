# Konteeksamen 2022

Som medlem av et utviklingsteam skal du sørge for at et API som tar i mot værdata fra ulike steder i verden følger 
DevOps prinsipper for utvikling. 

## Krav til innlevering 

* Lag et nytt GitHub repository og kopier innholdet av dette repositoriet over. Du må *ikke* lage en fork, fordi sensor igjen skal lage en fork av 
dit repository.
* Du skal levere lenke til et repository med en MarkDown til som beskvarer drøfte-oppgaver, og som inneholder løsning på oppgavene gitt her. 
* Du trenger en Docker Hub konto. Registrer deg her hvis du ikke har gjort det allerede https://hub.docker.com/
* Applikasjonen er ment å fungere med Java 11eller nyere. 

## Oppgave 1 - Spring Boot

Applikasjonen i dette repositoryet eksponerer et endepunkt som regisrerer  måling av vær. 
Du kan starte applikasjonen med kommandoen `mvn spring-boot:run`

En JSON Payload som sendes med en POST request til http://localhost:5050/weather/ ser slik ut, og vil registrer en ny måling.

```json
{
    "lat": 59.1212,
    "lan": 11.1243,
    "pressure": 934,
    "temperature": -3.5
}
```

A. Du skal utvide applikasjonen med et ekstra endepunkt som lister alle målinger når en GET request 
treffer http://localhost:5050/weather/

B. Skriv minst en Unit test.

## Oppgave 2 - Lag en Github Actions workflow  

A. Lag en GitHub actions workflow som ved endringer på _main_ branch gjør følgende;  

* Bygger Spring Boot prosjektet med Maven
* Kjører enhetstester. Bygget skal feile dersom enhetstestene feiler.

## Oppgave 3 Drøft - Branch protection

I et DevOps team er det vanlig å jobbe med en "protected main branch". Det vil si at ingen kan direkte comitte kode på main, men at man jobber på en feature branch, og lager en pull request mot main som må godkjennes av andre i teamet. 
Det er også ofte en krav om at en CI server har kompilert kode, og kjørt tester og gjort andre sjekker på feature branch før den kan merges. 

* A. Forklar med egne ord hva som er fordelen med denne måten å jobbe på
* B. Forklar med ord eller vis med skjermbilder hvordan man konfigurerer et GitHub repository på denne måten.

## Oppgave 4 Docker  

* A. Produser en Dockerfil som kompilerer, pakker og kjører Spring boot applikasjonen i dette repoet. 
* B. Beskriv hvilke kommandoer sensor må kjøre for å  bygge et container image som sensor kan starte med kommandoen `docker run konte2022:latest`
* C. Beskriv hvilken docker kommando sensor må kjøre for å starte en container på en slik måte at applikasjonen blir gjort tilgjengelig på http://localhost:9999
* D. Beskriv hvilken docker kommando sensor må kjøre for å starte en container du har pushet til din Docker Hub konto, og som gjør applikasjonen tilgjengelig på http://localhost:9999 
* E.  Beskriv hvilke docker kommandoer sensor må kjøre for å pushe et container image, som er bygget lokalt, til sin private Docker Hub konto.

## Oppgave 5 Docker i pipeline 

* A. Lag en GitHub actions pipeline som på hver commit til main branch produserer et nytt container image, pusher dette til din DockerHub konto.
* B. Forklar hva sensor må gjøre for å få pipeline til å kjøre på sin egen GitHub konto  med en fork av ditt repo.

## Oppgave 6 Loadtest med K6 i pipeline 

En viktig del av GitHub actions er den åpne markedsplassen der tredjeparter utvikler plug-ins for sine 
produkter slik at disse enkelt kan tas i bruk i CI/CD Pipelines. 

K6 er et produkt som brukes for last- og performance testing av applikasjoner. K6 lar deg simulere trafikk mot applikasjonen din
for å stressteste den, og se responstider når den er under last. K6 brukter tester skrevet i Javascript 

K6 sin plugin for GitHub actions ligger her, sett deg inn i hvordan denne fungerer.  
https://github.com/marketplace/actions/k6-load-test

Det ligger allerede en load test i dette repositoryet dere kan bruke. Filen heter _loadtest.js_og ser slik ut. 

```renderscript
import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  duration: '1m',
  vus: 50
};

export default function () {
  const res = http.get('https://test.k6.io');
  sleep(1);
}
```

A. Bruke dokumentasjonen til denne  plugin'en, og bruke den i din egen pipeline. Du står fritt til å velge om du vil lage din egen 
Github actions workflow, eller lagge en workflow med to jobber. 

For enkelhets skyld kan dere late som om _https://test.k6.io_ er deres applikasjon som skal testes.   

B. Endre testen slik at den feiler hvis 95 Percentilen til responstid overstiger 500ms. Med andre ord at den feiler om ikke 95% av requestenen fullfører under 500ms.

Lykke til og ha det gøy!
