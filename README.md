# Besmetting
simulatie besmettingsproces
code is gebaseerd op de code van het boek OO-programmeren in Java met BlueJ van Gertjan Laan, waarin hij een programmaatje beschrijft dat figuren en plaatjes random
in een venster laat bewegen. Dat programma heb ik omgeschreven naar een simulatie waarbij groene rondjes onbesmette personen voorstellen, rode rondjes besmette personen
die een bepaalde tijd besmet (en besmettelijk) blijven, en blauwe rondjes personen die een besmetting hebben doorgemaakt en daarna immuun zijn. Alle bolletjes bewegen 
at random over het vlak, en als een besmet bolletje botst met een groen bolletje, dan wordt het groene bolletje rood (besmet en besmettelijk). Na een tijdje wordt
het rode bolletje blauw, dan is de besmettelijke periode voorbij, en is het bolletje immuun. Aan het eind van een run wordt weergegeven hoeveel onbesmette personen
resteren (bij aanvang zijn het er 50), hoeveel tijd (ticks) er paniek in de ic is geweest (meer dan 5 personen tegelijk ziek), en hoeveel tijd er paniek is geweest
terwijl er al 80% van de bolletjes immuun is.
