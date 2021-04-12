package com.fredrikpedersen.petclinic.formatters;

import com.fredrikpedersen.petclinic.model.pets.PetType;
import com.fredrikpedersen.petclinic.services.PetTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

/**
 * @author Fredrik Pedersen
 * @version 1.0
 * @since 12/04/2021 at 10:28
 */

@Component
@RequiredArgsConstructor
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    @Override
    public String print(final PetType petType, final Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(final String text, final Locale locale) throws ParseException {
        final Collection<PetType> findPetTypes = petTypeService.findAll();

        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("type not found: " + text, 0);
    }
}
