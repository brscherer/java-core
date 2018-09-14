package com.github.brscherer.core_engineering.homework_9.got;

import com.github.brscherer.core_engineering.homework_9.got.binder.CharacterBinder;
import com.github.brscherer.core_engineering.homework_9.got.rest.GoTRestClient;
import com.github.brscherer.core_engineering.homework_9.got.rest.models.CharacterRequest;
import com.github.brscherer.core_engineering.homework_9.models.CharacterModel;

public class GoTFacade {
    private GoTRestClient restClient;

    public GoTFacade() {
        this.restClient = new GoTRestClient();
    }

    public CharacterModel getCharacterById(Long id) {
        CharacterRequest request = restClient.getByID(id);
        return CharacterBinder.bindFromRequest(request);
    }
}
