Test task

1. Vytvorte všeobecné Jetpack Compose InputView
    a. Implementujte nové Jetpack Compose View podľa pripraveného dizajnového podkladu.
    b. Zamerajte sa na flexibilitu a rozšíriteľnosť komponentu.
2. Vytvorte PasswordInput pomocou InputView
   * Použite vytvorený komponent a implementujte nové Jetpack Compose View s názvom PasswordInput.
   * Komponent by mal:
     * Jasne komunikovať požiadavky na heslo používateľovi.
     * Zabezpečiť dobrý používateľský zážitok (UX).
     * Byť ľahko použiteľný a rozšíriteľný. 
     * Umožniť jednoduchú zmenu štýlu.
   * Požiadavky na heslo
     * Minimálne 8 znakov
     * Aspoň jedno veľké písmeno
     * Aspoň jedno číslo
     * Aspoň jeden špeciálny znak (? = # / %)

Pridal som prepínač na zobrazenie alebo skrytie hesla v heslovom poli.
Zároveň som pridal možnosť určiť, či je vstupné pole dostupné, ale spracovanie som zatiaľ ponechal bez dizajnu 
a farieb, keďže návrh pre nedostupné pole nebol definovaný.
Farby a orámovanie pre stav vo fóku a mimo fokusu sú rovnaké, pretože to nebolo špecifikované v dizajne.