package com.github.brscherer.core_engineering.homework_9;

import com.github.brscherer.core_engineering.homework_9.got.GoTFacade;
import com.github.brscherer.core_engineering.homework_9.models.CharacterModel;

public class Main {
    public static void main(String[] args) {
        GoTFacade facade = new GoTFacade();
        CharacterModel model = facade.getCharacterById(583L);
        StringBuilder alias = new StringBuilder();
        model.getAliases().forEach(a -> alias.append("\n").append(a));
        System.out.println(model.getName() + alias.toString());
    }
}
