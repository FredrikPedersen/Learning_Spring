package com.fredrikpedersen.services;

import com.fredrikpedersen.domain.Recipe;
import com.fredrikpedersen.repositories.reactive.RecipeReactiveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final RecipeReactiveRepository recipeRepository;

    @Override
    public Mono<Void> saveImageFile(final String recipeId, final MultipartFile file) {

        final Mono<Recipe> recipeMono = recipeRepository.findById(recipeId)
                .map(recipe -> {

                    Byte[] byteObjects;

                    try {
                        byteObjects = new Byte[file.getBytes().length];

                        int i = 0;
                        for (byte b : file.getBytes()) {
                            byteObjects[i++] = b;
                        }

                        recipe.setImage(byteObjects);
                        return recipe;

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                });

        recipeRepository.save(recipeMono.block()).block();

        return Mono.empty();

    }
}
