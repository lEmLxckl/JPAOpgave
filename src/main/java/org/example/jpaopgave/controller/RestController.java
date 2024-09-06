package org.example.jpaopgave.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping("/unicode/{i}")
    public String unicodeToChar(@PathVariable int i) {
        char c = (char) i;
        return "unicode=" + i + " char=" + c;
    }

    @GetMapping("/char/{c}")
    public String getCharCode(@PathVariable char c) {
        int unicode = (int) c;
        return "char=" + c + " unicode=" + unicode;
    }

    // Endpoint til at få et antal bogstaver startende med et bestemt bogstav
    @GetMapping("/sequence")
    public List<Character> getCharactersStartingFrom(
            @RequestParam char startChar,
            @RequestParam int count) {
        List<Character> result = new ArrayList<>();
        // Generer en sekvens af bogstaver startende fra 'startChar'
        for (int i = 0; i < count; i++) {
            result.add((char) (startChar + i));
        }

        return result;

    }
}