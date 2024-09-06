package org.example.jpaopgave.config;

import org.example.jpaopgave.model.Unicode;
import org.example.jpaopgave.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeUnicodeCharacters();
    }

    private void initializeUnicodeCharacters() {
        Set<Character> characters = new HashSet<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            characters.add(c);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            characters.add(c);
        }
        for (char c = '0'; c <= '9'; c++) {
            characters.add(c);
        }
        // Gem hver karakter i databasen
        for (Character character : characters) {
            Unicode unicode = new Unicode();
            unicode.setUnicode((int) character); // Sætter Unicode-værdi
            unicode.setBogstav(character);            // Sætter selve karakteren
            unicode.setDescription("The Kurd"); // Valgfri beskrivelse
            unicode.setName("Emre " + character);      // Valgfrit navn, fx "Character A"

            unicodeRepository.save(unicode); // Gemmer i databasen
        }
    }
}
