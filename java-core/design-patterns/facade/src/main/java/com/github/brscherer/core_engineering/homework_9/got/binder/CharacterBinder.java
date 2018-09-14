package com.github.brscherer.core_engineering.homework_9.got.binder;

import com.github.brscherer.core_engineering.homework_9.got.rest.models.CharacterRequest;
import com.github.brscherer.core_engineering.homework_9.models.CharacterModel;

import java.util.Optional;

public class CharacterBinder {

    public static CharacterModel bindFromRequest(CharacterRequest request) {
        CharacterModel model = new CharacterModel();
        Optional.ofNullable(request.getName()).ifPresent(model::setName);
        Optional.ofNullable(request.getGender()).ifPresent(model::setGender);
        Optional.ofNullable(request.getAliases()).ifPresent(model::setAliases);
        Optional.ofNullable(request.getTitles()).ifPresent(model::setTitles);
        Optional.ofNullable(request.getPlayedBy()).ifPresent(model::setPlayedBy);

        return model;
    }
}
