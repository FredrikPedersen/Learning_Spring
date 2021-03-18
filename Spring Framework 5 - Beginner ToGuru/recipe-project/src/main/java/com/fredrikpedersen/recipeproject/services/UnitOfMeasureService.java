package com.fredrikpedersen.recipeproject.services;

import com.fredrikpedersen.recipeproject.commands.UnitOfMeasureCommand;

import java.util.Set;


public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
